package ua.khai.golik.layoutsCreating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import ua.golik.khai.air_tickets_app.R;

public class MainActivity extends AppCompatActivity {

    private static final String mainActivity = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void goButtonClick(View view){
        Intent loggingActivity = new Intent("main.logging");
        startActivity(loggingActivity);
    }

    // TODO method for execute secret menu for manage all data bases in the application

    // TextView accessText = findViewById(R.id.accessDBManagemant);
}
