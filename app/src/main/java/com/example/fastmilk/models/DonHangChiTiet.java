package com.example.fastmilk.models;

public class DonHangChiTiet {
    private int maDHCT;
    private int maDon;
    private int maSP;
    private int soLuong;
    private float donGia;

    public DonHangChiTiet(int maDHCT, int maDon, int maSP, int soLuong, float donGia) {
        this.maDHCT = maDHCT;
        this.maDon = maDon;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public DonHangChiTiet() {
    }

    public int getMaDHCT() {
        return maDHCT;
    }

    public void setMaDHCT(int maDHCT) {
        this.maDHCT = maDHCT;
    }

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}
