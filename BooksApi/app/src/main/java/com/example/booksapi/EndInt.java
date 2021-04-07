package com.example.booksapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndInt {
    @GET("books/v1/volumes?q=twostates")
    Call<String> getData();
}
