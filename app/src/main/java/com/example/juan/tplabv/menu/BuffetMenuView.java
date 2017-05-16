package com.example.juan.tplabv.menu;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.juan.tplabv.R;

import org.w3c.dom.Text;

public class BuffetMenuView {

    private RecyclerView recView;
    private Activity act;
    private BuffetMenuController bmc;
    private Button myResume;
    private TabLayout menuTabs;
    private TextView totalSelected;
    private TextView totalPrice;

    public BuffetMenuView(Activity act){
        this.act = act;
        this.recView = (RecyclerView)act.findViewById(R.id.buffetmenu_menu_list);
        this.myResume = (Button) act.findViewById(R.id.buffetmenu_my_resume);
        this.menuTabs = (TabLayout)act.findViewById(R.id.buffetmenu_tabmenu);
        this.totalSelected = (TextView) act.findViewById(R.id.buffetmenu_total_selected);
        this.totalPrice = (TextView) act.findViewById(R.id.buffetmenu_total);
        menuTabs.addOnTabSelectedListener(tabListener);
    }

    private TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            bmc.onTabSelected(tab);
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) { /*do nothing*/ }
        @Override
        public void onTabReselected(TabLayout.Tab tab) { /*do nothing*/  }
    };

    private View.OnClickListener myResumeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bmc.goMyResume(act);
        }
    };

    public void setBuffetMenuController(BuffetMenuController bmcontroller){
        bmc = bmcontroller;
        bmc.initRecyclerView(act,recView);
    }

    public TextView getTotalselected() {
        return totalSelected;
    }

    public TextView getTotalPrice() {
        return totalPrice;
    }
}

