package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ua.golik.khai.air_tickets_app.R;

public class LoggingActivity extends AppCompatActivity {

    // Secret password to access activity for managing all db in the application

    private static final String SECRET_KEY = "xH7238t";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logging_activity);
    }

    public void onLoginClick(View view){
        Intent personalArea = new Intent("personal-area");
        startActivity(personalArea);
    }

    public void onRegisterClick(View view){
        Intent registerActivity = new Intent("register");
        startActivity(registerActivity);
    }

    // TODO method for execute secret menu for manage all data bases in the application
}
