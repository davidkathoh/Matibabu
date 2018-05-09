package com.example.david.matibabu.model.remote;

import com.example.david.matibabu.model.hopital.HopitalInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by david on 3/26/18.
 */

public interface ApiService {


    @POST("/d")
    Call<HopitalInfo> signUp(@Body HopitalInfo hopitalInfo);



}
