package com.example.android.depressiontest;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ExerciseActivity extends AppCompatActivity {
    Button BtnInfo;
    Button BtnBreathing;
    Button BtnWorkout;
    Button BtnYoga;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_exercise);

            BtnInfo = findViewById(R.id.btnInfo);
            BtnBreathing = findViewById(R.id.btnBreathing);
            BtnWorkout = findViewById(R.id.btnWorkout);
            BtnYoga = findViewById(R.id.btnYoga);

            BtnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), ExerciseInfo.class);
                    startActivity(i);
                }
            });

            BtnBreathing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent b = new Intent(getApplicationContext(), BreathingActivity.class);
                    startActivity(b);
                }
            });


            BtnWorkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent w = new Intent(getApplicationContext(), WorkoutActivity.class);
                    startActivity(w);
                }
            });

            BtnYoga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent y = new Intent(getApplicationContext(), YogaActivity.class);
                    startActivity(y);
                }
            });
        }
    }