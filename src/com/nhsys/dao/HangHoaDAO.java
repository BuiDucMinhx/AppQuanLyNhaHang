/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.dao;

import com.nhsys.entity.HangHoa;
import com.nhsys.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhha
 */
public class HangHoaDAO extends NHDAO<HangHoa, String> {

    String INSERT_SQL = "INSERT INTO KhoHang(MaHangHoa, TenHangHoa, NgayNhap, DonVi, SoLuong, ChiPhi, TongChiPhi)VALUES(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhoHang SET TenHangHoa=?, NgayNhap=?, DonVi=?, SoLuong=?, ChiPhi=?, TongChiPhi=? where MaHangHoa = ?";
    String DELETE_SQL = "DELETE FROM KhoHang WHERE MaHangHoa =?";
    String SELECT_ALL_SQL = "SELECT * FROM KhoHang";
    String SELETE_BY_ID_SQL = "SELECT * FROM KhoHang WHERE MaHangHoa =?";

    @Override
    public void insert(HangHoa entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaHangHoa(), entity.getTenHangHoa(), entity.getNgayNhap(), entity.getDonVi(), entity.getSoLuong(), entity.getChiPhi(), entity.getTongChiPhi());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(HangHoa entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTenHangHoa(), entity.getNgayNhap(), entity.getDonVi(), entity.getSoLuong(), entity.getChiPhi(), entity.getTongChiPhi(), entity.getMaHangHoa());
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
    public HangHoa selectById(String id) {
        List<HangHoa> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HangHoa> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HangHoa> selectBySql(String sql, Object... args) {
        List<HangHoa> list = new ArrayList<HangHoa>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HangHoa enity = new HangHoa();
                enity.setMaHangHoa(rs.getString("MaHangHoa"));
                enity.setTenHangHoa(rs.getString("TenHangHoa"));
                enity.setNgayNhap(rs.getString("NgayNhap"));
                enity.setDonVi(rs.getString("DonVi"));
                enity.setSoLuong(rs.getDouble("SoLuong"));
                enity.setChiPhi(rs.getDouble("ChiPhi"));
                enity.setTongChiPhi(rs.getDouble("TongChiPhi"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HangHoa> SearchByNameHH(String TenHangHoa) {
        String sql = "SELECT * FROM KhoHang WHERE TenHangHoa LIKE N'%" + TenHangHoa + "%' ";
        return this.selectBySql(sql);
    }
}
