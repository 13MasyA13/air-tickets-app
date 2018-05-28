package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import ua.golik.khai.air_tickets_app.R;

public class SelectBirthdayActitity extends AppCompatActivity {

    private static final String selectBirthdayActivity = "Birthday Activity";

    private CalendarView birthdayCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_birthday_activity);

        birthdayCalendar = findViewById(R.id.birthdayCalendar);

        birthdayCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                Log.d(selectBirthdayActivity, date);
                RegisterActivity.dateTextView.setText(date);
            }
        });
    }

    public void onConfirmOnClick(View view){
        this.finish();
    }
}
