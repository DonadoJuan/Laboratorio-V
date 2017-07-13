package com.example.juan.tplabv.order;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetMenuItem;

import java.util.List;

public class OrderModel {

    public void sendOrder(List<BuffetMenuItem> orderList,Context con){

        SharedPreferences shpf = con.getSharedPreferences("User", Context.MODE_PRIVATE);
        String email = shpf.getString("email","email@email.com");
        BuffetDAO.sendOrder(orderList,email);
    }

}
