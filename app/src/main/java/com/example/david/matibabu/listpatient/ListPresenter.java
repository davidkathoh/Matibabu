package com.example.david.matibabu.listpatient;

import android.content.Context;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by david on 2/27/18.
 */

public class ListPresenter  {
    public List<PersonalInfo> getAllPatient(Context context){
        AppDatabase db = AppDatabase.getAppDatabase(context);
      return (List<PersonalInfo>) db.patientDao().getAll().subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Consumer<List<PersonalInfo>>() {
                  @Override
                  public void accept(List<PersonalInfo> personalInfos) throws Exception {

                  }
              });
    }
}
