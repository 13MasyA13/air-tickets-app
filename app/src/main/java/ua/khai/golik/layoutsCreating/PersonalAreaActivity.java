package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ua.golik.khai.air_tickets_app.R;

public class PersonalAreaActivity extends AppCompatActivity {

    private static final String personalAreaActivity = "PersonalAreaActivity";

    private TextView firstNameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_area_activity);

        firstNameLabel = findViewById(R.id.helloLabel);

        firstNameLabel.append(" " + RegisterActivity.name);
        System.out.println(RegisterActivity.login);
    }

    public void makeOrderActivityOnClick(View view){
        Intent makeOrderActivity = new Intent(PersonalAreaActivity.this, MakeOrderActivity.class);
        startActivity(makeOrderActivity);
    }

    public void myBookedTicketsActivityOnClick(View view){
        Intent myOrdersActivity = new Intent(PersonalAreaActivity.this, MyOrdersActivity.class);
        startActivity(myOrdersActivity);
    }

    public void helpActivityOnClick(View view){
        Intent helpActivity = new Intent(PersonalAreaActivity.this, HelpActivity.class);
        startActivity(helpActivity);
    }

    public void aboutActivityOnClick(View view){
        Intent aboutAcvitity = new Intent(PersonalAreaActivity.this, AboutActivity.class);
        startActivity(aboutAcvitity);
    }

}
