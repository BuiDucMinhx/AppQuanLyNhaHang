/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhsys.utils;

import java.text.DecimalFormat;

/**
 *
 * @author anhha
 */
public class XNumber {
    private static DecimalFormat formatter = new DecimalFormat();
    
    public static Double convertToDouble (String numberStr, String pattern) {
        try {
            formatter.applyPattern(pattern);
            return formatter.parse(numberStr).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public static String convertToString (Double number, String pattern) {
        try {
            formatter.applyPattern(pattern);
            return formatter.format(number);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
