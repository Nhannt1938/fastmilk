package com.example.fastmilk.models;

public class NhanVien {
    private int idNV;
    private String tenNV;
    private String taiKhoan;
    private String password;
    private String matKhau;
    private String SDT;
    private String chucVu;

    public NhanVien(int idNV, String tenNV, String SDT) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.SDT = SDT;
    }

    public NhanVien(int idNV) {
        this.idNV = idNV;
    }

    public NhanVien(int idNV, String password) {
        this.idNV = idNV;
        this.password = password;
    }

    public NhanVien(String taiKhoan, String password) {
        this.taiKhoan = taiKhoan;
        this.password = password;
    }

    public NhanVien(int idNV, String tenNV, String taiKhoan, String password, String SDT, String chucVu) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.taiKhoan = taiKhoan;
        this.password = password;
        this.SDT = SDT;
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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
