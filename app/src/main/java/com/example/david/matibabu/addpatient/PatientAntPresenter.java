package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
import com.example.david.matibabu.model.remote.firebase.RemoteData;

import java.util.Date;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by david on 3/10/18.
 */

public class PatientAntPresenter {
    GynecoChirurgi mChirurgi;
    Medicaux mMedicaux;
    Obstetricaux mObstetricaux;
    PersonalInfo mPersonalInfo;

    Context mContext;
    AppDatabase db;
    PatientDao  mDao;
    private Date mDate;
    private int patientID;
    static CompositeDisposable mCompositeDisposable ;
    private RemoteData mRemoteData;

    public PatientAntPresenter(Context context) {
        mContext = context;
        mCompositeDisposable = new CompositeDisposable();
        db = AppDatabase.getAppDatabase(context);
        mDao = db.patientDao();
        mRemoteData = new RemoteData();
       // mView.setPresenter(this);
    }

    public void addAntMedi( Medicaux medicaux, Context context){
       mDao.insertMedico(medicaux);
    }
    public void addAntGyn(GynecoChirurgi chirurgi, Context context){
        mDao.insertGyneco(chirurgi);
    }
    public void addAntObs(Obstetricaux obstetricaux, Context context){
        mDao.insertObsterico(obstetricaux);
    }

    public GynecoChirurgi insertGyn(
            long patient_id, boolean cesarienne,
            boolean cerclage, boolean fibromeUterin, boolean fractureBassin,
            boolean geu, boolean fistule,
            boolean uterusCicatriciel, boolean steriliteTraitement){
        GynecoChirurgi gynecoChirurgi
                = new GynecoChirurgi(patient_id,cesarienne,cerclage,fibromeUterin
                ,fractureBassin,geu,fistule,uterusCicatriciel,steriliteTraitement);
        mChirurgi = gynecoChirurgi;
        return gynecoChirurgi;
    }

    public Medicaux inserMedi(
            long patientId, boolean tbc, boolean hta,
            boolean sca_ss,boolean dbt, boolean car,
            boolean mgf, boolean raa, boolean syphylis,
            boolean vih_sida, boolean vvs, boolean pep){
        Medicaux med =
                new Medicaux( patientId, tbc,
                        hta,  sca_ss,dbt, car, mgf,raa, syphylis,vih_sida,  vvs,  pep);
        mMedicaux = med;
        return med;
    }
    public Obstetricaux insertObs(long patientId, int parite, int gestite,
                                  int enfantEnVie, int avortement, int dystocie, int eutocie, int premature, int post_mature,
                                  int mort_ne, boolean complicationPostPartum){
        Obstetricaux obstetricaux
                = new Obstetricaux( patientId,  parite,
                gestite, enfantEnVie, avortement,
                dystocie, eutocie, premature,
                post_mature, mort_ne,  complicationPostPartum);
        mObstetricaux = obstetricaux;
        return obstetricaux;}

        public void upDatePeriodDate(int patientId,Date lastPeriodDate){
          mDate = lastPeriodDate;
          this.patientID = patientId;

    }


    public void add(Context context){
        Log.e("Called","calledd");
        Disposable suscribe = Completable.create(e -> {
            addAntGyn( mChirurgi,context);
            addAntMedi(mMedicaux,context);
            addAntObs(mObstetricaux,context);
            mDao.addLastPeriodeDate(mDate,patientID);
            mRemoteData.syncAnt(String.valueOf(patientID),mMedicaux,mObstetricaux,mChirurgi);
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.e("SAVED","Antecedent saved"),
                        e -> Log.e("NotSaved",e.toString()));
        mCompositeDisposable.add(suscribe);
    }


}
