package com.example.android.depressiontest;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DietActivity extends AppCompatActivity {

    TextView Instruction;
    TextView food1;
    TextView food2;
    TextView food3;
    TextView food4;
    TextView food5;
    TextView food6;
    TextView food7;
    TextView food8;
    TextView food9;
    TextView food10;
    ImageView greentea;
    ImageView almond;
    ImageView salmon;
    ImageView chocolate;
    ImageView eggs;
    ImageView banana;
    ImageView avocado;
    ImageView blueberry;
    ImageView spinach;
    ImageView asparagus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        Instruction = findViewById(R.id.Instruction);
        food1 = findViewById(R.id.txtGreentea);
        food2 = findViewById(R.id.txtAlmond);
        food3 = findViewById(R.id.txtSalmon);
        food4 = findViewById(R.id.txtChoco);
        food5 = findViewById(R.id.txtEggs);
        food6 = findViewById(R.id.txtBanana);
        food7 = findViewById(R.id.txtAvocado);
        food8 = findViewById(R.id.txtBlueberry);
        food9 = findViewById(R.id.txtSpinach);
        food10 = findViewById(R.id.txtAsparagus);
        greentea = findViewById(R.id.picGreentea);
        almond = findViewById(R.id.picAlmond);
        salmon = findViewById(R.id.picSalmon);
        eggs = findViewById(R.id.picEggs);
        banana = findViewById(R.id.picBanana);
        avocado = findViewById(R.id.picAvocado);
        blueberry = findViewById(R.id.picBlueberry);
        spinach = findViewById(R.id.picSpinach);
        asparagus = findViewById(R.id.picAsparagus);


    }
}