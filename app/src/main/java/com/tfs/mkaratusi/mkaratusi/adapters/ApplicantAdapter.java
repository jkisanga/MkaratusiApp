package com.tfs.mkaratusi.mkaratusi.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.activities.BillActivity;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;

/**
 * Created by Dell on 1/18/2018.
 */

public class ApplicantAdapter  extends RecyclerView.Adapter<ApplicantAdapter.MyViewHolder> {


    private List<Applicant> applicants;
    Activity activity;

    public ApplicantAdapter(List<Applicant> applicants, Activity activity) {
        this.applicants = applicants;
        this.activity = activity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textApplicant, textAddress, textEmail, textPhone;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            //linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
            textApplicant = (TextView)view.findViewById(R.id.txt_applicant);
            textAddress = (TextView)view.findViewById(R.id.txt_address);
            textEmail = (TextView)view.findViewById(R.id.txt_email);
            textPhone = (TextView)view.findViewById(R.id.txt_phone);
            cardView = (CardView)view.findViewById(R.id.card_view);

        }
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.applicant_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ApplicantAdapter.MyViewHolder holder, final int position) {
        final Applicant applicant = applicants.get(position);
            holder.textApplicant.setText(applicant.getName());
            holder.textAddress.setText(applicant.getAdress());
            holder.textPhone.setText(applicant.getPhone());
            holder.textEmail.setText(applicant.getEmail());
        Log.d(TAG, "onBindViewHolder: " + applicant.getId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            int viewCounter = 1;
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, BillActivity.class);
                i.putExtra(APPLICANT_ID, applicant.getId());
                i.putExtra(APPLICANT_NAME, applicant.getName());
                activity.startActivity(i);

            }
        });




    }




    @Override
    public int getItemCount() {
        return applicants.size();
    }


        public void setFilter(List<Applicant> applicants) {
        applicants = new ArrayList<>();
        applicants.addAll(applicants);
        notifyDataSetChanged();
    }

}
