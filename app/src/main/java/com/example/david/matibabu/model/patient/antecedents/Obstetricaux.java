package com.example.david.matibabu.model.patient.antecedents;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.utils.TimestampConverter;

import java.util.Date;

/**
 * Created by david on 11/22/17.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = PersonalInfo.class,parentColumns ="id"
        ,childColumns = "patientId"))
public class Obstetricaux {
    @PrimaryKey(autoGenerate = true)
    private int antObstId;
    private long patientId;
    private int parite;
    private int gestite;
    private int enfantEnVie;
    private int avortement;
    private int dystocie;
    private int eutocie;
    private int poidsDeNaissanceEleve;
    private int premature;
    private int post_mature;
    private int mort_ne;
    private boolean mort_avant7jours;
    @TypeConverters({TimestampConverter.class})
    private Date lastBirthdate;
    private boolean complicationPostPartum;

    public Obstetricaux(long patientId, int parite, int gestite, int enfantEnVie, int avortement, int dystocie, int eutocie, int premature, int post_mature, int mort_ne, boolean complicationPostPartum) {
        this.patientId = patientId;
        this.parite = parite;
        this.gestite = gestite;
        this.enfantEnVie = enfantEnVie;
        this.avortement = avortement;
        this.dystocie = dystocie;
        this.eutocie = eutocie;
        this.premature = premature;
        this.post_mature = post_mature;
        this.mort_ne = mort_ne;
        this.complicationPostPartum = complicationPostPartum;
    }

    public int getParite() {
        return parite;
    }

    public void setParite(int parite) {
        this.parite = parite;
    }

    public int getGestite() {
        return gestite;
    }

    public void setGestite(int gestite) {
        this.gestite = gestite;
    }

    public int getEnfantEnVie() {
        return enfantEnVie;
    }

    public void setEnfantEnVie(int enfantEnVie) {
        this.enfantEnVie = enfantEnVie;
    }

    public int getAvortement() {
        return avortement;
    }

    public void setAvortement(int avortement) {
        this.avortement = avortement;
    }

    public int getDystocie() {
        return dystocie;
    }

    public void setDystocie(int dystocie) {
        this.dystocie = dystocie;
    }

    public int getEutocie() {
        return eutocie;
    }

    public void setEutocie(int eutocie) {
        this.eutocie = eutocie;
    }

    public int getPoidsDeNaissanceEleve() {
        return poidsDeNaissanceEleve;
    }

    public void setPoidsDeNaissanceEleve(int poidsDeNaissanceEleve) {
        this.poidsDeNaissanceEleve = poidsDeNaissanceEleve;
    }

    public int getPremature() {
        return premature;
    }

    public void setPremature(int premature) {
        this.premature = premature;
    }

    public int getPost_mature() {
        return post_mature;
    }

    public void setPost_mature(int post_mature) {
        this.post_mature = post_mature;
    }

    public int getMort_ne() {
        return mort_ne;
    }

    public void setMort_ne(int mort_ne) {
        this.mort_ne = mort_ne;
    }

    public boolean isMort_avant7jours() {
        return mort_avant7jours;
    }

    public void setMort_avant7jours(boolean mort_avant7jours) {
        this.mort_avant7jours = mort_avant7jours;
    }

    public Date getLastBirthdate() {
        return lastBirthdate;
    }

    public void setLastBirthdate(Date lastBirthdate) {
        this.lastBirthdate = lastBirthdate;
    }

    public boolean isComplicationPostPartum() {
        return complicationPostPartum;
    }

    public void setComplicationPostPartum(boolean complicationPostPartum) {
        this.complicationPostPartum = complicationPostPartum;
    }

    public int getAntObstId() {
        return antObstId;
    }

    public void setAntObstId(int antObstId) {
        this.antObstId = antObstId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
}
