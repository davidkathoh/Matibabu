package com.example.david.matibabu.statistics;

import com.example.david.matibabu.model.patient.Cpn;
import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

import java.util.List;

/**
 * Created by david on 6/16/18.
 */

public interface StatisticContract {
    interface View extends BaseView<Presenter>{
        void cpnStatistcs(List<Cpn> cpn);

    }
    interface Presenter extends BasePresenter{
        void loadCpnNumber(String from, String to);

    }
}
