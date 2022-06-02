/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.quanly;

import com.nhsys.dao.HoaDonDAO;
import com.nhsys.entity.HoaDon;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.XDate;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
//import ui.QuanLy.NV_HoaDonChiTiet;

/**
 *
 * @author Hai Tran
 */
public class QL_DoanhThuThang extends javax.swing.JPanel {

    /**
     * Creates new form DoanhThuThangPanel
     */
    public QL_DoanhThuThang() {
        initComponents();
        fillToTable();
        chart();
    }
    HoaDonDAO dao = new HoaDonDAO();
    double tongTien = 0;
    static DefaultTableModel model;
    static int row = 0;
    List<HoaDon> listhd;

    void fillToTable() {
        Locale locale = new Locale("en", "EN");
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        try {
            listhd = dao.selectAllProc("Đã thanh toán");
            for (HoaDon hd : listhd) {

                decimalFormat.applyPattern("###,###.##");
                Object[] row = {
                    hd.getMaBan(),
                    hd.getTenNV(),
                    XDate.formatDate1(hd.getNgayTao()),
                    decimalFormat.format(hd.getTongTien())
                };
                model.addRow(row);
                tongTien += hd.getTongTien();

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }

    }

    void chart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 1; i < 13; i++) {
            List<HoaDon> list = dao.selectValueChar(i, cboNam.getSelectedItem().toString());
            dataset.addValue(list.get(0).getTongTien(), "Tổng tiền", "Tháng " + i);
        }

        JFreeChart barChart = ChartFactory.createBarChart("DOANH THU THÁNG",
                "Tháng", "Tổng tiền",
                dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(barChart);
        pnlReport.removeAll();
        pnlReport.add(chartPanel);
        pnlReport.updateUI();
    }
    private static String[] columns = {"Số bàn", "Tên nhân viên", "Ngày thanh toán", "Tổng tiền"};

    public static void xuatExcel() throws IOException {
        FileOutputStream file = new FileOutputStream("Doanh thu\\DoanhThuThang.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet workSheet = workbook.createSheet("name");
        XSSFRow row;
        XSSFCell cellA;
        XSSFCell cellB;
        XSSFCell cellC;
        XSSFCell cellD;
        XSSFCell cellE;
        XSSFCell cellF;

        CellStyle style = workbook.createCellStyle();
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BROWN.getIndex());
        headerFont.setFontName("Times New Roman");

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN); // 右边框
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerCellStyle.setWrapText(true);

        // Create a Row
        Row headerRow = workSheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for (int i = 1; i < model.getRowCount() + 1; i++) {
            row = workSheet.createRow(i);
            cellA = row.createCell((short) 0);
            cellA.setCellValue((model.getValueAt(i - 1, 0).toString()));
            cellA.setCellStyle(style);
            cellB = row.createCell((short) 1);
            cellB.setCellValue((model.getValueAt(i - 1, 1).toString()));
            cellB.setCellStyle(style);
            cellC = row.createCell((short) 2);
            cellC.setCellValue((model.getValueAt(i - 1, 2).toString()));
            cellC.setCellStyle(style);
            cellD = row.createCell((short) 3);
            cellD.setCellValue((model.getValueAt(i - 1, 3).toString()));
            cellD.setCellStyle(style);
        }

        workbook.write(file);
        workbook.close();
        file.close();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboNgay = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        btnXuat = new javax.swing.JButton();
        pnlReport = new javax.swing.JPanel();
        cboNam = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        cboNgay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo ngày", "Ngày mới nhất", "Ngày cũ nhất" }));
        cboNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNgayActionPerformed(evt);
            }
        });

        tblDoanhThu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số Bàn", "Tên nhân viên", "Ngày thanh toán", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0;x<4;x++){
            tblDoanhThu.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }

        tblDoanhThu.setRowHeight(30);

        tblDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(1);
        tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(1);
        jScrollPane1.setViewportView(tblDoanhThu);

        btnXuat.setBackground(new java.awt.Color(255, 153, 51));
        btnXuat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/excel.png"))); // NOI18N
        btnXuat.setText("XUẤT EXCEL");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        pnlReport.setLayout(new javax.swing.BoxLayout(pnlReport, javax.swing.BoxLayout.LINE_AXIS));

        cboNam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021" }));
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                            .addComponent(btnXuat))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlReport, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayActionPerformed
        // TODO add your handling code here:
        if (cboNgay.getSelectedIndex() == 0) {
            fillToTable();
        } else if (cboNgay.getSelectedIndex() == 1) {
            DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
            model.setRowCount(0);
            try {
                List<HoaDon> list = dao.selectByTang();
                for (HoaDon hd : list) {
                    Object[] row = {
                        hd.getMaBan(),
                        hd.getTenNV(),
                        XDate.formatDate1(hd.getNgayTao()),
                        hd.getTongTien()
                    };
                    model.addRow(row);
                    tongTien += hd.getTongTien();

                }
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
                e.printStackTrace();
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
            model.setRowCount(0);
            try {
                List<HoaDon> list = dao.selectByGiam();
                for (HoaDon hd : list) {
                    Object[] row = {
                        hd.getMaBan(),
                        hd.getTenNV(),
                        XDate.formatDate1(hd.getNgayTao()),
                        hd.getTongTien()
                    };
                    model.addRow(row);
                    tongTien += hd.getTongTien();

                }
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cboNgayActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {
            xuatExcel();
        } catch (IOException ex) {
            Logger.getLogger(QL_DoanhThuThang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        chart();
    }//GEN-LAST:event_cboNamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboNgay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlReport;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
