package com.example.david.matibabu.model.hopital;

import java.util.List;

/**
 * Created by david on 12/3/17.
 */

public interface HopitalInterface {
    List<String> listOfProvince();
    List<String> listOfZone();
    List<String> listOfStructure();
    void register(String province, String zone,String arretMinister);
}
