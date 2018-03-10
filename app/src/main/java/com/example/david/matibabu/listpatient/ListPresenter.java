package com.example.david.matibabu.listpatient;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 2/27/18.
 */

public class ListPresenter {
    private Context mContext;

    public ListPresenter(Context context) {
        mContext = context;
    }
    ArrayList<PersonalInfo> personalInfoss = new ArrayList<>();

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public List<PersonalInfo> getAllPatient(Context context){
       ArrayList<PersonalInfo> personalInfos = new ArrayList<>();
        AppDatabase db = AppDatabase.getAppDatabase(context);
       db.patientDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .flatMap(Flowable::fromIterable)
                .map(PersonalInfo::getPartnerNumber)
               .subscribe(patient ->{
              // personalInfos.add(patient);


                   // patient.setColor(getRandomMaterialColor("400"));
                    //allPatients(patient);
          // Log.e("SIZE","ALL PATIENTS" +personalInfos.size());

       },throwable -> {
           Log.e("NOTLOAD",throwable.toString());
       });

        return personalInfos;
}

    public int getRandomMaterialColor(String typeColor) {
        int returnColor = Color.GRAY;
        int arrayId =mContext. getResources().getIdentifier("mdcolor"+typeColor,"array",mContext.getPackageName());
        if (arrayId != 0) {
            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }
        return returnColor;
    }
    public List<PersonalInfo> allPatients(PersonalInfo personalInfo){
        ArrayList<PersonalInfo> personalInfos = new ArrayList<>();
       while (personalInfo == null){
            personalInfos.add(personalInfo);
        }
        Log.e("SIZE","ALL PATIENTS" +personalInfos.size());
        return personalInfos;
    }
}
