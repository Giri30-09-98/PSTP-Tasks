package com.example.covid19reports;

import retrofit2.Call;
import retrofit2.http.GET;

public class EndInterface {
    @GET("dayone/country/IN")
    Call<String> getData(){
        return null;
    }
}
