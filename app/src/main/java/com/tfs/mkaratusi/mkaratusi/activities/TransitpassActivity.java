package com.tfs.mkaratusi.mkaratusi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.Bill;
import com.tfs.mkaratusi.mkaratusi.pojo.BillItem;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;

import java.util.Calendar;
import java.util.Date;

import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.BILL_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.TRANSITPASS_ID;

public class TransitpassActivity extends AppCompatActivity {
    String ApplicantName = "";
    int ApplicantId = 0;
    int BillId = 0;
    EditText inputSourceForest,inputDestination, inputVehicleNo, inputHummerNo,
            inputHummerMaker, inputNumberOfExpire,inputAddtionInfo;
    String SourceForest,Destination, VehicleNo, HummerNo, HummerMaker, NumberOfExpire,AddtionInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transitpass);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle b = getIntent().getExtras();
        if(b != null){
            ApplicantId = b.getInt(APPLICANT_ID) ;
            BillId = b.getInt(BILL_ID) ;
            ApplicantName = b.getString(APPLICANT_NAME);
            toolbar.setTitle(ApplicantName);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        inputSourceForest = (EditText) findViewById(R.id.input_source_forest);
        inputDestination = (EditText)findViewById(R.id.input_destination);
        inputVehicleNo = (EditText)findViewById(R.id.input_vehicle_no);
        inputVehicleNo = (EditText) findViewById(R.id.input_hummer_no);
        inputHummerMaker = (EditText)findViewById(R.id.input_hummer_maker);
        inputHummerNo = (EditText) findViewById(R.id.input_hummer_no);
        inputAddtionInfo = (EditText) findViewById(R.id.input_addtion_information);
        inputNumberOfExpire = (EditText) findViewById(R.id.input_expire_days);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SourceForest = inputSourceForest.getText().toString();
                Destination = inputDestination.getText().toString();
                VehicleNo = inputVehicleNo.getText().toString();
                HummerNo = inputHummerNo.getText().toString();
                HummerMaker = inputHummerMaker.getText().toString();
                NumberOfExpire = inputNumberOfExpire.getText().toString();
                AddtionInfo = inputAddtionInfo.getText().toString();
                createTransitpass(SourceForest,Destination, VehicleNo, HummerNo, HummerMaker, NumberOfExpire,AddtionInfo);
            }
        });


    }


    private void createTransitpass(String sourceForest, String destination, String vehicleNo, String hummerNo, String hummerMaker, String numberOfExpire, String addtionInfo) {



        Date expireDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(expireDate);
        c.add(Calendar.DATE, Integer.parseInt(numberOfExpire));
        expireDate = c.getTime();

        final Transitpass transitpass = new Transitpass();
        transitpass.setApplicantId(ApplicantId);
        transitpass.setBillId(BillId);
        transitpass.setExpireDays(Integer.valueOf(numberOfExpire));
        transitpass.setDestinationName(destination);
        transitpass.setHummerNo(hummerNo);
        transitpass.setHummerMaker(hummerMaker);
        transitpass.setSourceName(sourceForest);
        transitpass.setVehcleNo(vehicleNo);
        transitpass.setAdditionInformation(addtionInfo);
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<Transitpass> call = getResponse.postTransipass(transitpass);
            call.enqueue(new retrofit2.Callback<Transitpass>() {
                @Override
                public void onResponse(retrofit2.Call<Transitpass> call, retrofit2.Response<Transitpass> response) {
                    if (response.isSuccessful()) {
                        Transitpass transitpass1 = response.body();

                        Intent i = new Intent(TransitpassActivity.this, TransitpassRouteActivity.class);
                        i.putExtra(TRANSITPASS_ID, transitpass1.getId());
                        i.putExtra(APPLICANT_NAME, ApplicantName);

                        Toast.makeText(TransitpassActivity.this, "TP Information has been saved.", Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    }else{
                        Log.d("Transitpass", "onResponse : onFailure" + response.toString());
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<Transitpass> call, Throwable t) {
                    Log.d("Transitpass", "onResponse : onFailure" + t.toString());
                }
            });
        } catch (Exception e) {
            Log.d("Transitpass", "onResponse: Exception" + e.toString());
        }



    }



}
