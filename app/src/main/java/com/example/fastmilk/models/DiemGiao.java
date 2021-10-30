package com.example.fastmilk.models;

public class DiemGiao {
    private int idDiemGiao;
    private String tenDiemGiao;
    private int idKhuVuc;
    private String diaChi;
    private String tenKhuVuc;
    private String trangThai;

    public DiemGiao(int idDiemGiao, String tenDiemGiao, int idKhuVuc, String diaChi, String tenKhuVuc, String trangThai) {
        this.idDiemGiao = idDiemGiao;
        this.tenDiemGiao = tenDiemGiao;
        this.idKhuVuc = idKhuVuc;
        this.diaChi = diaChi;
        this.tenKhuVuc = tenKhuVuc;
        this.trangThai = trangThai;
    }

    public DiemGiao() {
    }

    public int getIdDiemGiao() {
        return idDiemGiao;
    }

    public void setIdDiemGiao(int idDiemGiao) {
        this.idDiemGiao = idDiemGiao;
    }

    public String getTenDiemGiao() {
        return tenDiemGiao;
    }

    public void setTenDiemGiao(String tenDiemGiao) {
        this.tenDiemGiao = tenDiemGiao;
    }

    public int getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(int idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
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
