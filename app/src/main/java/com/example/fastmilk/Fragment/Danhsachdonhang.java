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

import com.example.fastmilk.Adapter.donhangapdapter;
import com.example.fastmilk.DAO.DonhangDao;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;

import java.util.ArrayList;

public class Danhsachdonhang extends Fragment {
    ArrayList<DonHang> dh_list = new ArrayList<>();
    RecyclerView recyclerView;
    donhangapdapter donhangapdapter;
    DonhangDao donhangDao;
    DonHang donHang;
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
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        donhangDao = new DonhangDao(getContext());
            dh_list=donhangDao.getALl(0);
            donhangapdapter=new donhangapdapter(getContext(),dh_list);
        recyclerView.setAdapter(donhangapdapter);

        for (int i =0;i<=dh_list.size();i++){
           sodon.setText("("+i+""+")");

        }
            }
}
