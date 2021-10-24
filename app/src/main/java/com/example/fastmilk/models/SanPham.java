package com.example.fastmilk.models;

public class SanPham {
    private int maSP;
    private String tenSP;
    private float donGia;
    private String moTa;

    public SanPham(int maSP, String tenSP, float donGia, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public SanPham() {
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
