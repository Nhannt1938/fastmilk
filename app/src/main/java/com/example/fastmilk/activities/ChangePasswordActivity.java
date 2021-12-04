package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastmilk.MainActivity;
import com.example.fastmilk.R;
import com.example.fastmilk.models.Message;
import com.example.fastmilk.models.NhanVien;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText et_MKCu,et_MKMoi,et_XacNhanMK;
    private TextInputLayout textInput_MKCu,textInput_MKMoi,textInput_XacNhanMK;
    private Button btn_Luu;
    private NhanVien mNhanVien = new NhanVien();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        et_MKCu = (EditText) findViewById(R.id.etMKCu_DoiMK);
        et_MKMoi = (EditText) findViewById(R.id.etMKMoi_DoiMK);
        et_XacNhanMK = (EditText) findViewById(R.id.etXacNhan_DoiMK);
        textInput_MKCu = (TextInputLayout) findViewById(R.id.textInputMKCu_DoiMK);
        textInput_MKMoi = (TextInputLayout) findViewById(R.id.textInputMKMoi_DoiMK);
        textInput_XacNhanMK = (TextInputLayout) findViewById(R.id.textInputXacNhan_DoiMK);
        btn_Luu = (Button) findViewById(R.id.btnLuu_DoiMK);

        textInput_MKCu.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    textInput_MKCu.setError("Không được để trống");
                    textInput_MKCu.setErrorEnabled(true);
                } else {
                    textInput_MKCu.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textInput_MKMoi.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    textInput_MKMoi.setError("Không được để trống");
                    textInput_MKMoi.setErrorEnabled(true);
                } else {
                    textInput_MKMoi.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textInput_XacNhanMK.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_XacNhanMK.getText().toString().equals(et_MKMoi.getText().toString())==false){
                    textInput_XacNhanMK.setError("Xác nhận chưa chính xác");
                    textInput_XacNhanMK.setErrorEnabled(true);
                } else {
                    textInput_XacNhanMK.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_MKCu.getText().toString().equals("")||et_MKMoi.getText().toString().equals("")||et_XacNhanMK.getText().toString().equals("")) {
                    Toast.makeText(ChangePasswordActivity.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                } else if(!et_XacNhanMK.getText().toString().equals(et_MKMoi.getText().toString())){
                    Toast.makeText(ChangePasswordActivity.this,"Xác nhận mật khẩu chưa chính xác",Toast.LENGTH_SHORT).show();
                } else {
                    mNhanVien = restore();
                    if(!et_MKCu.getText().toString().equals(mNhanVien.getPassword())){
                        Toast.makeText(ChangePasswordActivity.this,"Mật khẩu cũ chưa chính xác",Toast.LENGTH_SHORT).show();
                    } else {
                        save();
                        mNhanVien = restore();
                        update();
                        finish();
                    }
                }
            }
        });
    }

    private void update() {
        MainActivity.pDialog.show();
        int idNV = mNhanVien.getIdNV();
        String tenNV = mNhanVien.getTenNV();
        String SDT = mNhanVien.getSDT();
        String chucVu = mNhanVien.getChucVu();
        String matKhau = et_MKMoi.getText().toString().trim();

        IRetrofitService apiService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<Message> call = apiService.update(idNV, tenNV, matKhau, SDT, chucVu);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(ChangePasswordActivity.this, ""+response.body().getThongbao(), Toast.LENGTH_SHORT).show();
                MainActivity.pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(ChangePasswordActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                MainActivity.pDialog.dismiss();
            }
        });
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("matKhau", et_MKMoi.getText().toString());
        editor.commit();
    }

    private NhanVien restore() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        mNhanVien.setIdNV(sharedPreferences.getInt("idNV", -1));
        mNhanVien.setTenNV(sharedPreferences.getString("tenNV", ""));
        mNhanVien.setTaiKhoan(sharedPreferences.getString("taiKhoan", ""));
        mNhanVien.setPassword(sharedPreferences.getString("password", ""));
        mNhanVien.setSDT(sharedPreferences.getString("SDT", ""));
        mNhanVien.setChucVu(sharedPreferences.getString("chucVu", ""));
        return mNhanVien;
    }
}