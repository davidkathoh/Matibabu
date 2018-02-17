package com.example.david.matibabu.model.localDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.List;

/**
 * Created by david on 1/30/18.
 */
@Dao
public interface PatientDao {
    @Insert
    void insertPatient(PersonalInfo ... personalInfos);
    @Query("SELECT * FROM Patient")
    List<PersonalInfo> getAll();
}
