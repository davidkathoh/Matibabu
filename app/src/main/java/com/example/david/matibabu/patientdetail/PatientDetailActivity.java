package com.example.david.matibabu.patientdetail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;


import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class PatientDetailActivity extends AppCompatActivity {
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_detail_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Intent intent = getIntent();
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        CpnDetailFragment cpnDetailFragment =  new CpnDetailFragment();
        cpnDetailFragment.setRetainInstance(true);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cpnDetailFragment,R.id.container);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(getLocalClassName(),"on backPressed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(getLocalClassName(),"on stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(getLocalClassName(),"on Resume");
    }
}
