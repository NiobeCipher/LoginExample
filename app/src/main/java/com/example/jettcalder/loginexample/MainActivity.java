package com.example.jettcalder.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

//    activity_main component
    TextView mUsername;
    TextInputLayout mActivity;
    Button mGo;
    Button mReset;
    ListView mListView;

//    variables
    Boolean loggedIn = false;
    String username;
    Integer numberChosen = 0;
    String[] items = {"0 - Login Activity", "1 - Profile Activity", "2 - Dummy Activity", "3 - Example Activity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent login = getIntent();
        loggedIn = login.getBooleanExtra("loggedIn", false);

        if (loggedIn){
            mUsername = (TextView) findViewById(R.id.primary_textView_username);
            username = login.getStringExtra("username");
            mUsername.setText(username);
//            ------------------------------------------------------------------
            mListView = (ListView) findViewById(R.id.primary_listView);
            mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i) {
                        case 0: startActivity(new Intent(MainActivity.this, LoginActivity.class)); break;
                        case 1: startActivity(new Intent(MainActivity.this, ProfileActivity.class).putExtra("username", username)); break;
                        case 2: startActivity(new Intent(MainActivity.this, DummyActivity.class)); break;
                        case 3: startActivity(new Intent(MainActivity.this, ExampleActivity.class)); break;
                        default:
                            Toast.makeText(MainActivity.this, "Pls choose the number from the list above!", Toast.LENGTH_LONG).show();
                    }
                }
            });
//            ------------------------------------------------------------------
            mGo = (Button) findViewById(R.id.primary_btn_go);
            mReset = (Button) findViewById(R.id.primary_btn_reset);
            mGo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mActivity = (TextInputLayout) findViewById(R.id.primary_activitynumber);
                    if (!mActivity.getEditText().getText().toString().trim().isEmpty()) {
                        numberChosen = parseInt(mActivity.getEditText().getText().toString().trim());
                        switch (numberChosen) {
                            case 0:
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                break;
                            case 1:
                                startActivity(new Intent(MainActivity.this, ProfileActivity.class).putExtra("username", username));
                                break;
                            case 2:
                                startActivity(new Intent(MainActivity.this, DummyActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
                                break;
                            default:
                                Toast.makeText(MainActivity.this, "Pls choose the number from the list above!", Toast.LENGTH_LONG).show();
                        }
                        mActivity.getEditText().setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Pls Enter a valid number", Toast.LENGTH_LONG).show();
                    }
                }
            });
            mReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mActivity.getEditText().setText("");

                }
            });
        }
        else{
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

    }
}
