package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 2/6/18.
 */

public class PatientPresenter {
    GynecoChirurgi mChirurgi;
    private String EXTRAT_PATIENT_ID = "PATIENT_UID";

List<PersonalInfo> persone;

    private PersonalInfo addPatient(AppDatabase db,PersonalInfo personalInfo){
        db.patientDao().insertPatient(personalInfo);
        persone = new ArrayList<>();
        persone = db.patientDao().getAll();
        return personalInfo;
    }

//    private static void createPatient(AppDatabase db) {
//
//        addPatient(db, patient);
//    }


    public void createPatiente(String name, String telephone, Date dob, String etatCivil,
                               String cojName, String cojPhone, String urgName,
                               String urgPhone, String address, Context context) {
        //Context context  = ;
        final AppDatabase db = AppDatabase.getAppDatabase(context);
                //AppDatabase.getAppDatabase();
        final PersonalInfo patient = new PersonalInfo();
        patient.setPartnerName(name);
        patient.setPatientPhone(telephone);
        patient.setDateOfBirth(dob);
        patient.setEtatCivil(etatCivil);
        patient.setPartnerName(cojName);
        patient.setPartnerNumber(cojPhone);
        patient.setAddress(address);
        patient.setRescueName(urgName);
        patient.setRescuePhone(urgPhone);
        Single<PersonalInfo> patien = Single.fromCallable(new Callable<PersonalInfo>() {
            @Override
            public PersonalInfo call() throws Exception {
                addPatient(db,patient);
                return patient;
            }
        }
        );
        patien.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PersonalInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(PersonalInfo personalInfo) {

                            Bundle bundle = new Bundle();

                            // getting the added patient id and send it to antecents fragment
                            int patientId = persone.get(persone.size()-1).getId();
                            bundle.putInt(EXTRAT_PATIENT_ID,patientId);
                            new PatientInfoFragment().openAntecendent(bundle);



                    }

                    @Override
                    public void onError(Throwable e) {

                      Log.e("ERROR",e.getMessage());

                    }
                });


    }


}
