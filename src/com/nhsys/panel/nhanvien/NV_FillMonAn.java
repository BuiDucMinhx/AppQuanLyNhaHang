/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.panel.nhanvien;

import com.nhsys.dao.*;
import com.nhsys.entity.BanAn;
import com.nhsys.entity.ChiTietHoaDon;
import com.nhsys.entity.HoaDon;
import com.nhsys.entity.NhanVien;
import com.nhsys.entity.ThucDon;
import com.nhsys.utils.ButtonRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static com.nhsys.panel.nhanvien.NV_SoDoBan.MABANKH;
import static com.nhsys.panel.nhanvien.NV_SoDoBan.DuPhong1;
import static com.nhsys.ui.VB_Login.MANVLogin;
import com.nhsys.utils.MsgBox;
import com.nhsys.utils.mouseEvent;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VU
 */
public class NV_FillMonAn extends javax.swing.JPanel {
    public static List<HoaDon> hd1 = new HoaDonDAO().selectAllProcL2("Chưa thanh toán", MABANKH);
    public static boolean flag = true;
    public static String GhiChuYCK;
    public static double tongTien = 0;
    public static boolean isDatMon = true;
    List<ThucDon> DSTD = new ArrayList<>();
    
    public static List<ChiTietHoaDon> DuPhong = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH2 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH3 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH4 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH5 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH6 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH7 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH8 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH9 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH10 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH11 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH12 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH13 = new ArrayList<>();
    public static List<ChiTietHoaDon> DSCTHDKH14 = new ArrayList<>();
    public static List<Integer> numbers = new ArrayList<>();
    
    List<JButton> listBt = new ArrayList<>();
    ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
    HoaDonDAO HDdao = new HoaDonDAO();
    BanAnDAO BaDao = new BanAnDAO();
    public static DefaultTableModel model;
    public static String[] header = {"Tên món", "Số lượng", "Thành tiền", "Thao tác"};
    public static String[] header1 = {"Tên món", "Số lượng", "Thành tiền"};
    List<BanAn> DSBA = new ArrayList<>();
    String MaNV;
    String TenBan;
    int MaBan;
    int MaHD, tienmon = 0, tongtien = 0;

    String tenMenu;
    HoaDon hd;
    Timer t1;

    /**
     * Creates new form QL_MonAn
     */
    public NV_FillMonAn(int maban) {
        initComponents();
        MaBan = maban;
        lblSoBan.setText(Integer.toString(maban));
        FillmonAn("", "", DanhSachMon1);
        DanhSachMon1.setLayout(new FlowLayout(FlowLayout.CENTER));
//        jPanel1.removeAll();
//        jPanel1.setLayout(new BorderLayout());
//        NV_SoDoBan = new NV_SoDoBan();
//        jPanel1.add(NV_SoDoBan);
        jLabel1.updateUI();
    }

    public void FillmonAn(String LoaiTD, String TenTD, JPanel DanhSachMon) {
        int hMonAn = 0;
        //xóa hết món ăn
        DanhSachMon1.removeAll();
//        if (LoaiTD.equals("")) {
//            DSTD = new ThucDonDAO().selectAll();
//        } else if (LoaiTD.equals("Món uống")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Món ăn")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Món khác")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Khai vị")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Sashimi")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Cua")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Lẩu")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (LoaiTD.equals("Súp")) {
//            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
//        } else if (TenTD.equals("")) {
//            DSTD = new ThucDonDAO().SearchByDish(TenTD);
//        } else {
//            DSTD = new ThucDonDAO().SearchByDish(TenTD);
//        }
        if (TenTD.equals("") && LoaiTD.equals("")) {
            DSTD = new ThucDonDAO().selectAll();
        } else if (TenTD.equals("")) {
            DSTD = new ThucDonDAO().selectLoaiTD(LoaiTD);
        } else {
            DSTD = new ThucDonDAO().SearchByDish(TenTD);
        }

        //fill món ăn
        if (DSTD != null) {
            for (int i = 0; i < DSTD.size(); i++) {
                DSTD.get(i).getHinhAnh();
                JPanel panelMonAn = new MonAnPanel("logos\\" + DSTD.get(i).getHinhAnh(), DSTD.get(i).getTenMon().split("_")[0]);
                panelMonAn.addMouseListener(new CustomMouseListener(panelMonAn, DSTD.get(i)));
//                JPanel panelMonAn = new MonAnPanel("logos\\" + "kimchi.jpg", "Mực");
                DanhSachMon.add(panelMonAn);
                hMonAn += 80;
            }
        }
        DanhSachMon.setPreferredSize(new Dimension(200, hMonAn));
        DanhSachMon.validate();
        DanhSachMon.repaint();
        DSMon.repaint();
        DSMon.validate();
    }

