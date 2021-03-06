package com.example.david.matibabu.model.localDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.model.patient.antecedents.GynecoChirurgi;
import com.example.david.matibabu.model.patient.antecedents.Medicaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

/**
 * Created by david on 1/30/18.
 */
@Database(entities = {PersonalInfo.class, GynecoChirurgi.class
                      , Medicaux.class, Obstetricaux.class, Cpn.class},version = 4)
public abstract class
AppDatabase extends RoomDatabase {
        private static AppDatabase INSTANCE;
        public abstract  PatientDao patientDao();

        public static AppDatabase getAppDatabase(Context context) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class, "patient-database")

                                .fallbackToDestructiveMigration()
                                .build();
            }
            return INSTANCE;
        }
            public static void destroyInstance() {
                INSTANCE = null;

        }



}
