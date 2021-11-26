package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastmilk.MainActivity;
import com.example.fastmilk.R;
import com.example.fastmilk.models.NhanVien;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etTaiKhoan, etMatKhau;
    private CheckBox checkboxGhiNho;
    private Button btnDangNhap;
    private NhanVien mNhanVien = new NhanVien();
    public static ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etTaiKhoan = (EditText) findViewById(R.id.etTaiKhoan);
        etMatKhau = (EditText) findViewById(R.id.etMatKhau);
        checkboxGhiNho = (CheckBox) findViewById(R.id.checkboxGhiNho);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCanceledOnTouchOutside(false);

        mNhanVien = restore();
        
        checkboxGhiNho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    if (!TextUtils.isEmpty("") && !TextUtils.isEmpty("")){
                        Toast.makeText(LoginActivity.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                        checkboxGhiNho.setChecked(false);
                    }
                }
            }
        });
        
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etTaiKhoan.getText().toString().trim();
                String password = etMatKhau.getText().toString().trim();

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    loginU();
                } else {
                    Toast.makeText(LoginActivity.this, "Khong duoc de trong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private NhanVien restore() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("ghiNho", false);
        if (check){
            mNhanVien.setIdNV(sharedPreferences.getInt("idNV", -1));
            mNhanVien.setTenNV(sharedPreferences.getString("tenNV", ""));
            mNhanVien.setTaiKhoan(sharedPreferences.getString("taiKhoan", ""));
            mNhanVien.setMatKhau(sharedPreferences.getString("matKhau", ""));
            mNhanVien.setSDT(sharedPreferences.getString("SDT", ""));
            mNhanVien.setChucVu(sharedPreferences.getString("chucVu", ""));
            etTaiKhoan.setText(mNhanVien.getTaiKhoan());
            etMatKhau.setText(mNhanVien.getMatKhau());
            checkboxGhiNho.setChecked(check);
            loginU();
        }
        return mNhanVien;
    }

    private void loginU() {
        pDialog.show();
        String username = etTaiKhoan.getText().toString().trim();
        String password = etMatKhau.getText().toString().trim();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<NhanVien> call = iRetrofitService.login(username, password);
        call.enqueue(new Callback<NhanVien>() {
            @Override
            public void onResponse(Call<NhanVien> call, Response<NhanVien> response) {
                if (response.body() == null){
                    Toast.makeText(LoginActivity.this, "Sai TK or MK", Toast.LENGTH_SHORT).show();
                    pDialog.dismiss();
                } else {
                    mNhanVien.setIdNV(response.body().getIdNV());
                    mNhanVien.setTenNV(response.body().getTenNV().toString());
                    mNhanVien.setTaiKhoan(response.body().getTaiKhoan().toString());
                    mNhanVien.setMatKhau(response.body().getMatKhau().toString());
                    mNhanVien.setChucVu(response.body().getChucVu().toString());
                    mNhanVien.setSDT(response.body().getSDT().toString());

                    save();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    etTaiKhoan.setText("");
                    etMatKhau.setText("");
                    checkboxGhiNho.setChecked(false);
                    pDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NhanVien> call, Throwable t) {
                Log.d("TAGE", "onFailure: "+t.toString());
                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                pDialog.dismiss();
            }
        });
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean check = checkboxGhiNho.isChecked();
        editor.putInt("idNV", mNhanVien.getIdNV());
        editor.putString("tenNV", mNhanVien.getTenNV());
        editor.putString("taiKhoan", mNhanVien.getTaiKhoan());
        editor.putString("matKhau", mNhanVien.getMatKhau());
        editor.putString("SDT", mNhanVien.getSDT());
        editor.putString("chucVu", mNhanVien.getChucVu());
        editor.putBoolean("ghiNho",check);
        editor.commit();
    }

}