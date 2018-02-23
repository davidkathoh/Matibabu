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
    private int patientId;
    private boolean parite;
    private boolean gestite;
    private boolean enfantEnVie;
    private boolean avortement;
    private boolean dystocie;
    private boolean eutocie;
    private boolean poidsDeNaissanceEleve;
    private boolean premature;
    private boolean post_mature;
    private boolean mort_ne;
    private boolean mort_avant7jours;
    @TypeConverters({TimestampConverter.class})
    private Date lastBirthdate;
    private boolean complicationPostPartum;

    public Obstetricaux(int patientId, boolean parite, boolean gestite, boolean enfantEnVie, boolean avortement, boolean dystocie, boolean eutocie, boolean premature, boolean post_mature, boolean mort_ne, boolean complicationPostPartum) {
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

    public boolean isParite() {
        return parite;
    }

    public void setParite(boolean parite) {
        this.parite = parite;
    }

    public boolean isGestite() {
        return gestite;
    }

    public void setGestite(boolean gestite) {
        this.gestite = gestite;
    }

    public boolean isEnfantEnVie() {
        return enfantEnVie;
    }

    public void setEnfantEnVie(boolean enfantEnVie) {
        this.enfantEnVie = enfantEnVie;
    }

    public boolean isAvortement() {
        return avortement;
    }

    public void setAvortement(boolean avortement) {
        this.avortement = avortement;
    }

    public boolean isDystocie() {
        return dystocie;
    }

    public void setDystocie(boolean dystocie) {
        this.dystocie = dystocie;
    }

    public boolean isEutocie() {
        return eutocie;
    }

    public void setEutocie(boolean eutocie) {
        this.eutocie = eutocie;
    }

    public boolean isPoidsDeNaissanceEleve() {
        return poidsDeNaissanceEleve;
    }

    public void setPoidsDeNaissanceEleve(boolean poidsDeNaissanceEleve) {
        this.poidsDeNaissanceEleve = poidsDeNaissanceEleve;
    }

    public boolean isPremature() {
        return premature;
    }

    public void setPremature(boolean premature) {
        this.premature = premature;
    }

    public boolean isPost_mature() {
        return post_mature;
    }

    public void setPost_mature(boolean post_mature) {
        this.post_mature = post_mature;
    }

    public boolean isMort_ne() {
        return mort_ne;
    }

    public void setMort_ne(boolean mort_ne) {
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

    public boolean getComplicationPostPartum() {
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
