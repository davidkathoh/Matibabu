package com.example.david.matibabu.home;

import com.example.david.matibabu.utils.BasePresenter;
import com.example.david.matibabu.utils.BaseView;

/**
 * Created by david on 3/27/18.
 */

public interface HomeContract {
    interface View extends BaseView<Presenter>{
    void numberofCpn(int cpnNumber,int registeredToday, int numberOfdueToday);}
    interface Presenter extends BasePresenter{
        void fetch();

    }
}
