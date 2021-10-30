package com.example.fastmilk.models;

public class DonHang {
    private int idDon;
    private int idDiemGiao;
    private int idNV;
    private int idKhuVuc;
    private int ngayTaoDon;
    private String trangThai;
    private String tenNV;
    private float thanhTien;

    public DonHang() {
    }

    public DonHang(int idDon, int idDiemGiao, int idNV, int idKhuVuc, int ngayTaoDon, String trangThai, String tenNV, float thanhTien) {
        this.idDon = idDon;
        this.idDiemGiao = idDiemGiao;
        this.idNV = idNV;
        this.idKhuVuc = idKhuVuc;
        this.ngayTaoDon = ngayTaoDon;
        this.trangThai = trangThai;
        this.tenNV = tenNV;
        this.thanhTien = thanhTien;
    }

    public int getIdDon() {
        return idDon;
    }

    public void setIdDon(int idDon) {
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

    public int getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(int idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public int getNgayTaoDon() {
        return ngayTaoDon;
    }

    public void setNgayTaoDon(int ngayTaoDon) {
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
