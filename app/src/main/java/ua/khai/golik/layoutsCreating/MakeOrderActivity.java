package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ua.golik.khai.air_tickets_app.R;

public class MakeOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order_activity);
    }

    public void firstDateClick(View view){
        Intent firstDateActivity = new Intent("first.date");
        startActivity(firstDateActivity);
    }

    public void secondDateClick(View view){
        Intent firstDateActivity = new Intent("second.date");
        startActivity(firstDateActivity);
    }

    // TODO onMakeOrderClick()

    public void onMakeOrderClick(){

    }
}
