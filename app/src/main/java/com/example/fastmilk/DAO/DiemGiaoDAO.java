package com.example.fastmilk.DAO;

import android.util.Log;

import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.models.DiemGiao;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.Message;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiemGiaoDAO {

/*
    @Override
    public void onResume() {
        super.onResume();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        //khai báo rồi nhét idDiemGiao vào dg để gửi lên sever
        //DiemGiao dg=new DiemGiao(idDiemGiao);
        iRetrofitService.getDiemGiao(dg).enqueue(getDiemGiaoCB);
    }

    Callback<DiemGiao> getDiemGiaoCB = new Callback<DiemGiao>() {
        @Override
        public void onResponse(Call<DiemGiao> call, Response<DiemGiao> response) {
            if (response.isSuccessful()){
                //khai báo, nếu lỗi thì vứt thằng khai báo lên đầu activity
                DiemGiao diemGiao=new DiemGiao();

                //get api
                diemGiao=response.body();

                //lấy tọa độ
                diemGiao.getLongitude();
                diemGiao.getLatitude();
            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<DiemGiao> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };




    //post thông tin + tọa độ lên db
    //ông làm cái form từ map -> form, get tọa độ hiện tại rồi gửi đi.

    @Override
    public void onResume() {
        super.onResume();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        DiemGiao dg=new DiemGiao();
        dg.setIdKhuVuc(01);
        dg.setTenDiemGiao("tên điểm giao");
        dg.setDiaChi("123 bình hưng hòa");
        //hình như nó bắt thêm chữ f vào ms thành kiểu flooat
        dg.setLongitude(-56.31523f);
        dg.setLatitude(6.31546f);

        iRetrofitService.postDiemGiao(dg).enqueue(postDiemGiaoCB);
    }

    Callback<Message> postDiemGiaoCB = new Callback<Message>() {
        @Override
        public void onResponse(Call<Message> call, Response<Message> response) {
            if (response.isSuccessful()){
                // muốn làm gì thì làm, thông báo thành công hay ko cũng đc.
            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<Message> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };


 */


}
