package com.example.juan.tplabv.menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.dao.BuffetDAO;
import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.login.MainActivity;

import java.util.List;

public class BuffetMenuActivity extends AppCompatActivity {

    BuffetMenuModel bmm;
    BuffetMenuView bmv;
    BuffetMenuController bmc;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffet_menu);
        bmm = new BuffetMenuModel();
        bmv = new BuffetMenuView(this);
        bmc = new BuffetMenuController(bmv,bmm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.buffet_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.bar_logout) {
            SharedPreferences shpf = getSharedPreferences("User", MODE_PRIVATE);
            shpf.edit().clear().apply();
            startActivity(new Intent(this, MainActivity.class));
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            bmc.onOrderActivityFinished(resultCode,data);
    }
}
