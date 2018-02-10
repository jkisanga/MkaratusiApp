package com.tfs.mkaratusi.mkaratusi.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.adapters.WaitingTpAdapter;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.PrintTp;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WaitingTpFragment extends Fragment implements SearchView.OnQueryTextListener, SwipeRefreshLayout.OnRefreshListener{

    // TODO: Customize parameters
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ProgressDialog dialog;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WaitingTpFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waitingtp_list, container, false);
        recyclerView =  view.findViewById(R.id.tp_recycler_view);
        swipeRefreshLayout =  view.findViewById(R.id.swipe_refresh_layout);
        dialog = new ProgressDialog(getActivity());
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setDistanceToTriggerSync(40);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        ListData();
                                        // stopping swipe refresh
                                        swipeRefreshLayout.setRefreshing(false);
                                    }
                                });
        // Set the adapter

        ListData();
        return view;
    }

    private void ListData() {
        dialog.setMessage("loading ...");
        dialog.show();
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            Call<List<PrintTp>> call = getResponse.getWeiting();
            call.enqueue(new Callback<List<PrintTp>>() {
                @Override
                public void onResponse(Call<List<PrintTp>> call, Response<List<PrintTp>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<PrintTp> applicants    = response.body();
                    WaitingTpAdapter waitingTpAdapter = new WaitingTpAdapter(applicants,getActivity());
                    recyclerView.setAdapter(waitingTpAdapter);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
                    Log.d("onSuccess", String.valueOf(applicants.size()));

                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                }

                @Override
                public void onFailure(Call<List<PrintTp>> call, Throwable t) {
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





    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onRefresh() {

    }


}
