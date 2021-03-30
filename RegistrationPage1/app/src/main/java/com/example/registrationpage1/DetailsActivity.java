package com.example.registrationpage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registrationpage1.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        detailsBinding.gpDetails.setVisibility(View.VISIBLE);
        Intent i = getIntent();
        String n = i.getStringExtra("myname");
        String p = i.getStringExtra("mypassword");
        String e = i.getStringExtra("myemail");
        String m = i.getStringExtra("mymobile");
        String a = i.getStringExtra("myaddress");
        String g = i.getStringExtra("mygender");
        String r = i.getStringExtra("mygrating");
        detailsBinding.gpDetails.append("name:"+n+"\n"+"password:"+p+"\n"+"email:"+e+"\n"+"mobile:"+m+"\n"+"gender:"+g+"\n"+"address:"+a+"\n");
    }
}