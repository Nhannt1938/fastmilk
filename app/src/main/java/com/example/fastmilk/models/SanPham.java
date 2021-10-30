package com.example.fastmilk.models;

public class SanPham {
    private int idSP;
    private String tenSP;
    private float donGia;
    private String moTa;

    public SanPham(int idSP, String tenSP, float donGia, String moTa) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public SanPham() {
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
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