    public static void fillTableGoiMon(boolean NVThemMonMoi, List<ChiTietHoaDon> a) {
        //nếu nhân có tín hiệu của nhân viên thêm món mới thì mới load database -> để nhanh hơn
        tongTien = 0;
//        if (NVThemMonMoi) {
//            DSCTHDKH = new ChiTietHoaDonDAO().getchiTietHoaDonbySoBan(KHSoBan);
//        }
        if (isDatMon) {
            model = new DefaultTableModel(header, 0);
        } else {
            model = new DefaultTableModel(header1, 0);
        }
        model.setRowCount(0); //Xóa tát cả các hàng trên table

        for (ChiTietHoaDon cthd : a) {
            double ThanhTien;
            int SoLuong = cthd.getSoLuong();
            double GiaTien = cthd.getGiatien();
            ThanhTien = SoLuong * GiaTien;
            tongTien += ThanhTien;
            Object[] row = {cthd.getTenMon().split("_")[0], SoLuong, ThanhTien};
            model.addRow(row); //Thêm 1 hàng vàoJTable
        }
        tblDSMonAn1.setModel(model);
        tblDSMonAn1.setRowHeight(30);
        tblDSMonAn1.getColumnModel().getColumn(0).setPreferredWidth(150);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < 3; x++) {
            tblDSMonAn1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
        txtTongTien.setText("TỔNG TIỀN: " + tongTien);
        //Đây là thêm nút vào table
    }

    public void setTablegoiMon() {
        if (isDatMon) {
            tblDSMonAn1.getColumn("Thao tác").setCellRenderer(new ButtonRenderer());
            tblDSMonAn1.getColumn("Thao tác").setCellEditor(new ButtonEditor(new JCheckBox()));
        }
    }

    class CustomMouseListener implements MouseListener {

        JPanel pn;
        ThucDon td;

