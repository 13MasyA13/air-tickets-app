package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.AbstractDAOFactory;
import ua.khai.golik.db.dao.SQLiteDAOFactory;
import ua.khai.golik.db.dao.UserDAO;

public class LoggingActivity extends AppCompatActivity {

    private static final String loggingActivity = "LoggingActivity";

    private DBHelper dbHelper;

    private EditText login,password;

    public static int userID = 0;
    public static String userFirstName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logging_activity);

        dbHelper = new DBHelper(this);
    }

    public void onLoginClick(View view){
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);

        String loginText = login.getText().toString();
        String passwordText = password.getText().toString();

        // Hardcode validation

        if(loginText == null || loginText.equals("")){
            Toast.makeText(LoggingActivity.this, "Login field is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passwordText == null || passwordText.equals("")){
            Toast.makeText(LoggingActivity.this, "Password field is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        AbstractDAOFactory abstractDAOFactory = new SQLiteDAOFactory();
        UserDAO userDAO = abstractDAOFactory.getUserDAO();

        boolean isExists = userDAO.loginUserByLogAndPass(dbHelper, loginText, passwordText);

        if(isExists == true){
            Toast.makeText(LoggingActivity.this, "Successfully logging! Welcome, " + loginText, Toast.LENGTH_SHORT).show();
            Intent personalArea = new Intent("personal.area");
            startActivity(personalArea);
        } else{
            Toast.makeText(LoggingActivity.this, "User with current inputed data hasn't exists, please try again", Toast.LENGTH_LONG).show();
        }

    }

    public void onRegisterClick(View view){
        Intent registrationActivity = new Intent("register");
        startActivity(registrationActivity);
    }

}
