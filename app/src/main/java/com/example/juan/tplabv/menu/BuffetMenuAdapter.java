package com.example.juan.tplabv.menu;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juan.tplabv.R;
import com.example.juan.tplabv.dao.BuffetMenuItem;

import java.util.ArrayList;
import java.util.List;

public class BuffetMenuAdapter extends RecyclerView.Adapter<BuffetMenuAdapter.BuffetMenuHolder> {

    private List<BuffetMenuItem> bfMenuList;
    private List<BuffetMenuItem> selectedMenuItems;
    private LayoutInflater inflater;
    private SelectedItemListener listener;

    public BuffetMenuAdapter(List<BuffetMenuItem> bfMenuList, Context c){
        inflater = LayoutInflater.from(c);
        this.bfMenuList = new ArrayList<>();
        this.bfMenuList.addAll(bfMenuList);
        this.selectedMenuItems = new ArrayList<>();
    }

    @Override
    public BuffetMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.buffet_menu_item, parent, false);
        return new BuffetMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(BuffetMenuHolder holder, int position) {
        BuffetMenuItem item = bfMenuList.get(position);
        holder.setViewHolderData(item);
    }

    @Override
    public int getItemCount() {
        return bfMenuList.size();
    }



    public void setBfMenuList(List<BuffetMenuItem> updatedList){
        bfMenuList.clear();
        bfMenuList.addAll(updatedList);
        notifyDataSetChanged();
    }

    public List<BuffetMenuItem> getSelectedMenuItems(){ return selectedMenuItems;}

    public void setSelectedItemListener(SelectedItemListener sil){ listener = sil;}



    class BuffetMenuHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title;
        private TextView price;
        private BuffetMenuItem menuItem;
        private View container;

        public BuffetMenuHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.buffetmenu_item_title);
            price = (TextView)itemView.findViewById(R.id.buffetmenu_item_price);
            container = itemView.findViewById(R.id.buffetmenu_root_id);
            container.findViewById(R.id.buffetmenu_item_add).setOnClickListener(this);
        }

        private void setViewHolderData(BuffetMenuItem menuItem){
            this.menuItem = menuItem;
            title.setText(menuItem.getName());
            price.setText(menuItem.getPrice().toString());
            if(selectedMenuItems.contains(menuItem))
                container.setBackgroundColor(Color.GRAY);
            else
                container.setBackgroundColor(Color.TRANSPARENT);
        }

        @Override
        public void onClick(View v) {
                if(!selectedMenuItems.contains(menuItem)){
                    selectedMenuItems.add(menuItem);
                    container.setBackgroundColor(Color.GRAY);
                }else{
                    selectedMenuItems.remove(menuItem);
                    container.setBackgroundColor(Color.TRANSPARENT);
                }
                listener.OnChange();
        }
    }
}
