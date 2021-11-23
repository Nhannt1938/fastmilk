package com.example.fastmilk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.fastmilk.Fragment.Danhsachdonhang;
import com.example.fastmilk.Fragment.ThongKeDonHang;
import com.example.fastmilk.models.DonHang;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}