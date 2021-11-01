package com.example.fastmilk.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastmilk.Fragment.Chitietdonhang;
import com.example.fastmilk.R;
import com.example.fastmilk.models.DonHang;

import java.util.ArrayList;

public class donhangapdapter extends RecyclerView.Adapter<donhangapdapter.donhangViewHolder> {
    Context context;
    ArrayList<DonHang> list;
public donhangapdapter(Context context, ArrayList<DonHang> list){
    this.context=context;
    this.list=list;
}

    @Override
    public donhangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.danhsachdonitem,parent,false);
        donhangViewHolder donhang = new donhangViewHolder(view);
        return donhang;
    }

    @Override
    public void onBindViewHolder(@NonNull donhangapdapter.donhangViewHolder holder, int position) {
    DonHang donHang =list.get(position);
    holder.sodon.setText(donHang.getIdDon());
    holder.txt_name_shop.setText(donHang.getIdDiemGiao());
    holder.txt_address_shop.setText(donHang.getIdDiemGiao());
    holder.ds_View_3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context,Chitietdonhang.class));

        }
    });

    if (donHang.getTrangThai()==0){
        holder.trangthaids.setText("Đang chờ giao hàng");
        holder.trangthaids.setBackgroundResource(R.drawable.trangthai_giaohang_dangchogiaohang);
    }else if (donHang.getTrangThai()==1){
        holder.trangthaids.setText("Đang  giao hàng");
        holder.trangthaids.setBackgroundResource(R.drawable.trangthai_giaohang);
    }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class donhangViewHolder extends RecyclerView.ViewHolder {
    TextView sodon,txt_name_shop,txt_address_shop,trangthaids;
    ImageView imgCall,img_xuly;
    RelativeLayout ds_View_3;
        public donhangViewHolder(View v) {
            super(v);
            sodon=v.findViewById(R.id.txt_donso);
            trangthaids=v.findViewById(R.id.Trangthai_ds);
            txt_name_shop=v.findViewById(R.id.txt_Name_shop);
            txt_address_shop=v.findViewById(R.id.txt_Address_shop);
            imgCall=v.findViewById(R.id.img_Call);
            img_xuly=v.findViewById(R.id.img_icon_xulydonhang);
            ds_View_3=v.findViewById(R.id.view_ds_3);

        }
    }
}
