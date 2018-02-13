package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.app.SessionManager;
import com.tfs.mkaratusi.mkaratusi.models.RPosUser;
import com.tfs.mkaratusi.mkaratusi.models.RUser;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointTP;
import com.tfs.mkaratusi.mkaratusi.pojo.PosUser;
import com.tfs.mkaratusi.mkaratusi.pojo.User;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends Activity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private Button btnLogin;
    String username;
    String pinCode;
    private EditText inputUsername,inputPincode;
    private ProgressDialog dialog;
    private Realm realm;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session manager
        session = new SessionManager(getApplicationContext());
        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        this.realm = RealmController.with(this).getRealm();
        dialog = new ProgressDialog(this);

        inputUsername = (EditText) findViewById(R.id.input_username);
        inputPincode = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        inputPincode.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if(inputUsername.getText().length() > 0 && inputPincode.getText().length() >0){
                                username = inputUsername.getText().toString().trim();
                                 pinCode = inputPincode.getText().toString().trim();

                               checkLogin(username,pinCode);

                            }else{
                                Toast.makeText(LoginActivity.this, "fill username/pin code ", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }


        });




        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                if(inputUsername.getText().length() > 0 && inputPincode.getText().length() >0){
                     username = inputUsername.getText().toString().trim();
                     pinCode = inputPincode.getText().toString().trim();

                    checkLogin(username,pinCode);

                }else{
                    Toast.makeText(LoginActivity.this, "fill username/pin code ", Toast.LENGTH_SHORT).show();
                }


            }

        });



    }

    private void checkLogin(final String username, final String pinCode) {
        dialog.setMessage("validating ...");
        dialog.show();
        final PosUser user = new PosUser();
        user.setUsername(username);
        user.setPassword(pinCode);
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<PosUser> call = getResponse.postUserLogin(user);
            call.enqueue(new retrofit2.Callback<PosUser>() {
                @Override
                public void onResponse(retrofit2.Call<PosUser> call, retrofit2.Response<PosUser> response) {
                    if (response.isSuccessful()) {
                        PosUser user1 = response.body();
                        RPosUser rUser = new RPosUser();
                        rUser.setId(user1.getId());
                        rUser.setOfficerName(user1.getOfficerName());
                        rUser.setUserId(user1.getUserId());
                        rUser.setCheckpointId(user1.getCheckpointId());
                        rUser.setCheckpointName(user1.getCheckpointName());
                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(rUser);
                        realm.commitTransaction();
                        session.setLogin(true);

                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);

                        Toast.makeText(LoginActivity.this, "Successful Login.", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }else{
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        Log.d("Transitpass", "onResponse : onFailure" + response.toString());
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<PosUser> call, Throwable t) {
                    Log.d("Transitpass", "onResponse : onFailure" + t.toString());
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            });
        } catch (Exception e) {
            Log.d("Transitpass", "onResponse: Exception" + e.toString());
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }



    }


}
