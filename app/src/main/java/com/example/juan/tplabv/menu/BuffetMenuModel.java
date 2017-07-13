package com.example.juan.tplabv.menu;


import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.dao.BuffetMenuItemType;
import static com.example.juan.tplabv.dao.BuffetMenuItemType.*;

import java.util.ArrayList;
import java.util.List;

public class BuffetMenuModel {

    public BuffetMenuModel(){

    }

    public List<BuffetMenuItem> getBuffetMenuItemList() {
        return BuffetDAO.getBuffetMenuList();
    }

    public List<BuffetMenuItem> getBuffetMenuItemList(BuffetMenuItemType type){
        List<BuffetMenuItem> filteredList = new ArrayList<>();
        for (BuffetMenuItem item : BuffetDAO.getBuffetMenuList()) {
            if(item.getBfiType() == type)
                filteredList.add(item);
        }
        return filteredList;
    }
}
