package com.example.david.matibabu.home;

import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.example.david.matibabu.listpatient.PatientListActivity;
import com.example.david.matibabu.utils.ActivityUtils;

public class HomeActivity extends AppCompatActivity
                        implements NavigationView.OnNavigationItemSelectedListener{

    HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        HomeFragment homeFragment =   (HomeFragment)getSupportFragmentManager()
                .findFragmentById(R.id.content_main);
        if (homeFragment == null){
        homeFragment =  HomeFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),homeFragment,
                R.id.content_main);}
        mHomePresenter = new HomePresenter(homeFragment,getApplicationContext());
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }
    public void displaySelectedScreen(int itemId){
        Fragment fragment = null;
        switch (itemId){
            case R.id.nav_home:
                break;
            case R.id.nav_add_patient:
                //nothing todo
                startActivity(new Intent(this, PatientActivity.class));
                //fragment = new PatientInfoFragment();
                break;
            case R.id.nav_cpn:
                startActivity(new Intent(this, PatientListActivity.class));
        }
        if (fragment != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
