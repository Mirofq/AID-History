package com.example.android.depressiontest;

import android.content.Intent;
import android.speech.tts.Voice;
//import android.support.annotation.StringRes;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //TextView Introduksi;
    //Button VoiceTest;
    Button StartTest;
    //Button TestInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView Introduksi = (TextView)findViewById(R.id.AIDText);
        //Introduksi.setText("@string/app_label");

        //TextView appfullname = (TextView)findViewById(R.id.AmID);
        //appfullname.setText("@string/app_fullname");

        //+ "This test is conducted for early detection purposes.");


        //VoiceTest = (Button)findViewById(R.id.btnVoice);
        //VoiceTest.setOnClickListener(new View.OnClickListener() {
        //@Override
        // public void onClick(View view) {
        //Intent v=new Intent(getApplicationContext(), VoiceActivity.class);


        //startActivity(v);
        //}
        // });

        StartTest = (Button)findViewById(R.id.MulaiTest);
        StartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), StartActivity.class);


                startActivity(i);
            }
        });

        //TestInfo = (Button)findViewById(R.id.InfoTes);
        //TestInfo.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View view) {
        //Intent m=new Intent(getApplicationContext(), ReccomendActivity.class);

        //startActivity(m);
        //}
        //});

    }
}
