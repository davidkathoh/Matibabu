package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by david on 2/6/18.
 */

public class PatientPresenter implements PatientContract.Presenter{
    GynecoChirurgi mChirurgi;
    Medicaux mMedicaux;
    Obstetricaux mObstetricaux;
    private String EXTRAT_PATIENT_ID = "PATIENT_UID";
    private int patientId;
     long uid;
     @NonNull
     PatientContract.View mContract;

    Context mContext;
  static CompositeDisposable mCompositeDisposable ;


    List<PersonalInfo> persone;

    private Long addPatient(AppDatabase db,PersonalInfo personalInfo){
        persone = new ArrayList<>();
        return  db.patientDao().insertPatient(personalInfo);
    }

//    private static void createPatient(AppDatabase db) {
//
//        addPatient(db, patient);
//    }


    public PatientPresenter(@NonNull PatientContract.View contract, Context context) {
        mContract = checkNotNull(contract);
        mContext = context;
        mCompositeDisposable = new CompositeDisposable();
        mContract.setPresenter(this );
    }

    public void addAntMedi(Medicaux medicaux, Context context){
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
    @Override
    public long createPatiente(String name, String telephone, Date dob, String etatCivil,
                               String cojName, String cojPhone, String urgName,
                               String urgPhone, String address, Context context) {
        final AppDatabase db = AppDatabase.getAppDatabase(context);
                //AppDatabase.getAppDatabase();
        final long[] da = new long[1];
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
        Disposable subscribe = Observable.just(addPatient(db,patient))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(patientOptional -> {
                    //onNext
                   // patientId =  patientOptional.intValue();
                       // setPatientId(patientId);
                   // da[0] = patientOptional;
              mContract.openAntecendent(patientOptional);


                }, throwable -> Log.e("NOTSAVED",throwable.toString()));
            mCompositeDisposable.add(subscribe);
      //  Log.e("Saved","patient id is"+ da[0]);
 return uid;
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
        Disposable suscribe = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter e) throws Exception {
                addAntGyn(mChirurgi,context);
                        addAntMedi(mMedicaux,context);
                        addAntObs(mObstetricaux,context);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.e("SAVED","Antecedent saved"),
                        e -> Log.e("NotSaved",e.toString()));
        mCompositeDisposable.add(suscribe);
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
