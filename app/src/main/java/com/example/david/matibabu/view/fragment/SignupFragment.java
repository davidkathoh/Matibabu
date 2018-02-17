package com.example.david.matibabu.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.hopital.HopitalInfo;
import com.example.david.matibabu.presenter.SignUpInterace;
import com.example.david.matibabu.presenter.SignUpPresenter;
import com.example.david.matibabu.addpatient.PatientActivity;

public class SignupFragment extends Fragment  implements ViewInterface,View.OnClickListener {
    private HopitalInfo lstProvince;
    private Spinner sp_province;
    private Spinner sp_zone;
    private Spinner sp_type;
    private EditText edt_minArret;
    private EditText edt_hopitalName;
    private EditText edt_hopitalAddress;
    private EditText edt_hopitalResponsableName;
    private EditText edt_hopitalResponsableNumber;
    private Button btnSave;
    String st_province;
    String st_Zone;
    String st_type;

    SignUpInterace presenter;
    SignUpPresenter controller = new SignUpPresenter();



    public SignupFragment() {
        // Required empty public constructor
    }

    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

      sp_province =  view.findViewById(R.id.sp_province);
      sp_zone = view.findViewById(R.id.sp_zone_sante);
      sp_type = view.findViewById(R.id.sp_structure);
      edt_minArret = view.findViewById(R.id.edt_hopital_arrete);
      edt_hopitalName = view.findViewById(R.id.edt_hopital_name);
      edt_hopitalAddress = view.findViewById(R.id.edt_hopital_address);
      edt_hopitalResponsableName =view.findViewById(R.id.edt_responsable_name);
      edt_hopitalResponsableNumber = view.findViewById(R.id.edt_responsable_num);
      btnSave = view.findViewById(R.id.btn_save);

     sp_province.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,
             controller.provinceList()));

     sp_zone.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,
             controller.zoneList()));
     sp_type.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,
             controller.strucureList()));
        btnSave.setOnClickListener(this);
    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    presenter = new SignUpPresenter();
    presenter.register(
            getSelectedItem(sp_province),
            getSelectedItem(sp_zone),
            getSelectedItem(sp_type),
            edt_minArret.getText().toString(),
            edt_hopitalName.getText().toString(),
            edt_hopitalAddress.getText().toString(),
            edt_hopitalResponsableName.getText().toString(),
            edt_hopitalResponsableNumber.getText().toString()

    );
            Intent i = new Intent(getContext(), PatientActivity.class);
            startActivity(i);

        }
    });


        return view;

    }




    @Override
    public String getSelectedItem(Spinner spinner) {
        String item = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        return item;
    }


    @Override
    public void onClick(View v) {
    if (v == btnSave){

    }
    }


}
