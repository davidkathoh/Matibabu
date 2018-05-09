package com.example.david.matibabu.model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by david on 3/26/18.
 */

public class RetrofitClient {
    private static Retrofit mRetrofit = null;
    public  static Retrofit getClient(String baseUrl){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

}
