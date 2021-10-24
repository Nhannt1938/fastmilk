package com.example.fastmilk.models;

public class NhanVien {
    private int maNV;
    private String tenNV;
    private String taiKhoan;
    private String password;
    private String SDT;
    private String chucVu;

    public NhanVien(int maNV, String tenNV, String taiKhoan, String password, String SDT, String chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.taiKhoan = taiKhoan;
        this.password = password;
        this.SDT = SDT;
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
