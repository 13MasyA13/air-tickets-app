package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

import ua.golik.khai.air_tickets_app.R;

public class SelectBirthdayActitity extends AppCompatActivity {

    private static final String selectBirthdayActivity = "Birthday Activity";

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_birthday_activity);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth + 1) + "/" + month + "/" + year;
                Log.d(selectBirthdayActivity, date);

                Intent intent = new Intent(SelectBirthdayActitity.this, RegisterActivity.class);
                intent.putExtra("birthdayDate", date);
                startActivity(intent);
            }
        });
    }
}
