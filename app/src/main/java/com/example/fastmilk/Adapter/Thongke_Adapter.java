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

import java.util.List;

public class Thongke_Adapter  extends RecyclerView.Adapter<Thongke_Adapter.Thongke_ViewHolder> {

    Context context;
    List<DonHang> list;

    public  Thongke_Adapter(Context context, List<DonHang> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public Thongke_Adapter.Thongke_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.thogke_item,parent,false);
       Thongke_ViewHolder thongke = new Thongke_ViewHolder(view);
        return thongke;
    }

    @Override
    public void onBindViewHolder(@NonNull Thongke_ViewHolder holder, int position) {
        DonHang donHang =list.get(position);
        holder.sodon.setText(position+1+"");
        if (donHang.getTrangThai() == 1){
            holder.txt_name_detail.setText(donHang.getTenDiemGiao()+"");
            holder.txt_address_detail.setText(donHang.getDiaChi()+"");
            holder.trangthaids_detail.setText("Hoàn Thành");
            holder.trangthaids_detail.setBackgroundResource(R.drawable.trangthai_giaohang_hoanthanh);
        }else if(donHang.getTrangThai() == -1){
            holder.txt_name_detail.setText(donHang.getTenDiemGiao()+"");
            holder.txt_address_detail.setText(donHang.getDiaChi()+"");
            holder.trangthaids_detail.setText("Thất Bại");
            holder.trangthaids_detail.setBackgroundResource(R.drawable.trangthai_giaohang_thatbai);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }

    public class Thongke_ViewHolder extends RecyclerView.ViewHolder {
        TextView sodon,txt_name_detail,txt_address_detail,trangthaids_detail;
        ImageView imgCall,img_xuly;
        RelativeLayout ds_View_1;
        public Thongke_ViewHolder(@NonNull View itemView) {
            super(itemView);
            sodon=itemView.findViewById(R.id.Sodon_detail);
            trangthaids_detail=itemView.findViewById(R.id.Trangthai_ds_detail);
            txt_name_detail=itemView.findViewById(R.id.txt_Name_shop_detail);
            txt_address_detail=itemView.findViewById(R.id.txt_Address_shop_detail);
//            imgCall=itemView.findViewById(R.id.img_Call);
//            img_xuly=itemView.findViewById(R.id.img_icon_xulydonhang);
            ds_View_1=itemView.findViewById(R.id.view_ds_1_detail);


        }
    }


}


