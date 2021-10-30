package com.example.fastmilk.models;

public class DonHangChiTiet {
    private int idDHCT;
    private int idDon;
    private int idSP;
    private int soLuong;
    private float donGia;

    public DonHangChiTiet(int idDHCT, int idDon, int idSP, int soLuong, float donGia) {
        this.idDHCT = idDHCT;
        this.idDon = idDon;
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public DonHangChiTiet() {
    }

    public int getIdDHCT() {
        return idDHCT;
    }

    public void setIdDHCT(int idDHCT) {
        this.idDHCT = idDHCT;
    }

    public int getIdDon() {
        return idDon;
    }

    public void setIdDon(int idDon) {
        this.idDon = idDon;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
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
