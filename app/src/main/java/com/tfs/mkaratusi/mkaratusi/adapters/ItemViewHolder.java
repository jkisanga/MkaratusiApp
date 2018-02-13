package com.tfs.mkaratusi.mkaratusi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.activities.ProductDetailActivity;
import com.tfs.mkaratusi.mkaratusi.activities.RouteActivity;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.pojo.PrintTp;

/**
 * Created by Dell on 2/12/2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder{
    public TextView listTPNo, listDateOfIssue, listExpiryDate, product, listStatus,
            listTpIssuedTo, listTpLicenseNo, listTpBillNo, listTpForm,
            listTpTo, listTpVehicleNo,
            listOfficer, listOfficerPhone, listForest, listHummerNo, listTpDesc;
    public CardView cardView;
    public FloatingActionButton btnProductDetail, btnRouteDetail, btnCargoIssue;
    public ItemViewHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        cardView = itemView.findViewById(R.id.tp_cardView);
        listTpIssuedTo = itemView.findViewById(R.id.list_tp_issued_to);
        listTPNo = itemView.findViewById(R.id.list_tp_number);
        listTpLicenseNo = itemView.findViewById(R.id.list_license_no);
        listTpBillNo = itemView.findViewById(R.id.list_bill_no);
        listTpForm = itemView.findViewById(R.id.list_from_village);
        listTpTo = itemView.findViewById(R.id.list_to_village);
        listTpVehicleNo = itemView.findViewById(R.id.list_vehicle_reg_no);
        listDateOfIssue = itemView.findViewById(R.id.list_date_of_issue);
        listExpiryDate = itemView.findViewById(R.id.list_expiry_date);
        listOfficer = itemView.findViewById(R.id.list_officer);
        listOfficerPhone = itemView.findViewById(R.id.list_officer_phone);
        listForest = itemView.findViewById(R.id.list_forest);
        listHummerNo = itemView.findViewById(R.id.list_hummer_no);
        listTpDesc = itemView.findViewById(R.id.list_tp_desc);
        btnProductDetail = itemView.findViewById(R.id.btn_product_detail);
        btnRouteDetail = itemView.findViewById(R.id.btn_checkpoint_route);
        btnCargoIssue = itemView.findViewById(R.id.btn_cargo_issue);
    }

    public void bind(final PrintTp transitPass) {
        listTPNo.setText("TP No : " + transitPass.getTransitPassNo());
        listTpIssuedTo.setText("Issued To : " + transitPass.getApplicant());
        listTpLicenseNo.setText("License No : " + transitPass.getLisenceNo());
        listTpBillNo.setText("Bill No : " + transitPass.getBillId());
        listTpForm.setText("Source : " + transitPass.getSourceName());
        listTpTo.setText("Destination : " + transitPass.getDestinationName());
        listTpVehicleNo.setText("Vehicle No : " + transitPass.getVehcleNo());
        listDateOfIssue.setText("Issued on : " + transitPass.getIssuedDate());
        listExpiryDate.setText("Expiry on : " + transitPass.getExpireDate());
        listOfficer.setText("Issuer Officer : " + transitPass.getNoOfConsignment());
        listOfficerPhone.setText("Officer No : " + transitPass.getExpireDate());
        listForest.setText("Source Forest : " + transitPass.getNoOfConsignment());
        listHummerNo.setText("Hummer No : " + transitPass.getHummerNo());
        // listStatus.setText("TP Status : " + transitPass.getStatus());
        listTpDesc.setText("More Desc : " + transitPass.getAdditionInformation());

//
        btnProductDetail.setOnClickListener(new View.OnClickListener() {
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

        btnRouteDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context, RouteActivity.class);
                i.putExtra(AppConfig.KEY_TPID, transitPass.getId());
                i.putExtra(AppConfig.KEY_TPNO, transitPass.getTransitPassNo());
                i.putExtra(AppConfig.KEY_CLIENT, transitPass.getApplicant());
                context.startActivity(i);
            }
        });

//       btnCargoIssue.setOnClickListener(new View.OnClickListener() {
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

}
