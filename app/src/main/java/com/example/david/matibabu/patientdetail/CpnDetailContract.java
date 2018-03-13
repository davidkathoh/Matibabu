package com.example.david.matibabu.patientdetail;

import android.content.Context;

import com.example.david.matibabu.addpatient.PatientContract;
import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

import java.util.Date;

/**
 * Created by david on 3/13/18.
 */

public interface CpnDetailContract {
    interface View extends BaseView<Presenter> {
        void opencCpnActivity(long id);}
    interface Presenter extends BasePresenter {

    }
}
