package ua.khai.golik.layoutsCreating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ua.golik.khai.air_tickets_app.R;

public class MainActivity extends AppCompatActivity {

    private static final String mainActivity = "MainActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        textView = findViewById(R.id.accessDBManagemant);
    }

    public void goButtonClick(View view){
        Intent loggingActivity = new Intent("main.logging");
        startActivity(loggingActivity);
    }
}
