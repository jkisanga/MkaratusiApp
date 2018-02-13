package com.tfs.mkaratusi.mkaratusi.app;

import com.tfs.mkaratusi.mkaratusi.pojo.Activity;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;
import com.tfs.mkaratusi.mkaratusi.pojo.Bill;
import com.tfs.mkaratusi.mkaratusi.pojo.BillItem;
import com.tfs.mkaratusi.mkaratusi.pojo.BillPrint;
import com.tfs.mkaratusi.mkaratusi.pojo.Checkpoint;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointPrint;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointTP;
import com.tfs.mkaratusi.mkaratusi.pojo.PosUser;
import com.tfs.mkaratusi.mkaratusi.pojo.PrintTp;
import com.tfs.mkaratusi.mkaratusi.pojo.Product;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;
import com.tfs.mkaratusi.mkaratusi.pojo.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Dell on 1/18/2018.
 */

public interface ApiConfig {

    @GET("/api/Applicant/applicantList")
    Call<List<Applicant>> getApplicants();

    @GET("/api/Applicant/activityList")
    Call<List<Activity>> getActivities();

    @GET("/api/Applicant/CheckpointList")
    Call<List<Checkpoint>> getCheckpoints();


    @GET("/api/Applicant/BillItemList")
    Call<List<BillItem>> getBillItems();

    @GET("/api/Applicant/getTPBill/{Id}")
    Call<List<BillPrint>> getBillPrint(@Path("Id") int Id);

    @POST("/api/Applicant/RespondBill")
    Call<Bill> postBill(@Body Bill bill);


    @POST("/api/Applicant/ResponseBillItem")
    Call<BillItem> postBillItem(@Body BillItem billItem);


    @POST("/api/Applicant/ResponseTransitpass")
    Call<Transitpass> postTransipass(@Body Transitpass transitpass);


    @POST("/api/Applicant/ResponseCheckpointTP")
    Call<CheckpointTP> postCheckpointTp(@Body CheckpointTP checkpointTP);

    @POST("/api/PosUser/Login")
    Call<PosUser> postUserLogin(@Body PosUser user);

    @GET("/Api/TransitPass/getItemsByTransitPassId/{id}")
    Call<List<Product>> getTpProducts(@Path("id") int id);

    @GET("/Api/TransitPass/getCheckPointsByTransitPassId/{id}")
    Call<List<CheckpointPrint>> getTpCheckpoints(@Path("id") int id);

    @GET("/Api/TransitPass/getIssuedTransitPasses")
    Call<List<PrintTp>> getWeiting();

    @POST("/api/Applicant/ResponseOkInspection")
    Call<CheckpointTP> postInspectionOK(@Body CheckpointTP checkpointPrint);


}
