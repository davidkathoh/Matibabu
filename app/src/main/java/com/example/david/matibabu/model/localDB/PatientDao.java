package com.example.david.matibabu.model.localDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;
import com.example.david.matibabu.utils.TimestampConverter;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by david on 1/30/18.
 */
@Dao
public interface PatientDao {
    @Insert()
    long insertPatient(PersonalInfo personalInfos);
    @Query("SELECT * FROM Patient")
   Flowable<List<PersonalInfo>> getAll();
    @Query("SELECT * FROM PATIENT")
    List<PersonalInfo> getAllPatient();
    @Update
    void upDatePatient(PersonalInfo personalInfo);

    //antecedents
    @Insert
    void insertGyneco(GynecoChirurgi  chirurgis);
    @Insert
    void insertMedico(Medicaux  medicauxes);
    @Insert
    void insertObsterico(Obstetricaux  obstetricauxes);

    //cpn
    @Insert
    long makeCpn(Cpn cpn);
    //home page querries

    @Query("SELECT COUNT(Registration_date) FROM Patient where Registration_date = :todaydate")
    int numberOfTodayRegistration(String todaydate);

    @Query("SELECT COUNT(cpnDate) FROM CPN where cpnDate = :date")
    int todayCpnNumber(String date);

    @Query("SELECT COUNT(probableDueDate) FROM Patient where probableDueDate = :todaydate")
    int numberOfProbaleDueToday(String todaydate);
    @TypeConverters({TimestampConverter.class})
   @Query("UPDATE Patient set lastPeriodDate = :date where id = :uid")
   void  addLastPeriodeDate(Date date,int uid);

    @Query("SELECT * FROM CPN where  cpnDate between date(:startDate) and date(:endDate) ")
    List<Cpn> cpnStatistic(String startDate,String endDate);



}
