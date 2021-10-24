package com.example.fastmilk.models;

public class KhuVuc {
    private int maKhuVuc;
    private String tenKhuVuc;
    private String trangThai;

    public KhuVuc(int maKhuVuc, String tenKhuVuc, String trangThai) {
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.trangThai = trangThai;
    }

    public KhuVuc() {
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
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
}
