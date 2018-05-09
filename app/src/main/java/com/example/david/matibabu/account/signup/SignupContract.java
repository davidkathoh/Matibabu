package com.example.david.matibabu.account.signup;

import android.widget.Spinner;

import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

/**
 * Created by david on 12/5/17.
 */

public interface SignupContract {
    interface View extends BaseView<Presenter>{
        void showLoadingIndicator();
        void showErrorMessage();
        void openActivity();

    }
    interface Presenter extends BasePresenter{
        void registerHospital(String province,
                              String zoneSante,
                              String StructureType,
                              String arreteMinisteriel,
                              String nomHopital,
                              String addressHopital,
                              String nomResponsable,
                              String telephoneResposable);
    }
}
