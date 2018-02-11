package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.adapters.CheckpointAdapter;
import com.tfs.mkaratusi.mkaratusi.adapters.ProductAdapter;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointPrint;
import com.tfs.mkaratusi.mkaratusi.pojo.Product;

import java.util.List;

public class RouteActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private String TPNo,Client;
    int  TPId;
    private RecyclerView recyclerViewRoute;
    private CheckpointAdapter mAdapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Toolbar toolbar =  findViewById(R.id.toolbar);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            TPNo = bundle.getString(AppConfig.KEY_TPNO);
            TPId = bundle.getInt(AppConfig.KEY_TPID);
            Client = bundle.getString(AppConfig.KEY_CLIENT);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TP NO : " + TPNo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// Progress dialog
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);


        recyclerViewRoute =  findViewById(R.id.tp_route_recycler_view);

        sendTPno(TPId);

        fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RouteActivity.this, InspectionActivity.class);
                i.putExtra(AppConfig.KEY_TPID, TPId);
                i.putExtra(AppConfig.KEY_TPNO, TPNo);
                i.putExtra(AppConfig.KEY_CLIENT, Client);
                startActivity(i);
            }
        });
    }

    private void sendTPno(int tp_id) {
        dialog.setMessage("loading data ...");
        dialog.show();
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<List<CheckpointPrint>> call = getResponse.getTpCheckpoints(tp_id);
            call.enqueue(new retrofit2.Callback<List<CheckpointPrint>>() {
                @Override
                public void onResponse(retrofit2.Call<List<CheckpointPrint>> call, retrofit2.Response<List<CheckpointPrint>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<CheckpointPrint> checkpointPrints = response.body();

                    mAdapter = new CheckpointAdapter(checkpointPrints);
                    recyclerViewRoute.setAdapter(mAdapter);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(RouteActivity.this);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerViewRoute.setLayoutManager(layoutManager);
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<List<CheckpointPrint>> call, Throwable t) {
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

}
