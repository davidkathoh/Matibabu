package com.example.david.matibabu.account.signup;



import com.example.david.matibabu.model.hopital.HopitalInfo;
import com.example.david.matibabu.model.remote.firebase.RemoteData;

import java.util.concurrent.TimeUnit;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by david on 3/26/18.
 */

public class SignupPresenter implements SignupContract.Presenter {
    private SignupContract.View mView;
    private HopitalInfo mHopitalInfo;
    private RemoteData mRemoteData;




    public SignupPresenter(SignupContract.View view) {
        this.mView = checkNotNull(view);
        mView.setPresenter(this);

    }

    @Override
    public void registerHospital(String province, String zoneSante, String aireDeSante, String arreteMinisteriel, String nomHopital, String addressHopital, String nomResponsable, String telephoneResposable) {
        mRemoteData = new RemoteData();
        mHopitalInfo = new HopitalInfo();
        mHopitalInfo.setProvince(province);
        mHopitalInfo.setZoneDeSante(zoneSante);
        mHopitalInfo.setAireDesante(aireDeSante);
        mHopitalInfo.setArret(arreteMinisteriel);
        mHopitalInfo.setNomDeHopital(nomHopital);
        mHopitalInfo.setAddress(addressHopital);
        mHopitalInfo.setNomResponsable(nomResponsable);
        mHopitalInfo.setPhoneResponsable(telephoneResposable);
        mRemoteData.addHopitalRemote(mHopitalInfo);


    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }


}
