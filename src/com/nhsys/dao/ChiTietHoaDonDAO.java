package com.nhsys.dao;

import com.nhsys.entity.ChiTietHoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.nhsys.utils.XJdbc;

public class ChiTietHoaDonDAO extends NHDAO<ChiTietHoaDon, Integer> {

    String INSERT_SQL = "INSERT INTO ChiTietHoaDon(MaHD, MaMon, SoLuong)VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE ChiTietHoaDon SET MaTD = ?,MaHD = ?,SoLuong = ? where maCTHD = ?";
    String DELETE_SQL = "DELETE FROM ChiTietHoaDon WHERE MaHD =?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietHoaDon";

    String SELETE_BY_SOBAN_SQL = "select MaCTHD,MaHD,TD.maTD, tenTD, soluong, giatien from ChiTietHoaDon CTHD inner join ThucDon TD on TD.MaTD = CTHD.MaTD where TD.MaBan= ?select MaHDCT,CTHD.MaHD,TD.MaMon, TenMon, soluong, giatien\n"
            + " from(( \n"
            + "ChiTietHoaDon CTHD\n"
            + "inner join ThucDon TD on TD.MaMon = CTHD.MaMon )\n"
            + "inner join  HoaDon HD on HD.MaHD = CTHD.MaHD) \n"
            + "where HD.MaBan = ?";
    String SELETE_BY_ID_SQL = "select MaCTHD,CTHD.MaHD,TD.maTD, tenTD, soluong, giatien,ba.GhiChu from ChiTietHoaDon CTHD \n"
            + "inner join ThucDon TD on TD.MaTD = CTHD.MaTD \n"
            + "inner join HoaDon HD on HD.MaHD = CTHD.MaHD \n"
            + "inner join BanAn BA on HD.SoBan = BA.SoBan\n"
            + "where hd.MaHD = ?;";

    @Override
    public void insert(ChiTietHoaDon entity) {
        try {
            XJdbc.update(INSERT_SQL,  entity.getMaHD(),entity.getMaMon(), entity.getSoLuong());
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiTietHoaDon entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMaMon(), entity.getMaHD(), entity.getSoLuong(), entity.getMaCTHD());
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiTietHoaDon selectById(Integer id) {
        List<ChiTietHoaDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<ChiTietHoaDon> selectByHD(Integer id) {
        List<ChiTietHoaDon> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<ChiTietHoaDon> selectBySoban(Integer MaBan) {
        System.out.println("số bàn" + MaBan);
        return this.selectBySql(SELETE_BY_SOBAN_SQL, MaBan);
    }

    public List<ChiTietHoaDon> getchiTietHoaDonbySoBan(Integer MaBan) {
        String sql = "{CALL sp_GetCTHDBySoBan(?)}";
        return this.selectBySql(sql, MaBan);
    }

    @Override
    protected List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ChiTietHoaDon enity = new ChiTietHoaDon();
                enity.setMaCTHD(rs.getInt("MaCTHD"));
                enity.setMaMon(rs.getString("MaMon"));
                enity.setMaHD(rs.getInt("MaHD"));
                enity.setSoLuong(rs.getInt("SoLuong"));
                enity.setTenMon(rs.getString("TenMon"));
                enity.setGiatien(rs.getDouble("GiaTien"));
                enity.setGhiChu(rs.getString("GhiChu"));
                enity.setMaBan(rs.getInt("MaBan"));
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
