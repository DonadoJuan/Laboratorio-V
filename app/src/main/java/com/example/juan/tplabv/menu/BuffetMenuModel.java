package com.example.juan.tplabv.menu;


import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.dao.BuffetMenuItemType;
import static com.example.juan.tplabv.dao.BuffetMenuItemType.*;

import java.util.ArrayList;
import java.util.List;

public class BuffetMenuModel {

    private BuffetDAO bfdao;
    private List<BuffetMenuItem> buffetMenuItemList;

    public BuffetMenuModel(){
        bfdao = new BuffetDAO();
        buffetMenuItemList = bfdao.getBuffetMenuItemList();
    }

    public List<BuffetMenuItem> getBuffetMenuItemList() {
        return buffetMenuItemList;
    }

    public List<BuffetMenuItem> getBuffetMenuItemList(BuffetMenuItemType type){
        List<BuffetMenuItem> filteredList = new ArrayList<>();
        for (BuffetMenuItem item : buffetMenuItemList ) {
            if(item.getBfiType() == type)
                filteredList.add(item);
        }
        return filteredList;
    }
}
