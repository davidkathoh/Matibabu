package com.example.david.matibabu.model.localDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by david on 1/30/18.
 */
@Dao
public interface PatientDao {
    @Insert
    void insertPatient(PersonalInfo ... personalInfos);
    @Query("SELECT * FROM Patient")
    Flowable<List<PersonalInfo>> getAll();
    @Insert
    void insertGyneco(GynecoChirurgi ... chirurgis);
    @Insert
    void insertMedico(Medicaux ... medicauxes);
    @Insert
    void insertObsterico(Obstetricaux ... obstetricauxes);
}
