package com.example.booksapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView Title,Author,Description;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Data Fetching..");
        dialog.setMessage("Please Wait ...");
        dialog.show();
Title=findViewById(R.id.kd);
Author=findViewById(R.id.tt);
Description=findViewById(R.id.it);
EndInt ei=RetIns.getRetrofit().create(EndInt.class);
        Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.cancel();
                Log.i("ding", response.body());
                Toast.makeText(MainActivity.this, "Hii", Toast.LENGTH_SHORT).show();
                try {


                    JSONObject rootobj = new JSONObject(response.body());
                    JSONArray root=rootobj.getJSONArray("items");
                    JSONObject root1=root.getJSONObject(0);
                    JSONObject root2=root1.getJSONObject("volumeInfo");
                    String res_title = root2.getString("title");
                    Title.setText("title:"+res_title);
                    JSONArray root3=root2.getJSONArray("authors");
                    String s = root3.getString(0);
                    String res_authors = root2.getString("authors");
                    Author.setText("authors:" + s);
                    String res_description = root2.getString("description");
                    Description.setText("description" + res_description);
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
}
