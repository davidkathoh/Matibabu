package com.example.david.matibabu;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by david on 6/23/18.
 */

public class FirebaseOffline extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    //    FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
