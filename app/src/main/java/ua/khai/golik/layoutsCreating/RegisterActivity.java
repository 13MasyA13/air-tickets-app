package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ua.golik.khai.air_tickets_app.R;

public class RegisterActivity extends AppCompatActivity {

    private static final String registerActivity = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
    }
}
