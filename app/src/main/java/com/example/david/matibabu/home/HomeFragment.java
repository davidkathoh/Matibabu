package com.example.david.matibabu.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.matibabu.R;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeContract.View{
    private TextView date;
    private Date mDate;

    private TextView registeredToday;
    private TextView cpnToday;
    private TextView passedCpnToday;
    private TextView dueToday;
    private HomeContract.Presenter mPresenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        getActivity().setTitle("");
        date = view.findViewById(R.id.txt_date);
        registeredToday = view.findViewById(R.id.txt_cpn_new);
        cpnToday = view.findViewById(R.id.txt_cpn_today);
        dueToday = view.findViewById(R.id.txt_dueToday);
        passedCpnToday = view.findViewById(R.id.txt_pass_cpn_today);
        mDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM");
        String txtDate  = df.format(mDate);

        date.setText(txtDate);
        mPresenter.fetch();
        return view;
    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void numberofCpn(int cpnNumber, int registeredToday, int numberOfdueToday) {
        cpnToday.setText(makeFirstLetterBig(cpnNumber +" entendu pour la cpn"), TextView.BufferType.SPANNABLE);
        passedCpnToday.setText(makeFirstLetterBig(registeredToday +" ont fait la cpn "));
        dueToday.setText(makeFirstLetterBig(numberOfdueToday + " accouchent"));
        this.registeredToday.setText(makeFirstLetterBig(registeredToday + "  enregistre "));
    }
    private String makeFirstLetterBig( String title) {
        final SpannableString spannableString = new SpannableString(title);
        int position = 0;
        spannableString.setSpan(new RelativeSizeSpan(2.0f), position, position + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString.toString();

    }
}
