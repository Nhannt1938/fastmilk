package com.example.fastmilk.models;


public class DonHang {
    private String idDon;
    private int idDiemGiao;
    private int idNV;
    private String tenDiemGiao;
    private String diaChi;
    private int trangThai;
    private float thanhTien;

    public DonHang() {
    }

    public DonHang(String idDon) {
        this.idDon = idDon;
    }

    public DonHang(String idDon, int idDiemGiao, int idNV, String tenDiemGiao, String diaChi, int trangThai) {
        this.idDon = idDon;
        this.idDiemGiao = idDiemGiao;
        this.idNV = idNV;
        this.tenDiemGiao = tenDiemGiao;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public String getIdDon() {
        return idDon;
    }

    public void setIdDon(String idDon) {
        this.idDon = idDon;
    }

    public int getIdDiemGiao() {
        return idDiemGiao;
    }

    public void setIdDiemGiao(int idDiemGiao) {
        this.idDiemGiao = idDiemGiao;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getTenDiemGiao() {
        return tenDiemGiao;
    }

    public void setTenDiemGiao(String tenDiemGiao) {
        this.tenDiemGiao = tenDiemGiao;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
}
