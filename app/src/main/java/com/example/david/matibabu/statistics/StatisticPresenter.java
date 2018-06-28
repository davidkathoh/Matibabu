package com.example.david.matibabu.statistics;

import android.content.Context;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 5/23/18.
 */

public class StatisticPresenter  implements StatisticContract.Presenter{

    private CompositeDisposable mCompositeDisposable;
    private AppDatabase mDatabase;
    private PatientDao mDao;
    private String dateStringFrom;
    private String getDateStringto;
    private StatisticContract.View mView;


    public StatisticPresenter(Context context,StatisticContract.View view ) {
       mView = view;
        mDatabase = AppDatabase.getAppDatabase(context);
        mDao = mDatabase.patientDao();
        mView.setPresenter(this);
    }
    public void result( String from ,String to){
        Observable.fromCallable(() ->
                mDao.cpnStatistic(from,to)

        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(m -> {
                  mView.cpnStatistcs(m);
                  Log.i("STATISTIC",m.size()+"");

                });

    }





    @Override
    public void loadCpnNumber(String from, String to) {

        result(from,to);

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
