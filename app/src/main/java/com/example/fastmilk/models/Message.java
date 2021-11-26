package com.example.fastmilk.models;

public class Message {
    private String thanhcong;
    private String thongbao;

    public Message(String thanhcong, String thongbao) {
        this.thanhcong = thanhcong;
        this.thongbao = thongbao;
    }

    public String getThanhcong() {
        return thanhcong;
    }

    public void setThanhcong(String thanhcong) {
        this.thanhcong = thanhcong;
    }

    public String getThongbao() {
        return thongbao;
    }

    public void setThongbao(String thongbao) {
        this.thongbao = thongbao;
    }
}
