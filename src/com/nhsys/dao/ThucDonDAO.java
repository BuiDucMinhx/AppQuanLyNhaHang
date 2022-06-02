/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.NhanVien;
import com.nhsys.entity.ThucDon;
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
public class ThucDonDAO extends NHDAO<ThucDon, String> {

    String INSERT_SQL = "INSERT INTO ThucDon(MaMon, TenMon, GiaTien, HinhAnh, MaDanhMuc)VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ThucDon SET TenMon=?, GiaTien=?, HinhAnh=?, Loai=? where MaMon = ?";
    String DELETE_SQL = "DELETE FROM ThucDon WHERE MaMon =?";
    String SELECT_ALL_SQL = "SELECT * FROM ThucDon";
    String SELETE_BY_ID_SQL = "SELECT * FROM ThucDon WHERE MaMon =?";
    String SELECTE_BY_MTD = "select *from ThucDon where Loai =?";

    @Override
    public void insert(ThucDon entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaMon(), entity.getTenMon(), entity.getGiaTien(), entity.getHinhAnh(), entity.getLoai());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(ThucDon entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenMon(), entity.getGiaTien(), entity.getHinhAnh(), entity.getLoai(), entity.getMaMon());
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
    public ThucDon selectById(String id) {
        //To change body of generated methods, choose Tools | Templates.
        List<ThucDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThucDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<ThucDon> selectBySql(String sql, Object... args) {
        List<ThucDon> list = new ArrayList<ThucDon>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ThucDon enity = new ThucDon();
                enity.setMaMon(rs.getString("MaMon"));
                enity.setTenMon(rs.getString("TenMon"));
                enity.setGiaTien(rs.getFloat("GiaTien"));
                enity.setHinhAnh(rs.getString("HinhAnh"));
                enity.setLoai(rs.getString("Loai"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ThucDon> selectByCategory(String category) {
        String sql = "SELECT * FROM ThucDon WHERE Loai like ?";
        return this.selectBySql(sql, "%" + category + "%");
    }

    public List<ThucDon> SearchByDish(String TenMonAn) {
        String sql = "SELECT * FROM ThucDon WHERE TenMon LIKE N'%" + TenMonAn + "%' ";
        return this.selectBySql(sql);
    }

    public List<ThucDon> selectLoaiTD(String loaiTD) {
        return this.selectBySql(SELECTE_BY_MTD, loaiTD);
    }
}