        public CustomMouseListener(JPanel pn, ThucDon td) {
            this.pn = pn;
            this.td = td;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (NV_SoDoBan.DaDat == false) {
                btnDatMon.setText("CẬP NHẬT");
                NV_SoDoBan.DaDat = true;
            }
            if (isDatMon) {
                checkTable();
                boolean coMonAn = false;
                int r = -1;
                for (int i = 0; i < tblDSMonAn1.getRowCount(); i++) {
                    if (td.getTenMon().split("_")[0].equals(tblDSMonAn1.getValueAt(i, 0))) {
                        //check xem đã có món ăn trên table chưa
                        coMonAn = true;
                        r = i;
                    }
                }
                int maban = MABANKH;
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                //nếu chưa có thì thêm vào số lượng là 1
                if (!coMonAn) {
                    cthd.setTenMon(td.getTenMon());
                    cthd.setSoLuong(1);
                    cthd.setGiatien(td.getGiaTien());
                    cthd.setMaMon(td.getMaMon());
                    tongTien += td.getGiaTien();
                    if (maban == 1) {
                        DSCTHDKH.add(cthd);
                    } else if (maban == 2) {
                        DSCTHDKH2.add(cthd);
                    } else if (maban == 3) {
                        DSCTHDKH3.add(cthd);
                    } else if (maban == 4) {
                        DSCTHDKH4.add(cthd);
                    } else if (maban == 5) {
                        DSCTHDKH5.add(cthd);
                    } else if (maban == 6) {
                        DSCTHDKH6.add(cthd);
                    } else if (maban == 7) {
                        DSCTHDKH7.add(cthd);
                    } else if (maban == 8) {
                        DSCTHDKH8.add(cthd);
                    } else if (maban == 9) {
                        DSCTHDKH9.add(cthd);
                    } else if (maban == 10) {
                        DSCTHDKH10.add(cthd);
                    } else if (maban == 11) {
                        DSCTHDKH11.add(cthd);
                    } else if (maban == 12) {
                        DSCTHDKH12.add(cthd);
                    } else if (maban == 13) {
                        DSCTHDKH13.add(cthd);
                    } else if (maban == 14) {
                        DSCTHDKH14.add(cthd);
                    }
                } else {// + số lượng món
                    if (maban == 1) {
                        int soluong = DSCTHDKH.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH.get(r).getGiatien();
                        DSCTHDKH.get(r).setSoLuong(soluong);
                    } else if (maban == 2) {
                        int soluong = DSCTHDKH2.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH2.get(r).getGiatien();
                        DSCTHDKH2.get(r).setSoLuong(soluong);
                    } else if (maban == 3) {
                        int soluong = DSCTHDKH3.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH3.get(r).getGiatien();
                        DSCTHDKH3.get(r).setSoLuong(soluong);
                    } else if (maban == 4) {
                        int soluong = DSCTHDKH4.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH4.get(r).getGiatien();
                        DSCTHDKH4.get(r).setSoLuong(soluong);
                    } else if (maban == 5) {
                        int soluong = DSCTHDKH5.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH5.get(r).getGiatien();
                        DSCTHDKH5.get(r).setSoLuong(soluong);
                    } else if (maban == 6) {
                        int soluong = DSCTHDKH6.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH6.get(r).getGiatien();
                        DSCTHDKH6.get(r).setSoLuong(soluong);
                    } else if (maban == 7) {
                        int soluong = DSCTHDKH7.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH7.get(r).getGiatien();
                        DSCTHDKH7.get(r).setSoLuong(soluong);
                    } else if (maban == 8) {
                        int soluong = DSCTHDKH8.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH8.get(r).getGiatien();
                        DSCTHDKH8.get(r).setSoLuong(soluong);
                    } else if (maban == 9) {
                        int soluong = DSCTHDKH9.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH9.get(r).getGiatien();
                        DSCTHDKH9.get(r).setSoLuong(soluong);
                    } else if (maban == 10) {
                        int soluong = DSCTHDKH10.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH10.get(r).getGiatien();
                        DSCTHDKH10.get(r).setSoLuong(soluong);
                    } else if (maban == 11) {
                        int soluong = DSCTHDKH11.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH11.get(r).getGiatien();
                        DSCTHDKH11.get(r).setSoLuong(soluong);
                    } else if (maban == 12) {
                        int soluong = DSCTHDKH12.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH12.get(r).getGiatien();
                        DSCTHDKH12.get(r).setSoLuong(soluong);
                    } else if (maban == 13) {
                        int soluong = DSCTHDKH13.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH13.get(r).getGiatien();
                        DSCTHDKH13.get(r).setSoLuong(soluong);
                    } else if (maban == 14) {
                        int soluong = DSCTHDKH14.get(r).getSoLuong();
                        soluong = soluong + 1;
                        tongTien += DSCTHDKH14.get(r).getGiatien();
                        DSCTHDKH14.get(r).setSoLuong(soluong);
                    }
                }
                if (maban == 1) {
                    fillTableGoiMon(false, DSCTHDKH);
                } else if (maban == 2) {
                    fillTableGoiMon(false, DSCTHDKH2);
                } else if (maban == 3) {
                    fillTableGoiMon(false, DSCTHDKH3);
                } else if (maban == 4) {
                    fillTableGoiMon(false, DSCTHDKH4);
                } else if (maban == 5) {
                    fillTableGoiMon(false, DSCTHDKH5);
                } else if (maban == 6) {
                    fillTableGoiMon(false, DSCTHDKH6);
                } else if (maban == 7) {
                    fillTableGoiMon(false, DSCTHDKH7);
                } else if (maban == 8) {
                    fillTableGoiMon(false, DSCTHDKH8);
                } else if (maban == 9) {
                    fillTableGoiMon(false, DSCTHDKH9);
                } else if (maban == 10) {
                    fillTableGoiMon(false, DSCTHDKH10);
                } else if (maban == 11) {
                    fillTableGoiMon(false, DSCTHDKH11);
                } else if (maban == 12) {
                    fillTableGoiMon(false, DSCTHDKH12);
                } else if (maban == 13) {
                    fillTableGoiMon(false, DSCTHDKH13);
                } else if (maban == 14) {
                    fillTableGoiMon(false, DSCTHDKH14);
                }
                setTablegoiMon();
            } else {
//                if (MsgBox.confirm(pn, "Bạn muốn thêm món mới?")) {
//                    NetworkClient.chatToServer(KHSoBan + "-ThemMonAnMoiKH");
//                    MsgBox.alert(null, "Vui lòng đợi nhân viên xác nhận");
//                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pn.setBackground(new Color(255, 153, 51));

        }

        @Override

        public void mouseReleased(MouseEvent e) {
            pn.setBackground(new Color(204, 204, 204));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            pn.setBackground(new Color(255, 153, 51));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            pn.setBackground(new Color(204, 204, 204));
        }
    }

    public class ButtonEditor extends DefaultCellEditor {

        protected JButton button;
        private String label;
        private boolean isPushed;
        JTable tb;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            //ở đây lấy table nè
            this.tb = table;
            if (isSelected) {
                button.setBackground(new Color(255, 153, 51));
            } else {
                button.setBackground(new Color(255, 153, 51));
            }
            button.setIcon(new ImageIcon("src\\com\\nhsys\\icon\\Delete.png"));
            isPushed = true;
            return button;
        }

