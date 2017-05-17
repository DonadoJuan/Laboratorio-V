package com.example.juan.tplabv.menu;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.dao.BuffetMenuItemType;
import com.example.juan.tplabv.order.OrderActivity;
import com.example.juan.tplabv.util.BuffetUtil;

import static com.example.juan.tplabv.dao.BuffetMenuItemType.*;

import java.io.Serializable;
import java.util.List;

public class BuffetMenuController {

        private BuffetMenuView bmv;
        private BuffetMenuModel bmm;
        private BuffetMenuAdapter bfAdapter;

        public BuffetMenuController(BuffetMenuView bmv, BuffetMenuModel bmm){
            this.bmv = bmv;
            this.bmm = bmm;
            bmv.setBuffetMenuController(this);
        }

        public List<BuffetMenuItem> getBuffetMenuItemList(){
            return bmm.getBuffetMenuItemList(MAINCOURSE);
        }

        public void initRecyclerView(Activity act, RecyclerView rv){
            List<BuffetMenuItem> startList = bmm.getBuffetMenuItemList(MAINCOURSE);
            rv.setLayoutManager(new LinearLayoutManager(act));
            bfAdapter = new BuffetMenuAdapter(startList,act);
            bfAdapter.setSelectedItemListener(onSelectedItemChange);
            rv.setAdapter(bfAdapter);
        }

        private SelectedItemListener onSelectedItemChange = new SelectedItemListener() {
            @Override
            public void OnChange(){
                List<BuffetMenuItem> selectedItems = bfAdapter.getSelectedMenuItems();
                int totalSelected = selectedItems.size();
                bmv.getTotalselected().setText(String.valueOf(totalSelected));
                bmv.getTotalPrice().setText(String.valueOf(BuffetUtil.calculateTotalPrice(selectedItems)));
            }
        };


        public void onTabSelected(TabLayout.Tab tab ){
            switch(tab.getText().toString()) {
                case "drinks":
                    bfAdapter.setBfMenuList(bmm.getBuffetMenuItemList(DRINK));
                    break;

                case "main course":
                        bfAdapter.setBfMenuList(bmm.getBuffetMenuItemList(MAINCOURSE));
                    break;
                case "snacks":
                    bfAdapter.setBfMenuList(bmm.getBuffetMenuItemList(SNACK));
                    break;
            }
        }

        public void goMyResume(Activity act){
            List<BuffetMenuItem> selectedItemList = bfAdapter.getSelectedMenuItems();
            if(selectedItemList.size() == 0) {
                bmv.showNoItemSelectedError();
            }else{
                Intent intent = new Intent(act, OrderActivity.class);
                intent.putExtra("selectedItemList",(Serializable)selectedItemList);
                act.startActivity(intent);
            }
        }
}
