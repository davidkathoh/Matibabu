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

/**
 * Created by david on 1/31/18.
 */

public class DfObstericaux extends DialogFragment {
    public static final String EXTRAT_OBS_GESTILE="mGestile";
    public static final String EXTRAT_OBS_PARITE="mParite";
    public static final String EXTRAT_OBS_ENFA="mEnfant";
    public static final String EXTRAT_OBS_AVORT="mAvortement";
    public static final String EXTRAT_OBS_DYSTO="mDystocie";
    public static final String EXTRAT_OBS_EUTO="mEutocie";
    public static final String EXTRAT_OBS_PREMATURE="mPremature";
    public static final String EXTRAT_OBS_POSTMATURE="mPostPremature";
    public static final String EXTRAT_OBS_MORT="mMort";
    public static final String EXTRAT_OBS_COMPLICATION="mComplication";

    private CheckBox mParite;
    private CheckBox mGestile;
    private CheckBox mEnfant;
    private CheckBox mAvortement;
    private CheckBox mDystocie;
    private CheckBox mEutocie;
    private CheckBox mPremature;
    private CheckBox mPostPremature;
    private CheckBox mMort;
    private CheckBox mComplication;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext())
                .inflate(R.layout.dialogfr_obsterico,null);
        mGestile = v.findViewById(R.id.chb_gestile);
        mEnfant =  v.findViewById(R.id.chb_enfant);
        mAvortement = v.findViewById(R.id.chb_avortement);
        mDystocie = v.findViewById(R.id.chb_dystocie);
        mEutocie = v.findViewById(R.id.chb_eutocie);
        mParite = v.findViewById(R.id.chb_parite);
        mPremature = v.findViewById(R.id.chb_premature);
        mPostPremature = v.findViewById(R.id.chb_postmature);
        mMort = v.findViewById(R.id.chb_mort);
        mComplication = v.findViewById(R.id.chb_complication);
        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.ant_obstericaux)
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
        i.putExtra(EXTRAT_OBS_AVORT,mAvortement.isChecked());
        i.putExtra(EXTRAT_OBS_COMPLICATION,mComplication.isChecked());
        i.putExtra(EXTRAT_OBS_DYSTO,mDystocie.isChecked());
        i.putExtra(EXTRAT_OBS_ENFA,mEnfant.isChecked());
        i.putExtra(EXTRAT_OBS_EUTO,mEutocie.isChecked());
        i.putExtra(EXTRAT_OBS_GESTILE,mGestile.isChecked());
        i.putExtra(EXTRAT_OBS_POSTMATURE,mPostPremature.isChecked());
        i.putExtra(EXTRAT_OBS_PREMATURE,mPremature.isChecked());
        i.putExtra(EXTRAT_OBS_MORT,mMort.isChecked());

        getTargetFragment().
                onActivityResult(getTargetRequestCode(),resultCode,i);
    }
}
