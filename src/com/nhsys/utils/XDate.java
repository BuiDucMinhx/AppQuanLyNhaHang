/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huydu
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date toDate(String date, String pattern){
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String toString(String date, String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    public static Date addDays(Date date, long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
    public static String formatDate1(String date){
        
       String ar[] = date.split(" ")[0].split("-");
       date = ar[2]+"-"+ar[1]+"-"+ar[0];
        return date;
    }
}
