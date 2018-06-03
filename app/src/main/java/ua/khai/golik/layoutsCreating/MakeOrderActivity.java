package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import ua.golik.khai.air_tickets_app.R;

public class MakeOrderActivity extends AppCompatActivity {

    private static final String makeOrderActivity = "MakeOrderActivity";

    private SeekBar adultsSeekBar, childrenSeekBar;
    private TextView adultsBarValue, childrenBarValue, fromDateText, toDateText, priceValue;
    private Spinner fromPlaceSpinner, toPlaceSpinner;

    public int childrenBarCount, adultsBarCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order_activity);

        adultsBarValue = findViewById(R.id.adultsBarValue);
        childrenBarValue = findViewById(R.id.childrenBarValue);
        fromDateText = findViewById(R.id.firstDateLabel);
        toDateText = findViewById(R.id.secondDateLabel);
        priceValue = findViewById(R.id.priceLabel);

        adultsSeekBar = findViewById(R.id.adultsSeekBar);
        childrenSeekBar = findViewById(R.id.childrenSeekBar);

        fromPlaceSpinner = findViewById(R.id.fromSpinner);
        toPlaceSpinner = findViewById(R.id.toSpinner);

        adultsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                adultsBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                adultsBarCount = adultsSeekBar.getProgress();
            }
        });

        childrenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                childrenBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                childrenBarCount = childrenSeekBar.getProgress();
            }
        });
    }

    public void firstDateClick(View view){
        Intent firstDateActivity = new Intent("first.date");
        startActivity(firstDateActivity);
    }

    public void secondDateClick(View view){
        Intent firstDateActivity = new Intent("second.date");
        startActivity(firstDateActivity);
    }

    // TODO onMakeOrderClick()

    public void onMakeOrderClick(){
        String firstDateValue = fromDateText.getText().toString();
        String secondDateValue = toDateText.getText().toString();

        //String fromPlace = fromPlaceSpinner.get...
        //String toPlace = toPlaceSpinner.get...

        int adultsCount = adultsBarCount;
        int childrenCount = childrenBarCount;


    }
}
