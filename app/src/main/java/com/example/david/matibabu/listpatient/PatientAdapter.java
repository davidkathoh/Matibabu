package com.example.david.matibabu.listpatient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.patientcpn.PatientCpnActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/16/18.
 */

class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    List<PersonalInfo> users;
    PatientListFragment mPatientListFragment = new PatientListFragment();

    public PatientAdapter(List<PersonalInfo> personalInfos) {
        this.users = personalInfos;

    }

    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {
        PersonalInfo info = users.get(position);
        holder.name.setText(info.getPatientName());
        holder.firstLetterIcon.setText(info.getPatientName().substring(0,1).toUpperCase());
        holder.ageGrossece.setText(info.getEtatCivil());
        holder.nombreCpn.setText((String.valueOf(info.getId())));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ageGrossece;
        ImageView icon;
        TextView nombreCpn;
        TextView name;
        TextView firstLetterIcon;
        ViewGroup container;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patient_name);
            icon = itemView.findViewById(R.id.img_icon);
            nombreCpn = itemView.findViewById(R.id.nombre_cpn);
            ageGrossece = itemView.findViewById(R.id.age_grossece);
            firstLetterIcon = itemView.findViewById(R.id.first_letter);
            container = itemView.findViewById(R.id.root_patient_list);
            container.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

           Log.e("Clicked()","item "+getAdapterPosition());
        }
    }
}
