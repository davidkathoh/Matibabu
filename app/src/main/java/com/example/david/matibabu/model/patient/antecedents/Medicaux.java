package com.example.david.matibabu.model.patient.antecedents;

/**
 * Created by david on 11/22/17.
 */

public class Medicaux {
    private int patient_id;
    private boolean tbc;
    private boolean hta;
    private boolean sca_ss;
    private boolean dbt;
    private boolean car;
    private boolean mgf;
    private boolean raa;
    private boolean syphylis;
    private boolean vih_sida;
    private boolean vvs;
    private boolean pep;

    public boolean isTbc() {
        return tbc;
    }

    public void setTbc(boolean tbc) {
        this.tbc = tbc;
    }

    public boolean isHta() {
        return hta;
    }

    public void setHta(boolean hta) {
        this.hta = hta;
    }

    public boolean isSca_ss() {
        return sca_ss;
    }

    public void setSca_ss(boolean sca_ss) {
        this.sca_ss = sca_ss;
    }

    public boolean isDbt() {
        return dbt;
    }

    public void setDbt(boolean dbt) {
        this.dbt = dbt;
    }

    public boolean isCar() {
        return car;
    }

    public void setCar(boolean car) {
        this.car = car;
    }

    public boolean isMgf() {
        return mgf;
    }

    public void setMgf(boolean mgf) {
        this.mgf = mgf;
    }

    public boolean isRaa() {
        return raa;
    }

    public void setRaa(boolean raa) {
        this.raa = raa;
    }

    public boolean isSyphylis() {
        return syphylis;
    }

    public void setSyphylis(boolean syphylis) {
        this.syphylis = syphylis;
    }

    public boolean isVih_sida() {
        return vih_sida;
    }

    public void setVih_sida(boolean vih_sida) {
        this.vih_sida = vih_sida;
    }

    public boolean isVvs() {
        return vvs;
    }

    public void setVvs(boolean vvs) {
        this.vvs = vvs;
    }

    public boolean isPep() {
        return pep;
    }

    public void setPep(boolean pep) {
        this.pep = pep;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
}
