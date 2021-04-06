package com.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView country, date, active, recovered, deaths, confirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country = findViewById(R.id.ct);
        date = findViewById(R.id.date);
        active = findViewById(R.id.ac);
        recovered = findViewById(R.id.rc);
        deaths = findViewById(R.id.dc);
        confirmed = findViewById(R.id.cc);
        EndInterface ei = C19Res.getRetrofit().create(EndInterface.class);
        Call<String> c = ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ding", response.body());
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something", Toast.LENGTH_LONG);
            }
        });
    }
}
