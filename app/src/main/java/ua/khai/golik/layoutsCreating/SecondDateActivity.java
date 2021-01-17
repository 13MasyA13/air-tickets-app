package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

import ua.golik.khai.air_tickets_app.R;

public class SecondDateActivity extends AppCompatActivity {

    private static final String secondDateActivity = "Second Date Activity";

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_date_activity);

        calendarView = findViewById(R.id.secondDateCalendar);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int months = month + 1;

                String date = dayOfMonth + "/" + months + "/" + year;

                Log.d(secondDateActivity, date.toString());
                MakeOrderActivity.toDateText.setText(date);
                finish();
            }
        });
    }
}
