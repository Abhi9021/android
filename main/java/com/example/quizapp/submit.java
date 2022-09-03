package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class submit extends AppCompatActivity implements View.OnClickListener{
Button submit1;
SQLiteDatabase db;
TextView txtobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        db = openOrCreateDatabase("Answerreport", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS report1 (Id INTEGER PRIMARY KEY AUTOINCREMENT,Q1 NUMBER,Q2 NUMBER,Q3 NUMBER,Q4 NUMBER);");
        submit1=findViewById(R.id.btnsub);
        txtobj=findViewById(R.id.txt1);
        submit1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        Cursor c = db.rawQuery("select * from report1", null);
        StringBuffer buffer=new StringBuffer();
        while (c.moveToNext())
        {
     txtobj.setText( buffer.append("Id:"+c.getInt(0)+"\n"));
      txtobj.setText( buffer.append("Q1:" + c.getInt(1) + "\n"));
          txtobj.setText(buffer.append("Q2:" + c.getInt(2) + "\n"));
            txtobj.setText(buffer.append("Q3:" + c.getInt(3) + "\n"));
          txtobj.setText(  buffer.append("Q4:" + c.getInt(4) + "\n"));
            //Toast.makeText(getApplicationContext(),buffer,Toast.LENGTH_SHORT).show();

        }

    }
}