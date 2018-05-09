package com.example.david.matibabu.model.remote.firebase;

import android.content.Context;

import com.example.david.matibabu.model.hopital.Hopital;
import com.example.david.matibabu.model.hopital.HopitalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by david on 5/6/18.
 */

public class RemoteData {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private FirebaseAuth mAuth;

    public RemoteData() {
        mDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

    }
    public  void signUp(String phone, Context context){

    }

    public void addHopitalRemote(HopitalInfo hopitalInfo){
        String userId = mAuth.getCurrentUser().getUid();
        mReference = mDatabase.getReference().child("Hospitals")
                .child(userId);
        mReference.setValue(hopitalInfo);

    }
    public void syncAnt(Medicaux medicaux, Obstetricaux obstetricaux, GynecoChirurgi chirurgi){

    }
}
