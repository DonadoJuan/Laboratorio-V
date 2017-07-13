package com.example.juan.tplabv.order;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.login.MainActivity;

public class OrderActivity extends AppCompatActivity {

    private OrderModel om;
    private OrderView ov;
    private OrderController oc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        om = new OrderModel();
        ov = new OrderView(this);
        oc = new OrderController(ov,om);
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
    public void onBackPressed(){
        oc.callBuffetMenuWithChangedData(this);
        super.onBackPressed();
    }
}
