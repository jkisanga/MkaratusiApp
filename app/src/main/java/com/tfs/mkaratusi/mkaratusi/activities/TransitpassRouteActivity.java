package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sagereal.api.Printer;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.models.RActivity;
import com.tfs.mkaratusi.mkaratusi.models.RCheckpoint;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;
import com.tfs.mkaratusi.mkaratusi.pojo.BillPrint;
import com.tfs.mkaratusi.mkaratusi.pojo.Checkpoint;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointTP;
import com.tfs.mkaratusi.mkaratusi.pojo.Transitpass;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;
import com.tfs.mkaratusi.mkaratusi.testmp3.CurrentPrinterStatusEnum;
import com.tfs.mkaratusi.mkaratusi.testmp3.DeviceInformation;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tfs.mkaratusi.mkaratusi.activities.HomeActivity.HOME_ACTIVITY;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.APPLICANT_NAME;
import static com.tfs.mkaratusi.mkaratusi.app.AppConfig.TRANSITPASS_ID;

public class TransitpassRouteActivity extends AppCompatActivity {

    int TransitpassId = 0;
    ListView listview ;
   List<String>  checkpointName;
   List<Integer>  checkpointId;
   String ApplicantName = "";
    List<String> ValueHolder;
    ProgressDialog dialog;

    private Printer printer = null;
    DeviceInformation info;
    TextView textError;
    StringBuilder stb;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    Date currentDate = null;
    public static String newline = System.getProperty("line.separator");

