package com.example.juan.tplabv.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.dao.BuffetDAO;

public class BuffetMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffet_menu);

        BuffetMenuModel bmm = new BuffetMenuModel();
        BuffetMenuView bmv = new BuffetMenuView(this);
        BuffetMenuController bmc = new BuffetMenuController(bmv,bmm);
    }

}
