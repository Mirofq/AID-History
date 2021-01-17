package com.example.android.depressiontest;

import android.content.ComponentName;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

//import junit.framework.Test;

public class ResultActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView TestResult;
    TextView Disclaimer;
    Button viewRec;
    int nilaiInt;
    //ImageView ScoreRange;
    private static final String Name = "FullName";
    String VoiceEmo;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();

        TestResult = (TextView) findViewById(R.id.TestResult);
        //Disclaimer = (TextView) findViewById(R.id.Disclaimer);
        //ScoreRange = (ImageView) findViewById(R.id.ScoreRange);

        //MainMenu = findViewById(R.id.ButtonMenu);

        //getName = getIntent().getStringExtra("nameofuser");
        nilaiInt = getIntent().getIntExtra("nilai", 0);
        VoiceEmo = getIntent().getStringExtra("voiceemotion");

        final DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String FullName = documentSnapshot.getString(Name);

                            //Neutral
                            if (nilaiInt <= 4 && "Neutral".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n  Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Neutral".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Neutral".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n\n This indicates that you may have mild depression. Please contact recommended hotline numbers if your symptoms worsen and affects your daily activities."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest twice a month in order to track improvements.");
                            } else if (nilaiInt <= 22 && "Neutral".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 22 && "Neutral".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            }

                            //Happiness
                            if (nilaiInt <= 4 && "Happiness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n  Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Happiness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Happiness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n\n This indicates that you may have mild depression. Please contact recommended hotline numbers if your symptoms worsen and affects your daily activities."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest twice a month in order to track improvements.");
                            } else if (nilaiInt <= 22 && "Happiness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 22 && "Happiness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            }


                            //Sadness
                            if (nilaiInt <= 4 && "Sadness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n  Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Sadness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n\n This indicates that you may have mild depression. Please do recommended self-treatment activities and contact recommended hotline numbers if your symptoms worsen."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest twice a month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Sadness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 22 && "Sadness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate to Severe Depression"+
                                        "\n\n\n This indicates that you may have moderate to severe depression. We gladly suggest you to seek active treatment with medication and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 22 && "Sadness".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n\n This indicates that you may have severe depression. We gladly suggest you to refer yourself to mental health specialist."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest daily in order to track improvements.");
                            }

                            //Anger
                            if (nilaiInt <= 4 && "Anger".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n  Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Anger".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n\n This indicates that you may have mild depression. Please do recommended self-treatment activities and contact recommended hotline numbers if your symptoms worsen."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest twice a month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Anger".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 22 && "Anger".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate to Severe Depression"+
                                        "\n\n\n This indicates that you may have moderate to severe depression. We gladly suggest you to seek active treatment with medication and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 22 && "Anger".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n\n This indicates that you may have severe depression. We gladly suggest you to refer yourself to mental health specialist."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest daily in order to track improvements.");
                            }

                            //Fear
                            if (nilaiInt <= 4 && "Fear".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n  Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: No Depression"+
                                        "\n\n\n This indicates that you have no depression."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest after one month in order to track improvements.");
                            } else if (nilaiInt <= 9 && "Fear".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Mild Depression"+
                                        "\n\n\n This indicates that you may have mild depression. Please do recommended self-treatment activities and contact recommended hotline numbers if your symptoms worsen."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest twice a month in order to track improvements.");
                            } else if (nilaiInt <= 14 && "Fear".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate Depression"+
                                        "\n\n\n This indicates that you may have moderate depression. We gladly suggest you to get counselling and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt <= 22 && "Fear".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Moderate to Severe Depression"+
                                        "\n\n\n This indicates that you may have moderate to severe depression. We gladly suggest you to seek active treatment with medication and/or therapy."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest weekly in order to track improvements.");
                            } else if (nilaiInt > 22 && "Fear".equals(VoiceEmo)) {
                                TestResult.setText("\n Hi " + FullName + "\n\n\n\n\n Face Emotion: " + VoiceEmo + "\n PHQ-9 Questionnaire Score: " + nilaiInt +
                                        "\n Total Result: Severe Depression"+
                                        "\n\n\n This indicates that you may have severe depression. We gladly suggest you to refer yourself to mental health specialist."+
                                        "\n\n\n Please try our recommended treatment suggestions and we recommend you to retest daily in order to track improvements.");
                            }

                        } else {
                            Toast.makeText( ResultActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                            //Log.d("tag", "onEvent: Document do not exists");
                        }


                        documentReference.get().addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText( ResultActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.d("tag", e.toString());

                            }
                        });

                    }
                });
        //Disclaimer.setText("\nPHQ-9, Patient Health Questionnaire 9:-" + "\nDeveloped by Drs Robert L Spitzer, Janet B.W. Williams, Kurt Kroenke and colleages, with an educational grant from Pfizer Inc."
        // + "\nNo permission required to reproduce, translate, display or contribute.");


        viewRec = (Button) findViewById(R.id.recList);
        viewRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(getApplicationContext(), ReccomendActivity.class);
                startActivity(r);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_MAIN);

        int itemId = item.getItemId();

        if (itemId == R.id.nav_account) {
            Log.i("MenuItem", "Account");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.UserActivity"));
            startActivity(intent);

        } else if (itemId == R.id.nav_settings) {
            Log.i("MenuItem", "About");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.AboutActivity"));
            startActivity(intent);

        } else if (itemId == R.id.nav_homepage) {
            Log.i("MenuItem", "Home");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.Homepage"));
            startActivity(intent);

        } else if (itemId == R.id.nav_logout) {
            Log.i("MenuItem", "Logout");
            FirebaseAuth.getInstance().signOut();//logout
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.LoginActivity"));
            finish();
        } else {
            return false;
        }

        return false;
    }
}