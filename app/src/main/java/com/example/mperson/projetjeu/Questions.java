package com.example.mperson.projetjeu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Questions extends AppCompatActivity implements View.OnClickListener {

    Button retur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        retur = (Button) findViewById(R.id.butret);
        retur.setOnClickListener(this);
    }

    public void onClick (View v) {

        Questions.this.finish();
    }
}


