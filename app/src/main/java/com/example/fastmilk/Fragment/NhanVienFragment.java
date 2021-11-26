package com.example.fastmilk.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fastmilk.R;
import com.example.fastmilk.activities.ChangePasswordActivity;
import com.example.fastmilk.activities.InformationActivity;
import com.example.fastmilk.models.NhanVien;

public class NhanVienFragment extends Fragment {

    private TextView tv_tenNV, tv_SDT, tv_chucvu, tv_doithongtin, tv_doimk, tv_dangxuat, tv_thoat;
    private NhanVien mNhanVien = new NhanVien();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thongtinnhanvien_fragment, container, false);

        tv_tenNV = view.findViewById(R.id.tv_TenNV);
        tv_SDT = view.findViewById(R.id.tv_SDT);
        tv_chucvu = view.findViewById(R.id.tv_Chucvu);
        tv_doithongtin = view.findViewById(R.id.tv_Thaydoi);
        tv_doimk = view.findViewById(R.id.tv_DoiMK);
        tv_dangxuat = view.findViewById(R.id.tv_DangXuat);
        tv_thoat = view.findViewById(R.id.tv_Thoat);
        mNhanVien = restore();

        tv_doithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), InformationActivity.class);
                startActivity(i);
            }
        });

        tv_doimk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(i);
            }
        });

        tv_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_xac_nhan,null);
                TextView xacnhan = (TextView) v.findViewById(R.id.tvXacNhan);
                xacnhan.setText("Bạn có muốn đăng xuất tài khoản này không?");
                Button yes= v.findViewById(R.id.yes);
                Button no= v.findViewById(R.id.no);
                builder.setView(v);
                builder.setCancelable(false);
                AlertDialog dialog=builder.create();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        delete();
                        dialog.dismiss();
                        getActivity().finish();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        tv_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_xac_nhan,null);
                TextView xacnhan = (TextView) v.findViewById(R.id.tvXacNhan);
                xacnhan.setText("Bạn có chắc chắn muốn thoát không?");
                Button yes= v.findViewById(R.id.yes);
                Button no= v.findViewById(R.id.no);
                builder.setView(v);
                builder.setCancelable(false);
                AlertDialog dialog=builder.create();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        getActivity().finishAffinity();
                        System.exit(0);
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mNhanVien = restore();
        tv_tenNV.setText(mNhanVien.getTenNV());
        tv_SDT.setText(mNhanVien.getSDT());
        tv_chucvu.setText(mNhanVien.getChucVu());
    }

//    public void save() {
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NV_active.txt", getActivity().MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("idNV", mNhanVien.getIdNV());
//        editor.putString("tenNV", mNhanVien.getTenNV());
//        editor.putString("taiKhoan", mNhanVien.getTaiKhoan());
//        editor.putString("matKhau", mNhanVien.getMatKhau());
//        editor.putString("SDT", mNhanVien.getSDT());
//        editor.putString("chucVu", mNhanVien.getChucVu());
//        editor.commit();
//    }

    private void delete() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NV_active.txt", getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("idNV",-1);
        editor.putString("tenNV", "");
        editor.putString("taiKhoan", "");
        editor.putString("matKhau", "");
        editor.putString("SDT", "");
        editor.putString("chucVu", "");
        editor.putBoolean("ghiNho", false);
        editor.commit();
    }

    private NhanVien restore() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NV_active.txt", getActivity().MODE_PRIVATE);
        mNhanVien.setIdNV(sharedPreferences.getInt("idNV", -1));
        mNhanVien.setTenNV(sharedPreferences.getString("tenNV", ""));
        mNhanVien.setTaiKhoan(sharedPreferences.getString("taiKhoan", ""));
        mNhanVien.setMatKhau(sharedPreferences.getString("matKhau", ""));
        mNhanVien.setSDT(sharedPreferences.getString("SDT", ""));
        mNhanVien.setChucVu(sharedPreferences.getString("chucVu", ""));
        return mNhanVien;
    }
}