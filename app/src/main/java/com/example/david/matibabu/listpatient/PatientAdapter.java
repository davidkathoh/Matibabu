package com.example.david.matibabu.listpatient;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.patient.PersonalInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/16/18.
 */

class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    List<PersonalInfo> users;
    PatientListFragment mPatientListFragment = new PatientListFragment();

    public PatientAdapter(List<PersonalInfo> users) {
        this.users = users;
    }

    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position).getPatientName());



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ageGrossece;
        ImageView icon;
        TextView nombreCpn;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patient_name);
            icon = itemView.findViewById(R.id.img_icon);
            nombreCpn = itemView.findViewById(R.id.nombre_cpn);
            ageGrossece = itemView.findViewById(R.id.age_grossece);
        }
    }
}
