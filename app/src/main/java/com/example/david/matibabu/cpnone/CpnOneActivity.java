package com.example.david.matibabu.cpnone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;

import com.example.david.matibabu.R;
import com.example.david.matibabu.patientdetail.PatientDetailActivity;
import com.example.david.matibabu.utils.ActivityUtils;

public class CpnOneActivity extends AppCompatActivity {

    private String name;
    private long UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpn_one);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        UID =  intent.getLongExtra("uid",0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_cpn_one);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CpnOneFragment cpnOneFragment =
                (CpnOneFragment)getSupportFragmentManager().findFragmentById(R.id.content_main_cpn);
        if (cpnOneFragment == null){
            cpnOneFragment = CpnOneFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    cpnOneFragment,R.id.content_main_cpn);
        }
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//            Intent i = new Intent(this, PatientDetailActivity.class);
//            i.putExtra("uid",UID);
//            i.putExtra("name",name);
//            startActivity(i);
//        }




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
