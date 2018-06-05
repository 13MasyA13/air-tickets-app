package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.bl.BusinessLogic;
import ua.khai.golik.bl.interfaces.MakeOrderValidation;
import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.AbstractDAOFactory;
import ua.khai.golik.db.dao.OrderDAO;
import ua.khai.golik.db.dao.SQLiteDAOFactory;
import ua.khai.golik.entities.Order;

public class MakeOrderActivity extends AppCompatActivity implements MakeOrderValidation{

    private static final String makeOrderActivity = "MakeOrderActivity";

    private SeekBar adultsSeekBar, childrenSeekBar;
    private TextView adultsBarValue, childrenBarValue, priceValue;
    private Spinner fromPlaceSpinner, toPlaceSpinner;
    private RadioButton economClass;

    public static TextView fromDateText, toDateText;

    public int childrenBarCount, adultsBarCount;

    private Order order = new Order();

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order_activity);

        dbHelper = new DBHelper(this);

        adultsBarValue = findViewById(R.id.adultsBarValue);
        childrenBarValue = findViewById(R.id.childrenBarValue);
        fromDateText = findViewById(R.id.firstDateLabel);
        toDateText = findViewById(R.id.secondDateLabel);
        priceValue = findViewById(R.id.priceLabel);

        adultsSeekBar = findViewById(R.id.adultsSeekBar);
        childrenSeekBar = findViewById(R.id.childrenSeekBar);

        fromPlaceSpinner = findViewById(R.id.fromSpinner);
        toPlaceSpinner = findViewById(R.id.toSpinner);

        economClass = findViewById(R.id.economClassRadioButton);

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

    public void onMakeOrderClick(View view){
        BusinessLogic businessLogic = new BusinessLogic();
        Intent currentIntent = getIntent();

        // TODO getting user_id
        //int user_id = currentInten.getIntExtra();

        String firstDateValue = fromDateText.getText().toString();
        String secondDateValue = toDateText.getText().toString();

        String fromPlace = fromPlaceSpinner.getSelectedItem().toString();
        String toPlace = toPlaceSpinner.getSelectedItem().toString();

        int adultsCount = adultsBarCount;
        int childrenCount = childrenBarCount;

        boolean isBusinessClass;

        if(economClass.isChecked() == true){
            isBusinessClass = false;
        } else{
            isBusinessClass = true;
        }

        order.setFirst_date(firstDateValue);
        order.setSecond_date(secondDateValue);
        order.setFrom_place(fromPlace);
        order.setTo_place(toPlace);
        order.setCount_of_adults(adultsCount);
        order.setCount_of_children(childrenCount);
        order.setCount_of_seats(childrenCount + adultsCount);
        order.setBusinessClass(isBusinessClass);

        int validationResult = makeOrderValidation(order);

        switch (validationResult){
            case 0:
                order.setPrice(businessLogic.countPrice(order));
                priceValue.setText(Double.toString(order.getPrice()));
                break;
            case 1:
                Toast.makeText(this,"You should choose first date!", Toast.LENGTH_LONG);
                break;
            case 2:
                Toast.makeText(this,"You should choose second date!", Toast.LENGTH_LONG);
                break;
            case 3:
                Toast.makeText(this,"Children count & adults count can't be = 0!", Toast.LENGTH_LONG);
                break;

        }

    }

    public void onConfirmMakeOrderClick(View view){
        AbstractDAOFactory sqLiteDAOFactory = new SQLiteDAOFactory();
        OrderDAO orderDAO = sqLiteDAOFactory.getOrderDAO();

        orderDAO.insertNewOrder(dbHelper, order, 1);

        Toast.makeText(this, "You are successfully make order!", Toast.LENGTH_SHORT);
        Toast.makeText(this, "You can check it out by tap on 'My Booked Tickets' button", Toast.LENGTH_SHORT);

        finish();
    }

    @Override
    public int makeOrderValidation(Order order) {
        int childrenCount = order.getCount_of_children();
        int adultsCount = order.getCount_of_adults();

        String firstDate = order.getFirst_date();
        String secondDate = order.getSecond_date();

        if(firstDate.equals("First Date")){
            return 1;
        }

        if(secondDate.equals("Second Date")){
            return 2;
        }

        if(childrenCount == 0 & adultsCount == 0){
            return 3;
        }

        return 0;
    }
}
