/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.nhanvien;




import com.nhsys.dao.BanAnDAO;
import com.nhsys.dao.HoaDonDAO;
import com.nhsys.entity.BanAn;
import com.nhsys.entity.ChiTietHoaDon;
import com.nhsys.entity.HoaDon;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH2;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH3;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH4;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH5;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH6;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH7;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH8;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH9;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH10;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH11;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH12;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH13;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.DSCTHDKH14;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.fillTableGoiMon;
import static com.nhsys.panel.nhanvien.NV_FillMonAn.hd1;
import com.nhsys.ui.VB_ManHinhChinh;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Hai Tran
 */
public class NV_SoDoBan extends javax.swing.JPanel {
    public static List<ChiTietHoaDon> DuPhong1 = new ArrayList<>(DSCTHDKH);
    public static int MABANKH;
    BanAnDAO BaDao = new BanAnDAO();
    public static boolean DaDat = true;

//    List<BanAn> ban = new ArrayList<>();
    int i;

    void xemMon(int MaBAn, JButton bt) {
        MABANKH = MaBAn;
        NV_FillMonAn monan;
        monan = new NV_FillMonAn(MaBAn);
        jPanel3.removeAll();
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(monan);
        jPanel3.updateUI();
        //khi click vào nút bàn trên giao diện -> lấy text của button -> truyền qua form xemMon
    }

    public NV_SoDoBan() {
        initComponents();
//        fillButtonBan();
        TrangThaiBan();
    }

    ;

    void TrangThaiBan() {
        List<BanAn> ban = new ArrayList<>();
        ban = new BanAnDAO().selectAll();
        if (ban.get(1).getTrangThai().equals("Đang phục vụ")) {
            btnB01.setBackground(Color.decode("#66ff66"));
        }
    }

    public static void fillButtonBan() {

        //dshd = danh sách hóa đơn
        List<HoaDon> DSHD = new HoaDonDAO().selectAll();
        for (HoaDon hd : DSHD) {
            switch (hd.getMaBan()) {
                case 1:
                    btnB01.setBackground(new Color(255, 153, 51));
                    btnB01.setForeground(Color.white);

                    break;
                case 2:
                    btnB02.setBackground(new Color(255, 153, 51));
                    btnB02.setForeground(Color.white);
                    break;
                case 3:
                    btnB03.setBackground(new Color(255, 153, 51));
                    btnB03.setForeground(Color.white);
                    break;
                case 4:
                    btnB04.setBackground(new Color(255, 153, 51));
                    btnB04.setForeground(Color.white);
                    break;
                case 5:
                    btnB05.setBackground(new Color(255, 153, 51));
                    btnB05.setForeground(Color.white);
                    break;
                case 6:
                    btnB06.setBackground(new Color(255, 153, 51));
                    btnB06.setForeground(Color.white);
                    break;
                case 7:
                    btnB07.setBackground(new Color(255, 153, 51));
                    btnB07.setForeground(Color.white);
                    break;
                case 8:
                    btnB08.setBackground(new Color(255, 153, 51));
                    btnB08.setForeground(Color.white);
                    break;
                case 9:
                    btnB09.setBackground(new Color(255, 153, 51));
                    btnB09.setForeground(Color.white);
                    break;
                case 10:
                    btnB10.setBackground(new Color(255, 153, 51));
                    btnB10.setForeground(Color.white);
                    break;
                case 11:
                    btnB11.setBackground(new Color(255, 153, 51));
                    btnB11.setForeground(Color.white);
                    break;
                case 12:
                    btnB12.setBackground(new Color(255, 153, 51));
                    btnB12.setForeground(Color.white);
                    break;
                case 13:
                    btnB13.setBackground(new Color(255, 153, 51));
                    btnB13.setForeground(Color.white);
                    break;
                case 14:
                    btnB14.setBackground(new Color(255, 153, 51));
                    btnB14.setForeground(Color.white);
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnB09 = new javax.swing.JButton();
        btnB04 = new javax.swing.JButton();
        btnB01 = new javax.swing.JButton();
        btnB02 = new javax.swing.JButton();
        btnB03 = new javax.swing.JButton();
        btnB11 = new javax.swing.JButton();
        btnB10 = new javax.swing.JButton();
        btnB13 = new javax.swing.JButton();
        btnB06 = new javax.swing.JButton();
        btnB14 = new javax.swing.JButton();
        btnB05 = new javax.swing.JButton();
        btnB07 = new javax.swing.JButton();
        btnB12 = new javax.swing.JButton();
        btnB08 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSODOIMG = new javax.swing.JLabel();

        jPanel3.setLayout(null);

        btnB09.setBackground(new java.awt.Color(204, 204, 204));
        btnB09.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB09.setForeground(new java.awt.Color(255, 153, 0));
        btnB09.setText("B09");
        btnB09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB09ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB09);
        btnB09.setBounds(920, 380, 170, 100);

        btnB04.setBackground(new java.awt.Color(204, 204, 204));
        btnB04.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB04.setForeground(new java.awt.Color(255, 153, 0));
        btnB04.setText("B04");
        btnB04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB04ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB04);
        btnB04.setBounds(780, 10, 90, 50);

        btnB01.setBackground(new java.awt.Color(204, 204, 204));
        btnB01.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB01.setForeground(new java.awt.Color(255, 153, 0));
        btnB01.setText("B01");
        btnB01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB01ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB01);
        btnB01.setBounds(230, 10, 100, 50);

