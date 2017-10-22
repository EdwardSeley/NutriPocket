package com.example.theo1.nutripocket;

import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by theod on 10/21/2017.
 */

public class calculateCaloricGoal {

    static int height;
    static int age;
    static int weight;
    static String gender;
    static String activityLevel;
    static String goal;

    calculateCaloricGoal (String[] userInfo)
    {
        age = Integer.parseInt(userInfo[0]);
        height = Integer.parseInt(userInfo[1]);
        weight = Integer.parseInt(userInfo[2]);
        gender = userInfo[3];
        activityLevel = userInfo[4];
        goal = userInfo[5];
        Log.d("HELP", "GOAL: " + userInfo[5]);

    }

    public static int calculate() {
        double RMR;
        double TDEE;
        double dTDEE;
        int finalTDEE;


        final String firstLevel = "Sedentary";
        final String secondLevel = "Light Activity";
        final String thirdLevel = "Moderate Activity";
        final String fourthLevel = "Heavy Activity";
        final String fifthLevel = "Extreme Activity";

        double userActivity = 0;

        switch (activityLevel) {
            case firstLevel:
                userActivity = 1.2;
                break;
            case secondLevel:
                userActivity = 1.375;
                break;
            case thirdLevel:
                userActivity = 1.55;
                break;
            case fourthLevel:
                userActivity = 1.725;
                break;
            case fifthLevel:
                userActivity = 1.9;
                break;
        }

        final String oneLevel = "Lose Weight";
        final String twoLevel = "Maintain Weight";
        final String threeLevel = "Gain Weight";

        double userGoal = 0;

        switch (goal) {
            case oneLevel:
                userGoal = 0.8;
                break;
            case twoLevel:
                userGoal = 1.0;
                break;
            case threeLevel:
                userGoal = 1.2;
                break;
        }

        final String bLevel = "Female";

        int userGender = 0;

        switch (gender) {
            case bLevel:
                userGender = -161;
                break;
            default:
                userGender = 5;
                break;
        }

        Log.d("HELP", String.valueOf(userGender));
        RMR = (9.99 * weight) + (6.25 * height) - (4.92 * age) + userGender;
        TDEE = RMR * userActivity;
        Log.d("HELP", "TDEE " + String.valueOf(TDEE));
        dTDEE = TDEE * userGoal;
        Log.d("HELP", "USER GOAL: " + String.valueOf(userGoal));
        Log.d("HELP", "dTDEE: " + String.valueOf(dTDEE));
        finalTDEE = (int) dTDEE;
        return finalTDEE;
    }


}
