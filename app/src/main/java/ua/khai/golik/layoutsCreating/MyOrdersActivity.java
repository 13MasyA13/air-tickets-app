package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.AbstractDAOFactory;
import ua.khai.golik.db.dao.SQLiteDAOFactory;
import ua.khai.golik.db.dao.UserDAO;
import ua.khai.golik.db.dao.UsersOrdersDAO;
import ua.khai.golik.entities.Order;

public class MyOrdersActivity extends AppCompatActivity {

    private static final String myOrdersActivity = "MyOrdersActivity";

    private ListView listView;

    private TextView defaultTextView1, defaultTextView2;

    private Button makeOrderButton;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_orders_activity);

        defaultTextView1 = findViewById(R.id.defTextView1);
        defaultTextView2 = findViewById(R.id.defTextView2);

        makeOrderButton = findViewById(R.id.areaMakeOrderButton);

        defaultTextView1.setVisibility(View.INVISIBLE);
        defaultTextView2.setVisibility(View.INVISIBLE);
        makeOrderButton.setVisibility(View.INVISIBLE);

        listView = findViewById(R.id.bookedTickets);

        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        // TODO when made Intent.putExtra()
        //Integer id = Integer.getInteger(userID);

        AbstractDAOFactory sqLiteDAOFactory = new SQLiteDAOFactory();
        UsersOrdersDAO usersOrdersDAO = sqLiteDAOFactory.getUsersOrdersDAO();

        List<Order> ordersList = usersOrdersDAO.getOrdersByUserID(dbHelper,1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_2, ordersList);
        listView.setAdapter(arrayAdapter);

        if(ordersList == null || ordersList.isEmpty() == true){
            listView.setVisibility(View.INVISIBLE);

            defaultTextView1.setVisibility(View.VISIBLE);
            defaultTextView2.setVisibility(View.VISIBLE);
            makeOrderButton.setVisibility(View.VISIBLE);
        }
    }
}
