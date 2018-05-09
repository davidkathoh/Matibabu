package com.example.david.matibabu.introscreen;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.david.matibabu.R;
import com.example.david.matibabu.account.signup.SignupActivity;
import com.example.david.matibabu.home.HomeActivity;
import com.example.david.matibabu.model.preferences.PreferManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IntroScreen extends AppCompatActivity {
    private PreferManager mManager;
    private Button signup;
    private Button signin;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
        mAuth = FirebaseAuth.getInstance();
        mManager = new PreferManager(this);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(v->{
            startActivity(new Intent(this, SignupActivity.class));
        });
        signin.setOnClickListener(v ->{
            // open signin layout
        });
        mAuthStateListener = (firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() == null){

            }else {
                startActivity(new Intent(this,HomeActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
      mAuth.addAuthStateListener(mAuthStateListener);


//        if (!mManager.isFirstTimeLaunch()){
//            mManager.setFirstTimeLaunch(false);
//            startActivity(new Intent(IntroScreen.this,HomeActivity.class));
//            finish();
//            // lunch home activity
//        }

    }
}