        Timer t;

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int r = tb.getSelectedRow();
                int maban = MABANKH;
                if (maban == 1) {
                    fill(r, DSCTHDKH);
                } else if (maban == 2) {
                    fill(r, DSCTHDKH2);
                } else if (maban == 3) {
                    fill(r, DSCTHDKH3);
                } else if (maban == 4) {
                    fill(r, DSCTHDKH4);
                } else if (maban == 5) {
                    fill(r, DSCTHDKH5);
                } else if (maban == 6) {
                    fill(r, DSCTHDKH6);
                } else if (maban == 7) {
                    fill(r, DSCTHDKH7);
                } else if (maban == 8) {
                    fill(r, DSCTHDKH8);
                } else if (maban == 9) {
                    fill(r, DSCTHDKH9);
                } else if (maban == 10) {
                    fill(r, DSCTHDKH10);
                } else if (maban == 11) {
                    fill(r, DSCTHDKH11);
                } else if (maban == 12) {
                    fill(r, DSCTHDKH12);
                } else if (maban == 13) {
                    fill(r, DSCTHDKH13);
                } else if (maban == 14) {
                    fill(r, DSCTHDKH14);
                }

            };
            isPushed = false;
            return label;
        }
        private void fill(int r, List<ChiTietHoaDon> a) {
            if (r > -1) {
                int soluong = (int) tb.getValueAt(r, 1);
                if (soluong == 1) {
                    tongTien -= a.get(r).getGiatien();
                    a.remove(r);
                } else {
                    a.get(r).setSoLuong(soluong - 1);
                    tongTien -= a.get(r).getGiatien();
                }
                t = new Timer(100, (ActionEvent e) -> {
                    checkTable();
                    fillTableGoiMon(false, a);

                    setTablegoiMon();
                    t.stop();
                });
                t.start();
            }
        }
        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    //set BG bt
    public void setBackgroundBT(JButton btClick) {
        for (JButton bt : listBt) {
            if (bt.equals(btClick)) {
                btClick.setBackground(new Color(252, 214, 112));
            } else {
                bt.setBackground(new Color(204, 204, 204));
            }
        }
    }

    public void checkTable() {
        t1 = new Timer(100, (e) -> {
            int soRow = tblDSMonAn1.getRowCount();
            if (soRow > 0) {
                btnDatMon.setEnabled(true);

            } else {
                btnDatMon.setEnabled(false);

            }
            t1.stop();
        });
        t1.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpnCenter = new javax.swing.JPanel();
        tabs6 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        DSMon = new javax.swing.JScrollPane();
        DanhSachMon1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnMonAn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnThucUong = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnKhac = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnTatCa = new javax.swing.JButton();
        btnKhaivi = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnSashimi = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnLau = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnSup = new javax.swing.JButton();
        btnCua = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        txtNhapTenMon = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtTongTien = new javax.swing.JTextField();
        jCroMonAn = new javax.swing.JScrollPane();
        tblDSMonAn1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblSoBan = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnDatMon = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 600));

        tabs6.setBackground(new java.awt.Color(255, 229, 153));
        tabs6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabs6.setForeground(new java.awt.Color(255, 153, 51));
        tabs6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        DSMon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DSMon.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        DanhSachMon1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout DanhSachMon1Layout = new javax.swing.GroupLayout(DanhSachMon1);
        DanhSachMon1.setLayout(DanhSachMon1Layout);
        DanhSachMon1Layout.setHorizontalGroup(
            DanhSachMon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        DanhSachMon1Layout.setVerticalGroup(
            DanhSachMon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        DSMon.setViewportView(DanhSachMon1);

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.add(jSeparator4);

        btnMonAn.setBackground(new java.awt.Color(204, 204, 204));
        btnMonAn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnMonAn.setText("Món ăn");
        btnMonAn.setFocusable(false);
        btnMonAn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMonAn.setMaximumSize(new java.awt.Dimension(95, 63));
        btnMonAn.setMinimumSize(new java.awt.Dimension(95, 63));
        btnMonAn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonAnActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMonAn);
        jToolBar1.add(jSeparator1);

        btnThucUong.setBackground(new java.awt.Color(204, 204, 204));
        btnThucUong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThucUong.setText("Thức uống");
        btnThucUong.setFocusable(false);
        btnThucUong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThucUong.setMaximumSize(new java.awt.Dimension(95, 63));
        btnThucUong.setMinimumSize(new java.awt.Dimension(95, 63));
        btnThucUong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThucUong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThucUongActionPerformed(evt);
            }
        });
        jToolBar1.add(btnThucUong);
        jToolBar1.add(jSeparator2);

        btnKhac.setBackground(new java.awt.Color(204, 204, 204));
        btnKhac.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnKhac.setText("Khác");
        btnKhac.setFocusable(false);
        btnKhac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhac.setMaximumSize(new java.awt.Dimension(95, 63));
        btnKhac.setMinimumSize(new java.awt.Dimension(95, 63));
        btnKhac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhacActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhac);

        jToolBar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnTatCa.setBackground(new java.awt.Color(204, 204, 204));
        btnTatCa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTatCa.setText("Tất cả");
        btnTatCa.setBorder(null);
        btnTatCa.setFocusable(false);
        btnTatCa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTatCa.setMaximumSize(new java.awt.Dimension(95, 63));
        btnTatCa.setMinimumSize(new java.awt.Dimension(95, 63));
        btnTatCa.setPreferredSize(new java.awt.Dimension(83, 65));
        btnTatCa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnTatCa);

        btnKhaivi.setBackground(new java.awt.Color(204, 204, 204));
        btnKhaivi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnKhaivi.setText("Khai vị");
        btnKhaivi.setFocusable(false);
        btnKhaivi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhaivi.setMaximumSize(new java.awt.Dimension(95, 63));
        btnKhaivi.setMinimumSize(new java.awt.Dimension(95, 63));
        btnKhaivi.setPreferredSize(new java.awt.Dimension(83, 65));
        btnKhaivi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhaivi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhaiviActionPerformed(evt);
            }
        });
        jToolBar2.add(btnKhaivi);
        jToolBar2.add(jSeparator5);

        btnSashimi.setBackground(new java.awt.Color(204, 204, 204));
        btnSashimi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSashimi.setText("Sashimi");
        btnSashimi.setFocusable(false);
        btnSashimi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSashimi.setMaximumSize(new java.awt.Dimension(95, 63));
        btnSashimi.setMinimumSize(new java.awt.Dimension(95, 63));
        btnSashimi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSashimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSashimiActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSashimi);
        jToolBar2.add(jSeparator6);

        btnLau.setBackground(new java.awt.Color(204, 204, 204));
        btnLau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLau.setText("Lẩu");
        btnLau.setFocusable(false);
        btnLau.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLau.setMaximumSize(new java.awt.Dimension(95, 63));
        btnLau.setMinimumSize(new java.awt.Dimension(95, 63));
        btnLau.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLauActionPerformed(evt);
            }
        });
        jToolBar2.add(btnLau);
        jToolBar2.add(jSeparator7);

        btnSup.setBackground(new java.awt.Color(204, 204, 204));
        btnSup.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSup.setText("Soup");
        btnSup.setFocusable(false);
        btnSup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSup.setMaximumSize(new java.awt.Dimension(95, 63));
        btnSup.setMinimumSize(new java.awt.Dimension(95, 63));
        btnSup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSup);

        btnCua.setBackground(new java.awt.Color(204, 204, 204));
        btnCua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCua.setText("Cua/Ghẹ");
        btnCua.setFocusable(false);
        btnCua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCua.setMaximumSize(new java.awt.Dimension(95, 63));
        btnCua.setMinimumSize(new java.awt.Dimension(95, 63));
        btnCua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCua);
        jToolBar2.add(jSeparator8);

        txtNhapTenMon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNhapTenMon.setText("Nhập tên món cần tìm");
        txtNhapTenMon.setToolTipText("Nhập tên món cần tìm");
        txtNhapTenMon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNhapTenMon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNhapTenMonFocusLost(evt);
            }
        });
        txtNhapTenMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapTenMonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNhapTenMonMouseExited(evt);
            }
        });
        txtNhapTenMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapTenMonActionPerformed(evt);
            }
        });
        txtNhapTenMon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNhapTenMonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jSeparator11)
                .addGap(17, 17, 17))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(DSMon, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNhapTenMon)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNhapTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DSMon, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tabs6.addTab("GỌI MÓN", jPanel11);

        jPanel8.setBackground(new java.awt.Color(255, 153, 51));

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(255, 255, 255));
        txtTongTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 153, 51));
        txtTongTien.setText(" TỔNG TIỀN: ");
        txtTongTien.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTongTien)
                .addContainerGap())
        );

        jCroMonAn.setBackground(new java.awt.Color(255, 255, 255));

        tblDSMonAn1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDSMonAn1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "SL", "Thành tiền", "Thao tác"
            }
        ));
        jCroMonAn.setViewportView(tblDSMonAn1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Bàn:");

        lblSoBan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblSoBan.setForeground(new java.awt.Color(255, 153, 0));
        lblSoBan.setText("0");

        btnThanhToan.setBackground(new java.awt.Color(255, 102, 0));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhsys/icon/arrow.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDatMon.setBackground(new java.awt.Color(255, 153, 51));
        btnDatMon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDatMon.setForeground(new java.awt.Color(255, 255, 255));
        btnDatMon.setText("ĐẶT MÓN");
        btnDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatMonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnCenterLayout = new javax.swing.GroupLayout(JpnCenter);
        JpnCenter.setLayout(JpnCenterLayout);
        JpnCenterLayout.setHorizontalGroup(
            JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnCenterLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpnCenterLayout.createSequentialGroup()
                .addComponent(tabs6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCroMonAn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpnCenterLayout.createSequentialGroup()
                        .addComponent(btnDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThanhToan))
                .addContainerGap())
        );
        JpnCenterLayout.setVerticalGroup(
            JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnCenterLayout.createSequentialGroup()
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSoBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs6, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JpnCenterLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jCroMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(JpnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDatMon)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpnCenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
NV_SoDoBan NV_SoDoBan;
    NhanVienDAO NVDao = new NhanVienDAO();
    List<NhanVien> nvl = new ArrayList<>();
    private void btnMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonAnActionPerformed
        // TODO add your handling code here:
        btnMonAn.setBackground(new Color(255, 153, 51));
        FillmonAn("Món ăn", "", DanhSachMon1);
    }//GEN-LAST:event_btnMonAnActionPerformed

    private void btnThucUongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThucUongActionPerformed
        // TODO add your handling code here:
        btnThucUong.setBackground(new Color(255, 153, 51));
        FillmonAn("Món uống", "", DanhSachMon1);
    }//GEN-LAST:event_btnThucUongActionPerformed

    private void btnKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhacActionPerformed
        // TODO add your handling code here:
        btnKhac.setBackground(new Color(255, 153, 51));
        FillmonAn("Món khác", "", DanhSachMon1);
    }//GEN-LAST:event_btnKhacActionPerformed

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        // TODO add your handling code here:
        btnTatCa.setBackground(new Color(255, 153, 51));
        FillmonAn("", "", DanhSachMon1);
    }//GEN-LAST:event_btnTatCaActionPerformed

    private void btnKhaiviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhaiviActionPerformed
        // TODO add your handling code here:
        btnKhaivi.setBackground(new Color(255, 153, 51));
        FillmonAn("Khai vị", "", DanhSachMon1);
    }//GEN-LAST:event_btnKhaiviActionPerformed

    private void btnSashimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSashimiActionPerformed
        // TODO add your handling code here:
        btnSashimi.setBackground(new Color(255, 153, 51));
        FillmonAn("Sashimi", "", DanhSachMon1);
    }//GEN-LAST:event_btnSashimiActionPerformed

    private void btnLauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLauActionPerformed
        // TODO add your handling code here:
        btnLau.setBackground(new Color(255, 153, 51));
        FillmonAn("Lẩu", "", DanhSachMon1);
    }//GEN-LAST:event_btnLauActionPerformed

    private void btnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupActionPerformed
        // TODO add your handling code here:
        btnSup.setBackground(new Color(255, 153, 51));
        FillmonAn("Súp", "", DanhSachMon1);
    }//GEN-LAST:event_btnSupActionPerformed

    private void btnCuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuaActionPerformed
        // TODO add your handling code here:
        btnCua.setBackground(new Color(255, 153, 51));
        FillmonAn("Cua", "", DanhSachMon1);
    }//GEN-LAST:event_btnCuaActionPerformed

    private void txtNhapTenMonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNhapTenMonKeyReleased
        // TODO add your handling code here:
        String tenMon = txtNhapTenMon.getText();
        FillmonAn("", tenMon, DanhSachMon1);
    }//GEN-LAST:event_txtNhapTenMonKeyReleased

    private void txtNhapTenMonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNhapTenMonFocusLost
        // TODO add your handling code here:
        new mouseEvent().clear_text_exit(txtNhapTenMon, "Nhập tên món cần tìm");
    }//GEN-LAST:event_txtNhapTenMonFocusLost

    private void txtNhapTenMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapTenMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapTenMonActionPerformed

    private void txtNhapTenMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapTenMonMouseClicked
        // TODO add your handling code here:
        new mouseEvent().clear_text_click(txtNhapTenMon, "Nhập tên món cần tìm");
        try {
            Process proc = Runtime.getRuntime().exec("cmd /c osk");
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_txtNhapTenMonMouseClicked

    private void txtNhapTenMonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapTenMonMouseExited
        // TODO add your handling code here:
          new mouseEvent().clear_text_exit(txtNhapTenMon, "Nhập tên món cần tìm");
    }//GEN-LAST:event_txtNhapTenMonMouseExited

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        hd = new HoaDon();
        hd.setNgayTao(java.time.LocalDate.now().toString());
        hd.setMaNV(MANVLogin);
        hd.setMaBan(MABANKH);
        hd.setTongTien(tongTien);
        hd.setTrangThai("Chưa thanh toán");
        new HoaDonDAO().insert(hd);
        int mahd;
        //tiếp tục lấy hóa đơn với trạng thái chưa thanh toán và số bàn đúng với số bàn hiện tại
        hd1 = new HoaDonDAO().selectAllProcL2("Chưa thanh toán", MABANKH);

        if (MABANKH == 1) {
            DSCTHDKH.removeAll(DSCTHDKH);
        } else if (MABANKH == 2) {
            DSCTHDKH2.removeAll(DSCTHDKH2);
        } else if (MABANKH == 3) {
            DSCTHDKH3.removeAll(DSCTHDKH3);
        } else if (MABANKH == 4) {
            DSCTHDKH4.removeAll(DSCTHDKH4);
        } else if (MABANKH == 5) {
            DSCTHDKH5.removeAll(DSCTHDKH5);
        } else if (MABANKH == 6) {
            DSCTHDKH6.removeAll(DSCTHDKH6);
        } else if (MABANKH == 7) {
            DSCTHDKH7.removeAll(DSCTHDKH7);
        } else if (MABANKH == 8) {
            DSCTHDKH8.removeAll(DSCTHDKH8);
        } else if (MABANKH == 9) {
            DSCTHDKH9.removeAll(DSCTHDKH9);
        } else if (MABANKH == 10) {
            DSCTHDKH10.removeAll(DSCTHDKH10);
        } else if (MABANKH == 11) {
            DSCTHDKH11.removeAll(DSCTHDKH11);
        } else if (MABANKH == 12) {
            DSCTHDKH12.removeAll(DSCTHDKH12);
        } else if (MABANKH == 13) {
            DSCTHDKH13.removeAll(DSCTHDKH13);
        } else if (MABANKH == 14) {
            DSCTHDKH14.removeAll(DSCTHDKH14);
        }

        mahd = hd1.get(0).getMaHD();
        int maban = hd1.get(0).getMaBan();
        double tong = hd1.get(0).getTongTien();
        System.out.println(MABANKH);
        numbers.removeIf(t -> t.equals(MABANKH));
        System.out.println(numbers);
        System.out.println("Ma hoa don: " + mahd + ", ma ban : " + maban + ", tong tien: " + tong);

        //        int mahd;
        //        //tiếp tục lấy hóa đơn với trạng thái chưa thanh toán và số bàn đúng với số bàn hiện tại
        //        List<HoaDon> hd = new HoaDonDAO().selectAllProcL2("Chưa thanh toán", MABANKH);
        //        System.out.println("Ma hoa don: " + mahd + " ");
        //
        //        //thêm vào hóa đơn chi tiết
        HoaDon hdmoi = HDdao.selectById(mahd);
        //
        try {
            hdmoi.setTrangThai("Đã thanh toán");
            hdmoi.setTongTien(tong);
            HDdao.updateTT(hdmoi);
            MsgBox.alert(this, "Thanh toán thành công");

            reloadSodo(1);

        } catch (Exception e) {
            System.out.println("Thanh toán thất bại");
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void change() {
        for (int x : numbers) {
            switch (x) {
                case 1:
                    NV_SoDoBan.btnB01.setBackground(Color.green);
                    break;
                case 2:
                    NV_SoDoBan.btnB02.setBackground(Color.green);
                    break;
                case 3:
                    NV_SoDoBan.btnB03.setBackground(Color.green);
                    break;
                case 4:
                    NV_SoDoBan.btnB04.setBackground(Color.green);
                    break;
                case 5:
                    NV_SoDoBan.btnB05.setBackground(Color.green);
                    break;
                case 6:
                    NV_SoDoBan.btnB06.setBackground(Color.green);
                    break;
                case 7:
                    NV_SoDoBan.btnB07.setBackground(Color.green);
                    break;
                case 8:
                    NV_SoDoBan.btnB08.setBackground(Color.green);
                    break;
                case 9:
                    NV_SoDoBan.btnB09.setBackground(Color.green);
                    break;
                case 10:
                    NV_SoDoBan.btnB10.setBackground(Color.green);
                    break;
                case 11:
                    NV_SoDoBan.btnB11.setBackground(Color.green);
                    break;
                case 12:
                    NV_SoDoBan.btnB12.setBackground(Color.green);
                    break;
                case 13:
                    NV_SoDoBan.btnB13.setBackground(Color.green);
                    break;
                case 14:
                    NV_SoDoBan.btnB14.setBackground(Color.green);
                    break;
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        reloadSodo(1);

        Back();

    }//GEN-LAST:event_jButton1ActionPerformed
    public static void Back() {
        if (flag == true) {
            if (MABANKH == 1) {
                DSCTHDKH.removeAll(DSCTHDKH);
                DSCTHDKH.addAll(DuPhong1);
            } else if (MABANKH == 2) {
                DSCTHDKH2.removeAll(DSCTHDKH2);
                DSCTHDKH2.addAll(DuPhong1);
            } else if (MABANKH == 3) {
                DSCTHDKH3.removeAll(DSCTHDKH3);
                DSCTHDKH3.addAll(DuPhong1);
            } else if (MABANKH == 4) {
                DSCTHDKH4.removeAll(DSCTHDKH4);
                DSCTHDKH4.addAll(DuPhong1);
            } else if (MABANKH == 5) {
                DSCTHDKH5.removeAll(DSCTHDKH5);
                DSCTHDKH5.addAll(DuPhong1);
            } else if (MABANKH == 6) {
                DSCTHDKH6.removeAll(DSCTHDKH6);
                DSCTHDKH6.addAll(DuPhong1);
            } else if (MABANKH == 7) {
                DSCTHDKH7.removeAll(DSCTHDKH7);
                DSCTHDKH7.addAll(DuPhong1);
            } else if (MABANKH == 8) {
                DSCTHDKH8.removeAll(DSCTHDKH8);
                DSCTHDKH8.addAll(DuPhong1);
            } else if (MABANKH == 9) {
                DSCTHDKH9.removeAll(DSCTHDKH9);
                DSCTHDKH9.addAll(DuPhong1);
            } else if (MABANKH == 10) {
                DSCTHDKH10.removeAll(DSCTHDKH10);
                DSCTHDKH10.addAll(DuPhong1);
            } else if (MABANKH == 11) {
                DSCTHDKH11.removeAll(DSCTHDKH11);
                DSCTHDKH11.addAll(DuPhong1);
            } else if (MABANKH == 12) {
                DSCTHDKH12.removeAll(DSCTHDKH12);
                DSCTHDKH12.addAll(DuPhong1);
            } else if (MABANKH == 13) {
                DSCTHDKH13.removeAll(DSCTHDKH13);
                DSCTHDKH13.addAll(DuPhong1);
            } else if (MABANKH == 14) {
                DSCTHDKH14.removeAll(DSCTHDKH14);
                DSCTHDKH14.addAll(DuPhong1);
            }
        }
        flag = true;
    }
    private void btnDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatMonActionPerformed
        //         TODO add your handling code here:
        System.out.println(DSCTHDKH2);
        System.out.println(MABANKH);
        System.out.println(MANVLogin);
        System.out.println(tongTien);
        NVDao.selectById(MaNV);
        ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();

        isDatMon = false;
        //khi đặt món thì set lại nút

        //            btnDatMon.setText("CẬP NHẬT");
        //tạo hd mới và set dữ liệu cần thiết
        numbers.add(MABANKH);
        System.out.println(numbers);
        MsgBox.alert(this, "Đặt bàn thành công");
        isDatMon = true;
        flag = false;
    }//GEN-LAST:event_btnDatMonActionPerformed

    public void reloadSodo(int i) {

        JpnCenter.removeAll();
        tabs6.removeAll();
        jCroMonAn.removeAll();
        tblDSMonAn1.removeAll();
        switch (i) {
            case 1:
                NV_SoDoBan = new NV_SoDoBan();
                JpnCenter.setLayout(new BorderLayout());
                JpnCenter.add(NV_SoDoBan);
                change();
                break;
        }
        JpnCenter.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane DSMon;
    private javax.swing.JPanel DanhSachMon1;
    private javax.swing.JPanel JpnCenter;
    private javax.swing.JButton btnCua;
    private javax.swing.JButton btnDatMon;
    private javax.swing.JButton btnKhac;
    private javax.swing.JButton btnKhaivi;
    private javax.swing.JButton btnLau;
    private javax.swing.JButton btnMonAn;
    private javax.swing.JButton btnSashimi;
    private javax.swing.JButton btnSup;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThucUong;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jCroMonAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblSoBan;
    private javax.swing.JTabbedPane tabs6;
    public static javax.swing.JTable tblDSMonAn1;
    private javax.swing.JTextField txtNhapTenMon;
    private static javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
