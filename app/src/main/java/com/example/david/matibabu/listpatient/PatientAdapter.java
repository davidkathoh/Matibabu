package com.example.david.matibabu.listpatient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.patientdetail.PatientDetailActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/**
 * Created by david on 2/16/18.
 */

class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder>
 implements Filterable{
    List<PersonalInfo> patientList;
    List<PersonalInfo> patientFilterdList;
    Bundle mBundle;



    public PatientAdapter(List<PersonalInfo> list) {

    this.patientList = list;
    this.patientFilterdList = patientList;
    setList(patientFilterdList);


    }

    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {
        PersonalInfo info = patientFilterdList.get(position);
        holder.icon.setColorFilter(info.getColor());
        holder.name.setText(info.getPatientName());
       holder.firstLetterIcon.setText(info.getPatientName().substring(0,1).toUpperCase());
        holder.ageGrossece.setText(info.getPatientPhone());
        holder.nombreCpn.setText((String.valueOf(info.getId())));

        //mPresenter.onBindRepositoryAtPosition(position,holder);

    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
    public void replaceData(List<PersonalInfo> personalInfos){
        setList(personalInfos);
        notifyDataSetChanged();
    }
    private void setList(List<PersonalInfo> personalInfos){
        patientFilterdList = checkNotNull(personalInfos);
    }
    public void setPatientList(List<PersonalInfo> patientLists){
        patientList = patientLists;
        notifyDataSetChanged();

    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String queryString = constraint.toString();
                if ( queryString.isEmpty()  ){
                    patientFilterdList = patientList;
                }else {
                    List<PersonalInfo>  filter = new ArrayList<>();
                    for (PersonalInfo info : patientList){
                        if (info.getPatientName().toLowerCase().contains(queryString)
                                || String.valueOf(info.getId()).contains(queryString)
                                || info.getPatientPhone().contains(queryString)){
                            filter.add(info);
                        }
                    }
                    patientFilterdList = filter;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = patientFilterdList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                patientFilterdList = (ArrayList<PersonalInfo>)results.values;
                notifyDataSetChanged();
            }
           };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,rowView {
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
            String name = patientFilterdList.get(getAdapterPosition()).getPatientName();
            int uid = patientFilterdList.get(getAdapterPosition()).getId();
            Date date = patientFilterdList.get(getAdapterPosition()).getLastPeriodDate();
            Intent intent = new Intent(v.getContext(), PatientDetailActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("uid",uid);
            intent.putExtra("date",date);
            v.getContext().startActivity(intent);
           Log.e("Clicked()","item "+getAdapterPosition());
        }

        @Override
        public void setPatientName(String name) {
            this.name.setText(name);
        }

        @Override
        public void setBackGroungColor(int color) {

            icon.setColorFilter(color);
        }

        @Override
        public void setFirstLetter(String letter) {firstLetterIcon.setText(letter);
        }
    }
}
 interface rowView{
    void setPatientName(String name);
    void setBackGroungColor(int color);
    void setFirstLetter(String letter);
}
