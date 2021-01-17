package ua.khai.golik.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.entities.Order;

public class OrderAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Order> orders;

    public OrderAdapter(Context context, ArrayList<Order> ordersList) {
        ctx = context;
        orders = ordersList;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = lInflater.inflate(R.layout.order, parent, false);
        }

        Order order = getOrder(position);

        TextView firstPlaceText = view.findViewById(R.id.firstPlaceText);
        TextView secondPlaceText = view.findViewById(R.id.secondPlaceText);
        TextView firstDate = view.findViewById(R.id.arrivalDateText);
        TextView secondDate = view.findViewById(R.id.backDateText);
        TextView adultsCount = view.findViewById(R.id.adultsCountText);
        TextView childrenCount = view.findViewById(R.id.childrenCountText);
        TextView price = view.findViewById(R.id.priceText);

        firstPlaceText.setText(order.getFrom_place());
        secondPlaceText.setText(order.getTo_place());
        firstDate.setText(order.getFirst_date());
        secondDate.setText(order.getSecond_date());
        adultsCount.append(String.valueOf(order.getCount_of_adults()));
        childrenCount.append(String.valueOf(order.getCount_of_children()));
        price.append(String.valueOf(order.getPrice()));

        return view;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    Order getOrder(int pos){
        return ((Order) getItem(pos));
    }
}
