package com.nhsys.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class XImage {
    /**
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/com/nhsys");
        return new ImageIcon(url).getImage();
    }
    
    /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */   
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon read(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static void setHinh(Object cpn, String path, int w, int h) {
        if (cpn.getClass().toString().equalsIgnoreCase("class javax.swing.JLabel")) {
            JLabel lbl = (JLabel) cpn;
            ImageIcon icon = new ImageIcon(path);
            Image im = icon.getImage();
            ImageIcon iconn = new ImageIcon(im.getScaledInstance(w, h, im.SCALE_SMOOTH));
            lbl.setIcon(iconn);
        } else if (cpn.getClass().toString().equalsIgnoreCase("class javax.swing.JButton")) {
            JButton btn = (JButton) cpn;
            ImageIcon icon = new ImageIcon(path);
            Image im = icon.getImage();
            ImageIcon iconn = new ImageIcon(im.getScaledInstance(w, h, im.SCALE_SMOOTH));
            btn.setIcon(iconn);
        }
    }
}