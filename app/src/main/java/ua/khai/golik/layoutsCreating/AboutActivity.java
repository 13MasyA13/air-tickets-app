package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ua.golik.khai.air_tickets_app.R;

public class AboutActivity extends AppCompatActivity {

    private static final String aboutActivity = "AboutActivity";

    private TextView telegramLink, twitterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        telegramLink = findViewById(R.id.telegramLink);
        twitterLink = findViewById(R.id.twitterLink);
    }
}
