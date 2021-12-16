package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fastmilk.R;

public class TestActivity extends AppCompatActivity {
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv1=findViewById(R.id.tvTest1);
        tv2=findViewById(R.id.tvTest2);



        tv1.setText(getIntent().getExtras().getString("longitude"));
        tv2.setText(getIntent().getExtras().getString("latitude"));



    }
}