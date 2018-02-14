package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.models.RPosUser;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointTP;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;

import java.util.List;

import info.hoang8f.widget.FButton;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class InspectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    String TPNo, SelectedIrre, SelectedAct, SecectedProd, SelectedUnit, Client;
    int  TPId;
    private ProgressDialog dialog;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    Button FbtnAdd, FbtnSubmint;

    EditText txtQuantity,Value,Amount, ReceiptNo, txtMoreDesc;

    Spinner spIrregularities, spActions, spProduct, spUnit;
    int UserId, CheckpointId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        Toolbar toolbar =  findViewById(R.id.toolbar);

        List<RPosUser> rPosUsers = RealmController.with(this).getPosUsers();
        CheckpointId = rPosUsers.get(0).getCheckpointId();
        UserId = rPosUsers.get(0).getUserId();

        dialog = new ProgressDialog(this);
        Bundle bundle = getIntent().getExtras();
        TPNo = bundle.getString(AppConfig.KEY_TPNO);
        Client =  "To : " + bundle.getString(AppConfig.KEY_CLIENT);
        TPId = bundle.getInt(AppConfig.KEY_TPID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TP NO : " + TPNo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //EditText
//        Value =  findViewById(R.id.edt_value);
//        txtQuantity =  findViewById(R.id.edt_volume);
        txtMoreDesc =  findViewById(R.id.edt_more_desc);
//        Amount =  findViewById(R.id.edt_amount);
//        ReceiptNo =  findViewById(R.id.edt_receipt_no);

        //FButton
        FbtnAdd =  findViewById(R.id.fbtn_add);
        FbtnSubmint =  findViewById(R.id.fbtn_submit);
       FbtnSubmint.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               radioGroup = findViewById(R.id.radioGroup);
               int selectedId=radioGroup.getCheckedRadioButtonId();
               if(selectedId > 0){
                   radioButton = findViewById(selectedId);
                   radioButton.getText();
                   if(radioButton.getText().toString().equals("OK")){
                       sendOKResult(CheckpointId,UserId, txtMoreDesc.getText().toString());
                   }else{
//                       Intent i = new Intent(InspectionActivity.this, IrregularityActivity.class);
//                       startActivity(i);
//                       finish();

                   }
               }else{

                   message("You Must Choose if is Ok or Not");
               }




           }
       });
        FbtnAdd.setOnClickListener(this);

//        spIrregularities =  findViewById(R.id.sp_irregularities);
//        spActions =  findViewById(R.id.sp_action);
//        spProduct =  findViewById(R.id.sp_product);
//        spUnit = findViewById(R.id.sp_unit);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void sendOKResult(int checkpointId, int  UserId, String addtionInfo) {

        final CheckpointTP checkpointTP = new CheckpointTP();
        checkpointTP.setTransitPassId(TPId);
        checkpointTP.setStationId(checkpointId);
        checkpointTP.setInspectorId(UserId);
        checkpointTP.setAdditionInformation(addtionInfo);

        try {
            dialog.setMessage("saving ...");
            dialog.show();
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<CheckpointTP> call = getResponse.postInspectionOK(checkpointTP);
            call.enqueue(new retrofit2.Callback<CheckpointTP>() {
                @Override
                public void onResponse(retrofit2.Call<CheckpointTP> call, retrofit2.Response<CheckpointTP> response) {
                    if (response.isSuccessful()) {
                        CheckpointTP checkpointTP1 = response.body();

                        startActivity(new Intent(InspectionActivity.this, HomeActivity.class));
                        finish();
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }else{
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        Log.d("onResponse", "onResponse: " + response.message());
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<CheckpointTP> call, Throwable t) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            });
        } catch (Exception e) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    private void message(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
