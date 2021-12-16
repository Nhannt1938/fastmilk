package com.example.fastmilk.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.fastmilk.Adapter.Thongke_Adapter;
import com.example.fastmilk.Adapter.Thongke_Adapter;
import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.R;
import com.example.fastmilk.activities.LoginActivity;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.NhanVien;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongKeDonHang extends Fragment {
    List<DonHang> dh = new ArrayList<>();
    private int id= LoginActivity.idNV;
    NhanVien nv=new NhanVien(id);
    RecyclerView recyclerView;
    Thongke_Adapter thongke_adapter;
    DonhangDao donhangDao;
    DonHang donHang;
    TextView sodon;
    int [] trangThai={-1,1};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thongke_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView=view.findViewById(R.id.List_View_thongke);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        donhangDao = new DonhangDao(getContext());
//        if(donHang.getTrangThai()!=0){
           // TK_List.addAll(donhangDao.getALl_delivery()) ;
//        }

        //thongke_adapter = new Thongke_Adapter(getContext(),TK_List);
        //recyclerView.setAdapter(thongke_adapter);
    }


    @Override
    public void onResume() {
        super.onResume();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        iRetrofitService.getAllLichSu(nv).enqueue(getAllLSCB);
    }

    Callback<List<DonHang>> getAllLSCB = new Callback<List<DonHang>>() {
        @Override
        public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
            if (response.isSuccessful()){
                dh=response.body();
                thongke_adapter=new Thongke_Adapter(getContext(),dh);
                recyclerView.setAdapter(thongke_adapter);
                Log.d("check lich su", "onResponse: "+dh.size());
            } else {
                Log.i("Error: ", response.message());
            }
        }

        @Override
        public void onFailure(Call<List<DonHang>> call, Throwable t) {
            Log.i("Error: ", call.toString());
        }
    };
}
