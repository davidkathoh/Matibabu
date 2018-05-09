package com.example.david.matibabu.cpnfour;

import android.content.Context;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;
import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.Date;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 3/13/18.
 */

public class CpnFourPresenter {
    private AppDatabase db;
    private PatientDao mDao;
    private Cpn mCpn;
    private PersonalInfo mPersonalInfo;


    private CompositeDisposable mCompositeDisposable;
    private  final int CPN_NUMBER = 4;

    public CpnFourPresenter(Context context) {
        db = AppDatabase.getAppDatabase(context);
        mDao = db.patientDao();
        mCompositeDisposable = new CompositeDisposable();

    }

    public void doCpn(int patientId, String vat, String fer, String sp, String risque,
                      boolean vgb, boolean mild, String occupatiion, Date nextApp){
        mCpn = new Cpn();
        mPersonalInfo = new PersonalInfo();
        mCpn.setPatientUID(patientId);
        mCpn.setCpnNumber(CPN_NUMBER);
        mCpn.setVat(vat);
        mCpn.setFer(fer);
        mCpn.setSp(sp);
        mCpn.setRisque(risque);
        mCpn.setRape(vgb);
        mCpn.setMoskitoNet(mild);
        mCpn.setNextCpnDate(nextApp);
        mPersonalInfo.setId(patientId);
        mPersonalInfo.setPatienteOccupation(occupatiion);
        insert(mPersonalInfo,mCpn);
    }

    public void insert(PersonalInfo personalInfo, Cpn cpn){
        Disposable disposable = Completable.create(e -> {

            mDao.makeCpn(cpn);})
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.e("SAVED","cpn saved saved"),
                        e -> Log.e("NotSaved",e.toString()));
        mCompositeDisposable.add(disposable);
    }
}
