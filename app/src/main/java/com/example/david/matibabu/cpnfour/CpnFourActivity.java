package com.example.david.matibabu.cpnfour;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class CpnFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpn_four);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_cpn_four);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CpnFourFragment cpnFourFragment =
                (CpnFourFragment)getSupportFragmentManager().findFragmentById(R.id.content_main_cpn);
        if (cpnFourFragment == null){
            cpnFourFragment = CpnFourFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    cpnFourFragment,R.id.content_main_cpn);
        }
    }
}
