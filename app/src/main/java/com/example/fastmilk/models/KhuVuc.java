package com.example.fastmilk.models;

public class KhuVuc {
    private int idKhuVuc;
    private String tenKhuVuc;
    private String trangThai;

    public int getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(int idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public KhuVuc(int idKhuVuc, String tenKhuVuc, String trangThai) {
        this.idKhuVuc = idKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.trangThai = trangThai;
    }

    public KhuVuc() {
    }
}
