package com.example.juan.tplabv.util;

import com.example.juan.tplabv.dao.BuffetMenuItem;

import java.util.List;

public class BuffetUtil {

    public static Double calculateTotalPrice(List<BuffetMenuItem> bfMenuList){
        Double totalPrice = 0d;
        for (BuffetMenuItem item : bfMenuList){
            totalPrice += item.getPrice();
        }
        return Math.floor(totalPrice*100)/100;
    }
}
