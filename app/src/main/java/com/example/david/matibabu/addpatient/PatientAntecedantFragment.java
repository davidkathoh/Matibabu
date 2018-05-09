package com.example.david.matibabu.addpatient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.david.matibabu.R;
import com.example.david.matibabu.addpatient.dialogFragment.DfGyneco;
import com.example.david.matibabu.addpatient.dialogFragment.DfMedical;
import com.example.david.matibabu.addpatient.dialogFragment.DfObstericaux;
import com.example.david.matibabu.patientdetail.PatientDetailActivity;

import java.text.DateFormat;
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
    static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String date = null;
   static String PATIENTUID="PATIENTID";


    private TextView medical;
    private TextView obstericaux;
    private TextView gyneco;
    private TextInputEditText edt_pat_regle_date;
    private ConstraintLayout rootLayout;
    private View dfMedical;
    private View dfObsterico;
    private View dfGyneco;

    //medidacal views              //obsterico
    private CheckBox mtbc;         private EditText parite;
    private CheckBox mHta;         private EditText gestite;
    private CheckBox mSca;         private EditText enfant;
    private CheckBox mDbt;         private EditText avortement;
    private CheckBox mCar;         private EditText dystocie;
    private CheckBox mMgf;         private EditText eutocie;
    private CheckBox mSyphilis;    private EditText premature;
    private CheckBox mSida;        private EditText postmature;
    private CheckBox mVvs;         private EditText mortne;
    private CheckBox mPep;
    private CheckBox mRaa;
    //Gyneco views
    private CheckBox mCesarieneChb;
    private CheckBox mCerclage;
    private CheckBox mFibrone;
    private CheckBox mFracture;
    private CheckBox mGeu;
    private CheckBox mFistude;
    private CheckBox mCicatrice;
    private CheckBox mSterilite;

    PatientAntPresenter mPresenter;

    long patid;
    Date mDate;
    private long UID;
    private String patientName;

    public PatientAntecedantFragment() {
    }

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
      mPresenter = new PatientAntPresenter(getContext());
    getActivity().setTitle(R.string.tlb_antecedent);
//        PatientId = mPresenter.getPatientId();
        setHasOptionsMenu(true);
        Bundle bundle = getArguments();
        UID = bundle.getLong("ID");
        patientName = bundle.getString("name");

       gyneco  = v.findViewById(R.id.txt_gyneco);
       dfGyneco =v.findViewById(R.id.view_gyneco);
       dfMedical = v.findViewById(R.id.view_medical);
       dfObsterico = v.findViewById(R.id.view_obsterico);
        obstericaux = v.findViewById(R.id.txt_obsterical);
        medical = v.findViewById(R.id.txt_medical);
        rootLayout = v.findViewById(R.id.root_antecedent);
        edt_pat_regle_date = v.findViewById(R.id.pat_regle_date);
        medical.setOnClickListener(v12 -> {
            dfMedical.setVisibility(View.VISIBLE);
            dfObsterico.setVisibility(View.GONE);
            dfGyneco.setVisibility(View.GONE);
        });
        gyneco.setOnClickListener(v1 -> {
            dfMedical.setVisibility(View.GONE);
            dfObsterico.setVisibility(View.GONE);
            dfGyneco.setVisibility(View.VISIBLE);
        });
        obstericaux.setOnClickListener(v13 -> {
            dfMedical.setVisibility(View.GONE);
            dfObsterico.setVisibility(View.VISIBLE);
            dfGyneco.setVisibility(View.GONE);

        });
        edt_pat_regle_date = v.findViewById(R.id.pat_regle_date);
        edt_pat_regle_date.setOnClickListener(v14 -> {
            FragmentManager fragmentManager = getFragmentManager();
            DatePickerFragment dialog = new DatePickerFragment();
            dialog.setTargetFragment(PatientAntecedantFragment.this,REQUEST_DATE);
            dialog.show(fragmentManager,DATE_FRAGMENT);
        });
        //medical
        mtbc = v.findViewById(R.id.chb_tbc);
        mHta = v.findViewById(R.id.chb_hta);
        mSca = v.findViewById(R.id.chb_sca);
        mDbt = v.findViewById(R.id.chb_dbt);
        mCar = v.findViewById(R.id.chb_car);
        mMgf = v.findViewById(R.id.chb_mgf);
        mSyphilis = v.findViewById(R.id.chb_syphilis);
        mSida = v.findViewById(R.id.chb_sida);
        mVvs = v.findViewById(R.id.chb_vvs);
        mPep = v.findViewById(R.id.chb_pep);
        mRaa = v.findViewById(R.id.chb_raa);

        //gyneco
        mCesarieneChb = v.findViewById(R.id.chb_cesariene);
        mCerclage = v.findViewById(R.id.chb_cerclage);
        mFibrone = v.findViewById(R.id.chb_fibrone);
        mFracture = v.findViewById(R.id.chb_fracture_bassin);
        mGeu = v.findViewById(R.id.chb_geu);
        mFistude = v.findViewById(R.id.chb_fistude);
        mCicatrice = v.findViewById(R.id.chb_cecatrice);
        mSterilite = v.findViewById(R.id.chb_sterilite);

        //obsterico
        parite = v.findViewById(R.id.obs_parite);
        gestite = v.findViewById(R.id.obs_gestite);
        enfant = v.findViewById(R.id.obs_enf);
        avortement = v.findViewById(R.id.obs_avortement);
        dystocie = v.findViewById(R.id.obs_distocie);
        eutocie = v.findViewById(R.id.obs_eutocie);
        premature = v.findViewById(R.id.obs_premature);
        postmature = v.findViewById(R.id.obs_post_mature);
        mortne = v.findViewById(R.id.obs_mort_ne);


        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode == REQUEST_DATE){
            mDate = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            date = df.format(mDate);
            edt_pat_regle_date.setText(date);
            mPresenter.upDatePeriodDate((int) UID,mDate);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_save){
            save();
        mPresenter.add(getContext());
            openActivity();
            Snackbar.make(rootLayout,"enregistré avec succès",Snackbar.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.save,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void save(){
        mPresenter.inserMedi(UID,mtbc.isChecked(),
                mHta.isChecked(),mSca.isChecked(),mDbt.isChecked(),
                mCar.isChecked(),mMgf.isChecked(), mRaa.isChecked(),mSyphilis.isChecked(),
                mSida.isChecked(),mVvs.isChecked(),mPep.isChecked());


        mPresenter.insertObs(UID,
                to_int(parite),to_int(gestite),to_int(enfant),
                to_int(avortement),to_int(dystocie),to_int(eutocie)
                ,to_int(premature)
                ,to_int(postmature),to_int(mortne),false);

       // mPresenter.upDatePeriodDate((int)UID,mDate);

    }
public int to_int(EditText editText){
        if (editText.getText().toString().isEmpty()){
            return 0;
        }
        return  Integer.valueOf(editText.getText().toString());
}

public void openActivity(){

        Intent i = new Intent(getActivity(), PatientDetailActivity.class);
        i.putExtra("uid",UID);
        i.putExtra("name",patientName);
        i.putExtra("date",date);
    Log.e("date",date);
        startActivity(i);
        getActivity().finish();
}

}
