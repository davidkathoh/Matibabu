package com.example.david.matibabu.patientdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.david.matibabu.R;


public class CpnDetailFragment extends Fragment {
    private Button cpn1;
    private Button cpn2;
    private Button cpn3;
    private Button cpn4;


    public CpnDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_detail,container,false);
        cpn1 = view.findViewById(R.id.cpn_one);
        cpn2 = view.findViewById(R.id.cpn_two);
        cpn3 = view.findViewById(R.id.cpn_three);
        cpn4 = view.findViewById(R.id.cpn_four);

        cpn1.setOnClickListener(v ->{
            //todo button click
        });
        cpn2.setOnClickListener(v ->{
            //todo button click
        });
        cpn3.setOnClickListener(v ->{
            //todo button click
        });
        cpn4.setOnClickListener(v ->{
            //todo button click
        });

        return view;

    }


}
