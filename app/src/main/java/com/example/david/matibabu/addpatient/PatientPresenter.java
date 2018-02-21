package com.example.david.matibabu.addpatient;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.example.david.matibabu.addpatient.dialogFragment.DfGyneco;
import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;

import java.util.Date;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
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



    private static PersonalInfo addPatient(AppDatabase db,PersonalInfo personalInfo){
        db.patientDao().insertPatient(personalInfo);
        return personalInfo;
    }

//    private static void createPatient(AppDatabase db) {
//
//        addPatient(db, patient);
//    }


    public void createPatiente(String name, int telephone, Date dob, String etatCivil,
                               String cojName, int cojPhone, String urgName,
                               int urgPhone,String address, Context context) {
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
        });
        patien.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<PersonalInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(PersonalInfo personalInfo) {
                        Log.e("ID",String.valueOf(personalInfo.getId()));
                    }

                    @Override
                    public void onError(Throwable e) {
                      Log.e("ERROR",e.getMessage());

                    }
                });


    }
}
