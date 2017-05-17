package com.example.juan.tplabv.order;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juan.tplabv.R;

import org.w3c.dom.Text;

public class OrderView {

    private Activity act;
    private OrderController oc;
    private Button confirmOrder;
    private TextView totalPrice;
    private RecyclerView orderRecView;
    private View alertLayout;
    private TextView alertTotalPrice;
    private TextView alertSelected;

    public OrderView(Activity act){
        this.act = act;
        confirmOrder = (Button) act.findViewById(R.id.order_button_confirmorder);
        totalPrice = (TextView) act.findViewById(R.id.order_totalprice);
        orderRecView = (RecyclerView) act.findViewById(R.id.order_recview);
        alertLayout = act.getLayoutInflater().inflate(R.layout.dialog_alert, null);
        alertTotalPrice = (TextView) alertLayout.findViewById(R.id.order_alert_total_price);
        alertSelected = (TextView) alertLayout.findViewById(R.id.order_alert_total_selected);
        confirmOrder.setOnClickListener(confirmOrderListener);
    }

    public void setOrderController(OrderController oc){
        this.oc = oc;
        oc.initRecyclerView(orderRecView, act);
    }

    public TextView getTotalPrice(){ return totalPrice; }

    public Activity getActivity(){ return act; }

    public void showOrderDialog(String totalSelected, String totalPrice){
        alertSelected.setText(totalSelected);
        alertTotalPrice.setText(totalPrice);
        AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setView(alertLayout);
        builder.setCancelable(false);
        builder.setTitle(act.getString(R.string.confirmOrderSuccess));
        builder.setNeutralButton(
                act.getString(R.string.alertOk),
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                       oc.doFinishOrder(dialog,act);
                    }
                });
        AlertDialog alertD = builder.create();
        alertD.setCanceledOnTouchOutside(false);
        alertD.show();
    }

    public void showConfirmOrderError(){
        Toast.makeText(act,act.getString(R.string.confirmOrderError),Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener confirmOrderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            oc.doConfirmOrder();
        }
    };
}
