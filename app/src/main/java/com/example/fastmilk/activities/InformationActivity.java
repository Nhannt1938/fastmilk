package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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

public class InformationActivity extends AppCompatActivity {

    private EditText et_Hoten, et_SDT;
    private TextInputLayout textInput_Hoten, textInput_SDT;
    private Button btn_Luu;
    private NhanVien mNhanVien = new NhanVien();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        et_Hoten = (EditText) findViewById(R.id.et_Hoten);
        et_SDT = (EditText) findViewById(R.id.et_SDT);
        textInput_Hoten = (TextInputLayout) findViewById(R.id.textInput_Hoten);
        textInput_SDT = (TextInputLayout) findViewById(R.id.textInput_SDT);
        btn_Luu = (Button) findViewById(R.id.btn_Luu);

        textInput_Hoten.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    textInput_Hoten.setError("Không được để trống");
                    textInput_Hoten.setErrorEnabled(true);
                } else {
                    textInput_Hoten.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textInput_SDT.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    textInput_SDT.setError("Không được để trống");
                    textInput_SDT.setErrorEnabled(true);
                } else {
                    textInput_SDT.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        mNhanVien = restore();
        et_Hoten.setText(mNhanVien.getTenNV());
        et_SDT.setText(mNhanVien.getSDT());
        btn_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty("") && !TextUtils.isEmpty("")){
                    Toast.makeText(InformationActivity.this,"Không được để trống",Toast.LENGTH_SHORT).show();
                } else {
                    save();
                    mNhanVien = restore();
                    update();
                    finish();
                }
            }
        });
    }

    private void update() {
        MainActivity.pDialog.show();
        int idNV = mNhanVien.getIdNV();
        String tenNV = et_Hoten.getText().toString().trim();
        String SDT = et_SDT.getText().toString().trim();
        String matKhau = mNhanVien.getPassword();
        NhanVien nv=new NhanVien(idNV, tenNV, SDT);

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<Message> call = iRetrofitService.nvUpdateInfo(nv);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Toast.makeText(InformationActivity.this, ""+response.body().getThongbao(), Toast.LENGTH_SHORT).show();
                MainActivity.pDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(InformationActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                MainActivity.pDialog.dismiss();
            }
        });
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("NV_active.txt", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tenNV", et_Hoten.getText().toString());
        editor.putString("SDT", et_SDT.getText().toString());
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