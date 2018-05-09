package com.example.david.matibabu.cpntwo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.david.matibabu.R;
import com.example.david.matibabu.utils.ActivityUtils;

public class CpnTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpn_two);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_cpn_two);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CpnTwoFragment cpnTwoFragment =
                (CpnTwoFragment)getSupportFragmentManager().findFragmentById(R.id.content_main_cpn);
        if (cpnTwoFragment == null){
            cpnTwoFragment = CpnTwoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    cpnTwoFragment,R.id.content_main_cpn);
        }
    }
}
