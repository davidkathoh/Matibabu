package com.example.david.matibabu.patientdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class PatientCpnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_cpn_activity);

        CpnDetailFragment cpnDetailFragment =  new CpnDetailFragment();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), cpnDetailFragment,R.id.container);
    }
}
