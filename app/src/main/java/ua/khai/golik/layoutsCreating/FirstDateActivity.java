package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth + 1) + "/" + month + "/" + year;
                Log.d(firstDateActivity, date);

                Intent intent = new Intent(FirstDateActivity.this, MakeOrderActivity.class);
                intent.putExtra("firstDate", date);
                startActivity(intent);
            }
        });
    }
}
