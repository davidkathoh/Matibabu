package com.example.david.matibabu.utils;

import android.arch.persistence.room.TypeConverter;
import android.provider.SyncStateContract;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by david on 2/10/18.
 */

public class TimestampConverter {
//        @TypeConverter
//        public static Date fromTimestamp(Long value) {
//            return value == null ? null : new Date(value);
//        }
//
//        @TypeConverter
//        public static Long dateToTimestamp(Date date) {
//            return date == null ? null : date.getTime();
//        }

    static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

    @TypeConverter
    public static Date fromTimestamp(String value) {
        if (value != null) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToTimestamp(Date value) {

        return value == null ? null : df.format(value);
    }
}
