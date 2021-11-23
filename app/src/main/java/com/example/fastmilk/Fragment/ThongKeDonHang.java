package com.example.fastmilk.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastmilk.Adapter.Thongke_Adapter;
import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;

import java.util.ArrayList;

public class ThongKeDonHang extends Fragment {
    ArrayList<DonHang> TK_List = new ArrayList<>();
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
            TK_List.addAll(donhangDao.getALl_delivery()) ;
//        }

        thongke_adapter = new Thongke_Adapter(getContext(),TK_List);
        recyclerView.setAdapter(thongke_adapter);
    }
}
