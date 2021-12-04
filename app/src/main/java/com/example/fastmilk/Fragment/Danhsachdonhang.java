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

public class Danhsachdonhang extends Fragment {
    RecyclerView recyclerView;
    List<DonHang> dh = new ArrayList<>();
    private int id= LoginActivity.idNV;
    NhanVien nv=new NhanVien(id);
    donhangapdapter donhangapdapter;
    DonhangDao donhangDao;
    TextView sodon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danhsachdon_list,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        sodon=view.findViewById(R.id.Sodon);
        recyclerView=view.findViewById(R.id.list_item_ds);


        donhangDao = new DonhangDao(getContext());
        //dh=donhangDao.getALl(0);


        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);




        for (int i =0;i<=dh.size();i++){
           sodon.setText("("+i+""+")");

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        iRetrofitService.getAll(nv).enqueue(getAllCB);
    }

    Callback<List<DonHang>> getAllCB = new Callback<List<DonHang>>() {
        @Override
        public void onResponse(Call<List<DonHang>> call, Response<List<DonHang>> response) {
            if (response.isSuccessful()){
                dh=response.body();
                donhangapdapter=new donhangapdapter(getContext(),dh);
                recyclerView.setAdapter(donhangapdapter);
                Log.d("TAG", "onResponse: "+dh.size());
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
