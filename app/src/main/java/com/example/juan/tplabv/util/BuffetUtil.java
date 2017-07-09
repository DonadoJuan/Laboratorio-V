package com.example.juan.tplabv.util;

import android.util.Log;

import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.dao.BuffetUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BuffetUtil {

    public static Double calculateTotalPrice(List<BuffetMenuItem> bfMenuList){
        Double totalPrice = 0d;
        for (BuffetMenuItem item : bfMenuList){
            totalPrice += item.getPrice();
        }
        return Math.floor(totalPrice*100)/100;
    }

    public static JSONObject BuffetUserToJson(BuffetUser bfUser) throws JSONException{

        JSONObject bfUserParsed = new JSONObject();
        bfUserParsed.put("nombre", bfUser.getNombre());
        bfUserParsed.put("apellido", bfUser.getApellido());
        bfUserParsed.put("dni", Integer.parseInt(bfUser.getDni()));
        bfUserParsed.put("mail", bfUser.getMail());
        bfUserParsed.put("clave", bfUser.getPassword());
        return bfUserParsed;

    }
}
