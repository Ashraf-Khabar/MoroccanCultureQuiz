package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class questionActivity extends AppCompatActivity {

    private Button btnNumber1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initViewsBtn () ;

        btnNumber1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(questionActivity.this , quizeNumber1.class) ;
                startActivity(intent);
            }
        });
    }

    private void initViewsBtn ()
    {
        btnNumber1 = findViewById(R.id.btnNumber1) ;
    }


}