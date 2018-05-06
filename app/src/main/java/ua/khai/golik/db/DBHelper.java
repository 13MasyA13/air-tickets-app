package ua.khai.golik.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import ua.khai.golik.db.interfaces.OrderDBOperations;
import ua.khai.golik.db.interfaces.UserDBOperations;
import ua.khai.golik.entities.Order;
import ua.khai.golik.entities.User;

public class DBHelper extends SQLiteOpenHelper implements UserDBOperations, OrderDBOperations{

    // Name of the DataBase

    public static final String DB_NAME = "air-app-db.db";

    // Name of the table 'users'

    public static final String USER_TABLE = "users";

    // Columns of the table 'users'

    public static final String USER_ID = "id";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FIRST_PHONE_NUMBER = "first_phone_number";
    public static final String USER_SECOND_PHONE_NUMBER = "second_phone_number";
    public static final String USER_EMAIL = "email";

    // Name of the table 'orders'

    public static final String ORDERS_TABLE = "orders";

    // Columns of the table 'orders'

    public static final String ORDER_ID = "id";
    public static final String FIRST_DATE = "first_date";
    public static final String SECOND_DATE = "second_date";
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String PRICE = "price";
    public static final String COUNT_OF_CHILDS = "count_of_childs";
    public static final String COUNT_OF_ADULTS = "count_of_adults";
    public static final String CLASS_OF_SEATS = "class_of_seats";

    // Name of the table 'users-orders'

    public static final String USERS_ORDERS_TABLE = "users_orders";

    // Columns of the table 'users-orders'

    public static final String USER_ID_USERS_ORDERS = "user_id";
    public static final String ORDER_ID_USERS_ORDERS = "order_id";

    public DBHelper(Context context){
        super(context, DB_NAME, null, 1 );
    }

    // DB lifecycle methods

    // TODO onCreate() DB

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    // TODO onUpgrade() DB

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // DB operations with orders

    // TODO DB operations with orders

    @Override
    public boolean insertNewOrder(Order order) {
        return false;
    }

    @Override
    public Order getOrderByID(int id) {
        return null;
    }

    @Override
    public boolean deleteOrderByID(int id) {
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    // DB operations with users

    // TODO DB operations with users

    @Override
    public boolean insertNewUser(User user) {
        return false;
    }

    @Override
    public User getUserByID(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
