package com.example.david.matibabu.listpatient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.david.matibabu.R;
import com.example.david.matibabu.addpatient.PatientActivity;
import com.example.david.matibabu.addpatient.PatientInfoFragment;
import com.example.david.matibabu.utils.ActivityUtils;

/**
 * Created by david on 2/12/18.
 */

public class PatientListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listpatient_act);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Femme enciente");
        setSupportActionBar(toolbar);
        PatientListFragment patientListFragment = (PatientListFragment)getSupportFragmentManager()
                .findFragmentById(R.id.content_main);

        if (patientListFragment == null) {
            patientListFragment = PatientListFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    patientListFragment, R.id.content_main);
        }else{
            Log.e("Errors","patent null");
        }
       // ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),new PatientListFragment(),
        //R.id.content_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home :
                break;
            case R.id.nav_cpn:
                //nothing todo alreay in nav_cpn
                break;
            case R.id.nav_add_patient:
               startActivity(new Intent(this, PatientActivity.class));
                break;
            case R.id.nav_statistic:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
