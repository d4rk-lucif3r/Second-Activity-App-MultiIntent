package com.example.sec_t_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button camera = (Button) findViewById(R.id.cam);
        final Button google = (Button) findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "http://www.google.com";
                Uri web = Uri.parse(id);
                Intent gt = new Intent(Intent.ACTION_VIEW, web);
                if (gt.resolveActivity(getPackageManager()) != null) {
                    startActivity(gt);
                }
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.google.android.GoogleCamera");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
        });
    }
        public void nextActivity (View view)
        {
            Intent i = new Intent(this, SecondActivity.class);
            final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(80);
            startActivity(i);

        }


    }
