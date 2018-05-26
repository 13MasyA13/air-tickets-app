package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ua.golik.khai.air_tickets_app.R;

public class MyOrdersActivity extends AppCompatActivity {

    private static final String myOrdersActivity = "MyOrdersActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_orders_activity);
    }
}
