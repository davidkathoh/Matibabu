package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
import com.example.david.matibabu.model.remote.firebase.RemoteData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by david on 2/6/18.
 */

public class PatientPresenter implements PatientContract.Presenter{

    private String EXTRAT_PATIENT_ID = "PATIENT_UID";
    private int patientId;
     long uid;
     @NonNull
     PatientContract.View mContract;

    Context mContext;
  static CompositeDisposable mCompositeDisposable ;
  private RemoteData mRemoteData;

    List<PersonalInfo> persone;

    private Long addPatient(AppDatabase db,PersonalInfo personalInfo){
        persone = new ArrayList<>();
        return  db.patientDao().insertPatient(personalInfo);
    }




    public PatientPresenter(@NonNull PatientContract.View contract, Context context) {
        mContract = checkNotNull(contract);
        mContext = context;
        mCompositeDisposable = new CompositeDisposable();
        mRemoteData = new RemoteData();
        mContract.setPresenter(this );
    }

    @Override
    public long createPatiente(String name, String telephone, Date dob, String etatCivil,
                               String cojName, String cojPhone, String urgName,
                               String urgPhone, String address, Context context) {
        final AppDatabase db = AppDatabase.getAppDatabase(context);


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

       // mRemoteData.syncPatient(patient);
        Observable.fromCallable(() -> db.patientDao().insertPatient(patient))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(returnedId ->{
                    saveToFirebase(patient,returnedId);
                    mContract.openAntecendent(returnedId);
                },throwable -> Log.e("not saved",throwable.toString()));

 return uid;
    }

    public void  saveToFirebase(PersonalInfo p, long uid){
        int id = (int)uid;
        p.setId(id);
        mRemoteData.syncPatient(p);
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }



    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
