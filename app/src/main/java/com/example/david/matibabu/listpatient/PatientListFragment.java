package com.example.david.matibabu.listpatient;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.matibabu.R;
import com.example.david.matibabu.model.patient.PersonalInfo;
import com.example.david.matibabu.patientdetail.PatientDetailActivity;
import com.example.david.matibabu.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 2/12/18.
 */

public class PatientListFragment extends Fragment  implements PatientListContract.View{
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;
    private PatientAdapter mPatientAdapter;
    private PatientListContract.Presenter mPresenter;



    public static PatientListFragment newInstance(){
        return new PatientListFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.patient_recycle_view,container,false);
        mRecyclerView = v.findViewById(R.id.pat_recycle_view);

       LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mPresenter.getAllPatient();
        //mRecyclerView.setAdapter(mPatientAdapter);

         return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       inflater.inflate(R.menu.menu_search,menu);
        super.onCreateOptionsMenu(menu, inflater);
        SearchManager searchManager = (SearchManager)getActivity().getSystemService(Context.SEARCH_SERVICE);
       mSearchView = (SearchView) menu.findItem(R.id.action_search)
               .getActionView();
        mSearchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        mSearchView.setMaxWidth(Integer.MAX_VALUE);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPatientAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mPatientAdapter.getFilter().filter(newText);
                return false;

            }
        });

    }


    public void showPatients(List<PersonalInfo> personalInfos){
        mPatientAdapter.setPatientList(personalInfos);
    }


    @Override
    public void setPresenter(PatientListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadPatients(List<PersonalInfo> personalInfos) {


        mPatientAdapter = new PatientAdapter(personalInfos);
        mRecyclerView.setAdapter(mPatientAdapter);
        Log.e("tag", "called");
    }

    @Override
    public void showNoPatient() {

    }

    @Override
    public void openCpnActivity(long patientId) {

    }


}
