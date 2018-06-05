package ua.khai.golik.layoutsCreating;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.bl.interfaces.RegistrationValidator;
import ua.khai.golik.db.DBHelper;
import ua.khai.golik.db.dao.AbstractDAOFactory;
import ua.khai.golik.db.dao.SQLiteDAOFactory;
import ua.khai.golik.db.dao.UserDAO;
import ua.khai.golik.entities.User;

public class RegisterActivity extends AppCompatActivity implements RegistrationValidator {

    private static final String registerActivity = "RegisterActivity";

    private DBHelper dbHelper;

    private EditText fNameEditText, lNameEditText, loginEditText, passwordEditText,
    firstPhoneEditText, secondPhoneEditText, emailEditText;

    public static TextView dateTextView;

    public static String login, name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        dbHelper = new DBHelper(this);

        fNameEditText = findViewById(R.id.firstName);
        lNameEditText = findViewById(R.id.lastName);
        loginEditText = findViewById(R.id.login);
        passwordEditText = findViewById(R.id.password);
        firstPhoneEditText = findViewById(R.id.firstPhone);
        secondPhoneEditText = findViewById(R.id.secondPhone);
        emailEditText = findViewById(R.id.email);

        dateTextView = findViewById(R.id.birthdayLabel);
    }

    public void registrationOnClick(View view){
        String firstName = fNameEditText.getText().toString();
        String lastName = lNameEditText.getText().toString();
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String firstPhone = firstPhoneEditText.getText().toString();
        String secondPhone = secondPhoneEditText.getText().toString();
        String email = emailEditText.getText().toString();

        String[] validateValues = new String[]{firstName, lastName, login, password, firstPhone,
        secondPhone, email };

        int action = registrationValidator(validateValues);

        switch (action){
            case -1:
                Toast.makeText(RegisterActivity.this, "User with the same login is already exists!", Toast.LENGTH_LONG);
                break;
            case 0:
                User user = new User();

                user.setFirst_name(firstName);
                user.setLast_name(lastName);
                user.setLogin(login);
                user.setPassword(password);
                user.setFirst_phone_number(firstPhone);

                if(secondPhone.equals("") | secondPhone == null){
                    user.setSecond_phone_number("");
                } else{
                    user.setFirst_phone_number(secondPhone);
                }
                user.setEmail(email);

                AbstractDAOFactory daoFactory = new SQLiteDAOFactory();
                UserDAO userDAO = daoFactory.getUserDAO();
                boolean b = userDAO.insertNewUser(dbHelper, user);

                if(b == true){
                    Toast.makeText(RegisterActivity.this, "You are successfully registered! Please login into your account!", Toast.LENGTH_LONG);
                    Intent personalArea = new Intent(this, PersonalAreaActivity.class);
                    startActivity(personalArea);
                } else{
                    Toast.makeText(RegisterActivity.this, "App Fatal Error!!!!!!!!", Toast.LENGTH_LONG);
                }

                break;
            case 1:
                Toast.makeText(RegisterActivity.this, "First name is too longer then 20 characters!", Toast.LENGTH_LONG);
                break;
            case 2:
                Toast.makeText(RegisterActivity.this, "Last name is too longer then 20 characters!", Toast.LENGTH_LONG);
                break;
            case 3:
                Toast.makeText(RegisterActivity.this, "Login is too longer then 15 characters!", Toast.LENGTH_LONG);
                break;
            case 4:
                Toast.makeText(RegisterActivity.this, "Password is too longer then 10 characters!", Toast.LENGTH_LONG);
                break;
            case 5:
                Toast.makeText(RegisterActivity.this, "Invalid phone format!", Toast.LENGTH_LONG);
                break;
            case 6:
                Toast.makeText(RegisterActivity.this, "Invalid phone format!", Toast.LENGTH_LONG);
                break;
            case 7:
                Toast.makeText(RegisterActivity.this, "Email is too longer then 30 characters!", Toast.LENGTH_LONG);
                break;

        }
    }

    @Override
    public int registrationValidator(String[] values) {

        if(values[0].length() > 20){
            return 1;
        }

        if(values[1].length() > 20){
            return 2;
        }

        if(values[2].length() > 15){
            return 3;
        }

        if(values[3].length() > 10){
            return 4;
        }

        if(values[4].length() > 13 | values[4].length() == 0){
            return 5;
        }

        if(values[5].length() > 13){
            return 6;
        }

        if(values[6].length() > 30){
            return 7;
        }

        AbstractDAOFactory daoFactory = new SQLiteDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        boolean b = userDAO.checkForUniqueLogin(dbHelper, values[2]);

        if(b == false){
            return -1;
        }

        return 0;
    }
}
