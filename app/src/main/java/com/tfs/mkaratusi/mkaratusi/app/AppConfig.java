package com.tfs.mkaratusi.mkaratusi.app;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Dell on 1/18/2018.
 */

public class AppConfig {
    //public static String BASE_URL = "http://192.168.43.196:8081";
    public static String BASE_URL = "http://154.118.224.146";

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    public static final String APPLICANT_ID = "ApplicantId";
    public static final String APPLICANT_NAME = "ApplicantName";
    public static final String BILL_ID = "bill_id";
    public static final String TAG = "LOG_TAG";
    public static final String TRANSITPASS_ID = "Transitpass_id";


    public final static String KEY_TPID = "tp_id";
    public final static String KEY_TPNO = "tp_no";
    public final static String KEY_CLIENT = "tp_client";
    public final static String KEY_CHECKPOINT_ID = "tp_checkpoint_id";
    public final static String KEY_CHECKPOINT = "tp_checkpoint";
    public final static String KEY_PRODUCT = "tp_product";
    public final static String KEY_USER_ID = "user_id";


    public final static String KEY_STATUS = "carg_status";
    public final static String KEY_IRREGULARITY = "irregularity";
    public final static String KEY_QUANTITY = "quantity";
    public final static String KEY_UNIT = "unit";
    public final static String KEY_VALUE = "value";
    public final static String KEY_ACTION = "action";
    public final static String KEY_ACTION_AMOUNT = "action_amount";
    public final static String KEY_RECEIPT_NO = "receipt_no";
    public final static String KEY_INSPECTOR = "inspected_by";
    public final static String KEY_DATE = "created_at";
}
