package com.example.david.matibabu.home;

import android.content.Context;
import android.util.ArrayMap;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 3/27/18.
 */

public class HomePresenter implements HomeContract.Presenter {


    private CompositeDisposable mCompositeDisposable;
    private AppDatabase mDatabase;
    private PatientDao mDao;
    SimpleDateFormat sd =  new SimpleDateFormat("dd-MMM-yyyy");
    private Date mDate;
    private String todayDate;

    public int cpnToday;
     HomeContract.View mView;
    public HomePresenter(HomeContract.View contract ,Context context) {
        mView = contract;
        mDatabase = AppDatabase.getAppDatabase(context);
        mDao = mDatabase.patientDao();
        mDate = Calendar.getInstance().getTime();
        mCompositeDisposable = new CompositeDisposable();
        todayDate = sd.format(mDate);
        mView.setPresenter(this);
    }

    public void result(){
        Observable.fromCallable(() ->
         computation()

        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(m -> {

                  mView.numberofCpn(
                          m.get("cpn"),m.get("registeredToday"),m.get("dueToday"));
                });


    }
    public Map<String,Integer> computation(){
        Map<String,Integer> comp = new HashMap<>();
        comp.put("cpn",mDao.todayCpnNumber(todayDate));
        comp.put("registeredToday",mDao.numberOfTodayRegistration(todayDate));
        comp.put("dueToday",mDao.numberOfProbaleDueToday(todayDate));
        return comp;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void fetch() {
        result();
    }
}

