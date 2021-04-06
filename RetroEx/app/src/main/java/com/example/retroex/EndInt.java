package com.example.retroex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndInt {
    @GET("dayone/country/IN")
    Call<String> getData();
}
