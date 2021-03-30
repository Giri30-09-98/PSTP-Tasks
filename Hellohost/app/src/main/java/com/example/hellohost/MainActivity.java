package com.example.hellohost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.tv);
        if(savedInstanceState!=null&&savedInstanceState.containsKey("any key")){

            count=savedInstanceState.getInt("any key");
            text.setText(String.valueOf(count));
            
        }
    }

    public void showToast(View view){
        Toast.makeText(this, "This is our own app", Toast.LENGTH_SHORT).show();
    }
    public void showCount(View view){
        count++;
        text.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("any key",count);
    }
}