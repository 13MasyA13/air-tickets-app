package ua.khai.golik.layoutsCreating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ua.golik.khai.air_tickets_app.R;

public class MainActivity extends AppCompatActivity {

    private static final String mainActivity = "MainActivity";

    private TextView textView;
    private EditText secretEditText;
    private Button secretButton;

    private static int clickNum;

    private static final String secretKey = "h56z38a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        textView = findViewById(R.id.accessDBManagemant);
        secretEditText = findViewById(R.id.secretKeyEditText);
        secretButton = findViewById(R.id.secretButton);

        secretButton.setVisibility(View.INVISIBLE);
        secretEditText.setVisibility(View.INVISIBLE);

        clickNum = 0;
    }

    public void goButtonClick(View view){
        Intent loggingActivity = new Intent("main.logging");
        startActivity(loggingActivity);
    }

    public void secretButtonOnClick(View view){
        String alivalibleKey = secretEditText.getText().toString();
        if(alivalibleKey.equals(secretKey)){
            Toast.makeText(MainActivity.this, "Right secret key", Toast.LENGTH_LONG);
            clickNum = 0;
        } else{
            Toast.makeText(MainActivity.this, "Invalid secret key", Toast.LENGTH_LONG);
            clickNum = 0;
        }
    }

    public void accessDBManagementOnClick(View view){
        clickNum++;

        if(clickNum % 5 == 0){
            secretEditText.setVisibility(View.VISIBLE);
            secretButton.setVisibility(View.VISIBLE);
        }
    }
}
