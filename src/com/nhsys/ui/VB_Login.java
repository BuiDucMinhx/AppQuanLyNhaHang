/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.ui;

import com.nhsys.dao.NhanVienDAO;
import com.nhsys.entity.NhanVien;
import com.nhsys.utils.Auth;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.XImage;
import com.nhsys.utils.mouseEvent;
import java.awt.Color;

/**
 *
 * @author anhha
 */
public class VB_Login extends javax.swing.JFrame {

    NhanVienDAO dao = new NhanVienDAO();
    boolean sp = true;
    public static String MANVLogin;

    /**
     * Creates new form HT_Login
     */
    public VB_Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        XImage.setHinh(lblBackground, "logos\\Wellcome.png", lblBackground.getWidth(), lblBackground.getHeight());
        Auth.clear();
        pnlBackgroundOpacity.setBackground(new Color(255, 255, 255, 160));
        txtTenDangNhap.setBackground(new Color(0, 0, 0, 0));
        txtMatKhau.setBackground(new Color(0, 0, 0, 0));
        showPass();
    }

    void showPass() {
        txtMatKhau.setEchoChar((char) 0);
        XImage.setHinh(lblShowPass, "logos//eye-hide.png", lblShowPass.getWidth(), lblShowPass.getHeight());
        sp = false;
    }

    void hidenPass() {
        txtMatKhau.setEchoChar('*');
        XImage.setHinh(lblShowPass, "logos//eye-show.png", lblShowPass.getWidth(), lblShowPass.getHeight());
        sp = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        lblLogoPassword = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblShowPass = new javax.swing.JLabel();
        lblQuenMK = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTenDangNhap = new javax.swing.JTextField();
        lblLogoUser = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        pnlBackgroundOpacity = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập Hệ Thống");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("©2021 - H&T Team | Terms & Privacy | Hotline 1900 0091");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 610, 341, -1));

        btnDangNhap.setBackground(new java.awt.Color(255, 153, 51));
        btnDangNhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setBorder(null);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 402, 43));

        lblLogoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/lock.png"))); // NOI18N
        jPanel1.add(lblLogoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 402, 10));

        lblShowPass.setBackground(new java.awt.Color(255, 255, 255));
        lblShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/eye-show.png"))); // NOI18N
        lblShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShowPassMouseClicked(evt);
            }
        });
        jPanel1.add(lblShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        lblQuenMK.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lblQuenMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMKMouseClicked(evt);
            }
        });
        jPanel1.add(lblQuenMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/logo.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 468, 260));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 402, 10));

        txtTenDangNhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenDangNhap.setText("Tên đăng nhập");
        txtTenDangNhap.setBorder(null);
        txtTenDangNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDangNhapFocusLost(evt);
            }
        });
        txtTenDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenDangNhapMouseClicked(evt);
            }
        });
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(txtTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 360, -1));

        lblLogoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/user.png"))); // NOI18N
        jPanel1.add(lblLogoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        txtMatKhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMatKhau.setText("123");
        txtMatKhau.setBorder(null);
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        txtMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMatKhauMouseClicked(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyPressed(evt);
            }
        });
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 360, -1));

        pnlBackgroundOpacity.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackgroundOpacity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlBackgroundOpacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 480, 580));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/Delete.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, 30));
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 650));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void dangNhap() {
        if (txtTenDangNhap.getText().equalsIgnoreCase("Tên đăng nhập")) {
            MsgBox.alert(this, "Chưa nhập tên đăng nhập!");
            return;
        }
        if (txtMatKhau.getText().equalsIgnoreCase("Mật khẩu")) {
            MsgBox.alert(this, "Chưa nhập mật khẩu!");
            return;
        }
        String maNV = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        NhanVien nhanVien = dao.selectById(maNV);
        MANVLogin = maNV;
        if (nhanVien == null) {
            MsgBox.alert(this, "Sai tên đăng nhập!");
        } else if (!matKhau.equalsIgnoreCase(nhanVien.getMatKhau())) {
            MsgBox.alert(this, "Sai mật khẩu!");
        } else {
            Auth.user = nhanVien;
            if (nhanVien.getChucVu().equalsIgnoreCase("Quản lý")) {
//                new NewJFrame().setVisible(true);
                new VB_ManHinhChinh(true).setVisible(true);
                this.dispose();
            } 
            else {
                new VB_ManHinhChinh(false).setVisible(true);
                this.dispose();
            }
        }
    }
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        dangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblQuenMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMKMouseClicked

    }//GEN-LAST:event_lblQuenMKMouseClicked

    private void txtTenDangNhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDangNhapFocusLost
        new mouseEvent().clear_text_exit(txtTenDangNhap, "Tên Đăng Nhập");
    }//GEN-LAST:event_txtTenDangNhapFocusLost

    private void txtTenDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenDangNhapMouseClicked
        new mouseEvent().clear_text_click(txtTenDangNhap, "Tên Đăng Nhập");
    }//GEN-LAST:event_txtTenDangNhapMouseClicked

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        new mouseEvent().clear_text_exit(txtMatKhau, "Mật Khẩu");
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void txtMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatKhauMouseClicked
        new mouseEvent().clear_text_click(txtMatKhau, "Mật Khẩu");
    }//GEN-LAST:event_txtMatKhauMouseClicked

    private void lblShowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPassMouseClicked
        // TODO add your handling code here:
        if (sp) {
            showPass();
        } else {
            hidenPass();
        }
    }//GEN-LAST:event_lblShowPassMouseClicked

    private void txtMatKhauKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyPressed
        // TODO add your handling code here:
        if (!sp) {
            hidenPass();
        }
    }//GEN-LAST:event_txtMatKhauKeyPressed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
            // TODO add your handling code here:
             this.dispose();  
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VB_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VB_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VB_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VB_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VB_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoPassword;
    private javax.swing.JLabel lblLogoUser;
    private javax.swing.JLabel lblQuenMK;
    private javax.swing.JLabel lblShowPass;
    private javax.swing.JPanel pnlBackgroundOpacity;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
