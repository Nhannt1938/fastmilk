package com.example.fastmilk.models;

public class DiemGiao {
    private int maDiemGiao;
    private String tenDiemGiao;
    private int maKhuVuc;
    private String diaChi;
    private String tenKhuVuc;
    private String trangThai;

    public DiemGiao(int maDiemGiao, String tenDiemGiao, int maKhuVuc, String diaChi, String tenKhuVuc, String trangThai) {
        this.maDiemGiao = maDiemGiao;
        this.tenDiemGiao = tenDiemGiao;
        this.maKhuVuc = maKhuVuc;
        this.diaChi = diaChi;
        this.tenKhuVuc = tenKhuVuc;
        this.trangThai = trangThai;
    }

    public DiemGiao() {
    }

    public int getMaDiemGiao() {
        return maDiemGiao;
    }

    public void setMaDiemGiao(int maDiemGiao) {
        this.maDiemGiao = maDiemGiao;
    }

    public String getTenDiemGiao() {
        return tenDiemGiao;
    }

    public void setTenDiemGiao(String tenDiemGiao) {
        this.tenDiemGiao = tenDiemGiao;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