        btnB02.setBackground(new java.awt.Color(204, 204, 204));
        btnB02.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB02.setForeground(new java.awt.Color(255, 153, 0));
        btnB02.setText("B02");
        btnB02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB02ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB02);
        btnB02.setBounds(370, 10, 90, 50);

        btnB03.setBackground(new java.awt.Color(204, 204, 204));
        btnB03.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB03.setForeground(new java.awt.Color(255, 153, 0));
        btnB03.setText("B03");
        btnB03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB03ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB03);
        btnB03.setBounds(650, 10, 80, 50);

        btnB11.setBackground(new java.awt.Color(204, 204, 204));
        btnB11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnB11.setForeground(new java.awt.Color(255, 153, 51));
        btnB11.setText("B11");
        btnB11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB11ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB11);
        btnB11.setBounds(240, 230, 80, 50);

        btnB10.setBackground(new java.awt.Color(204, 204, 204));
        btnB10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnB10.setForeground(new java.awt.Color(255, 153, 51));
        btnB10.setText("B10");
        btnB10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB10ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB10);
        btnB10.setBounds(240, 130, 80, 50);

        btnB13.setBackground(new java.awt.Color(204, 204, 204));
        btnB13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB13.setForeground(new java.awt.Color(255, 153, 0));
        btnB13.setText("B13");
        btnB13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB13ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB13);
        btnB13.setBounds(0, 120, 150, 150);

        btnB06.setBackground(new java.awt.Color(204, 204, 204));
        btnB06.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB06.setForeground(new java.awt.Color(255, 153, 0));
        btnB06.setText("B06");
        btnB06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB06ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB06);
        btnB06.setBounds(770, 270, 80, 100);

        btnB14.setBackground(new java.awt.Color(204, 204, 204));
        btnB14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnB14.setForeground(new java.awt.Color(255, 153, 0));
        btnB14.setText("B14");
        btnB14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB14ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB14);
        btnB14.setBounds(0, 310, 150, 110);

        btnB05.setBackground(new java.awt.Color(204, 204, 204));
        btnB05.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB05.setForeground(new java.awt.Color(255, 153, 0));
        btnB05.setText("B05");
        btnB05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB05ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB05);
        btnB05.setBounds(770, 120, 80, 100);

        btnB07.setBackground(new java.awt.Color(204, 204, 204));
        btnB07.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB07.setForeground(new java.awt.Color(255, 153, 0));
        btnB07.setText("B07");
        btnB07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB07ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB07);
        btnB07.setBounds(650, 190, 80, 100);

        btnB12.setBackground(new java.awt.Color(204, 204, 204));
        btnB12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB12.setForeground(new java.awt.Color(255, 153, 0));
        btnB12.setText("B12");
        btnB12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB12ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB12);
        btnB12.setBounds(0, 20, 150, 70);

        btnB08.setBackground(new java.awt.Color(204, 204, 204));
        btnB08.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnB08.setForeground(new java.awt.Color(255, 153, 0));
        btnB08.setText("B08");
        btnB08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB08ActionPerformed(evt);
            }
        });
        jPanel3.add(btnB08);
        btnB08.setBounds(920, 190, 170, 140);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 0, 1100, 0);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Nước uống");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(630, 450, 120, 29);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Thức ăn");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(870, 550, 100, 29);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bếp");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(220, 520, 40, 21);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 0, 1100, 0);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LỄ TÂN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(27, 27, 27))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(910, 110, 190, 40);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 480, 490, 100);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Thức ăn");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Nước uống");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(160, 430, 330, 50);

        lblSODOIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/SoDoIMG.png"))); // NOI18N
        jPanel3.add(lblSODOIMG);
        lblSODOIMG.setBounds(0, 0, 1110, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1104, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnB08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB08ActionPerformed
        // TODO add your handling code here:
        xemMon(8, btnB08);
        DuPhong1 = new ArrayList<>(DSCTHDKH8);
        fillTableGoiMon(false, DSCTHDKH8);
        if(btnB08.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB08ActionPerformed

    private void btnB12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB12ActionPerformed
        // TODO add your handling code here:
        xemMon(12, btnB12);
        DuPhong1 = new ArrayList<>(DSCTHDKH12);
        fillTableGoiMon(false, DSCTHDKH12);
        if(btnB12.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB12ActionPerformed

    private void btnB07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB07ActionPerformed
        // TODO add your handling code here:
        xemMon(07, btnB07);
        DuPhong1 = new ArrayList<>(DSCTHDKH7);
        fillTableGoiMon(false, DSCTHDKH7);
        if(btnB07.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB07ActionPerformed

    private void btnB05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB05ActionPerformed
        // TODO add your handling code here:
        xemMon(05, btnB05);
        DuPhong1 = new ArrayList<>(DSCTHDKH5);
        fillTableGoiMon(false, DSCTHDKH5);
        if(btnB05.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB05ActionPerformed

    private void btnB14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB14ActionPerformed
        // TODO add your handling code here:
        xemMon(14, btnB14);
        DuPhong1 = new ArrayList<>(DSCTHDKH14);
        fillTableGoiMon(false, DSCTHDKH14);
        if(btnB14.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB14ActionPerformed

    private void btnB06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB06ActionPerformed
        // TODO add your handling code here:
        xemMon(6, btnB06);
        DuPhong1 = new ArrayList<>(DSCTHDKH6);
        fillTableGoiMon(false, DSCTHDKH6);
        if(btnB06.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB06ActionPerformed

    private void btnB13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB13ActionPerformed
        // TODO add your handling code here:
        xemMon(13, btnB13);
        DuPhong1 = new ArrayList<>(DSCTHDKH13);
        fillTableGoiMon(false, DSCTHDKH13);
        if(btnB13.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB13ActionPerformed

    private void btnB10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB10ActionPerformed
        // TODO add your handling code here:
        xemMon(10, btnB10);
        DuPhong1 = new ArrayList<>(DSCTHDKH10);
        fillTableGoiMon(false, DSCTHDKH10);
        if(btnB10.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB10ActionPerformed

    private void btnB11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB11ActionPerformed
        // TODO add your handling code here:
        xemMon(11, btnB11);
        DuPhong1 = new ArrayList<>(DSCTHDKH11);
        fillTableGoiMon(false, DSCTHDKH11);
        if(btnB11.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB11ActionPerformed

    private void btnB03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB03ActionPerformed
        // TODO add your handling code here:
        xemMon(3, btnB03);
        DuPhong1 = new ArrayList<>(DSCTHDKH3);
        fillTableGoiMon(false, DSCTHDKH3);
        if(btnB03.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB03ActionPerformed

    private void btnB02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB02ActionPerformed
        // TODO add your handling code here:
        xemMon(2, btnB02);
        DuPhong1 = new ArrayList<>(DSCTHDKH2);
        fillTableGoiMon(false, DSCTHDKH2);
        if(btnB02.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB02ActionPerformed

    private void btnB01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB01ActionPerformed
        // TODO add your handling code here:
        xemMon(1, btnB01);
        DuPhong1 = new ArrayList<>(DSCTHDKH);
        fillTableGoiMon(false,DSCTHDKH);
        if(btnB01.getBackground() == Color.green) DaDat = false;

    }//GEN-LAST:event_btnB01ActionPerformed

    private void btnB04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB04ActionPerformed
        // TODO add your handling code here:

        xemMon(4, btnB04);
        DuPhong1 = new ArrayList<>(DSCTHDKH4);
        fillTableGoiMon(false, DSCTHDKH4);
        if(btnB04.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB04ActionPerformed

    private void btnB09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB09ActionPerformed
        // TODO add your handling code here:
        xemMon(9, btnB09);
        DuPhong1 = new ArrayList<>(DSCTHDKH9);
        fillTableGoiMon(false, DSCTHDKH9);
        if(btnB09.getBackground() == Color.green) DaDat = false;
    }//GEN-LAST:event_btnB09ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnB01;
    public static javax.swing.JButton btnB02;
    public static javax.swing.JButton btnB03;
    public static javax.swing.JButton btnB04;
    public static javax.swing.JButton btnB05;
    public static javax.swing.JButton btnB06;
    public static javax.swing.JButton btnB07;
    public static javax.swing.JButton btnB08;
    public static javax.swing.JButton btnB09;
    public static javax.swing.JButton btnB10;
    public static javax.swing.JButton btnB11;
    public static javax.swing.JButton btnB12;
    public static javax.swing.JButton btnB13;
    public static javax.swing.JButton btnB14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblSODOIMG;
    // End of variables declaration//GEN-END:variables
}
