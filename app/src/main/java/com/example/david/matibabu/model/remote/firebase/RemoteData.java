package com.example.david.matibabu.model.remote.firebase;

import android.content.Context;

import com.example.david.matibabu.model.hopital.Hopital;
import com.example.david.matibabu.model.hopital.HopitalInfo;
import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.model.patient.PersonalInfo;
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
    private DatabaseReference mReference;
    private FirebaseAuth mAuth;


    public RemoteData() {

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mAuth = FirebaseAuth.getInstance();

    }
    public  void signUp(String phone, Context context){

    }

    public void addHopitalRemote(HopitalInfo hopitalInfo){
        String userId = mAuth.getCurrentUser().getUid();
        mReference = FirebaseDatabase.getInstance().getReference().child("Hospitals")
                .child(userId).child("profile");
        mReference.setValue(hopitalInfo);

    }
    public void syncAnt(String patientId,Medicaux medicaux, Obstetricaux obstetricaux, GynecoChirurgi chirurgi){
        String userId = mAuth.getCurrentUser().getUid();

        mReference =   FirebaseDatabase.getInstance().getReference().child("Hospitals")
                .child(userId).child("patients").
                        child(patientId).child("antecedents");
        mReference.push().setValue(medicaux);
        mReference.push().setValue(obstetricaux);
        mReference.push().setValue(chirurgi);

    }
    public void syncPatient(PersonalInfo personalInfo){
        String userId = mAuth.getCurrentUser().getUid();
           mReference=  FirebaseDatabase.getInstance().getReference().child("Hospitals")
                   .child(userId).child("patients").
                child(String.valueOf(personalInfo.getId())).child("profile");
           mReference.setValue(personalInfo);
    }
    public void syncCpn(Cpn cpn){
        String userId = mAuth.getCurrentUser().getUid();
        mReference =  FirebaseDatabase.getInstance().getReference().child("Hospitals")
                .child(userId).child("patients").
                        child(String.valueOf(cpn.getPatientUID())).child("cpn").push();
        mReference.setValue(cpn);
    }
}
