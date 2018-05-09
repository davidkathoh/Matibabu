package com.example.david.matibabu.listpatient;

import android.content.Context;

import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

import java.util.List;

/**
 * Created by david on 3/8/18.
 */

public interface PatientListContract {
    interface View  extends BaseView<Presenter>{
        void loadPatients(List<PersonalInfo> personalInfos);
        void showNoPatient();
        void openCpnActivity(long patientId);
    }
    interface Presenter extends BasePresenter{
        void getAllPatient();
    }
}
