package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class second extends AppCompatActivity {
    Button previous, next, save;
    SQLiteDatabase db;
    RadioGroup rgb;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        previous = findViewById(R.id.btnpre2);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(second.this, first.class);
                startActivity(i);
            }
        });
        db = openOrCreateDatabase("Answerreport", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS report1 (Id INTEGER PRIMARY KEY AUTOINCREMENT,Q1 NUMBER,Q2 NUMBER,Q3 NUMBER,Q4 NUMBER);");
        next = findViewById(R.id.btnnext2);
        save = findViewById(R.id.btnsave2);
        rgb = (RadioGroup) findViewById(R.id.rgb2);
        rgb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1 = (RadioButton) findViewById(R.id.rb21);
                rb2 = (RadioButton) findViewById(R.id.rb22);
                rb3 = (RadioButton) findViewById(R.id.rb23);
                rb4 = (RadioButton) findViewById(R.id.rb24);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(second.this, third.class);
                startActivity(i);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()) {
                    db.execSQL("insert into report1(Q2) VALUES(1)");
                    Toast.makeText(getApplicationContext(), "1st option selected", Toast.LENGTH_SHORT).show();

                } else if (rb2.isChecked()) {
                    db.execSQL("insert into report1(Q2) VALUES(2)");
                    Toast.makeText(getApplicationContext(), "2nd option selected", Toast.LENGTH_SHORT).show();


                } else if (rb3.isChecked()) {
                    db.execSQL("insert into report1(Q3) VALUES(3)");
                    Toast.makeText(getApplicationContext(), "3rd option selected", Toast.LENGTH_SHORT).show();

                } else if (rb4.isChecked()) {
                    db.execSQL("insert into report1(Q4) VALUES(4)");
                    Toast.makeText(getApplicationContext(), "4th option selected", Toast.LENGTH_SHORT).show();

                } else {

                }
            }

        });
    }
}