package com.example.juan.tplabv.dao;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;

public class BuffetDAO {


    private static HashSet<BuffetUser> buffetUserList;
    private static ArrayList<BuffetMenuItem> buffetMenuItemList;
    public BuffetDAO(){
        buffetUserList = new HashSet<>();
        buffetUserList.add(new BuffetUser("juan","donado","38613611","donado@donado.com","123"));

        buffetMenuItemList = new ArrayList<>();
        buffetMenuItemList.add(new BuffetMenuItem("Cocola",40.20,BuffetMenuItemType.DRINK));
        buffetMenuItemList.add(new BuffetMenuItem("Manaos",22.20,BuffetMenuItemType.DRINK));
        buffetMenuItemList.add(new BuffetMenuItem("Pesi",34.60,BuffetMenuItemType.DRINK));
        buffetMenuItemList.add(new BuffetMenuItem("Pancho",20d,BuffetMenuItemType.MAINCOURSE));
        buffetMenuItemList.add(new BuffetMenuItem("Pizza",30d,BuffetMenuItemType.MAINCOURSE));
        buffetMenuItemList.add(new BuffetMenuItem("Hamburguesa",50d,BuffetMenuItemType.MAINCOURSE));
        buffetMenuItemList.add(new BuffetMenuItem("Barrita cereal",15d,BuffetMenuItemType.SNACK));
        buffetMenuItemList.add(new BuffetMenuItem("Saladix",35d,BuffetMenuItemType.SNACK));
        buffetMenuItemList.add(new BuffetMenuItem("Cheetos",40.20,BuffetMenuItemType.SNACK));
    }

    public BuffetUser isBuffetUser(String email, String password){

        for (BuffetUser user: buffetUserList) {
            if(user.getMail().equals(email) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public boolean isBuffetUser(BuffetUser newuser){

        for (BuffetUser user: buffetUserList) {
            if(user.getMail().equals(newuser.getMail()))
                return true;
            if(user.getDni().equals(newuser.getDni()))
                return true;
        }

        return false;
    }

    public boolean insertBuffetUser(BuffetUser newUser){
        if(isBuffetUser(newUser))
            return false;
        else
            return buffetUserList.add(newUser);
    }

    public ArrayList<BuffetMenuItem> getBuffetMenuItemList(){
        return buffetMenuItemList;
    }
}
