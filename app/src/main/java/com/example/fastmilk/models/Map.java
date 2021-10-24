package com.example.fastmilk.models;

public class Map {
    private int maMap;
    private int maKhuVuc;
    private int maNV;

    public Map(int maMap, int maKhuVuc, int maNV) {
        this.maMap = maMap;
        this.maKhuVuc = maKhuVuc;
        this.maNV = maNV;
    }

    public Map() {
    }

    public int getMaMap() {
        return maMap;
    }

    public void setMaMap(int maMap) {
        this.maMap = maMap;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
}
