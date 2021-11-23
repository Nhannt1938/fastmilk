package com.example.fastmilk.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.R;
import com.google.android.material.button.MaterialButton;

import java.util.zip.Inflater;

public class Chitietdonhang extends Fragment {
    ImageView img_out;
    Button btn_fail,btn_success;
    DonhangDao donhangDao;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chitiet_donhang_fragment,container,false);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        innit(view);
        btn_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oppenChange_Trangthai();
            }


        });
        btn_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donhangDao.Change_trangthai(1);
            }
        });
    }

    private void innit(View view) {
        btn_fail=view.findViewById(R.id.Delivery_Fail);
        btn_success=view.findViewById(R.id.Delivery_Success);
        img_out=view.findViewById(R.id.Btn_cancel_ds_item);
    }

    private void oppenChange_Trangthai() {
        AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
        LayoutInflater inflater =((AppCompatActivity) getContext()).getLayoutInflater();
        View view=inflater.inflate(R.layout.lydothatbai,null);
        builder.setView(view);
        Dialog dialog =builder.create();
        dialog.show();
        MaterialButton send_fail=view.findViewById(R.id.Send_Fail_Delivery);
        send_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donhangDao.Change_trangthai(-1);
            }
        });
    }
}
