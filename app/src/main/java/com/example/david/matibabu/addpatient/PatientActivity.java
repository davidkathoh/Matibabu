package com.example.david.matibabu.addpatient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.david.matibabu.R;
import com.example.david.matibabu.home.HomeActivity;
import com.example.david.matibabu.listpatient.PatientListActivity;
import com.example.david.matibabu.statistics.StatisticActivity;
import com.example.david.matibabu.utils.ActivityUtils;

public class PatientActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
       {
           private PatientPresenter mPresenter;
           private PatientAntPresenter mAntPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addpatient_act);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PatientInfoFragment patientInfoFragment =
                (PatientInfoFragment)getSupportFragmentManager().findFragmentById(R.id.content_main);
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (patientInfoFragment == null){
            patientInfoFragment = PatientInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),patientInfoFragment,R.id.content_main);
        }

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // initializing the presenter
        mPresenter = new PatientPresenter(patientInfoFragment,getApplicationContext());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
      displaySelectedScreen(item.getItemId());
        return true;
    }
public void displaySelectedScreen(int itemId){
    Fragment fragment = null;
    switch (itemId){
        case R.id.nav_home:
            startActivity(new Intent(this, HomeActivity.class));
            break;
        case R.id.nav_add_patient:
            //nothing todo
            fragment = new PatientInfoFragment();
            break;
        case R.id.nav_cpn:
            startActivity(new Intent(this, PatientListActivity.class));
            break;
        case R.id.nav_statistic:
            startActivity(new Intent(this, StatisticActivity.class));

    }
    if (fragment != null){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main,fragment);
        ft.commit();
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
}

}
