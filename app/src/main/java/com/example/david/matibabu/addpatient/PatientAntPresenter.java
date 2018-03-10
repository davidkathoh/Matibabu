package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

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

    Context mContext;

    static CompositeDisposable mCompositeDisposable ;

    public PatientAntPresenter(Context context) {
        mContext = context;
        mCompositeDisposable = new CompositeDisposable();
       // mView.setPresenter(this);
    }

    public void addAntMedi( Medicaux medicaux, Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertMedico(medicaux);
    }
    public void addAntGyn(GynecoChirurgi chirurgi, Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertGyneco(chirurgi);
    }
    public void addAntObs(Obstetricaux obstetricaux, Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.patientDao().insertObsterico(obstetricaux);
    }

    public GynecoChirurgi insertGyn(
            long patient_id,
            boolean cesarienne,
            boolean cerclage,
            boolean fibromeUterin,
            boolean fractureBassin,
            boolean geu,
            boolean fistule,
            boolean uterusCicatriciel,
            boolean steriliteTraitement){
        GynecoChirurgi gynecoChirurgi
                = new GynecoChirurgi(patient_id,cesarienne,cerclage,fibromeUterin
                ,fractureBassin,geu,fistule,uterusCicatriciel,steriliteTraitement);
        mChirurgi = gynecoChirurgi;
        return gynecoChirurgi;
    }

    public Medicaux inserMedi(
            long patientId, boolean tbc, boolean hta,
            boolean sca_ss, boolean dbt, boolean car,
            boolean mgf, boolean syphylis,
            boolean vih_sida, boolean vvs, boolean pep){
        Medicaux med =
                new Medicaux( patientId, tbc,
                        hta,  sca_ss,dbt, car, mgf, syphylis,vih_sida,  vvs,  pep);
        mMedicaux = med;
        return med;
    }
    public Obstetricaux insertObs(long patientId, boolean parite, boolean gestite,
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
        Log.e("Called","calledd");
        Disposable suscribe = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter e) throws Exception {
                addAntGyn( mChirurgi,context);
                addAntMedi(mMedicaux,context);
                addAntObs(mObstetricaux,context);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.e("SAVED","Antecedent saved"),
                        e -> Log.e("NotSaved",e.toString()));
        mCompositeDisposable.add(suscribe);
    }


}
