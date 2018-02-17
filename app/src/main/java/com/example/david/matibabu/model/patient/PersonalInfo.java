package com.example.david.matibabu.model.patient;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.david.matibabu.utils.TimestampConverter;

import java.util.Date;

/**
 * Created by david on 11/20/17.
 */
@Entity(tableName = "Patient")
public class PersonalInfo {
   @PrimaryKey(autoGenerate = true)
    private int id;
   @ColumnInfo(name = "pat_name")
    private String patientName;
   @ColumnInfo(name = "pat_phone")
    private int patientPhone;
   @ColumnInfo(name = "address")
    private String address;
   @ColumnInfo(name = "martial_status")
    private String etatCivil;
     @ColumnInfo(name = "Dob")
     @TypeConverters({TimestampConverter.class})
   private Date dateOfBirth;
   @ColumnInfo(name = "pat_occupation")
    private String PatienteOccupation;
   @ColumnInfo(name = "coj_name")
    private String partnerName;
   @ColumnInfo(name = "coj_occupation")
    private String partnerOccupation;
    @ColumnInfo(name = "coj_number")
    private int partnerNumber;
   @ColumnInfo(name = "res_name")
    private String rescueName;
   @ColumnInfo(name = "res_phone")
    private int rescuePhone;
    @TypeConverters({TimestampConverter.class})
   @ColumnInfo(name = "Registration_date")
   private Date registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }


    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(int patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatienteOccupation() {
        return PatienteOccupation;
    }

    public void setPatienteOccupation(String patienteOccupation) {
        PatienteOccupation = patienteOccupation;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerOccupation() {
        return partnerOccupation;
    }

    public void setPartnerOccupation(String partnerOccupation) {
        this.partnerOccupation = partnerOccupation;
    }

    public String getRescueName() {
        return rescueName;
    }

    public void setRescueName(String rescueName) {
        this.rescueName = rescueName;
    }

    public int getRescuePhone() {
        return rescuePhone;
    }

    public void setRescuePhone(int rescuePhone) {
        this.rescuePhone = rescuePhone;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public int getPartnerNumber() {
        return partnerNumber;
    }

    public void setPartnerNumber(int partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
