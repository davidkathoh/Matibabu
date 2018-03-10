package com.example.david.matibabu.model.patient.antecedents;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.david.matibabu.model.patient.PersonalInfo;

/**
 * Created by david on 11/22/17.
 */
@Entity(tableName = "Gyneco",foreignKeys = @ForeignKey(
        entity = PersonalInfo.class,parentColumns ="id"
        ,childColumns = "patientId"))
public class GynecoChirurgi {
    @PrimaryKey(autoGenerate = true)
    private int antGynId;
    @ColumnInfo(name = "patientId")
    private long patient_id;
    private boolean cesarienne;
    private boolean cerclage;
    private boolean fibromeUterin;
    private boolean fractureBassin;
    private boolean geu;
    private boolean fistule;
    private boolean uterusCicatriciel;
    private boolean steriliteTraitement;


    public GynecoChirurgi(long patient_id, boolean cesarienne, boolean cerclage, boolean fibromeUterin, boolean fractureBassin, boolean geu, boolean fistule, boolean uterusCicatriciel, boolean steriliteTraitement) {
        this.patient_id = patient_id;
        this.cesarienne = cesarienne;
        this.cerclage = cerclage;
        this.fibromeUterin = fibromeUterin;
        this.fractureBassin = fractureBassin;
        this.geu = geu;
        this.fistule = fistule;
        this.uterusCicatriciel = uterusCicatriciel;
        this.steriliteTraitement = steriliteTraitement;
    }

    public boolean isCesarienne() {
        return cesarienne;
    }

    public void setCesarienne(boolean cesarienne) {
        this.cesarienne = cesarienne;
    }

    public boolean isCerclage() {
        return cerclage;
    }

    public void setCerclage(boolean cerclage) {
        this.cerclage = cerclage;
    }

    public boolean isFibromeUterin() {
        return fibromeUterin;
    }

    public void setFibromeUterin(boolean fibromeUterin) {
        this.fibromeUterin = fibromeUterin;
    }

    public boolean isFractureBassin() {
        return fractureBassin;
    }

    public void setFractureBassin(boolean fractureBassin) {
        this.fractureBassin = fractureBassin;
    }

    public boolean isGeu() {
        return geu;
    }

    public void setGeu(boolean geu) {
        this.geu = geu;
    }

    public boolean isFistule() {
        return fistule;
    }

    public void setFistule(boolean fistule) {
        this.fistule = fistule;
    }

    public boolean isUterusCicatriciel() {
        return uterusCicatriciel;
    }

    public void setUterusCicatriciel(boolean uterusCicatriciel) {
        this.uterusCicatriciel = uterusCicatriciel;
    }

    public boolean isSteriliteTraitement() {
        return steriliteTraitement;
    }

    public void setSteriliteTraitement(boolean steriliteTraitement) {
        this.steriliteTraitement = steriliteTraitement;
    }

    public int getAntGynId() {
        return antGynId;
    }

    public void setAntGynId(int antGynId) {
        this.antGynId = antGynId;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
}
