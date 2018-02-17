package com.example.david.matibabu.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david.matibabu.R;
import com.example.david.matibabu.view.fragment.SignupFragment;

public class AuthentificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SignupFragment sp = new SignupFragment();
        fragmentTransaction.add(R.id.frag_authentificarion,sp);
        fragmentTransaction.commit();


    }
}
