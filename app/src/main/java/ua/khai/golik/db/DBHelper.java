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
    public static final String USER_EMAIL = "email";

    // Name of the table 'orders'

    public static final String ORDERS_TABLE = "orders";

    // Columns of the table 'orders'

    public static final String ORDER_ID = "id";
    public static final String USER_ID_IN_ORDER = "user_id";
    public static final String FIRST_DATE = "first_date";
    public static final String SECOND_DATE = "second_date";
    public static final String FROM_PLACE = "from_place";
    public static final String TO_PLACE = "to_place";
    public static final String PRICE = "price";
    public static final String COUNT_OF_CHILDREN = "count_of_children";
    public static final String COUNT_OF_ADULTS = "count_of_adults";
    public static final String COUNT_OF_SEATS = "count_of_seats";

    public DBHelper(Context context){
        super(context, DB_NAME, null, 34);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATION OF USER_TABLE

        db.execSQL("CREATE TABLE 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT,'first_name' TEXT NOT NULL, " +
                "'last_name' TEXT NOT NULL, 'login' TEXT NOT NULL, 'password' TEXT NOT NULL, 'first_phone_number' TEXT NOT NULL, " +
                "'second_phone_number' TEXT, 'email' TEXT NOT NULL)");

        // CREATION OF ORDERS_TABLE

        db.execSQL("CREATE TABLE 'orders' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'user_id' INTEGER NOT NULL, " +
                "'first_date' TEXT NOT NULL, 'second_date' TEXT NOT NULL, " + "'from_place' TEXT NOT NULL, 'to_place' TEXT NOT NULL, " +
                "'price' INTEGER NOT NULL, 'count_of_adults' INTEGER NOT NULL, " +
                "'count_of_children' INTEGER NOT NULL, 'count_of_seats' INTEGER NOT NULL)");

        // CREATION OF DEFAULT USER

        db.execSQL("INSERT INTO users ( " + DBHelper.USER_FIRST_NAME + " , " + DBHelper.USER_LAST_NAME + " , " +
                DBHelper.USER_LOGIN + " , " + DBHelper.USER_PASSWORD + " , " + DBHelper.USER_FIRST_PHONE_NUMBER + " , " +
                DBHelper.USER_SECOND_PHONE_NUMBER + " , " + DBHelper.USER_EMAIL + " ) " +
                " VALUES ('John', 'Burn', 'test', '123', '00000', '00000', 'jb@test.com')");

        // CREATION OF DEFAULT USER'S ORDER

        db.execSQL("INSERT INTO orders ( " + DBHelper.USER_ID_IN_ORDER + " , " + DBHelper.FIRST_DATE + " , " + DBHelper.SECOND_DATE + " , " +
                DBHelper.FROM_PLACE + " , " + DBHelper.TO_PLACE + " , " + DBHelper.PRICE + " , " +
                DBHelper.COUNT_OF_CHILDREN + " , " + DBHelper.COUNT_OF_ADULTS + " , " + DBHelper.COUNT_OF_SEATS + " ) " +
                " VALUES (1, '25/06/2018', '31/07/2018', 'Kharkiv', 'Sharm El Sheikh', 500, 2, 0, 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ORDERS_TABLE);
        onCreate(db);
    }
}