    SparseBooleanArray sparseBooleanArray ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transitpass_route);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        dialog = new ProgressDialog(this);

        Bundle b = getIntent().getExtras();
        if(b != null){
            TransitpassId = b.getInt(TRANSITPASS_ID);
            ApplicantName = b.getString(APPLICANT_NAME);
            toolbar.setTitle(ApplicantName + " Routes");
            setSupportActionBar(toolbar);
        }
        List<RCheckpoint> rCheckpoints = RealmController.with(this).getCheckpoints();
        checkpointName = new ArrayList<>();
        checkpointId = new ArrayList<>();
        for(int i =0; i <= rCheckpoints.size() -1; i++){
            checkpointName.add(rCheckpoints.get(i).getName());
            checkpointId.add(rCheckpoints.get(i).getId());

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createCheckpointRoute();

            }
        });


        listview = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (TransitpassRouteActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, checkpointName );

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                sparseBooleanArray = listview.getCheckedItemPositions();

               ValueHolder = new ArrayList<>();

                int i = 0 ;

                while (i < sparseBooleanArray.size()) {

                    if (sparseBooleanArray.valueAt(i)) {

                        ValueHolder.add(checkpointName.get(sparseBooleanArray.keyAt(i)));
                    }

                    i++ ;
                }


            }
        });


        textError=((TextView)findViewById(R.id.textError));
        //get instance
        printer = Printer.getInstance();
        info=new DeviceInformation(this);



    }

    private void createCheckpointRoute() {
        for(int i =0; i <= ValueHolder.size()-1; i++){
          RCheckpoint rCheckpoint =  RealmController.with(TransitpassRouteActivity.this).getSelectedCheckpointId(ValueHolder.get(i)) ;
         int cId = rCheckpoint.getId();
            postSelectedCheckpoint(cId, TransitpassId);
        }
    }

    private void postSelectedCheckpoint(int cId, int transitpassId) {
        final CheckpointTP checkpointTP = new CheckpointTP();
        checkpointTP.setTransitPassId(transitpassId);
        checkpointTP.setStationId(cId);

        try {
            dialog.setMessage("saving ...");
            dialog.show();
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<CheckpointTP> call = getResponse.postCheckpointTp(checkpointTP);
            call.enqueue(new retrofit2.Callback<CheckpointTP>() {
                @Override
                public void onResponse(retrofit2.Call<CheckpointTP> call, retrofit2.Response<CheckpointTP> response) {
                    if (response.isSuccessful()) {
                        CheckpointTP checkpointTP1 = response.body();

                        printBill(checkpointTP1.getTransitPassId());
                        startActivity(new Intent(TransitpassRouteActivity.this, HomeActivity.class));
                        finish();
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }else{

                    }

                }

                @Override
                public void onFailure(retrofit2.Call<CheckpointTP> call, Throwable t) {
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



    public void printBill(int tpId) {



        CurrentPrinterStatusEnum statusPrinter=CurrentPrinterStatusEnum.fromCode(printer.getCurrentPrinterStatus());
        switch (statusPrinter){
            case PRINTER_STATUS_OK:
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_OK", Toast.LENGTH_SHORT).show();
                if(!printer.isPrinterOperation()){
                    Toast.makeText(getApplicationContext(), "isNotPrinterOperation", Toast.LENGTH_SHORT).show();
                    if(printer.voltageCheck())
                        printContent(tpId);
                    else{
                        showError("VOLTAGE ERROR");
                        Toast.makeText(getApplicationContext(), "VOLTAGE ERROR", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showError("Exist Operation");
                    Toast.makeText(getApplicationContext(), "isPrinterOperation", Toast.LENGTH_SHORT).show();
                }
                break;
            case PRINTER_STATUS_NO_PAPER:
                showError("PRINTER_STATUS_NO_PAPER");
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_NO_PAPER", Toast.LENGTH_SHORT).show();
                break;
            case PRINTER_STATUS_NO_REACTION:
                showError("PRINTER_STATUS_NO_REACTION");
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_NO_REACTION", Toast.LENGTH_SHORT).show();
                break;
            case PRINTER_STATUS_GET_FAILE:
                showError("PPRINTER_STATUS_GET_FAILE");
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_GET_FAILE", Toast.LENGTH_SHORT).show();
                break;
            case PRINTER_STATUS_LOW_POWER:
                showError("PRINTER_STATUS_LOW_POWER");
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_LOW_POWER", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    int clt=0;
    boolean showSuccess=true;
    public void printContent(int tpId){

        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<List<BillPrint>> call = getResponse.getBillPrint(tpId);
            call.enqueue(new retrofit2.Callback<List<BillPrint>>() {
                @Override
                public void onResponse(retrofit2.Call<List<BillPrint>> call, retrofit2.Response<List<BillPrint>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<BillPrint> billPrints = response.body();

                    stb = new StringBuilder();
                    stb.append(newline);
                    stb.append("Bill for " + ApplicantName);
                    stb.append(newline);
                    stb.append("Government Bill");
                    stb.append(newline);
                    stb.append(newline);
                    stb.append("Bill item  : " + billPrints.get(0).getDescription().toString());
                    stb.append(newline);
                    stb.append("Payer name : " + billPrints.get(0).getPayerName().toString());
                    stb.append(newline);
                    stb.append("Payer phone: " + billPrints.get(0).getPayerPhone().toString());
                    stb.append(newline);
                    stb.append("Pay Address : " + billPrints.get(0).getPayerAddress().toString());
                    stb.append(newline);
                    stb.append("Expire date: " + billPrints.get(0).getExpireDate().toString());

                    for(int i =0; i < billPrints.size(); i++){

                        //stb = new StringBuilder();
                        //stb.append(newline);
                        stb.append("Bill Item: " + billPrints.get(i).getItemDescription().toString());
                        stb.append(newline);
                        stb.append("Amount     : TZS " + billPrints.get(i).getAmount().toString());
                        stb.append(newline);
                    }
                        // stb.append("Reference  : " + billPrints.get(i).getControlNumber().toString());
                        stb.append(newline);
                        stb.append(newline);
                        stb.append("Malipo yafanywe kupitia Benki\n(NMB/CRDB/NBC) au Mitandao(MPESA\nTigoPesa/Airtel Money kwa \nnamba ya kampuni 888999).Piga\nnamba 022 212 6384 kwa maelezo\nZaidi." );
                        stb.append(newline);
                        stb.append(newline);
                        currentDate = new Date();
                        // stb.append("POS center : "+intent.getExtras().get("collectionCenter").toString());
                        stb.append(newline);
                        stb.append("Printed on : "+sdf.format(currentDate));
                        stb.append(newline);
                        stb.append(newline);
                        stb.append("Signature : " + "...................");
//                        stb.append(newline);
//        try {
//            String message = controllNumber.getText().toString();
//            if (message.length() > 0) {
//                try {
//                    message = new String(message.getBytes("utf8"));
//                } catch (UnsupportedEncodingException e) {
//                }
//            }




/*


                        byte[] text = null;
                        text = st.toString().getBytes("GBK");
                        addPrintTextWithSize(1, 30, text);
                  int mWidth = 400;
                        int mHeight = 60;
                        mBitmap = BarcodeCreater.creatBarcode(getApplicationContext(),
                                billControlNumber.getText().toString(), mWidth, mHeight, true, 1);
                        byte[] printData = BitmapTools.bitmap2PrinterBytes(mBitmap);
                        mPrintQueue.addBmp(30, 30, mBitmap.getWidth(),
                                mBitmap.getHeight(), printData);

*/
                        //  st = new StringBuilder();

                        stb.append(newline);
                        stb.append("*********  END OF BILL *********");
                        stb.append(newline);
                        stb.append(newline);
                        stb.append(newline);
                        stb.append(newline);


                        new Thread(new Runnable() {
                            @Override
                            public void run()
                            {
                                try {
                                    // printer.printBitmap(getResources().openRawResource(R.raw.bitmap5));
                                    printer.printEndLine();
                                    Log.d("run", "run: " + stb.toString());
                                    printer.printText("Bill for " + ApplicantName,2,false);
                                    printer.printText(stb.toString(),1,false);

                                    // Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.raw.and3);
                                    //  printer.print32Bitmap(bmp);
                                    printer.printEndLine();
                                    while(printer.isPrinterOperation()){
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                showOnProgress();
                                /*if(printer.getPaperStatus()!=1){
                                    showError("RINTER_STATUS_NO_PAPER");
                                    showSuccess=false;
                                }*/

                                            }
                                        });
                                    }

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            //if(showSuccess==true)
                                            showSuccess();
                                        }
                                    });
                                }
                                catch (Exception e)
                                {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            showError(getString(R.string.text_unknown_error));
                                        }
                                    });

                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    Log.d(HOME_ACTIVITY, "onResponse: " + RealmController.with(TransitpassRouteActivity.this).getActivities());



                }

                @Override
                public void onFailure(retrofit2.Call<List<BillPrint>> call, Throwable t) {

                }


            });
        } catch (Exception e) {

        }






    }


    public void showError(String error){


        textError.setVisibility(View.VISIBLE);
        textError.setBackgroundColor(getResources().getColor(R.color.red));
        textError.setText(getString(R.string.text_printKO)+"\n"+error);
    }

    public void showSuccess(){

        textError.setVisibility(View.VISIBLE);
        textError.setBackgroundColor(getResources().getColor(R.color.green));
        textError.setText(getString(R.string.text_printOK));
    }

    public void showOnProgress(){

        textError.setVisibility(View.VISIBLE);
        textError.setBackgroundColor(getResources().getColor(R.color.green_light));
        textError.setText(getString(R.string.text_printProgress));
    }


}
