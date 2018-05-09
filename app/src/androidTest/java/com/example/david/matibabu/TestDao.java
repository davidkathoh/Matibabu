package com.example.david.matibabu;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.david.matibabu.model.localDB.AppDatabase;
import com.example.david.matibabu.model.localDB.PatientDao;
import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.model.patient.PersonalInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by david on 4/11/18.
 */
@RunWith(AndroidJUnit4.class)
public class TestDao {
    private AppDatabase mDatabase;
    private PatientDao mDao;
    PersonalInfo mPersonalInfo;

    @Before
    public void init() throws Exception{
        Context context = InstrumentationRegistry.getContext();
        mDatabase = Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        mDao = mDatabase.patientDao();
        PersonalInfo personalInfo ;
        Cpn cpn;
        for(int i =0 ;i< 10;i++){
            personalInfo  = new PersonalInfo();
            cpn = new Cpn();
            personalInfo.setPatientName("patient" +i);
           // personalInfo.setRegistrationDate(Calendar.getInstance().getTime());
            personalInfo.setLastPeriodDate(Calendar.getInstance().getTime());
            cpn.setNextCpnDate(Calendar.getInstance().getTime());
            mDao.insertPatient(personalInfo);
        }

    }

    @After
    public void closedb() throws IOException{
        mDatabase.close();
    }

    @Test
    public void numberOfPatientRegistered() throws Exception{
        int size  = mDao.getAllPatient().size();

        assertEquals(10,size);
    }
    @Test
    public void patientRegisteredToday() throws Exception{
        SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-YYY");

        int numberOfCpn  =  mDao.numberOfTodayRegistration(sd.format(Calendar.getInstance().getTime()));

        assertEquals(10,numberOfCpn);


    }
    @Test
    public void patientComingForPatientToday() throws Exception{

        SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-YYY");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Calendar.getInstance().getTime());

        int numberOfpatient = mDao.todayCpnNumber(sd.format(Calendar.getInstance().getTime()));
        assertEquals(10, numberOfpatient);
    }

    @Test
    public void insertCpn() throws Exception{
        Cpn cpn = new Cpn();
        int id = mDao.getAllPatient().get(0).getId();
        cpn.setNextCpnDate(Calendar.getInstance().getTime());
       // cpn.setPatientUID(id);
        mDao.makeCpn(cpn);
    }
    @Test
    public void updatePersonalInfo() throws Exception{
        PersonalInfo personalInfo = new PersonalInfo();
        String name = mDao.getAllPatient().get(0).getPartnerName();
        int  id = mDao.getAllPatient().get(0).getId();
        personalInfo.setId(id);
        personalInfo.setPatientName("david");
        mDao.upDatePatient(personalInfo);
        assertEquals(null,name);
        assertEquals("david",mDao.getAllPatient().get(0).getPartnerName());


    }

}
