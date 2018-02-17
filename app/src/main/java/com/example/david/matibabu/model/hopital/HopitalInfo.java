package com.example.david.matibabu.model.hopital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 11/24/17.
 */

public class HopitalInfo {
    private String province;
    private String zoneDeSante;
    private String structure;
    private String arret;
    private String nomDeHopital;
    private String address;
    private String nomResponsable;
    private int phoneResponsable;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZoneDeSante() {
        return zoneDeSante;
    }

    public void setZoneDeSante(String zoneDeSante) {
        this.zoneDeSante = zoneDeSante;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getNomDeHopital() {
        return nomDeHopital;
    }

    public void setNomDeHopital(String nomDeHopital) {
        this.nomDeHopital = nomDeHopital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public int getPhoneResponsable() {
        return phoneResponsable;
    }

    public void setPhoneResponsable(int phoneResponsable) {
        this.phoneResponsable = phoneResponsable;
    }

    public String getArret() {
        return arret;
    }

    public void setArret(String arret) {
        this.arret = arret;
    }
}
