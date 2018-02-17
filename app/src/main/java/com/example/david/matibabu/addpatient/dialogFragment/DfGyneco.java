package com.example.david.matibabu.addpatient.dialogFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import com.example.david.matibabu.R;
import com.example.david.matibabu.addpatient.PatientContract;

/**
 * Created by david on 1/31/18.
 */

public class DfGyneco extends DialogFragment {
    public static final String EXTRAT_GYNECO_CESA="mCesarieneChb";
    public static final String EXTRAT_GYNECO_CERC="mCerclage";
    public static final String EXTRAT_GYNECO_FIBRO="mFibrone";
    public static final String EXTRAT_GYNECO_FRA="mFracture";
    public static final String EXTRAT_GYNECO_GEU="mGeu";
    public static final String EXTRAT_GYNECO_CICA="mCicatrice";
    public static final String EXTRAT_GYNECO_STER="mSterilite";

    private CheckBox mCesarieneChb;
    private CheckBox mCerclage;
    private CheckBox mFibrone;
    private CheckBox mFracture;
    private CheckBox mGeu;
    private CheckBox mCicatrice;
    private CheckBox mSterilite;

    PatientContract mContract;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext())
                .inflate(R.layout.dialogfr_gyneco,null);
        mCesarieneChb = v.findViewById(R.id.chb_cesariene);
        mCerclage = v.findViewById(R.id.chb_cerclage);
        mFibrone = v.findViewById(R.id.chb_fibrone);
        mFracture = v.findViewById(R.id.chb_fracture_bassin);
        mGeu = v.findViewById(R.id.chb_geu);
        mCicatrice = v.findViewById(R.id.chb_cecatrice);
        mSterilite = v.findViewById(R.id.chb_sterilite);


        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.ant_gyneco)
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
        if (getTargetFragment() == null){
            return;
        }
        Intent i = new Intent();
        i.putExtra(EXTRAT_GYNECO_CESA,mCesarieneChb.isChecked());
        i.putExtra(EXTRAT_GYNECO_CERC,mCerclage.isChecked());
        i.putExtra(EXTRAT_GYNECO_FIBRO,mFibrone.isChecked());
        i.putExtra(EXTRAT_GYNECO_FRA,mFracture.isChecked());
        i.putExtra(EXTRAT_GYNECO_CICA,mCicatrice.isChecked());
        i.putExtra(EXTRAT_GYNECO_GEU,mGeu.isChecked());
        i.putExtra(EXTRAT_GYNECO_STER,mSterilite.isChecked());

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(),resultCode,i);



    }
}
