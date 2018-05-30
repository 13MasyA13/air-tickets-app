package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        firstNameLabel.append(RegisterActivity.name);
        System.out.println(RegisterActivity.login);
    }
}
