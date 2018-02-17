package com.example.david.matibabu.model.hopital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 12/3/17.
 */

public class Hopital implements HopitalInterface {
    public Hopital() {
        listOfZone();
        listOfZone();
        listOfStructure();
    }

    @Override
    public List<String> listOfProvince() {

        List<String> province = new ArrayList<>();
        province.add("NORD KIVU");
        province.add("SUD KIVU");
        province.add("ITURI");
        province.add("TSHOPO");
        return province;
    }

    @Override
    public List<String> listOfZone() {
        ArrayList<String> zone = new ArrayList<>();
        zone.add("GOMA");
        zone.add("NYIRAGONGO");
        zone.add("KARISIMBI");
        zone.add("KATWA");
        return zone;
    }

    @Override
    public List<String> listOfStructure() {
        ArrayList<String> type = new ArrayList<>();
        type.add("Hopital de reference");
        type.add("Centre de sante");
        return type;
    }


    @Override
    public void register(String province, String zone, String arretMinister) {



    }



}
