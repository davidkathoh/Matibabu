package com.example.david.matibabu.addpatient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    PatientPresenter mPresenter;

    private TextView medical;
    private TextView obstericaux;
    private TextView gyneco;


    public PatientAntecedantFragment()  {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_info_1,container,false);
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
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_GYNECO){
            boolean v = (Boolean) data.getSerializableExtra(DfGyneco.EXTRAT_GYNECO_FIBRO);
            Log.e("GYN",String.valueOf(v));


        }
        if (requestCode ==REQUEST_MEDICAUX){

        }
        if (requestCode == REQUEST_OBSTERICO){

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.menu.save){
            mPresenter.add();
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

}
