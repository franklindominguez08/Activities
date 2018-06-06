package com.wilsonrc.activities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton buttonLogin;
    EditText inputEmail;
    EditText inputPassword;
    HashMap<String, Person> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);

        buttonLogin = findViewById(R.id.btn_login);

        createDummyListOfPeople();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "";
                if(inputEmail!=null){
                    email = inputEmail.getText().toString().toLowerCase();
                }
                Person currentPerson  = data.get(email);
                if(currentPerson != null){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("PROFILE_DATA", currentPerson);
                    startActivity(intent);
                }else{
                    showErrorDialog();
                    inputEmail.setText("");
                    inputPassword.setText("");
                }
            }
        });

    }

    private void showErrorDialog(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(R.string.dialog_body_message);
        dlgAlert.setTitle(R.string.dialog_title_message);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }


    private void createDummyListOfPeople(){
        Person person = new Person();
        person.setName("Wilson Reyes Collado");
        person.setEmail("Wilsonrc16@gmail.com");
        person.setAbout("I'm a Software Developer specialized on Android Development.");
        person.setProjects(100);
        person.setStars(300);
        person.setRepos(150);

        data  = new HashMap<>();
        data.put("wilsonrc16@gmail.com", person);
    }
}
