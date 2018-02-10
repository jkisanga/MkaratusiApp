package com.tfs.mkaratusi.mkaratusi.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.adapters.ApplicantAdapter;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.models.RActivity;
import com.tfs.mkaratusi.mkaratusi.pojo.Activity;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;
import com.tfs.mkaratusi.mkaratusi.pojo.Bill;
import com.tfs.mkaratusi.mkaratusi.pojo.BillItem;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.srodrigo.androidhintspinner.HintAdapter;
import me.srodrigo.androidhintspinner.HintSpinner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.BILL_ID;

public class BillActivity extends AppCompatActivity {
    public static final String BII_ACTIVITY = "BII_ACTIVITY";
    public static final String ON_RESPONSE = "onResponse";
    private LinearLayout parentLinearLayout;
    int ApplicantId = 0;
    String ApplicantName = "";
    TextView textApplicant;
    Spinner activitySpinner1;
    Spinner activitySpinner;
    List<String> activityDesc;
    List<Integer> activityId;
    ArrayAdapter<String> adapter;
    int QTY = 0;
    double AMT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        activitySpinner = (Spinner) findViewById(R.id.spinner);

        List<RActivity> activityList = RealmController.with(this).getActivities();
        Log.d("TAG", "onCreate: " + activityList.size());
        activityDesc = new ArrayList<>();
        activityId = new ArrayList<>();
        for (int i = 0; i < activityList.size(); i++) {
            //spinnerValues.add(new MyClass(activityList.get(i).getName(), activityList.get(i).getId()));
            activityDesc.add(activityList.get(i).getName());
            activityId.add(activityList.get(i).getId());

        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activityDesc);
        activitySpinner.setAdapter(adapter);

        textApplicant = findViewById(R.id.txt_applicant);
        Bundle applicantObj = getIntent().getExtras();
        if (applicantObj != null) {
            ApplicantId = applicantObj.getInt(APPLICANT_ID);
            ApplicantName = applicantObj.getString(APPLICANT_NAME);
            toolbar.setTitle("Bill For: " + ApplicantName);
            setSupportActionBar(toolbar);
        } else {
            Toast.makeText(this, "Kuna Tatizo. Jaribu tena", Toast.LENGTH_SHORT).show();
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save_items);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Log.d("onClick", "onClick: " + activitySpinner.getSelectedItem().toString());
//                Log.d("onClick", "onClick: " + activitySpinner1.getSelectedItem().toString());   ;
                RActivity itemId = RealmController.with(BillActivity.this).getActivities(activitySpinner.getSelectedItem().toString());
                EditText inputQuantity = findViewById(R.id.quantity_text);
                EditText inputAmount = findViewById(R.id.amount_text);
                QTY = Integer.parseInt(inputQuantity.getText().toString());
                AMT = Double.parseDouble(inputAmount.getText().toString());

                createBill(ApplicantId, itemId.getId(),QTY,AMT);

            }
        });
    }


    public void onAddField(View v) {
//        int count = 0;
//        EditText ed;
//        List<EditText> allEds = new ArrayList<EditText>();
//
//        for (int i = 0; i < count; i++) {
//
//            ed = new EditText(BillActivity.this);
//            allEds.add(ed);
//            ed.setId(i);
//            ed.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT));
//            parentLinearLayout.addView(ed);
//            count++;
//        }

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.field, null);
        activitySpinner1 = rowView.findViewById(R.id.spinner1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, activityDesc);
        activitySpinner1.setAdapter(adapter);
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);

    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }

    private void createBillItem(final Bill bill, final  int activityId, double total) {
        Log.d("createBillItem: ", "createBillItem: ");
        BillItem billItem = new BillItem();
        billItem.setBillId(bill.getId());
        billItem.setActivityId(activityId);
        billItem.setTotal(total);
        billItem.setDescription(bill.getDescription());

        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<BillItem> call = getResponse.postBillItem(billItem);
            call.enqueue(new retrofit2.Callback<BillItem>() {
                @Override
                public void onResponse(retrofit2.Call<BillItem> call, retrofit2.Response<BillItem> response) {
                    if (response.isSuccessful()) {
                        BillItem billItem1 = response.body();

                        Intent i = new Intent(BillActivity.this, TransitpassActivity.class);
                        i.putExtra(APPLICANT_ID, bill.getApplicantId());
                        i.putExtra(BILL_ID, bill.getId());
                        i.putExtra(APPLICANT_NAME, ApplicantName);
                        Toast.makeText(BillActivity.this, "Bill Created, Fill TP Information", Toast.LENGTH_SHORT).show();
                        startActivity(i);


                    } else {
                        Log.d(ON_RESPONSE, "onResponse111: " + response.errorBody());
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<BillItem> call, Throwable t) {
                    Log.d(ON_RESPONSE, "onResponse : onFailure" + t.getStackTrace() + " : " + t.getMessage());
                }
            });
        } catch (Exception e) {
            Log.d(ON_RESPONSE, "onResponse: Exception" + e.toString());
        }


    }


    private void createBill(int applicantId, final int activityId, int quantity, double amount) {
        Log.d("onClick", "onClick: " + quantity + applicantId + amount);
        final double total = quantity * amount;
        Bill bill = new Bill();
        bill.setApplicantId(applicantId);
        bill.setBillAmount(total);
        bill.setDescription("Hundi Malipo ya Malipo ya Transitpass");
        bill.setStationId(2);


        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<Bill> call = getResponse.postBill(bill);
            call.enqueue(new retrofit2.Callback<Bill>() {
                @Override
                public void onResponse(retrofit2.Call<Bill> call, retrofit2.Response<Bill> response) {
                    if (response.isSuccessful()) {
                        Log.d("onClick1", "onClick11: hjhjhjhjh" );

                        Bill bill = response.body();
                        createBillItem(bill, activityId, total);
                    } else {
                        Log.d("createBill: ", "createBill: " + response.toString());
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<Bill> call, Throwable t) {
                    Log.d("createBill: ", "createBill: " + t.toString());
                }
            });
        } catch (Exception e) {
            Log.d("createBill: ", "createBill: " + e.toString());
        }


    }




}



