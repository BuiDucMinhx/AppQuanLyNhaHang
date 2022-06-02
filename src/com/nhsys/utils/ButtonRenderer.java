/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hai Tran
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
    String path;
    public ButtonRenderer() {
        setOpaque(true);
        path = "src\\icon\\Delete.png";
    }
    public ButtonRenderer(String path) {
        setOpaque(true);
        // ở đây lấy đường dẫn ảnh nè
        this.path = path;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setBackground(new Color(240,240,240));
        } else {
            setBackground(new Color(240,240,240));
        }
        //set đè icon luôn cho tiện
        setIcon(new ImageIcon(path));
        return this;
    }
}
