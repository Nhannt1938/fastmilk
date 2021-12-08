package com.example.fastmilk.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastmilk.Adapter.Donhangchitiet_Adapter;
import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.DonHangChiTiet;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chitietdonhang extends Fragment {
    ImageView img_out;
    Button btn_fail,btn_success;
    DonhangDao donhangDao;
    Donhangchitiet_Adapter donhangchitietAdapter;
    RecyclerView recyclerView;
    List<DonHangChiTiet> dh = new ArrayList<>();

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
        recyclerView=view.findViewById(R.id.list_item_detail);
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



    @Override
    public void onResume() {
        super.onResume();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);

        //từ danh sách đơn hàng lấy idDon qua nhét vào bên dưới rồi xóa comment đi.

        DonHang dh=new DonHang();
        dh.getIdDon();
        iRetrofitService.getDonByID(dh).enqueue(getByID);
    }

    Callback<List<DonHangChiTiet>> getByID = new Callback<List<DonHangChiTiet>>() {
        @Override
        public void onResponse(Call<List<DonHangChiTiet>> call, Response<List<DonHangChiTiet>> response) {
            if (response.isSuccessful()){
                List<DonHangChiTiet> dhct=new ArrayList<>();
                dhct=response.body();
                // gọi adapter rồi nhét dhct vào bên dưới.
                donhangchitietAdapter=new Donhangchitiet_Adapter(getContext(),dhct);
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
