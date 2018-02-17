package com.example.david.matibabu.addpatient.dialogFragment;

import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

/**
 * Created by david on 2/5/18.
 */

public class DialogPresenter {
    private GynecoChirurgi mGynecoChirurgi;
    private Medicaux mMedicaux;
    private Obstetricaux mObstetricaux;

    public void add(boolean i){
        mGynecoChirurgi.setSteriliteTraitement(i);
    }
}
