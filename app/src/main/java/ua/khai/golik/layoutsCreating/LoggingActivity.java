package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ua.golik.khai.air_tickets_app.R;

public class LoggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logging_activity);
    }

    public void onLoginClick(View view){
        // TODO method for clicking on login button
    }

    public void onRegisterClick(View view){
        // TODO method for clicking on register button
        Intent registerActivity = new Intent("register");
        startActivity(registerActivity);
    }
}
