
package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.MainActivity;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DiemGiao;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.Message;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewInformation extends AppCompatActivity {
    EditText etName, etDiaChi;
    Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_information);
        etName=findViewById(R.id.etNameDiemGiao);
        etDiaChi=findViewById(R.id.edtAddressDiemGiao);
        btn_confirm=findViewById(R.id.btn_confirm);
        String longitude = String.valueOf(getIntent().getExtras().getDouble("longitude"));
        String latitude = String.valueOf(getIntent().getExtras().getDouble("latitude"));

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenDiemGiao=etName.getText().toString().trim();
                String diaChi=etDiaChi.getText().toString().trim();

                DiemGiao dg=new DiemGiao();
                dg.setLongitude(Float.parseFloat(longitude));
                dg.setLatitude(Float.parseFloat(latitude));
                dg.setDiaChi(diaChi);
                dg.setTenDiemGiao(tenDiemGiao);
                dg.setIdKhuVuc(02);


                IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
                iRetrofitService.postDiemGiao(dg).enqueue(postDiemGiaoCB);
            }
        });

    }
    Callback<Message> postDiemGiaoCB = new Callback<Message>() {
        @Override
        public void onResponse(Call<Message> call, Response<Message> response) {
            if (response.isSuccessful()){
                Intent i=new Intent(AddNewInformation.this, MainActivity.class);
                finish();
            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<Message> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };
}