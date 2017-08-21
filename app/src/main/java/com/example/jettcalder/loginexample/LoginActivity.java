package com.example.jettcalder.loginexample;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // activity_login components
    TextInputLayout mUsername;
    TextInputLayout mPassword;
    Button mSignIn;
    // variables
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (TextInputLayout) findViewById(R.id.login_username);
        mPassword = (TextInputLayout) findViewById(R.id.login_password);
        mSignIn = (Button) findViewById(R.id.login_button_signin);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = mUsername.getEditText().getText().toString().trim();
                password = mPassword.getEditText().getText().toString().trim();
                login_authentication(username, password);
            }
        });
    }

    private void login_authentication(String username, String password) {
        if (username.equals("jettcalder") & password.equals("jett")){
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            mainIntent.putExtra("username", username);
            mainIntent.putExtra("password", password);
            mainIntent.putExtra("loggedIn", true);
            startActivity(mainIntent);
            finish();
        }
        else{
            Toast.makeText(LoginActivity.this, "Failed to login", Toast.LENGTH_LONG).show();

        }
    }
}
