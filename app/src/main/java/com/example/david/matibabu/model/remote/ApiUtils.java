package com.example.david.matibabu.model.remote;

import retrofit2.Retrofit;

/**
 * Created by david on 3/26/18.
 */

public class ApiUtils {
    private ApiUtils() {
    }
    public static final String BASE_URL = "// baseurl";
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
