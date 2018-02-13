package com.tfs.mkaratusi.mkaratusi.realm;


import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.tfs.mkaratusi.mkaratusi.models.RActivity;
import com.tfs.mkaratusi.mkaratusi.models.RCheckpoint;
import com.tfs.mkaratusi.mkaratusi.models.RPosUser;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }





    //query a single item with the given id
    public RealmResults<RActivity> getActivities() {

        return realm.where(RActivity.class)
        .findAll();
    }
    public RealmResults<RCheckpoint> getCheckpoints() {

        return realm.where(RCheckpoint.class)
        .findAll();
    }


    public RActivity getActivities(String activity) {

        return realm.where(RActivity.class).equalTo("name",activity)
                .findFirst();
    }

    public RCheckpoint getSelectedCheckpointId(String name) {
        return realm.where(RCheckpoint.class).equalTo("name",name)
                .findFirst();
    }

    public RealmResults<RPosUser> getPosUsers() {

        return realm.where(RPosUser.class)
                .findAll();
    }


}
