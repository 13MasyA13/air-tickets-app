package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ua.golik.khai.air_tickets_app.R;

public class HelpActivity extends AppCompatActivity {

    private static final String helpActivity = "HelpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);
    }
}
