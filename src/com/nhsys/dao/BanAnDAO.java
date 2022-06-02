package com.nhsys.dao;

import com.nhsys.entity.BanAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.nhsys.utils.XJdbc;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BanAnDAO extends NHDAO<BanAn, Integer> {

    String INSERT_SQL = "INSERT INTO BanAn(MaBan, SoBan,TrangThai)VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE BanAn SET SoBan = ?,TrangThai =? where MaBan = ?";
    String UPDATE_GC_SQL = "UPDATE BanAn SET TrangThai =? where MaBan = ?";
    String DELETE_SQL = "DELETE FROM BanAn WHERE MaBan =?";
    String SELECT_ALL_SQL = "SELECT *FROM BanAn";
    String SELETE_BY_ID_SQL = "SELECT * FROM BanAn WHERE MaBan =?";

    public List<BanAn> GetBan(int maban) {
//        ArrayList<BanAn> arrBan = null;
        List<BanAn> arrBan = this.selectBySql("SELECT * FROM BanAn WHERE MaBan =?", maban);
        return arrBan;
    }

    @Override
    public void insert(BanAn entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMaBan(), entity.getLoaiBan(), entity.getTrangThai());
        } catch (Exception ex) {
            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(BanAn entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getLoaiBan(), entity.getTrangThai(), entity.getMaBan());
        } catch (Exception ex) {
            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGC(BanAn entity) {
        try {
            XJdbc.update(UPDATE_GC_SQL, entity.getTrangThai(), entity.getMaBan());
        } catch (Exception ex) {
            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(BanAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BanAn selectById(Integer id) {
        List<BanAn> list = this.selectBySql(SELETE_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BanAn> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BanAn> selectBySql(String sql, Object... args) {
        List<BanAn> list = new ArrayList<BanAn>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                BanAn enity = new BanAn();
                enity.setMaBan(rs.getInt("MaBan"));
                enity.setLoaiBan(rs.getInt("LoaiBan"));
                enity.setTrangThai(rs.getString("TrangThai"));
             
                list.add(enity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
