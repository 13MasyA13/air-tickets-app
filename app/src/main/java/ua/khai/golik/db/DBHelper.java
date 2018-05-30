package ua.khai.golik.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

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
    public static final String USER_BIRTH_DATE = "user_birth_date";
    public static final String USER_EMAIL = "email";

    // Name of the table 'orders'

    public static final String ORDERS_TABLE = "orders";

    // Columns of the table 'orders'

    public static final String ORDER_ID = "id";
    public static final String FIRST_DATE = "first_date";
    public static final String SECOND_DATE = "second_date";
    public static final String FROM_PLACE = "from_place";
    public static final String TO_PLACE = "to_place";
    public static final String PRICE = "price";
    public static final String COUNT_OF_CHILDREN = "count_of_children";
    public static final String COUNT_OF_ADULTS = "count_of_adults";
    public static final String COUNT_OF_SEATS = "count_of_seats";

    public DBHelper(Context context){
        super(context, DB_NAME, null, 18);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATION OF USER_TABLE

        db.execSQL("CREATE TABLE 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'first_name' TEXT NOT NULL, " +
                "'last_name' TEXT NOT NULL, 'login' TEXT NOT NULL, 'password' TEXT NOT NULL, 'first_phone_number' TEXT NOT NULL, " +
                "'second_phone_number' TEXT, 'user_birth_date' TEXT NOT NULL, 'email' TEXT NOT NULL)");

        // CREATION OF ORDERS_TABLE

        db.execSQL("CREATE TABLE 'orders' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'first_date' TEXT NOT NULL, 'second date' TEXT NOT NULL, " +
                "'from_place' TEXT NOT NULL, 'to_place' TEXT NOT NULL, 'price' INTEGER NOT NULL, 'count_of_adults' INTEGER NOT NULL, " +
                "'count_of_children' INTEGER NOT NULL, 'count_of_seats' INTEGER NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ORDERS_TABLE);
        onCreate(db);
    }
}
