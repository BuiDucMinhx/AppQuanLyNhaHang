/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.NhanVien;
import com.nhsys.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class NhanVienDAO extends NHDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NHANVIEN(MaNV, Password, HoTen, SoDT, ChucVu, GioiTinh, Avatar)VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NHANVIEN SET Password=?, HoTen=?, SoDT=?, ChucVu=?, GioiTinh=?, Avatar=? where MaNV = ?";
    String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MaNV =?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELETE_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV =?";

    @Override
    public void insert(NhanVien entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getSoDT(), entity.getChucVu(), entity.isGioiTinh(), entity.getAvatar());
        } catch (Exception ex) {
            ex.printStackTrace();
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.getSoDT(), entity.getChucVu(), entity.isGioiTinh(), entity.getAvatar(), entity.getMaNV());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                NhanVien enity = new NhanVien();
                enity.setMaNV(rs.getString("MaNV"));
                enity.setMatKhau(rs.getString("Password"));
                enity.setHoTen(rs.getString("HoTen"));
                enity.setSoDT(rs.getString("SoDT"));
                enity.setChucVu(rs.getString("ChucVu"));
                enity.setGioiTinh(rs.getBoolean("GioiTinh"));
                enity.setAvatar(rs.getString("Avatar"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> selectByOrderD() {
        String sql = "SELECT * FROM NHANVIEN ORDER BY HoTen desc";
        return this.selectBySql(sql);
    }

    public List<NhanVien> selectByOrderA() {
        String sql = "SELECT * FROM NHANVIEN ORDER BY HoTen ASC";
        return this.selectBySql(sql);
    }

    public List<NhanVien> selectByPosition(String position) {
        String sql = "SELECT * FROM NHANVIEN WHERE ChucVu like ?";
        return this.selectBySql(sql, "%" + position + "%");
    }

    public List<NhanVien> timNhanVienTheoTenNV(String TenNhanVien) {
        String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE N'%" + TenNhanVien + "%' ";
        return this.selectBySql(sql);
    }
}
