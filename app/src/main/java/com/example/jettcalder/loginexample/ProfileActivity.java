package com.example.jettcalder.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
//    activity_profile component
    TextView mUsername;
    ImageView mImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent main = getIntent();
        mUsername = (TextView) findViewById(R.id.profile_username);
        mUsername.setText(main.getStringExtra("username"));
    }
}
