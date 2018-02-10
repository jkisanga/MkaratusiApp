package com.tfs.mkaratusi.mkaratusi.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.clans.fab.FloatingActionButton;
import com.squareup.okhttp.OkHttpClient;
import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.app.ApiConfig;
import com.tfs.mkaratusi.mkaratusi.app.AppConfig;
import com.tfs.mkaratusi.mkaratusi.fragments.ExpiredTpFragment;
import com.tfs.mkaratusi.mkaratusi.fragments.WaitingTpFragment;
import com.tfs.mkaratusi.mkaratusi.models.RActivity;
import com.tfs.mkaratusi.mkaratusi.models.RCheckpoint;
import com.tfs.mkaratusi.mkaratusi.pojo.Activity;
import com.tfs.mkaratusi.mkaratusi.pojo.Applicant;
import com.tfs.mkaratusi.mkaratusi.pojo.Checkpoint;
import com.tfs.mkaratusi.mkaratusi.realm.RealmController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager viewPager;
    public static final String HOME_ACTIVITY = "HomeActivity";
    private ProgressDialog dialog;
    private Realm realm;
    FloatingActionButton btnAddTP, btnPenndingTp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        btnAddTP =  findViewById(R.id.btn_add_tp);
        btnPenndingTp = findViewById(R.id.btn_pending_tp);
        btnPenndingTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });



        dialog = new ProgressDialog(this);
        this.realm = RealmController.with(this).getRealm();

        btnAddTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TPActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setDataToLocalActityTable();
        setDataToLocalCheckpointTable();
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WaitingTpFragment(), "Waiting");
        adapter.addFragment(new ExpiredTpFragment(), "Expired");
        viewPager.setAdapter(adapter);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setDataToLocalActityTable() {

        dialog.setMessage("updating data ...");
        dialog.show();
        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<List<Activity>> call = getResponse.getActivities();
            call.enqueue(new retrofit2.Callback<List<Activity>>() {
                @Override
                public void onResponse(retrofit2.Call<List<Activity>> call, retrofit2.Response<List<Activity>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<Activity> activities = response.body();
                    for(int i =0; i < activities.size(); i++){
                        RActivity rActivity = new RActivity();
                        rActivity.setId(activities.get(i).getId());
                        rActivity.setName(activities.get(i).getName());
                        rActivity.setDescription(activities.get(i).getDescription());
                        rActivity.setFee(activities.get(i).getFee());
                        rActivity.setRegistrationFee(activities.get(i).getRegistrationFee());


                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(rActivity);
                        realm.commitTransaction();

                    }
                    Log.d(HOME_ACTIVITY, "onResponse: " + RealmController.with(HomeActivity.this).getActivities());

                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }

                }

                @Override
                public void onFailure(retrofit2.Call<List<Activity>> call, Throwable t) {
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

    private void setDataToLocalCheckpointTable() {


        try {
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);

            retrofit2.Call<List<Checkpoint>> call = getResponse.getCheckpoints();
            call.enqueue(new retrofit2.Callback<List<Checkpoint>>() {
                @Override
                public void onResponse(retrofit2.Call<List<Checkpoint>> call, retrofit2.Response<List<Checkpoint>> response) {
                    Log.d("onResponse", "onResponse: ");
                    List<Checkpoint> checkpoints = response.body();
                    for(int i =0; i < checkpoints.size(); i++){
                        RCheckpoint rCheckpoint = new RCheckpoint();
                        rCheckpoint.setId(checkpoints.get(i).getId());
                        rCheckpoint.setName(checkpoints.get(i).getName());
                        rCheckpoint.setRegionId(checkpoints.get(i).getRegionId());
                        rCheckpoint.setZoneId(checkpoints.get(i).getZoneId());
                        rCheckpoint.setAddress(checkpoints.get(i).getAddress());

                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(rCheckpoint);
                        realm.commitTransaction();

                    }
                    Log.d(HOME_ACTIVITY, "onResponse: " + RealmController.with(HomeActivity.this).getActivities());



                }

                @Override
                public void onFailure(retrofit2.Call<List<Checkpoint>> call, Throwable t) {

                }


            });
        } catch (Exception e) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
//            if (position == 0){
//                return new RootFragment();
//            }else {
//                return new SearchFragment();
//            }

            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
            //return null;
        }
    }
}
