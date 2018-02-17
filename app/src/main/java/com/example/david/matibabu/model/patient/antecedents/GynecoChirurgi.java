package com.example.david.matibabu.model.patient.antecedents;

/**
 * Created by david on 11/22/17.
 */

public class GynecoChirurgi {
    private int patient_id;
    private boolean cesarienne;
    private boolean cerclage;
    private boolean fibromeUterin;
    private boolean fractureBassin;
    private boolean geu;
    private boolean fistule;
    private boolean uterusCicatriciel;
    private boolean steriliteTraitement;

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

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
}
