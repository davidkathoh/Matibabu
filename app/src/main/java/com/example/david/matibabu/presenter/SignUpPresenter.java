package com.example.david.matibabu.presenter;

import com.example.david.matibabu.model.hopital.Hopital;

import java.util.List;

/**
 * Created by david on 12/5/17.
 */

public class SignUpPresenter implements SignUpInterace {
Hopital hopital = new Hopital();



    public SignUpPresenter() {
        provinceList();
        zoneList();
        strucureList();

    }

    public List<String> provinceList(){

    return hopital.listOfProvince();
}
public List<String> zoneList(){
    return hopital.listOfZone();

}
    public List<String> strucureList(){
        return hopital.listOfStructure();
    }






    @Override
    public void register(String province, String zone, String type, String arret, String nomHopital, String address, String nomResponsable, String telephone) {

    }
}
