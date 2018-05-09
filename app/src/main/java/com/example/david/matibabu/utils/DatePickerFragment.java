package com.example.david.matibabu.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.example.david.matibabu.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by david on 12/30/17.
 */

public class DatePickerFragment extends DialogFragment {
    private static final String ARG_DATE = "date";
    public static final String EXTRA_DATE =
            "com.example.david.matibabu.addpatient.PatientInfoFragment";
    private DatePicker mDatePicker;
    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH) ;
        @NonNull
        View v = LayoutInflater.from(getContext())
                .inflate(R.layout.date_dialog,null);
        mDatePicker = v.findViewById(R.id.date_dialog);
        mDatePicker.init(year,month,day,null);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_de_naissance)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    int year1 = mDatePicker.getYear();
                    int month1 = mDatePicker.getMonth();
                    int day1 = mDatePicker.getDayOfMonth();
                    Date date = new GregorianCalendar(year1, month1, day1).getTime();

                    GregorianCalendar de = new GregorianCalendar(year1, month1, day1);
                    sendResult(Activity.RESULT_OK,date);
                })
                .create();
    }
    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);
        
        getTargetFragment()
    .onActivityResult(getTargetRequestCode(), resultCode, intent);

        }

}
