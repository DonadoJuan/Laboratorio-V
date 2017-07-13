package com.example.juan.tplabv.util;

import android.util.Log;

import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.dao.BuffetMenuItemType;
import com.example.juan.tplabv.dao.BuffetUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BuffetUtil {

    private static List<BuffetMenuItem> sharedSelectedItemList = new ArrayList<>();

    public static List<BuffetMenuItem> getSharedSelectedItemList(){ return sharedSelectedItemList;}

    public static void clearSelectedItemList(){
        sharedSelectedItemList.clear();
    }

    public static void setSharedSelectedItemList(List<BuffetMenuItem> newList){
        sharedSelectedItemList.clear();
        sharedSelectedItemList.addAll(newList);
    }
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

    public static List<BuffetMenuItem> JSONArrayToBuffetMenuList(JSONArray ja) throws JSONException{

        List<BuffetMenuItem> parsedBuffetMenuList = new ArrayList<>();

        for (int i = 0; i < ja.length(); i++) {

            JSONObject joItem = ja.getJSONObject(i);
            String name = joItem.getString("nombre");
            Double price = joItem.getDouble("precio");
            String imgUrl = joItem.getString("imagen");
            BuffetMenuItemType itemType = null;

            switch (joItem.getString("tipoMenu")){
                case "Principal": itemType = BuffetMenuItemType.MAINCOURSE;
                    break;
                case "Snack": itemType = BuffetMenuItemType.SNACK;
                    break;
                case "Bebida": itemType = BuffetMenuItemType.DRINK;
            }
            parsedBuffetMenuList.add(new BuffetMenuItem(name,price,itemType,imgUrl));
        }

        return parsedBuffetMenuList;
    }

    public static JSONObject BuffetMenuListToJSON(List<BuffetMenuItem> buffetMenuList,String user) throws JSONException{

        JSONObject parsedOrder = new JSONObject();
        JSONArray parsedBuffetMenuList = new JSONArray();
        parsedOrder.put("usuario",user);

        for (BuffetMenuItem bmi: buffetMenuList) {

            JSONObject orderItem = new JSONObject();
            orderItem.put("nombre",bmi.getName());
            orderItem.put("precio",bmi.getPrice());
            orderItem.put("imagen",bmi.getImgUrl());

            switch (bmi.getBfiType()){
                case MAINCOURSE: orderItem.put("tipoMenu","principal");
                    break;
                case SNACK: orderItem.put("tipoMenu","Snack");
                    break;
                case DRINK: orderItem.put("tipoMenu","Bebida");
                    break;
            }
            parsedBuffetMenuList.put(orderItem);
        }
        parsedOrder.put("pedido",parsedBuffetMenuList);
        return parsedOrder;

    }
}
