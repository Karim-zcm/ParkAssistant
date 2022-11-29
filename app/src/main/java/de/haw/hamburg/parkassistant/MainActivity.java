package de.haw.hamburg.parkassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView email;
    TextView password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextView) findViewById(R.id.editTextTextEmailAddress);
        password = (TextView) findViewById(R.id.editTextTextPassword);
    }

    public void loginButton(View view){
        if (email.getText().toString().equals("test@mail.de")) {
            Log.i("debugPrint", "correct Mail");
        } else Log.i("debugPrint", "incorrect Mail");

        if (password.getText().toString().equals("Pass")) {
            Log.i("debugPrint", "correct Password");
        } else Log.i("debugPrint", "incorrect Password");
    }

}