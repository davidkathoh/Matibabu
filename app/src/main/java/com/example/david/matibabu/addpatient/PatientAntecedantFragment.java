package com.example.david.matibabu.addpatient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.matibabu.R;
import com.example.david.matibabu.addpatient.dialogFragment.DfGyneco;
import com.example.david.matibabu.addpatient.dialogFragment.DfMedical;
import com.example.david.matibabu.addpatient.dialogFragment.DfObstericaux;
import com.example.david.matibabu.model.patient.antecedents.Obstetricaux;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by david on 1/12/18.
 */

public class PatientAntecedantFragment extends Fragment {

    private static final int REQUEST_MEDICAUX = 0;
    private static final int REQUEST_GYNECO = 1;
    private static final int REQUEST_OBSTERICO = 2;
    final private String DF_MEDICAUX = "DF_MEDICAL";
    final private String DF_GYNECO = "DF_GYNECO";
    final private String DF_OBSTERICO = "DF_OBSTERICO";
    private static final String DATE_FRAGMENT = "dialogFragmnet";
    private static final int REQUEST_DATE = 3;

    private TextView medical;
    private TextView obstericaux;
    private TextView gyneco;
    private TextInputEditText edt_pat_regle_date;
    PatientPresenter mPresenter ;
    private int PatientId;
    Date mDate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_info_1,container,false);
        mPresenter = new PatientPresenter();
        PatientId = mPresenter.getPatientId();
        setHasOptionsMenu(true);
       gyneco  = v.findViewById(R.id.txt_gyneco);
        obstericaux = v.findViewById(R.id.txt_obsterical);
        medical = v.findViewById(R.id.txt_medical);
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DfMedical df = new DfMedical();
                df.setTargetFragment(PatientAntecedantFragment.this,REQUEST_MEDICAUX);
                showFragmentDialog(df,DF_MEDICAUX);

            }
        });
        gyneco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DfGyneco df = new DfGyneco();
                df.setTargetFragment(PatientAntecedantFragment.this,REQUEST_GYNECO);
                showFragmentDialog(df,DF_GYNECO);

            }
        });
        obstericaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DfObstericaux df = new DfObstericaux();
                df.setTargetFragment(PatientAntecedantFragment.this,REQUEST_OBSTERICO);
                showFragmentDialog(df,DF_OBSTERICO);

            }
        });
        edt_pat_regle_date = v.findViewById(R.id.pat_regle_date);
        edt_pat_regle_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(PatientAntecedantFragment.this,REQUEST_DATE);
                dialog.show(fragmentManager,DATE_FRAGMENT);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter = new PatientPresenter();
        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_GYNECO){
           mPresenter.insertGyn(PatientId,
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_CESA),
                    isAntChecked(data,DfGyneco.EXTRAT_GYNECO_CERC),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_FIBRO),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_FRA),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_GEU),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_Fist),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_CICA),
                   isAntChecked(data,DfGyneco.EXTRAT_GYNECO_STER));
            //Log.e("GYN",String.valueOf(v));


        }
        if (requestCode ==REQUEST_MEDICAUX){
            mPresenter.inserMedi(PatientId,
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_TBC),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_HTA),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_SCA),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_DBT),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_CAR),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_MGF),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_SYPHILIS),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_SIDA),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_VVS),
                    isAntChecked(data,DfMedical.EXTRAT_MEDI_PEP));
        }
        if (requestCode == REQUEST_OBSTERICO){
            mPresenter.insertObs(PatientId,
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_PARITE),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_GESTILE),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_ENFA),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_AVORT),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_DYSTO),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_EUTO),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_PREMATURE),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_POSTMATURE),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_MORT),
                    isAntChecked(data,DfObstericaux.EXTRAT_OBS_COMPLICATION));

        }
        if (requestCode == REQUEST_DATE){
            mDate = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
            String date = fmt.format(mDate);
            edt_pat_regle_date.setText(date);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.menu.save){
          //  mPresenter.add(getContext());


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    public void showFragmentDialog(DialogFragment fragment, String tag){
        FragmentManager fragmentManager = getFragmentManager();
        fragment.show(fragmentManager,tag);

    }
    public boolean isAntChecked(Intent data,String EXTRAT_KEY){
       return   (Boolean) data.getSerializableExtra(EXTRAT_KEY) ;
    }
}
