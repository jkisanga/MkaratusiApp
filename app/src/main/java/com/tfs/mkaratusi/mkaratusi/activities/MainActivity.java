package com.tfs.mkaratusi.mkaratusi.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sagereal.api.Printer;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.testmp3.CurrentPrinterStatusEnum;
import com.tfs.mkaratusi.mkaratusi.testmp3.DeviceInformation;

public class MainActivity extends AppCompatActivity {

    private Printer printer = null;
    DeviceInformation info;
    TextView textError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Intent i = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
        //startActivity(i);

        textError=((TextView)findViewById(R.id.textError));
        //get instance
        printer = Printer.getInstance();
        info=new DeviceInformation(this);
        setInformationDevice();
        //getPrinterDriverVersion();
        //Intent intent = new Intent(WelcomeActivity.this, Mp3Service.class);
        //startService(intent);


    }

    /*
    public void getPrinterDriverVersion(){

        try {
            Log.e("pause","pause");
            Runtime.getRuntime().exec("input touchscreen tap 100 450\n");
        } catch (Exception e) {
            Log.e("exception",e.toString());
        }

    }
    */




    public void setInformationDevice(){
        ((TextView)findViewById(R.id.textModel)).setText(info.getModel());
        ((TextView)findViewById(R.id.textId)).setText(info.getId());
        ((TextView)findViewById(R.id.textManufacturer)).setText(info.getManufacturer());
        ((TextView)findViewById(R.id.textBBVersion)).setText(info.getBaseBandVersion());
        ((TextView)findViewById(R.id.textKernelVersion)).setText(info.getKernelVersion());
        ((TextView)findViewById(R.id.textBuildVersion)).setText(info.getBuidNumber());
        ((TextView)findViewById(R.id.textAndroidVersion)).setText(info.getAndroidVersion());
        ((TextView)findViewById(R.id.textCBuildVersion)).setText(info.getCustomBuildVersion());
        ((TextView)findViewById(R.id.textImei)).setText(info.getImei());
        ((TextView)findViewById(R.id.textMacAddress)).setText(info.getMacAddress());
    }

    public void testClick(View v) {
        Log.e("click","click");
        CurrentPrinterStatusEnum statusPrinter=CurrentPrinterStatusEnum.fromCode(printer.getCurrentPrinterStatus());
        switch (statusPrinter){
            case PRINTER_STATUS_OK:
                Toast.makeText(getApplicationContext(), "PRINTER_STATUS_OK", Toast.LENGTH_SHORT).show();
                if(!printer.isPrinterOperation()){
                    Toast.makeText(getApplicationContext(), "isNotPrinterOperation", Toast.LENGTH_SHORT).show();
                    if(printer.voltageCheck())
                        printContent();
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
    public void printContent(){
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                   // printer.printBitmap(getResources().openRawResource(R.raw.bitmap5));
                    printer.printEndLine();

                    printer.printText("Model",2,false);
                    printer.printText("\u0001"+info.getModel(),1,false);

                    printer.printText("Id",2,false);
                    printer.printText(info.getId(),1,false);

                    printer.printText("Manufacturer",2,false);
                    printer.printText(info.getManufacturer(),1,false);


                    printer.printText("Base Band Version",2,false);
                    printer.printText(info.getBaseBandVersion(),1,false);

                    printer.printText("kernel Version",2,false);
                    printer.printText(info.getKernelVersion(),1,false);

                    printer.printText("Build Number",2,false);
                    printer.printText(info.getBuidNumber(),1,false);

                    printer.printText("Android Version",2,false);
                    printer.printText(info.getAndroidVersion(),1,false);

                    printer.printText("Cusom Build Version",2,false);
                    printer.printText(info.getCustomBuildVersion(),1,false);

                    printer.printText("IMEI",2,false);
                    printer.printText(info.getImei(),1,false);

                    printer.printText("Mac Address",2,false);
                    printer.printText(info.getMacAddress(),1,false);

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
