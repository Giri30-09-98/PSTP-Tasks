package com.example.booksapi;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetIns {
    static Retrofit retrofit;
    public static final String URL = "https://www.googleapis.com/";

    static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit=new Retrofit.Builder().baseUrl(URL).addConverterFactory(ScalarsConverterFactory.create()).build();
        }
        return retrofit;
    }
}
