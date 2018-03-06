package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
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
    Medicaux mMedicaux;
    Obstetricaux mObstetricaux;
    private String EXTRAT_PATIENT_ID = "PATIENT_UID";
    private int patientId;


    List<PersonalInfo> persone;

    private PersonalInfo addPatient(AppDatabase db,PersonalInfo personalInfo){
        db.patientDao().insertPatient(personalInfo);
        persone = new ArrayList<>();
        return personalInfo;
    }

//    private static void createPatient(AppDatabase db) {
//
//        addPatient(db, patient);
//    }

    public void addAntMedi(Medicaux medicaux,Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertMedico(medicaux);
    }
    public void addAntGyn(GynecoChirurgi chirurgi,Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertGyneco(chirurgi);
    }
    public void addAntObs(Obstetricaux obstetricaux,Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertObsterico(obstetricaux);
    }

    public void createPatiente(String name, String telephone, Date dob, String etatCivil,
                               String cojName, String cojPhone, String urgName,
                               String urgPhone, String address, Context context) {
        //Context context  = ;
        final AppDatabase db = AppDatabase.getAppDatabase(context);
                //AppDatabase.getAppDatabase();
        final PersonalInfo patient = new PersonalInfo();
        patient.setPatientName(name);
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
                            // getting the added patient id and send it to antecents fragment
                          //  int patientId = persone.get(persone.size()-1).getId();
                           //setPatientId(patientId);
                            Log.e("Boolean",String.valueOf(patientId));
                    }

                    @Override
                    public void onError(Throwable e) {

                      Log.e("ERROR",e.getMessage());

                    }
                });


    }
    public GynecoChirurgi insertGyn(
             int patient_id,
             boolean cesarienne,
             boolean cerclage,
             boolean fibromeUterin,
             boolean fractureBassin,
             boolean geu,
             boolean fistule,
             boolean uterusCicatriciel,
             boolean steriliteTraitement){
        GynecoChirurgi gynecoChirurgi
                = new GynecoChirurgi(getPatientId(),cesarienne,cerclage,fibromeUterin
                        ,fractureBassin,geu,fistule,uterusCicatriciel,steriliteTraitement);
        Log.e("BOOLEAN",String.valueOf(gynecoChirurgi.getPatient_id()));
       mChirurgi = gynecoChirurgi;
        return gynecoChirurgi;
    }
    public Medicaux inserMedi(
            int patientId, boolean tbc, boolean hta,
            boolean sca_ss, boolean dbt, boolean car,
            boolean mgf, boolean syphylis,
            boolean vih_sida, boolean vvs, boolean pep){
                 Medicaux med =
                         new Medicaux( patientId, tbc,
                     hta,  sca_ss,dbt, car, mgf, syphylis,vih_sida,  vvs,  pep);
                 mMedicaux = med;
                 return med;
    }
    public Obstetricaux insertObs(int patientId, boolean parite, boolean gestite,
                                  boolean enfantEnVie, boolean avortement, boolean dystocie, boolean eutocie, boolean premature, boolean post_mature,
                                  boolean mort_ne, boolean complicationPostPartum){
                Obstetricaux obstetricaux
                        = new Obstetricaux( patientId,  parite,
        gestite, enfantEnVie, avortement,
         dystocie, eutocie, premature,
         post_mature, mort_ne,  complicationPostPartum);
                mObstetricaux = obstetricaux;
                return obstetricaux;

    }
    public void add(Context context){
        addAntGyn(mChirurgi,context);
        addAntMedi(mMedicaux,context);
        addAntObs(mObstetricaux,context);
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
