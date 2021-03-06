package com.example.david.matibabu.cpnfour;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.example.david.matibabu.R;
import com.example.david.matibabu.cpnthree.CpnThreeFragment;
import com.example.david.matibabu.cpnthree.CpnThreePresenter;
import com.example.david.matibabu.patientdetail.PatientDetailActivity;
import com.example.david.matibabu.utils.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CpnFourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CpnFourFragment extends Fragment {
    private static final String DATE_FRAGMENT = "dialogFragmnet";
    private static final int REQUEST_DATE = 3;

    private TextInputEditText datePicker;
    private TextInputEditText patientOccupation;
    private Spinner vat;
    private Spinner sp;
    private Spinner fer;
    private Spinner risque;
    private CheckBox mild;
    private CheckBox vgb;

    private Date mDate;
    private String dateString;
    CpnFourPresenter mPresenter;
    private int patientId;
    private String patientName;



    public static CpnFourFragment newInstance() {
        return new CpnFourFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_cpn_four, container,false);
        mPresenter = new CpnFourPresenter(getContext());
        Intent intent =getActivity().getIntent();
        patientId = intent.getIntExtra("uid",0);
        patientName = intent.getStringExtra("name");
        dateString = intent.getStringExtra("date");
        vat = view.findViewById(R.id.sp_vat);
        sp = view.findViewById(R.id.sp_sp);
        fer = view.findViewById(R.id.sp_fer);
        risque = view.findViewById(R.id.sp_risque);
        vgb = view.findViewById(R.id.ch_vgb);
        mild = view.findViewById(R.id.ch_mild);
        datePicker = view.findViewById(R.id.rdv_date);
        patientOccupation = view.findViewById(R.id.ed_patient_occup);

        datePicker.setOnClickListener(v ->{
            FragmentManager fragmentManager = getFragmentManager();
            DatePickerFragment dialog = new DatePickerFragment();
            dialog.setTargetFragment(CpnFourFragment.this,REQUEST_DATE);
            dialog.show(fragmentManager,DATE_FRAGMENT);
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_DATE){
            mDate = (Date) data.getSerializableExtra(com.example.david.matibabu.addpatient.DatePickerFragment.EXTRA_DATE);
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
            String date = fmt.format(mDate);
            datePicker.setText(date);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_save){
            save();
            openDetail();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    public void save(){
        mPresenter.doCpn( patientId
                ,sp.getSelectedItem().toString(),
                fer.getSelectedItem().toString(),
                sp.getSelectedItem().toString(),
                risque.getSelectedItem().toString(),
                vgb.isChecked(),mild.isChecked(),
                patientOccupation.getText().toString(),
                mDate);
    }
    public void openDetail(){
        Intent i = new Intent(getActivity(), PatientDetailActivity.class);
        i.putExtra("uid",patientId);
        i.putExtra("name",patientName);
        i.putExtra("date",dateString);
        startActivity(i);
        getActivity().finish();
    }



}
