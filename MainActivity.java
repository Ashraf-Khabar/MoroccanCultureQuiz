package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnStart , btnEssaies , btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews () ;

        btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this , questionActivity.class) ;
                startActivity( intent );
            }
        });

        btnEssaies.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this , essaiesActivity.class ) ;
                startActivity( intent );
            }
        });

        btnAbout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AboutActivity.class) ;
                startActivity(intent);
            }
        });
    }

    private void initViews ()
    {
        btnStart = findViewById(R.id.btnStart) ;
        btnEssaies = findViewById(R.id.btnEssaie) ;
        btnAbout = findViewById(R.id.btnAboutc) ;
    }

    private int mBackKeyPressedTimes = 0;
    @Override
    public void onBackPressed() {
        if (mBackKeyPressedTimes == 0) {
            Toast.makeText (this, "press the return key to exit", Toast.LENGTH_SHORT) .show ();
            mBackKeyPressedTimes = 1;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        mBackKeyPressedTimes = 0;
                    }
                }
            }.start();
            return;
        }
        super.onBackPressed();
    }
}