package com.example.david.matibabu.listpatient;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.matibabu.R;

import java.util.ArrayList;

/**
 * Created by david on 2/16/18.
 */

class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    ArrayList<String> users;

    public PatientAdapter(ArrayList<String> users) {
        this.users = users;
    }

    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.patientlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position));


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
