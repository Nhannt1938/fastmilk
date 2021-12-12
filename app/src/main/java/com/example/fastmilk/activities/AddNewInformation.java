
package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.fastmilk.R;

public class AddNewInformation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_information);
        String longitude = String.valueOf(getIntent().getExtras().getDouble("longitude"));
        String latitude = String.valueOf(getIntent().getExtras().getDouble("latitude"));


        Log.d("TAGzaxs", "onCreate: "+longitude);
    }
}