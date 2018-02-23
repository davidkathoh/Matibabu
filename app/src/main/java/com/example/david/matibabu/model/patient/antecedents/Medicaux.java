package com.example.david.matibabu.model.patient.antecedents;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.david.matibabu.model.patient.PersonalInfo;

/**
 * Created by david on 11/22/17.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = PersonalInfo.class,parentColumns ="id"
        ,childColumns = "patientId"))
public class Medicaux {
    @PrimaryKey(autoGenerate = true)
    private int antMediId;
    private int patientId;
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

    public Medicaux(int patientId, boolean tbc, boolean hta, boolean sca_ss, boolean dbt, boolean car, boolean mgf, boolean syphylis, boolean vih_sida, boolean vvs, boolean pep) {
        this.patientId = patientId;
        this.tbc = tbc;
        this.hta = hta;
        this.sca_ss = sca_ss;
        this.dbt = dbt;
        this.car = car;
        this.mgf = mgf;
        this.raa = raa;
        this.syphylis = syphylis;
        this.vih_sida = vih_sida;
        this.vvs = vvs;
        this.pep = pep;
    }

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

    public int getAntMediId() {
        return antMediId;
    }

    public void setAntMediId(int antMediId) {
        this.antMediId = antMediId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
