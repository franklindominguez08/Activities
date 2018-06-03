package com.wilsonrc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton buttonLogin;
    EditText inputEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail = findViewById(R.id.input_email);
        buttonLogin = findViewById(R.id.btn_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "";
                if(inputEmail!=null){
                    email = inputEmail.getText().toString();
                }
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("NAME", email);
                startActivity(intent);
            }
        });

    }
}
