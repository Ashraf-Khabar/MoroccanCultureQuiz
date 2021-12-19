package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {

    private TextView txtScore ;
    private Button btnQuite ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        txtScore = findViewById(R.id.txtScore) ;
        btnQuite = findViewById(R.id.btnQuite) ;

        String score_str = getIntent().getStringExtra("الحصيلة") ;
        txtScore.setText(score_str);

        btnQuite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scoreActivity.this , questionActivity.class) ;
                scoreActivity.this.startActivity(intent);
                scoreActivity.this.finish();
            }
        });
    }
}