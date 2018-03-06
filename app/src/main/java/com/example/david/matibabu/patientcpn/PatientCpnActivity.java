package com.example.david.matibabu.patientcpn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class PatientCpnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_cpn_activity);

        CpnFragment cpnFragment =  new CpnFragment();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),cpnFragment,R.id.content_main);
    }
}