package com.sanjogstha.np.swastik1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText userEditText;
    private EditText passEditText;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.submitLogin);
        userEditText = (EditText) findViewById(R.id.username);
        passEditText = (EditText) findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = userEditText.getText().toString().trim();
                password = passEditText.getText().toString().trim();
                System.out.println("username" + username + "password" + password);

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Plese enter valid credentials", Toast.LENGTH_LONG).show();
                } else {
                    if ((username.equals("swastik")||username.equals("sugam") )&& password.equals("123")) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();

                        Intent home = new Intent(MainActivity.this, HomeActivity.class);
                        home.putExtra("username", username);
                        startActivity(home);
                        finish();
                    } else {
                            Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });


    }


}




