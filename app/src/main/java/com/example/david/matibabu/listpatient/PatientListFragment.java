package com.example.david.matibabu.listpatient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.matibabu.R;

import java.util.ArrayList;

/**
 * Created by david on 2/12/18.
 */

public class PatientListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    ArrayList<String> users;



    public static PatientListFragment newInstance(){
        return new PatientListFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.patient_recycle_view,container,false);
        mRecyclerView = v.findViewById(R.id.pat_recycle_view);
        users = new ArrayList<>();
        for (int i =0;i< 10;i++){
            users.add("item "+i);
        }
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new PatientAdapter(users);
        mRecyclerView.setAdapter(mAdapter);

         return v;
    }
}
