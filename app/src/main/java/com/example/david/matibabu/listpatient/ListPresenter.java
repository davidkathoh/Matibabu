package com.example.david.matibabu.listpatient;

import android.content.Context;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;
import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by david on 2/27/18.
 */

public class ListPresenter   implements PatientListContract.Presenter{
    private Context mContext;
    private String TAG = "DATABASE";
    PatientListContract.View mView;
    private CompositeDisposable mCompositeDisposable;
      List<PersonalInfo> mPersonalInfoList = new ArrayList<>();
    AppDatabase mDatabase;
    PatientDao mDao;

//    public ListPresenter(Context context) {
//        mContext = context;
//        AppDatabase db = AppDatabase.getAppDatabase(mContext);
//        mPersonalInfoList = db.patientDao().getAllPatient();
//
//    }

    public ListPresenter(Context context, @NonNull PatientListContract.View mView) {
        this.mView = checkNotNull(mView);
        mContext = context;
        mCompositeDisposable = new CompositeDisposable();
        mContext = context;
        mDatabase    = AppDatabase.getAppDatabase(mContext);
        mDao = mDatabase.patientDao();
        mView.setPresenter(this);


    }



    @Override
    public void getAllPatient() {
//        mDao.getAll()
//                .flatMapIterable(patientlist -> {
//                        List<PersonalInfo> personalInfoList = new ArrayList<>();
//                        for (PersonalInfo p: patientlist) {
//                            p.setColor(getRandomMaterialColor("400"));
//                            personalInfoList.add(p);
//                        }
//                        return  personalInfoList;
//                })
//                .toList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result ->
//                   mView.loadPatients(result)
//                 );
        result();
    }
    public void result(){
        Observable.fromCallable(() ->mDao.getAllPatient())
                .map(list ->{
                    List<PersonalInfo>  personalInfos1 = new ArrayList<>();
                    for (PersonalInfo p: list) {
                        p.setColor(getRandomMaterialColor("400"));
                        personalInfos1.add(p);
                    }
                    return personalInfos1;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result ->
                        mView.loadPatients(result)
                );
    }

        public int repositorySize(){
            return mPersonalInfoList.size();
        }
    public int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId = mContext.getResources().getIdentifier("mdcolor_"+typeColor,"array",mContext.getPackageName());
        if (arrayId != 0) {
            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }



}
