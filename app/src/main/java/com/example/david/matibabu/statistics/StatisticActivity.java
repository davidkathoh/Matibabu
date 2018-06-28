package com.example.david.matibabu.statistics;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.david.matibabu.R;
import com.example.david.matibabu.addpatient.PatientActivity;
import com.example.david.matibabu.addpatient.PatientInfoFragment;
import com.example.david.matibabu.addpatient.PatientPresenter;
import com.example.david.matibabu.home.HomeActivity;
import com.example.david.matibabu.listpatient.PatientListActivity;
import com.example.david.matibabu.utils.ActivityUtils;

public class StatisticActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    StatisticPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getActionBar().setTitle("Statistiques");
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        StatisticFragment statisticFragment =(StatisticFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_main);

        if (statisticFragment == null){
            statisticFragment = StatisticFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),statisticFragment
                                        ,R.id.content_main);
        }
        mPresenter = new StatisticPresenter(getApplicationContext(),statisticFragment);
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
                startActivity(new Intent(this, PatientActivity.class));
                break;
            case R.id.nav_cpn:
                startActivity(new Intent(this, PatientListActivity.class));
                break;
            case R.id.nav_statistic:


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
