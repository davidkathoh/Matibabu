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
       Obstetricaux insertObs(long patientId, boolean parite, boolean gestite,
                              boolean enfantEnVie, boolean avortement, boolean dystocie, boolean eutocie, boolean premature, boolean post_mature,
                              boolean mort_ne, boolean complicationPostPartum);
       Medicaux inserMedi(
               long patientId, boolean tbc, boolean hta,
               boolean sca_ss, boolean dbt, boolean car,
               boolean mgf, boolean syphylis,
               boolean vih_sida, boolean vvs, boolean pep);
       GynecoChirurgi insertGyn(
               long patient_id,
               boolean cesarienne,
               boolean cerclage,
               boolean fibromeUterin,
               boolean fractureBassin,
               boolean geu,
               boolean fistule,
               boolean uterusCicatriciel,
               boolean steriliteTraitement);
   }

}
