package com.example.fastmilk.models;

public class DonHang {
    private int maDon;
    private int maDiemGiao;
    private int maNV;
    private int maKhuVuc;
    private String ngayTaoDon;
    private String trangThai;
    private String tenNV;
    private float thanhTien;

    public DonHang(int maDon, int maDiemGiao, int maNV, int maKhuVuc, String ngayTaoDon, String trangThai, String tenNV, float thanhTien) {
        this.maDon = maDon;
        this.maDiemGiao = maDiemGiao;
        this.maNV = maNV;
        this.maKhuVuc = maKhuVuc;
        this.ngayTaoDon = ngayTaoDon;
        this.trangThai = trangThai;
        this.tenNV = tenNV;
        this.thanhTien = thanhTien;
    }

    public DonHang() {
    }

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public int getMaDiemGiao() {
        return maDiemGiao;
    }

    public void setMaDiemGiao(int maDiemGiao) {
        this.maDiemGiao = maDiemGiao;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getNgayTaoDon() {
        return ngayTaoDon;
    }

    public void setNgayTaoDon(String ngayTaoDon) {
        this.ngayTaoDon = ngayTaoDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
}
