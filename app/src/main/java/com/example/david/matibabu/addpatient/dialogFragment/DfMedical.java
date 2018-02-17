package com.example.david.matibabu.addpatient.dialogFragment;

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
import android.widget.CheckBox;

import com.example.david.matibabu.R;

/**
 * Created by david on 1/13/18.
 */

public class DfMedical extends DialogFragment {
    public static final String EXTRAT_MEDI_TBC="mtbc";
    public static final String EXTRAT_MEDI_HTA= "mHta" ;
    public static final String EXTRAT_MEDI_SCA= "mSca" ;
    public static final String EXTRAT_MEDI_DBT= "mDbt" ;
    public static final String EXTRAT_MEDI_CAR= "mCar" ;
    public static final String EXTRAT_MEDI_MGF= "mMgf" ;
    public static final String EXTRAT_MEDI_SYPHILIS = "mSyphilis" ;
    public static final String EXTRAT_MEDI_SIDA= "mSida" ;
    public static final String EXTRAT_MEDI_VVS= "mVvs" ;
    public static final String EXTRAT_MEDI_PEP= "mPep" ;


    private CheckBox mtbc;
    private CheckBox mHta;
    private CheckBox mSca;
    private CheckBox mDbt;
    private CheckBox mCar;
    private CheckBox mMgf;
    private CheckBox mSyphilis;
    private CheckBox mSida;
    private CheckBox mVvs;
    private CheckBox mPep;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext())
                .inflate(R.layout.dialogfr_medical,null);
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

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.ant_medicaux)
                .setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();

    }
    public void sendResult(int resultCode){
        Intent i = new Intent();
        i.putExtra(EXTRAT_MEDI_CAR,mCar.isChecked());
        i.putExtra(EXTRAT_MEDI_DBT,mDbt.isChecked());
        i.putExtra(EXTRAT_MEDI_HTA,mHta.isChecked());
        i.putExtra(EXTRAT_MEDI_MGF,mMgf.isChecked());
        i.putExtra(EXTRAT_MEDI_SIDA,mSida.isChecked());
        i.putExtra(EXTRAT_MEDI_VVS,mVvs.isChecked());
        i.putExtra(EXTRAT_MEDI_PEP,mPep.isChecked());
        i.putExtra(EXTRAT_MEDI_TBC,mtbc.isChecked());
        i.putExtra(EXTRAT_MEDI_SYPHILIS,mSyphilis.isChecked());
        i.putExtra(EXTRAT_MEDI_SCA,mSca.isChecked());

        getTargetFragment().onActivityResult(getTargetRequestCode()
        ,resultCode,i);

    }
}
