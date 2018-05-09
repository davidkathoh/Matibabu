package com.example.david.matibabu.model.preferences;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by david on 3/28/18.
 */

public class PreferManager {

    SharedPreferences pref;
    SharedPreferences.Editor mEditor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name

    private static final String PREF_NAME = "matibabu-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String HOPITAL_NAME = "nom-hopital";
    private static final String ARRET_MINISTER = "arret_minister";
    private static final String ID_HOPITAL = "id_hopital";

    public PreferManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = pref.edit();
    }
    public void setFirstTimeLaunch(boolean isFirstTime) {
        mEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
       mEditor.commit();
    }

    public String getNomHopital() {
        return pref.getString(HOPITAL_NAME,"Nom de l'hopital");
    }

    public void setNomHopital(String nomHopital) {
      mEditor.putString(HOPITAL_NAME,nomHopital);
      mEditor.commit();
    }

    public String getHopitalId() {
        return pref.getString(ID_HOPITAL,"ID_Hopital");
    }

    public void setHopitalId(String hopitalId) {
        mEditor.putString(ID_HOPITAL,hopitalId);
        mEditor.commit();
    }

    public String getArretMonisteriel() {
        return pref.getString(ARRET_MINISTER,"arrete ministeriel");
    }

    public void setArretMonisteriel(String arretMonisteriel) {
        mEditor.putString(ARRET_MINISTER,arretMonisteriel);
        mEditor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
