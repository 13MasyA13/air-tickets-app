package ua.khai.golik.layoutsCreating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import ua.golik.khai.air_tickets_app.R;
import ua.khai.golik.bl.interfaces.Validators;
import ua.khai.golik.entities.User;

public class RegisterActivity extends AppCompatActivity implements Validators {

    private static final String registerActivity = "RegisterActivity";

    private EditText fNameEditText, lNameEditText, loginEditText, passwordEditText,
    firstPhoneEditText, secondPhoneEditText, emailEditText;
    private TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        fNameEditText = findViewById(R.id.firstName);
        lNameEditText = findViewById(R.id.lastName);
        loginEditText = findViewById(R.id.login);
        passwordEditText = findViewById(R.id.password);
        firstPhoneEditText = findViewById(R.id.firstPhone);
        secondPhoneEditText = findViewById(R.id.secondPhone);
        emailEditText = findViewById(R.id.email);

        dateTextView = findViewById(R.id.birthdayLabel);
    }

    public void registrationOnClick(){
        String firstName = fNameEditText.getText().toString();
        String lastName = lNameEditText.getText().toString();
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String firstPhone = firstPhoneEditText.getText().toString();
        String secondPhone = secondPhoneEditText.getText().toString();
        String dateOfBirthday = dateTextView.getText().toString();
        String email = emailEditText.getText().toString();

        String[] validateValues = new String[]{firstName, lastName, login, password, firstPhone,
        secondPhone, email };

        int action = registrationValidator(validateValues);

        switch (action){

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

        if(values[2].length() > 10){
            return 3;
        }

        if(values[3].length() > 10){
            return 4;
        }

        if(values[4].length() > 13){
            return 5;
        }

        if(values[5].length() > 13){
            return 6;
        }

        if(values[6].length() > 30){
            return 7;
        }

        // TODO check is login unique

        return 0;
    }
}
