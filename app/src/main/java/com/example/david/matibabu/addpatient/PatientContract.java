package com.example.david.matibabu.addpatient;

import android.content.Context;
import android.widget.CheckBox;

import java.util.Date;

/**
 * Created by david on 2/4/18.
 */

public interface PatientContract {


    void gyneco(boolean mCesarieneChb,
             boolean mCerclage,
            boolean mFibrone,
            boolean mFracture,
                boolean mGeu,
                        boolean mCicatrice,
                     boolean mSterilite);
//    interface CreatePatiente{
//        void createPatiente(String name, int telephone, Date dob,String etatCivil,
//                            String cojName,int cojPhone,String urgName,int urgPhone,String address,
//                            Context context);
//    }

}
