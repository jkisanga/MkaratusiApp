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
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.fragments.WaitingTpFragment;
import com.tfs.mkaratusi.mkaratusi.pojo.PrintTp;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_ID;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;


public class WaitingTpAdapter extends RecyclerView.Adapter<WaitingTpAdapter.MyViewHolder> {


    private List<PrintTp> printTps;
    Activity activity;

    public WaitingTpAdapter(List<PrintTp> printTpList, Activity activity) {
        this.printTps = printTpList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_waitingtp, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final PrintTp transitPass = printTps.get(position);
        holder.listTPNo.setText("TP No : " + transitPass.getTransitPassNo());
       // holder.listTpIssuedTo.setText("Issued To : " + transitPass.getIssuedTo());
       holder.listTpLicenseNo.setText("License No : " + transitPass.getLisenceNo());
       holder.listTpBillNo.setText("Bill No : " + transitPass.getBillId());
       holder.listTpForm.setText("Source : " + transitPass.getSourceName());
       holder.listTpTo.setText("Destination : " + transitPass.getDestinationName());
       holder.listTpVehicleNo.setText("Vehicle No : " + transitPass.getVehcleNo());
       holder.listDateOfIssue.setText("Issued on : " + transitPass.getIssuedDate());
       holder.listExpiryDate.setText("Expiry on : " + transitPass.getExpireDate());
        holder.listOfficer.setText("Issuer Officer : " + transitPass.getNoOfConsignment());
       holder.listOfficerPhone.setText("Officer No : " + transitPass.getExpireDate());
      holder.listForest.setText("Source Forest : " + transitPass.getNoOfConsignment());
       holder.listHummerNo.setText("Hummer No : " + transitPass.getHummerNo());
        // listStatus.setText("TP Status : " + transitPass.getStatus());
       holder.listTpDesc.setText("More Desc : " + transitPass.getAdditionInformation());

//
       holder.btnProductDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context, ProductDetailActivity.class);
                i.putExtra(AppConfig.KEY_TPID, transitPass.getId());
                i.putExtra(AppConfig.KEY_TPNO, transitPass.getTransitPassNo());
                i.putExtra(AppConfig.KEY_CLIENT, transitPass.getApplicant());
                context.startActivity(i);
            }
        });
//
//       holder.btnRouteDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//                Intent i = new Intent(context, RouteActivity.class);
//                i.putExtra(AppConfig.KEY_TPID, transitPass.getId());
//                i.putExtra(AppConfig.KEY_TPNO, transitPass.getTpNo());
//                i.putExtra(AppConfig.KEY_CLIENT, transitPass.getIssuedTo());
//                context.startActivity(i);
//            }
//        });
//
//       holder.btnCargoIssue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//                Intent i = new Intent(context, ResultActivity.class);
//                i.putExtra(AppConfig.KEY_TPID, transitPass.getId());
//                i.putExtra(AppConfig.KEY_TPNO, transitPass.getTpNo());
//                i.putExtra(AppConfig.KEY_CLIENT, transitPass.getIssuedTo());
//                context.startActivity(i);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return printTps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView listTPNo, listDateOfIssue, listExpiryDate, product, listStatus,
                listTpIssuedTo, listTpLicenseNo, listTpBillNo, listTpForm,
                listTpTo, listTpVehicleNo,
                listOfficer, listOfficerPhone, listForest, listHummerNo, listTpDesc;
        public CardView cardView;
        public FloatingActionButton btnProductDetail, btnRouteDetail, btnCargoIssue;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            cardView = (CardView) itemView.findViewById(R.id.tp_cardView);
            listTpIssuedTo = (TextView) itemView.findViewById(R.id.list_tp_issued_to);
            listTPNo = (TextView) itemView.findViewById(R.id.list_tp_number);
            listTpLicenseNo = (TextView) itemView.findViewById(R.id.list_license_no);
            listTpBillNo = (TextView) itemView.findViewById(R.id.list_bill_no);
            listTpForm = (TextView) itemView.findViewById(R.id.list_from_village);
            listTpTo = (TextView) itemView.findViewById(R.id.list_to_village);
            listTpVehicleNo = (TextView) itemView.findViewById(R.id.list_vehicle_reg_no);
            listDateOfIssue = (TextView) itemView.findViewById(R.id.list_date_of_issue);
            listExpiryDate = (TextView) itemView.findViewById(R.id.list_expiry_date);
            listOfficer = (TextView) itemView.findViewById(R.id.list_officer);
            listOfficerPhone = (TextView) itemView.findViewById(R.id.list_officer_phone);
            listForest = (TextView) itemView.findViewById(R.id.list_forest);
            listHummerNo = (TextView) itemView.findViewById(R.id.list_hummer_no);
            listTpDesc = (TextView) itemView.findViewById(R.id.list_tp_desc);
            btnProductDetail = (FloatingActionButton) itemView.findViewById(R.id.btn_product_detail);
            btnRouteDetail = (FloatingActionButton) itemView.findViewById(R.id.btn_checkpoint_route);
            btnCargoIssue = (FloatingActionButton) itemView.findViewById(R.id.btn_cargo_issue);
            btnProductDetail.setLabelText("product detail");
        }


        public void setFilter(List<Transitpass> applicants) {
            applicants = new ArrayList<>();
            applicants.addAll(applicants);
            notifyDataSetChanged();
        }
    }
}