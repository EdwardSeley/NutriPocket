package com.example.theo1.nutripocket;

import android.content.Intent;
import android.graphics.Typeface;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DailyNutritionActivity extends AppCompatActivity {

    Button submitButton;
    TextView nutritionTitle;

    TextView calorieDaily;
    TextView sodiumDaily;
    TextView fatDaily;
    TextView sugarDaily;
    TextView proteinDaily;

    EditText calorieAmount;
    EditText sodiumAmount;
    EditText sugarAmount;
    EditText proteinAmount;
    EditText fatAmount;

    static double calories;
    static double sodium;
    static double sugar;
    static double protein;
    static double fat;

    static double[] getNutrients()
    {
        return new double[] {calories, sodium, sugar, protein, fat};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_nutrition);
        getSupportActionBar().hide();
        nutritionTitle = (TextView) findViewById(R.id.nutritionTitleView);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/franklingothic-demi.otf");
        nutritionTitle.setTypeface(face);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DailyNutritionActivity.this, MainActivity.class);
                intent.putExtra("nutrients", new double[] {calories, sodium, sugar, protein, fat});
                setResult(5, intent);
                finish();            }
        });

        final TextView calorieDaily = (TextView) findViewById(R.id.caloriesDaily);
        final TextView sodiumDaily = (TextView) findViewById(R.id.sodiumDaily);
        final TextView fatDaily = (TextView) findViewById(R.id.fatDaily);
        final TextView sugarDaily = (TextView) findViewById(R.id.sugarDaily);
        final TextView proteinDaily = (TextView) findViewById(R.id.proteinDaily);

        calorieAmount = (EditText) findViewById(R.id.amountOfCalories);
        sodiumAmount = (EditText) findViewById(R.id.amountOfSodium);
        sugarAmount = (EditText) findViewById(R.id.amountOfSugar);
        proteinAmount = (EditText) findViewById(R.id.amountOfProtein);
        fatAmount = (EditText) findViewById(R.id.amountOfFat);

        final DecimalFormat df = new DecimalFormat("#.##");

        calorieAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = calorieAmount.getText().toString();
                text=text.replaceAll("[*a-zA-Z]", "");
                if (!text.isEmpty())
                {
                    calories = Integer.parseInt(text);
                    double percent = (calories/2000) * 100;
                    Log.d("HELP", String.valueOf(percent));
                    calorieDaily.setText(df.format(percent) + "%");
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        sodiumAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = sodiumAmount.getText().toString();
                text=text.replaceAll("[*a-zA-Z]", "");
                if (!text.isEmpty())
                {
                    sodium = Double.parseDouble(text);
                    double percent = (sodium/3.75) * 100;
                    Log.d("HELP", String.valueOf(percent));
                    sodiumDaily.setText(df.format(percent) + "%");
                }

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        sugarAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = sugarAmount.getText().toString();
                text = text.replaceAll("[*a-zA-Z]", "");
                if (!text.isEmpty())
                {
                    sugar = Integer.parseInt(text);
                    double percent = (sugar/25) * 100;
                    Log.d("HELP", String.valueOf(percent));
                    sugarDaily.setText(df.format(percent) + "%");
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        proteinAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = proteinAmount.getText().toString();
                text = text.replaceAll("[*a-zA-Z]", "");
                if (!text.isEmpty())
                {
                    protein = Integer.parseInt(text);
                    double percent = (protein/56) * 100;
                    Log.d("HELP", String.valueOf(percent));
                    proteinDaily.setText(df.format(percent) + "%");
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        fatAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = fatAmount.getText().toString();
                text = text.replaceAll("[*a-zA-Z]", "");
                if (!text.isEmpty())
                {
                    fat = Integer.parseInt(text);
                    double percent = (fat/500) * 100;
                    Log.d("HELP", String.valueOf(percent));
                    fatDaily.setText(df.format(percent) + "%");
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });


    }
}
