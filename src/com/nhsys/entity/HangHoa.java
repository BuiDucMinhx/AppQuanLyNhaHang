/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.entity;

import java.util.Date;

/**
 *
 * @author anhha
 */
public class HangHoa {

    String MaHangHoa;
    String TenHangHoa;
    String NgayNhap;
    String DonVi;
    double SoLuong;
    double ChiPhi;
    double TongChiPhi;

    public HangHoa(String MaHangHoa, String TenHangHoa, String NgayNhap, String DonVi, double SoLuong, double ChiPhi, double TongChiPhi) {
        this.MaHangHoa = MaHangHoa;
        this.TenHangHoa = TenHangHoa;
        this.NgayNhap = NgayNhap;
        this.DonVi = DonVi;
        this.SoLuong = SoLuong;
        this.ChiPhi = ChiPhi;
        this.TongChiPhi = TongChiPhi;
    }

    public HangHoa() {
    }

    public String getMaHangHoa() {
        return MaHangHoa;
    }

    public void setMaHangHoa(String MaHangHoa) {
        this.MaHangHoa = MaHangHoa;
    }

    public String getTenHangHoa() {
        return TenHangHoa;
    }

    public void setTenHangHoa(String TenHangHoa) {
        this.TenHangHoa = TenHangHoa;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getChiPhi() {
        return ChiPhi;
    }

    public void setChiPhi(double ChiPhi) {
        this.ChiPhi = ChiPhi;
    }

    public double getTongChiPhi() {
        return getChiPhi() * getSoLuong();
    }

    public void setTongChiPhi(double TongChiPhi) {
        this.TongChiPhi = TongChiPhi;
    }

 

}
