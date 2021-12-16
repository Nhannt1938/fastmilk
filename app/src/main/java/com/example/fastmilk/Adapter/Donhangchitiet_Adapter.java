package com.example.fastmilk.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.DonHangChiTiet;

import java.util.ArrayList;
import java.util.List;

public class Donhangchitiet_Adapter extends RecyclerView.Adapter<Donhangchitiet_Adapter.Donhangchitiet_ViewHolder> {

    Context context;
    List<DonHangChiTiet> list;

    public Donhangchitiet_Adapter(Context context, List<DonHangChiTiet> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public Donhangchitiet_Adapter.Donhangchitiet_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.chitiet_donhang_item,parent,false);
        Donhangchitiet_Adapter.Donhangchitiet_ViewHolder donhangchitiet_viewHolder = new Donhangchitiet_Adapter.Donhangchitiet_ViewHolder(view);
        return donhangchitiet_viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Donhangchitiet_Adapter.Donhangchitiet_ViewHolder holder, int position) {
        DonHangChiTiet dhct= list.get(position);
        holder.tvSanPham.setText(dhct.getTenSP());
        holder.tvSoLuong.setText(dhct.getSoLuong()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Donhangchitiet_ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSanPham, tvSoLuong;
        public Donhangchitiet_ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSanPham=itemView.findViewById(R.id.tw_name_donhang);
            tvSoLuong=itemView.findViewById(R.id.tw_soluong_donhang);
        }
    }
}