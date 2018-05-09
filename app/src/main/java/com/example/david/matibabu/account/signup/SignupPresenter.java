package com.example.david.matibabu.account.signup;



import java.util.concurrent.TimeUnit;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by david on 3/26/18.
 */

public class SignupPresenter implements SignupContract.Presenter {
    private SignupContract.View mView;



    public SignupPresenter(SignupContract.View view) {
        this.mView = checkNotNull(view);
        mView.setPresenter(this);

    }

    @Override
    public void registerHospital(String province, String zoneSante, String StructureType, String arreteMinisteriel, String nomHopital, String addressHopital, String nomResponsable, String telephoneResposable) {


    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }


}
