
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.entity;

/**
 *
 * @author anhha
 */
public class HoaDon {

    int MaHD;
    String NgayTao;
    String MaNV;
    int MaBan;
    double TongTien;
    String TrangThai;
    private String tenNV;

    public HoaDon(int MaHD, String NgayTao, String MaNV, int MaBan, double TongTien, String TrangThai, String tenNV) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;

        this.MaNV = MaNV;
        this.MaBan = MaBan;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.tenNV = tenNV;
    }

    public HoaDon() {

    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
     public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

}
