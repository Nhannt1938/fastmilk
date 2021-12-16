package com.example.fastmilk.models;

public class DiemGiao {
    private int idDiemGiao;
    private String tenDiemGiao;
    private int idKhuVuc;
    private float longitude;
    private float latitude;
    private String diaChi;
    private int trangThai;

    public DiemGiao(int idDiemGiao) {
        this.idDiemGiao = idDiemGiao;
    }

    public DiemGiao() {
    }

    public DiemGiao(int idDiemGiao, String tenDiemGiao, int idKhuVuc, float longitude, float latitude, String diaChi, int trangThai) {
        this.idDiemGiao = idDiemGiao;
        this.tenDiemGiao = tenDiemGiao;
        this.idKhuVuc = idKhuVuc;
        this.longitude = longitude;
        this.latitude = latitude;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
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
}
