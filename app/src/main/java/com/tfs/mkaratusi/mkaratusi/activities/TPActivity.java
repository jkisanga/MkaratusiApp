package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.adapters.ApplicantAdapter;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TPActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    private RecyclerView recyclerView;
    private ProgressDialog dialog;
    ApplicantAdapter applicantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(TPActivity.this));
        dialog = new ProgressDialog(this);
        getApplicants();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    private void getApplicants() {

        dialog.setMessage("loading ...");
        dialog.show();
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            Call<List<Applicant>> call = getResponse.getApplicants();
            call.enqueue(new Callback<List<Applicant>>() {
                @Override
                public void onResponse(Call<List<Applicant>> call, Response<List<Applicant>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<Applicant> applicants    = response.body();
                    ApplicantAdapter applicantAdapter = new ApplicantAdapter(applicants,TPActivity.this);
                    recyclerView.setAdapter(applicantAdapter);



                        Log.d("onSuccess", String.valueOf(applicants.size()));

                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                }

                @Override
                public void onFailure(Call<List<Applicant>> call, Throwable t) {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    Log.d("onFailure1", "onFailure1: " + t.toString());
                }


            });
        }catch (Exception e){
            Log.d("onFailure1", "onFailure1: " + e.toString());
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

}
