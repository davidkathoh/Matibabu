package com.example.david.matibabu.utils;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by david on 6/21/18.
 */

public class FirebaseAnalytic {
    private  static FirebaseAnalytics mFirebaseAnalytics;

    public static FirebaseAnalytics matibabuAnalyse(Context context)

    {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        mFirebaseAnalytics.setMinimumSessionDuration(5000);
        mFirebaseAnalytics.setSessionTimeoutDuration(1000000);
        return mFirebaseAnalytics;
    }
}
