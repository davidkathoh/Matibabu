package com.example.david.matibabu.addpatient;

import android.content.Context;

import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

import java.util.Date;

/**
 * Created by david on 2/4/18.
 */

public interface PatientContract {
    interface View extends BaseView<Presenter>{
    void openAntecendent(long id);}
   interface Presenter extends BasePresenter {
       long createPatiente(String name, String telephone, Date dob, String etatCivil,
                           String cojName, String cojPhone, String urgName,
                           String urgPhone, String address, Context context);
   }

}
