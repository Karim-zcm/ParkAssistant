package de.haw.hamburg.parkassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView username;
    TextView email;
    TextView password;
    TextView repeatPassword;

  //  Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (TextView) findViewById(R.id.editTextTextUsername);
        password = (TextView) findViewById(R.id.editTextTextPassword);
        repeatPassword = (TextView) findViewById(R.id.editTextTextRepeatPassword);
        email = (TextView) findViewById(R.id.editTextTextEmailAddress);
    }

    // Login --------------------------
    // Compare Login data
    public void loginButton(View view){
        if (email.getText().toString().equals("test@mail.de")) {
            Log.i("debugPrint", "correct Mail");
        } else Log.i("debugPrint", "incorrect Mail");

        if (password.getText().toString().equals("Pass")) {
            Log.i("debugPrint", "correct Password");
        } else Log.i("debugPrint", "incorrect Password");
    }
    // --------------------------------

    // Registration -------------------
    // Go to Registration page
    public void goToRegister(View view){ setContentView(R.layout.activity_register); }

    // Save data to database
    public void registerButton(View view){
        Database database = new Database(getApplicationContext());
        database.addUser(email.getText().toString(), password.getText().toString(), username.getText().toString());
    }
    // --------------------------------
}