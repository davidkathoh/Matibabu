package com.example.david.matibabu.model.patient;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.david.matibabu.utils.TimestampConverter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by david on 11/22/17.
 */
@Entity(tableName = "CPN",foreignKeys =
@ForeignKey(entity = PersonalInfo.class,parentColumns = "id",childColumns = "PatientUID"))
public class Cpn {

    @PrimaryKey(autoGenerate = true)
    private  long id;
    private int PatientUID;
    private String vat;
    private String risque;
    private String fer;
    private String sp;
    private boolean moskitoNet;
    private boolean rape;
    private int cpnNumber;
    @TypeConverters(TimestampConverter.class)
    private Date cpnDate = Calendar.getInstance().getTime();
    @TypeConverters(TimestampConverter.class)
    private Date nextCpnDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPatientUID() {
        return PatientUID;
    }

    public void setPatientUID(int patientUID) {
        PatientUID = patientUID;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public String getFer() {
        return fer;
    }

    public void setFer(String fer) {
        this.fer = fer;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public boolean isMoskitoNet() {
        return moskitoNet;
    }

    public void setMoskitoNet(boolean moskitoNet) {
        this.moskitoNet = moskitoNet;
    }

    public boolean isRape() {
        return rape;
    }

    public void setRape(boolean rape) {
        this.rape = rape;
    }

    public int getCpnNumber() {
        return cpnNumber;
    }

    public void setCpnNumber(int cpnNumber) {
        this.cpnNumber = cpnNumber;
    }

    public Date getCpnDate() {
        return cpnDate;
    }

    public void setCpnDate(Date cpnDate) {
        this.cpnDate = cpnDate;
    }

    public Date getNextCpnDate() {
        return nextCpnDate;
    }

    public void setNextCpnDate(Date nextCpnDate) {
        this.nextCpnDate = nextCpnDate;
    }
}
