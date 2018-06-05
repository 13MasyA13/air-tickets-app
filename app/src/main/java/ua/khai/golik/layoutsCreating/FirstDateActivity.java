package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

import ua.golik.khai.air_tickets_app.R;

public class FirstDateActivity extends AppCompatActivity {

    private static final String firstDateActivity = "FirstDateActivity";

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_date_activity);

        calendarView = findViewById(R.id.firstDateCalendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int monthes = month + 1;
                String date = dayOfMonth + "/" + monthes + "/" + year;

                Log.d(firstDateActivity, date);

                MakeOrderActivity.fromDateText.setText(date);
                finish();
            }
        });
    }
}
