package com.example.david.matibabu.cpnthree;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class CpnThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpn_three);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_cpn_three);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CpnThreeFragment cpnThreeFragment =
                (CpnThreeFragment)getSupportFragmentManager().findFragmentById(R.id.content_main_cpn);
        if (cpnThreeFragment == null) {
            cpnThreeFragment = CpnThreeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    cpnThreeFragment,R.id.content_main_cpn);

        }
    }
}
