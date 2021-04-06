package com.example.retroex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
TextView C19,Country,Date,Recovered,Dead,ActiveCases;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching..");
        dialog.setMessage("Please Wait ...");
        dialog.show();
        C19=findViewById(R.id.c19);
        Country=findViewById(R.id.c);
        Date=findViewById(R.id.dt);
        Recovered=findViewById(R.id.rc);
        Dead=findViewById(R.id.dd);
        ActiveCases=findViewById(R.id.ac);
        EndInt ei= RetIns.getRetrofit().create(EndInt.class);
       Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.cancel();
                Log.i("ding",response.body());
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                try {
                    JSONArray root=new JSONArray(response.body());
                    JSONObject rootobj=root.getJSONObject(root.length()-1);
                    String res_country=rootobj.getString("Country");
                    Country.setText("Country:"+res_country);
                    String resDate=rootobj.getString("Date");
                    Date.setText("Date:"+properDateFormat(resDate));
                    String resActiveCases=rootobj.getString("Active");
                    ActiveCases.setText("Active:"+resActiveCases);
                    String resDead=rootobj.getString("Deaths");
                    Dead.setText("Deaths:"+resDead);
                    String resRecovered=rootobj.getString("Recovered");
                    Recovered.setText("Recovered:"+resRecovered);
                    String resC19=rootobj.getString("C19");
                    C19.setText("C19:"+resC19);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String properDateFormat(String resDate) {
        String inputPattern = "yy-mm-dd";
        String outputPattern = "dd-mm-yy";
        SimpleDateFormat inputDate = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputDate = new SimpleDateFormat(outputPattern);
        java.util.Date d = null;
        String str = null;
        try {
            d = inputDate.parse(resDate);
            str = outputDate.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
