package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth + 1) + "/" + month + "/" + year;
                Log.d(secondDateActivity, date);

                Intent intent = new Intent(SecondDateActivity.this, MakeOrderActivity.class);
                intent.putExtra("secondDate", date);
                startActivity(intent);
            }
        });
    }
}
