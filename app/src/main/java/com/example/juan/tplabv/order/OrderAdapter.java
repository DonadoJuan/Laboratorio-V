package com.example.juan.tplabv.order;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.dao.BuffetMenuItem;
import com.example.juan.tplabv.menu.SelectedItemListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    private List<BuffetMenuItem> orderList;
    private LayoutInflater inflater;
    private SelectedItemListener removeItemListener;

    public OrderAdapter(List<BuffetMenuItem> bfMenuList, Context c){
        inflater = LayoutInflater.from(c);
        this.orderList = new ArrayList<>();
        this.orderList.addAll(bfMenuList);
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.buffet_menu_item, parent, false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {
        BuffetMenuItem item = orderList.get(position);
        holder.title.setText(item.getName());
        holder.price.setText(item.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public List<BuffetMenuItem> getOrderList(){
        return Collections.unmodifiableList(orderList);
    }

    public void setRemoveItemListener(SelectedItemListener ril){
        removeItemListener = ril;
    }

    class OrderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private TextView price;
        private View container;
        private Button remove;

        public OrderHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.buffetmenu_item_title);
            price = (TextView)itemView.findViewById(R.id.buffetmenu_item_price);
            container = itemView.findViewById(R.id.buffetmenu_root_id);
            remove = (Button) container.findViewById(R.id.buffetmenu_item_add);
            remove.setOnClickListener(this);
            remove.setText("X");
            remove.setBackgroundColor(Color.RED);
            remove.setTextColor(Color.WHITE);
        }

        @Override
        public void onClick(View v) {
            orderList.remove(getLayoutPosition());
            notifyDataSetChanged();
            removeItemListener.OnChange();
        }
    }
}