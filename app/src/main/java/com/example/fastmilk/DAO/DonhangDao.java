package com.example.fastmilk.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.fastmilk.Database.Database_Test;
import com.example.fastmilk.activities.LoginActivity;
import com.example.fastmilk.models.DonHang;
import com.example.fastmilk.models.NhanVien;
import com.example.fastmilk.retrofit.IRetrofitService;
import com.example.fastmilk.retrofit.RetrofitBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonhangDao {
Database_Test database_test;
    List<DonHang> dh = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public DonhangDao(Context context){
database_test = new Database_Test(context);
    }
    public List<DonHang> getALl(int trangThai) throws InterruptedException {





        /*
        SQLiteDatabase db = database_test.getReadableDatabase();
        String sql= "SELECT * FROM DonHang WHERE trangThai='"+trangThai+"'";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int ma =cursor.getInt(0);
            int iddiemgiao=cursor.getInt(1);
            int idkhuvuc=cursor.getInt(2);
            int idnv = cursor.getInt(3);
            Date ngay;
            try {
                ngay=sdf.parse(cursor.getString(4));
            } catch (ParseException e) {
                ngay = new Date();
            }
            int trangthai = cursor.getInt(5);
            String tennv=cursor.getString(6);
            Float tien=cursor.getFloat(7);
            //DonHang donhang = new DonHang(ma,iddiemgiao,idkhuvuc,idnv,ngay,trangthai,tennv,tien);
            //dh.add(donhang);
cursor.moveToNext();

        }
        cursor.close();
        db.close();

         */

        Log.d("size", "onResponse: "+dh.size());
        return dh;
    }
    public ArrayList<DonHang> getALl_delivery(){
        ArrayList<DonHang> dh = new ArrayList<>();
        SQLiteDatabase db = database_test.getReadableDatabase();
        String sql= "SELECT * FROM DonHang ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int ma =cursor.getInt(0);
            int iddiemgiao=cursor.getInt(1);
            int idkhuvuc=cursor.getInt(2);
            int idnv = cursor.getInt(3);
            Date ngay;
            try {
                ngay=sdf.parse(cursor.getString(4));
            } catch (ParseException e) {
                ngay = new Date();
            }
            int trangthai = cursor.getInt(5);
            String tennv=cursor.getString(6);
            Float tien=cursor.getFloat(7);
            if(trangthai==-1||trangthai==1) {
                //DonHang donhang = new DonHang(ma, iddiemgiao, idkhuvuc, idnv, ngay, trangthai, tennv, tien);
                //dh.add(donhang);
            }

            cursor.moveToNext();

        }
        cursor.close();
        db.close();
        return dh;
    }
    public void Change_trangthai(int trangthai){
SQLiteDatabase database = database_test.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put("trangThai", trangthai);
        database.update("DonHang",values,"idDon=?",new String[] {trangthai+""});
    }
}
