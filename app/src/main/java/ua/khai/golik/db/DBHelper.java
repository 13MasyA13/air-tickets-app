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
    public static final String COUNT_OF_CHILDREN = "count_of_childs";
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

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATION OF USER_TABLE

        db.execSQL("CREATE TABLE " + USER_TABLE + "(" + USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + "," +
                USER_FIRST_NAME + "TEXT NOT NULL" + "," + USER_LAST_NAME + "TEXT NOT NULL" + "," +
                USER_LOGIN + "TEXT NOT NULL" + "," + USER_PASSWORD + "TEXT NOT NULL" + "," +
                USER_FIRST_PHONE_NUMBER + "TEXT NOT NULL" + "," + USER_SECOND_PHONE_NUMBER + "TEXT" + "," +
                USER_BIRTH_DATE + "TEXT NOT NULL" + "," + USER_EMAIL + "TEXT" + ")");

        // CREATION OF ORDERS_TABLE

        db.execSQL("CREATE TABLE " + ORDERS_TABLE + "(" + ORDER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + "," +
                FIRST_DATE + "TEXT NOT NULL" + "," + SECOND_DATE + "TEXT NOT NULL" + "," + FROM_PLACE + "TEXT NOT NULL " + "," +
                TO_PLACE + "TEXT NOT NULL" + "," + PRICE + "INTEGER NOT NULL" + "," + COUNT_OF_ADULTS + "INTEGER NOT NULL" + "," +
                COUNT_OF_CHILDREN + "INTEGER NOT NULL" + "," + CLASS_OF_SEATS + "INTEGER NOT NULL" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ORDERS_TABLE);
        onCreate(db);
    }
}
