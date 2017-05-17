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
import com.example.juan.tplabv.login.MainActivity;

public class BuffetMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buffet_menu);
        BuffetMenuModel bmm = new BuffetMenuModel();
        BuffetMenuView bmv = new BuffetMenuView(this);
        BuffetMenuController bmc = new BuffetMenuController(bmv,bmm);
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
}
