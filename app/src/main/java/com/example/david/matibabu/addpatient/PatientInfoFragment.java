package com.example.david.matibabu.addpatient;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.example.david.matibabu.R;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class PatientInfoFragment extends Fragment implements PatientContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String DATE_FRAGMENT = "dialogFragmnet";
    private static final int REQUEST_DATE = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextInputEditText edt_pat_name;
    private TextInputEditText edt_pat_address;
    private TextInputEditText edt_pat_number;
    private TextInputEditText edt_urg_name;
    private TextInputEditText edt_urg_phone;
    private AutoCompleteTextView marital_status;
    private TextInputEditText edt_pat_date;
    private TextInputEditText edt_coj_name;
    private TextInputLayout til_pat_name;
    private TextInputLayout til_pat_num;
    private TextInputLayout til_pat_address;
    private TextInputLayout til_pat_etatcivil;
    private TextInputLayout til_pat_dob;
    private TextInputEditText edt_coj_number;
    private Toolbar toolbar;
    private LinearLayout mLinearLayout;

    Date mDate;
    PatientContract.Presenter mPresenter;




    public PatientInfoFragment() {
        // Required empty public constructor
    }


    public static PatientInfoFragment newInstance() {
        PatientInfoFragment fragment = new PatientInfoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
        getActivity().invalidateOptionsMenu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_patient_info, container, false);
//        ActionBar actionBar = getActivity().getActionBar();
//        actionBar.setTitle(R.string.tlb_new_patient);
            getActivity().setTitle(R.string.tlb_new_patient);
        // autocomplete on marital status
        marital_status = v.findViewById(R.id.auto_compl_etat_civil);
        til_pat_etatcivil = v.findViewById(R.id.tip_pat_etatcivil);
        int layoutId = android.R.layout.simple_dropdown_item_1line;
        String[] etatCivils = getResources().getStringArray(R.array.marital_status);
        List<String> etatCivilsList = Arrays.asList(etatCivils);
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),layoutId,etatCivilsList);
       marital_status.setAdapter(adapter);
        til_pat_name = v.findViewById(R.id.til_pat_name);
        edt_pat_name = v.findViewById(R.id.pat_name);
        edt_pat_number = v.findViewById(R.id.pat_num);
        edt_pat_address = v.findViewById(R.id.pat_address);
        til_pat_address = v.findViewById(R.id.til_pat_address);
        edt_coj_name = v.findViewById(R.id.conj_name);
        edt_coj_number = v.findViewById(R.id.conj_num);
        edt_urg_name = v.findViewById(R.id.edt_urg_name);
        edt_urg_phone = v.findViewById(R.id.edt_urg_num);
        edt_pat_date = (TextInputEditText)v.findViewById(R.id.pat_anniv);
        mLinearLayout = v.findViewById(R.id.linearoot);
        til_pat_dob = v.findViewById(R.id.til_pat_dob);
        edt_pat_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(PatientInfoFragment.this,REQUEST_DATE);
                dialog.show(fragmentManager,DATE_FRAGMENT);
            }
        });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_DATE){
            mDate = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
            String date = fmt.format(mDate);
            edt_pat_date.setText(date);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.next,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_next){
        if(validate()) {
            mPresenter.createPatiente(edt_pat_name.getText().toString(),
                    edt_pat_number.getText().toString(),
                    mDate, marital_status.getText().toString(),
                    edt_coj_name.getText().toString(), edt_coj_number.getText().toString(),
                    edt_urg_name.getText().toString(), edt_urg_phone.getText().toString(),
                    edt_pat_address.getText().toString(), getActivity().getApplicationContext());

        }


        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void openAntecendent(long id) {
            String name = edt_pat_name.getText().toString();
            PatientAntecedantFragment antecedant = new PatientAntecedantFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("ID", id);
            bundle.putString("name",name);
            antecedant.setArguments(bundle);
            Log.e("Open", "Interface called ");
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main, antecedant, "Fragment")
                    .addToBackStack(null)
                    .commit();

    }
    public boolean validate(){
        boolean valid = true;
        String nom = edt_pat_name.getText().toString().trim();
        String address = edt_pat_address.getText().toString();
        String dob = edt_pat_date.getText().toString();
        if (nom.isEmpty()){
            edt_pat_name.setError("le nom de la patiente");
            valid = false;
        }else{
            edt_pat_name.setError(null);
        }
        if (address.isEmpty()){
            edt_pat_address.setError("addresse de la patiente");
            valid = false;
        }else {
            edt_pat_address.setError(null);
        }
        if (dob.isEmpty()){
            edt_pat_date.setError("date de naissance patiente");
            valid = false;
        }else {
            edt_pat_date.setError(null);
        }
        return  valid;
    }

    @Override
    public void setPresenter(PatientContract.Presenter presenter) {
        mPresenter = presenter;
    }
}







