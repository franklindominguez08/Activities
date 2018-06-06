package com.wilsonrc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewAbout;
    TextView textViewProjects;
    TextView textViewRepos;
    TextView textViewStars;

    AppCompatButton buttonShare;


    private final String PROFILE_DATA = "PROFILE_DATA";

    Person currentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        textViewName = findViewById(R.id.textViewName);
        textViewAbout = findViewById(R.id.textViewAbout);
        textViewProjects = findViewById(R.id.textViewProjects);
        textViewRepos = findViewById(R.id.textViewRepos);
        textViewStars = findViewById(R.id.textViewStars);
        buttonShare = findViewById(R.id.btnShare);

        if(getIntent()!=null && getIntent().getExtras()!= null){
            currentPerson = getIntent().getParcelableExtra(PROFILE_DATA);
            if(currentPerson != null){
                textViewName.setText(currentPerson.getName());
                textViewAbout.setText(currentPerson.getAbout());
                textViewProjects.setText(String.valueOf(currentPerson.getProjects()));
                textViewRepos.setText(String.valueOf(currentPerson.getRepos()));
                textViewStars.setText(String.valueOf(currentPerson.getStars()));
            }
        }

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareProfileData(currentPerson);
            }
        });

    }

    private void shareProfileData(Person person){
        Intent sendIntent = new Intent();

        String textToSend = person.getName() + "\n" + person.getAbout();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
        sendIntent.setType("text/plain");

        startActivity(sendIntent);
    }
}
