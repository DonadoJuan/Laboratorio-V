package com.example.juan.tplabv.order;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AdapterView;

import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.menu.BuffetMenuActivity;
import com.example.juan.tplabv.menu.SelectedItemListener;
import com.example.juan.tplabv.util.BuffetUtil;

import java.io.Serializable;
import java.util.List;


public class OrderController {

    private OrderView ov;
    private OrderModel om;
    private OrderAdapter orderAdapter;

    public OrderController(OrderView ov, OrderModel om) {
        this.ov = ov;
        this.om = om;
        this.ov.setOrderController(this);
    }

    public void initRecyclerView(RecyclerView rv, Activity act){

        rv.setLayoutManager(new LinearLayoutManager(act));
        orderAdapter = new OrderAdapter(BuffetUtil.getSharedSelectedItemList(),act);
        orderAdapter.setRemoveItemListener(removeItemListener);
        rv.setAdapter(orderAdapter);
        refreshTotalPrice();
    }

    public void doConfirmOrder(){
        if(orderAdapter.getOrderList().size() == 0)
            ov.showConfirmOrderError();
        else{
            String totalSelected = String.valueOf(orderAdapter.getItemCount());
            String totalPrice = ov.getTotalPrice().getText().toString();
            ov.showOrderDialog(totalSelected,totalPrice);
        }
    }

    public SelectedItemListener removeItemListener = new SelectedItemListener() {
        @Override
        public void OnChange() {
            refreshTotalPrice();
        }
    };

    public void doFinishOrder(DialogInterface alertD,Activity act){
        alertD.cancel();
        act.setResult(2);
        act.finish();
    }

    public void callBuffetMenuWithChangedData(Activity act){
       Intent i = new Intent(act, BuffetMenuActivity.class);
       BuffetUtil.setSharedSelectedItemList(orderAdapter.getOrderList());
        act.setResult(1,i);
        act.finish();
    }

    private void refreshTotalPrice(){
        Double dTotal = BuffetUtil.calculateTotalPrice(orderAdapter.getOrderList());
        ov.getTotalPrice().setText(String.valueOf(dTotal));
    }

}
