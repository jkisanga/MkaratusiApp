package com.tfs.mkaratusi.mkaratusi.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.activities.BillActivity;
import com.tfs.mkaratusi.mkaratusi.activities.ProductDetailActivity;
import com.tfs.mkaratusi.mkaratusi.activities.RouteActivity;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.fragments.WaitingTpFragment;
import com.tfs.mkaratusi.mkaratusi.pojo.PrintTp;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;


public class WaitingTpAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<PrintTp> printTps;

    public WaitingTpAdapter(List<PrintTp> printTpList) {
        this.printTps = printTpList;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int i) {
        final PrintTp model = printTps.get(i);
        itemViewHolder.bind(model);

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_waitingtp, viewGroup, false);
        return new ItemViewHolder(view);
    }

    public void setFilter(List<PrintTp> applicants) {
        applicants = new ArrayList<>();
        applicants.addAll(applicants);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return printTps.size();
    }

}