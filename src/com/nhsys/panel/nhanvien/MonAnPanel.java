package com.nhsys.panel.nhanvien;

import com.nhsys.utils.XImage;
import java.awt.Color;


public class MonAnPanel extends javax.swing.JPanel {

    public MonAnPanel(String hinh, String ten) {
        

        initComponents();
        XImage.setHinh(lblHinhAnh, hinh, 244,150);
        lblTen.setText(ten);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinhAnh = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lblHinhAnh.setBackground(new java.awt.Color(255, 153, 153));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/lock.png"))); // NOI18N
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseEntered(evt);
            }
        });

        lblTen.setBackground(new java.awt.Color(255, 255, 255));
        lblTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTen.setText("Ten mon an");
        lblTen.setFocusCycleRoot(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTen)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhAnhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHinhAnhMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
  
            setBackground(new Color(225, 90, 51));    
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
         setBackground(new Color(204,204,204));
        
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblTen;
    // End of variables declaration//GEN-END:variables
}
