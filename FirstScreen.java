package com.example.tops.jsoninsert;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FirstScreen extends AppCompatActivity
{

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        imageView=(ImageView)findViewById(R.id.img);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, 12000);

    }




}

