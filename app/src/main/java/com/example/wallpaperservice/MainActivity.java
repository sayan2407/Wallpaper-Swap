package com.example.wallpaperservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton r1 , r2 ;
     int time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.radioButton1) ;
        r2 = findViewById(R.id.radioButton2) ;
    }

    public void stopService(View view) {
        Intent i = new Intent(MainActivity.this , wallpaper.class) ;
        stopService(i) ;
        finish();
    }

    public void set_Timing(View view) {
        if (r1.isChecked())
        {
            time = 60 ;
        }
        else {
            time = 120 ;
        }
        Intent i = new Intent(MainActivity.this , wallpaper.class) ;
        Bundle b = new Bundle() ;
        b.putInt("k" , time);
        i.putExtras(b) ;
        startService(i) ;
        finish();
    }
}