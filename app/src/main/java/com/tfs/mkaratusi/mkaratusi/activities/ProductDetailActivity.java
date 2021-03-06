package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.adapters.ProductAdapter;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.models.RActivity;
import com.tfs.mkaratusi.mkaratusi.pojo.Activity;
import com.tfs.mkaratusi.mkaratusi.pojo.Product;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.KEY_TPNO;

public class ProductDetailActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private String TPNo, Client;
    int  TPId;
    private ProductAdapter productAdapter;
    private RecyclerView recyclerViewProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Toolbar toolbar =  findViewById(R.id.toolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            TPNo = bundle.getString(AppConfig.KEY_TPNO);
            TPId = bundle.getInt(AppConfig.KEY_TPID);
            Client = bundle.getString(AppConfig.KEY_CLIENT);
           // db = new SQLiteHandler(this.getApplicationContext());
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TP NO : " + TPNo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// Progress dialog
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);

        recyclerViewProduct = findViewById(R.id.tp_product_recycler_view);
        sendTPno(TPId);
    }

    private void sendTPno(int tp_id) {
        dialog.setMessage("updating data ...");
        dialog.show();
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<List<Product>> call = getResponse.getTpProducts(tp_id);
            call.enqueue(new retrofit2.Callback<List<Product>>() {
                @Override
                public void onResponse(retrofit2.Call<List<Product>> call, retrofit2.Response<List<Product>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<Product> products = response.body();

                    productAdapter = new ProductAdapter(products);
                    recyclerViewProduct.setAdapter(productAdapter);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailActivity.this);
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerViewProduct.setLayoutManager(layoutManager);
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<List<Product>> call, Throwable t) {
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
