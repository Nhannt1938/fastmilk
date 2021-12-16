package com.example.fastmilk.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastmilk.Adapter.Donhangchitiet_Adapter;
import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.MainActivity;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.DonHangChiTiet;
import com.example.fastmilk.models.Message;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietDonHangActivity extends AppCompatActivity {
    ImageView img_out;
    Button btn_fail,btn_success;
    TextView tvTongTien, tvTenDiemGiao, tvDiaChi;
    Donhangchitiet_Adapter donhangchitietAdapter;
    RecyclerView recyclerView;
    private Float tongTien;
    List<DonHangChiTiet> dh = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_don_hang);
        tvTongTien=findViewById(R.id.tongTien);
        tvTenDiemGiao=findViewById(R.id.txt_Name_Of_Adrress);
        tvDiaChi=findViewById(R.id.txt_Detail_Of_Adrress);
        btn_success=findViewById(R.id.Delivery_Success);
        btn_fail=findViewById(R.id.Delivery_Fail);
        recyclerView=findViewById(R.id.list_item_detail);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String idDon = getIntent().getExtras().getString("idDon");
        String diaChi = getIntent().getExtras().getString("diaChi");
        String tenDiemGiao = getIntent().getExtras().getString("tenDiemGiao");

        tvDiaChi.setText(diaChi);
        tvTenDiemGiao.setText(tenDiemGiao);
        Log.d("check iddon", "onCreate: "+idDon);

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        //từ danh sách đơn hàng lấy idDon qua nhét vào bên dưới rồi xóa comment đi.
        //không xóa làm gì nhau?

        DonHang dhup=new DonHang(idDon);
        iRetrofitService.getDonByID(dhup).enqueue(getByID);

        btn_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
                Call<Message> call = iRetrofitService.updateTC(dhup);
                call.enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Toast.makeText(ChiTietDonHangActivity.this, ""+response.body().getThongbao(), Toast.LENGTH_SHORT).show();
                        MainActivity.pDialog.dismiss();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(ChiTietDonHangActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                        MainActivity.pDialog.dismiss();
                        finish();
                    }
                });
            }
        });

        btn_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
                Call<Message> call = iRetrofitService.updateTB(dhup);
                call.enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Toast.makeText(ChiTietDonHangActivity.this, ""+response.body().getThongbao(), Toast.LENGTH_SHORT).show();
                        MainActivity.pDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(ChiTietDonHangActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                        MainActivity.pDialog.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

    }


    Callback<List<DonHangChiTiet>> getByID = new Callback<List<DonHangChiTiet>>() {
        @Override
        public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
            if (response.isSuccessful()){
                dh=response.body();
                // gọi adapter rồi nhét dhct vào bên dưới.
                Log.d("size dhct", "onResponse: "+dh.size());
                //cal tổng tiền
                tongTien=0f;

                for (int i=0;i<dh.size();i++)
                {
                    tongTien+=(dh.get(i).getDonGia()*dh.get(i).getSoLuong());
                }
                tvTongTien.setText(String.format("%.0f", tongTien));
                donhangchitietAdapter=new Donhangchitiet_Adapter(ChiTietDonHangActivity.this, dh);
                recyclerView.setAdapter(donhangchitietAdapter);

            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<List<DonHangChiTiet>> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };
}