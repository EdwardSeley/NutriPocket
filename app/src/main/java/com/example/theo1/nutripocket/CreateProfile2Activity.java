package com.example.theo1.nutripocket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class CreateProfile2Activity extends AppCompatActivity {

    Button CP2Info;
    Button CP2Info2;
    Button buttonContinue;
    Spinner activityLevel;
    Spinner goal;
    Spinner bodyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile2);
        getSupportActionBar().hide();

        CP2Info = (Button) findViewById(R.id.CP2Info);
        CP2Info2 = (Button) findViewById(R.id.CP2Info2);
        activityLevel = (Spinner) findViewById(R.id.activityLevel);
        goal = (Spinner) findViewById(R.id.goal);
        bodyType = (Spinner) findViewById(R.id.bodyType);

        CP2Info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(CreateProfile2Activity.this, activityLevelDescriptionsActivity.class);
                startActivity(intent);

            }
        });
        CP2Info2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(CreateProfile2Activity.this, BodyTypeDescription.class);
                startActivity(intent);

            }
        });

        buttonContinue = (Button) findViewById(R.id.CP2Continue);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveUserInfo();
                Intent intent = new Intent(CreateProfile2Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        activityLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });

        goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });


        bodyType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                Log.d("HELP TAG", bodyType.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });
    }
    public void saveUserInfo() {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("activityLevel", activityLevel.getSelectedItem().toString());
        Log.d("HELP", "TestGoal" + goal);
        editor.putString("goal", goal.getSelectedItem().toString());
        editor.apply();
    }
}

