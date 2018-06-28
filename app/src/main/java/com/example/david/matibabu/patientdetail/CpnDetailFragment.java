package com.example.david.matibabu.patientdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.matibabu.R;
import com.example.david.matibabu.cpnfour.CpnFourActivity;
import com.example.david.matibabu.cpnone.CpnOneActivity;
import com.example.david.matibabu.cpnthree.CpnThreeActivity;
import com.example.david.matibabu.cpntwo.CpnTwoActivity;
import com.example.david.matibabu.listpatient.PatientListActivity;
import com.example.david.matibabu.utils.FirebaseAnalytic;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CpnDetailFragment extends Fragment {
    private TextView cpn1;
    private TextView cpn2;
    private TextView cpn3;
    private TextView cpn4;
    private TextView patient_name;
    private TextView age_grocesse;
    private TextView due_date;
    static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    private String name;
    private int UID;
    private Date mDate;
    private Calendar mCalendar = Calendar.getInstance();


    public CpnDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_detail,container,false);
        cpn1 = view.findViewById(R.id.cpn_one);
        cpn2 = view.findViewById(R.id.cpn_two);
        cpn3 = view.findViewById(R.id.cpn_three);
        cpn4 = view.findViewById(R.id.cpn_four);
        due_date = view.findViewById(R.id.txt_due_date);
        age_grocesse = view.findViewById(R.id.txt_age_grocesse);
        patient_name = view.findViewById(R.id.patient_name);
        getActivity().setTitle("");

            Intent i = getActivity().getIntent();

            name = i.getStringExtra("name");
            UID = i.getIntExtra("uid",0);
            String date = i.getStringExtra("date");
            patient_name.setText(name);


            if (date!= null) {

                try {
                    mDate = df.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                mCalendar.setTime(mDate);
                mCalendar.add(Calendar.MONTH, 9);
                mCalendar.add(Calendar.DAY_OF_WEEK, 7);
                DateTime dateTime1 = new DateTime(mDate);
                DateTime dateTime2 = new DateTime(Calendar.getInstance().getTime());

                int weeks = Weeks.weeksBetween(dateTime1, dateTime2).getWeeks();
                String age ="Age : "+weeks+" senaines";
                String dpa = df.format(mCalendar.getTime());
                    age_grocesse.setText(age);
                    due_date.setText(dpa);
            }else {
                age_grocesse.setText("inconu");
            }


        cpn1.setOnClickListener(v -> {
            //todo button click
            Intent intent = new Intent(CpnDetailFragment.this.getActivity(), CpnOneActivity.class);
            intent.putExtra("uid",UID);
            intent.putExtra("name",name);
            intent.putExtra("date",date);
            startActivity(intent);
        });
        cpn2.setOnClickListener(v ->{
            //todo button click
            Intent intent = new Intent(getActivity(), CpnTwoActivity.class);
            intent.putExtra("uid",UID);
            intent.putExtra("name",name);
            intent.putExtra("date",date);
            startActivity(intent);
        });
        cpn3.setOnClickListener(v ->{
            //todo button click
            Intent intent = new Intent(getActivity(), CpnThreeActivity.class);
            intent.putExtra("uid",UID);
            intent.putExtra("name",name);
            intent.putExtra("date",date);
            startActivity(intent);
        });
        cpn4.setOnClickListener(v ->{
            //todo button click
            Intent intent = new Intent(getActivity(), CpnFourActivity.class);
            intent.putExtra("uid",UID);
            intent.putExtra("name",name);
            intent.putExtra("date",date);
            startActivity(intent);
        });
        FirebaseAnalytic.matibabuAnalyse(getContext());

        return view;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.action_edit){
            Toast.makeText(getContext(),"edit clicked",Toast.LENGTH_LONG).show();


        }
        if (id == R.id.home){
            startActivity(new Intent(getActivity(), PatientListActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setdates(Date date){
        if (date!= null) {
            mCalendar.setTime(date);
            mCalendar.add(Calendar.MONTH, 9);
            mCalendar.add(Calendar.DAY_OF_WEEK, 7);
            due_date.setText(mCalendar.getTime().toString());



        }

    }


}
