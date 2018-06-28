package com.example.david.matibabu.account.signup;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.preferences.PreferManager;
import com.example.david.matibabu.utils.ActivityUtils;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    SignupPresenter mSignupPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        SignupFragment signupFragment = (SignupFragment)getSupportFragmentManager()
                .findFragmentById(R.id.frag_authentificarion);
        if (signupFragment == null) {
            signupFragment = SignupFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), signupFragment
                    , R.id.frag_authentificarion);
        }
        mSignupPresenter = new SignupPresenter(signupFragment);

    }


}
