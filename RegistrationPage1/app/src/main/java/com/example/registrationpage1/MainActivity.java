package com.example.registrationpage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registrationpage1.R;
import com.example.registrationpage1.databinding.ActivityMainBinding;
import com.example.registrationpage1.DetailsActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String gender,knowncourses,userrating,userprogress;




    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "your button is on state", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "your button is off state", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                binding.gpResult.setText("Rating is:" + rating);
            }
        });
        binding.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.gpResult.setText("your progress is"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void showData(View view) {
        String name=binding.gpUsername.getText().toString();
        String email=binding.gpEmail.getText().toString();
        String mobile=binding.gpUserMobileNumber.getText().toString();
        String password=binding.gpUserpassword.getText().toString();
        String address=binding.gpAddress.getText().toString();
        if(binding.male.isChecked())
        {
            gender="Male";
        }
        else if(binding.female.isChecked())
        {
            gender="Female";
        }
        binding.rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                userrating=String.valueOf(rating);
            }
        });
        Intent intentobj=new Intent(this, DetailsActivity.class);
        intentobj.putExtra("myname",name);
        intentobj.putExtra("myemail",email);
        intentobj.putExtra("mymobile",mobile);
        intentobj.putExtra("mypassword",password);
        intentobj.putExtra("myaddress",address);
        intentobj.putExtra("mygender",gender);
        intentobj.putExtra("myrating",userrating);

        startActivity(intentobj);
    }
}
