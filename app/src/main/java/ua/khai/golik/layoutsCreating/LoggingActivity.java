package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.db.DBHelper;
import ua.khai.golik.entities.User;

public class LoggingActivity extends AppCompatActivity {

    // Secret password to access activity for managing all db in the application

    private static final String SECRET_KEY = "xH7238t";

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logging_activity);
    }

    public void onLoginClick(View view){

        User user = null;
        user = DBHelper

        Intent personalArea = new Intent("personal-area");
        startActivity(personalArea);
    }

    public void onRegisterClick(View view){
        Intent makeOrderActivity = new Intent("makeOrder");
        startActivity(makeOrderActivity);
    }

}
