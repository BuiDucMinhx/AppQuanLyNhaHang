package com.nhsys.utils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class mouseEvent {
    public void clear_text_click(JTextField txt, String text){
        if(txt.getText().equalsIgnoreCase(text)){
            txt.setText("");
        }  
    }
    public void clear_text_exit(JTextField txt, String text){
        if(txt.getText().equalsIgnoreCase("")){
            txt.setText(text);
        } 
    }
    
    public void setCenterTabel(JTable tb){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tb.setDefaultRenderer(String.class, centerRenderer);
    }
    
}
