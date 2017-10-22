package com.example.theo1.nutripocket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static android.R.id.list;
import static com.example.theo1.nutripocket.R.array.genderSpinner;

public class CreateProfileActivity extends AppCompatActivity {
    Button buttonContinue;
    EditText fName;
    EditText lName;
    EditText age;
    EditText height;
    EditText weight;
    Spinner genderSpin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        getSupportActionBar().hide();
        buttonContinue = (Button) findViewById(R.id.CP1Button);
        genderSpin = (Spinner) findViewById(R.id.gender);

        age = (EditText) findViewById(R.id.age);
        fName = (EditText) findViewById(R.id.nameFirst);
        lName = (EditText) findViewById(R.id.nameLast);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveUserInfo();

                Intent intent = new Intent(CreateProfileActivity.this, CreateProfile2Activity.class);
                intent.putExtra("userInfo", new String[] {age.getText().toString(), weight.getText().toString(), height.getText().toString() } );
                startActivity(intent);

            }
        });
        genderSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                Log.d("HELP TAG", genderSpin.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                return;
            }
        });

    }

        //Save Info
        public void saveUserInfo() {
            SharedPreferences sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("firstName", fName.getText().toString());
            editor.putString("lastName", lName.getText().toString());
            editor.putString("age", age.getText().toString());
            editor.putString("height", height.getText().toString());
            editor.putString("weight", weight.getText().toString());
            editor.putString("gender", genderSpin.getSelectedItem().toString());
            editor.apply();
        }
}

