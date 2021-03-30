package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void browser(View view) {
        Uri uri=Uri.parse("https://www.linkedin.com/feed/");
        Intent i1=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }
}