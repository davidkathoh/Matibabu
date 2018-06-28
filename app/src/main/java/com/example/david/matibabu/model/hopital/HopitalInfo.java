package com.example.david.matibabu.model.hopital;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 11/24/17.
 */

public class HopitalInfo {
    private String hopitalUID;
    private String province;
    private String zoneDeSante;
    private String aireDesante;
    private String arret;
    private String nomDeHopital;
    private String address;
    private String nomResponsable;
    private String phoneResponsable;

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

    public String getAireDesante() {
        return aireDesante;
    }

    public void setAireDesante(String aireDesante) {
        this.aireDesante = aireDesante;
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

    public String getPhoneResponsable() {
        return phoneResponsable;
    }

    public void setPhoneResponsable(String phoneResponsable) {
        this.phoneResponsable = phoneResponsable;
    }

    public String getArret() {
        return arret;
    }

    public void setArret(String arret) {
        this.arret = arret;
    }

    public String getHopitalUID() {
        return hopitalUID;
    }

    public void setHopitalUID(String hopitalUID) {
        this.hopitalUID = hopitalUID;
    }
}
