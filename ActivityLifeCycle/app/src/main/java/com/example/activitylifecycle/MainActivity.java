package com.example.activitylifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitylifecycle.R;

import java.io.CharArrayWriter;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        textView.append("onCreate() invoked \n ");
        Log.i("mainActivity","on create()");
        Toast.makeText(this,"app is created",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStart() {

        super.onStart();
        textView.append("onStart()\n");
        Log.i("mainActivity","onStart");
        Toast.makeText(this,"app is created",Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onResume() {

        super.onResume();
        textView.append("onResume()\n");
        Log.i("mainActivity", "onResume");
        Toast.makeText(this, "app is Resumed", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onPause() {

        super.onPause();

        textView.append("onPause()\n");
        Log.i("mainActivity", "onpause");
        Toast.makeText(this, "app is pause", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onStop() {

        super.onStop();

        textView.append("onStop()\n");
        Log.i("mainActivity", "onStop");
        Toast.makeText(this, "app is stop", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onRestart() {

        super.onRestart();

        textView.append("onRestart()\n");
        Log.i("mainActivity", "onRestart");
        Toast.makeText(this, "app is Restart", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onDestroy() {

        super.onDestroy();

        textView.append("onDestroy()\n");

        Log.i("mainActivity", "onDestroy");
        Toast.makeText(this, "app is Destroy", Toast.LENGTH_SHORT).show();

    }

}