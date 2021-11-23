package com.example.fastmilk.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Test extends SQLiteOpenHelper {

    public Database_Test(Context context){
super(context,"test_database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table DonHang (idDon integer primary key autoincrement,"+
                "idDiemGiao integer,"+
                "idKhuVuc integer,"+
                "idNV integer,"+
                "ngayTaoDon date,"+
                "trangThai integer,"+
                "tenNV text,"+
                "thanhTien float)";
        db.execSQL(sql);
        sql ="insert into DonHang(idDon,idDiemGiao,idKhuVuc,idNV,ngayTaoDon,trangTHai,tenNV,thanhTien )"+
                "values" +
                "(null,44,434,567,'04-10-2060',0,'Hy',10000)," +
                "(null,324,534,890,'21-12-2023',0,'heeee',232323)," +
                "(null,464,834,456,'03-03-2300',0,'ssdsd',432332323),"+
                "(null,44,84,46,'03-03-2300',0,'ssdsd',432323),"+
                "(8,44,84,46,'03-03-2300',0,'ssdsd',432323),"+
                "(null,44,84,46,'03-03-2300',1,'ssdsd',432323),"+
                "(null,44,84,46,'03-03-2300',-1,'ssdsd',432323)";
db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop table if exists DonHang");
    }
}
