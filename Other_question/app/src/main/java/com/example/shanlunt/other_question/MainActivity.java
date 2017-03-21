package com.example.shanlunt.other_question;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shanlunt.other_question.Database.DatabaseHandler;
import com.example.shanlunt.other_question.Model.Other_QUestion;

public class MainActivity extends AppCompatActivity {

    Button mInssert;
    Button mRead;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHandler = new DatabaseHandler(this);

        mInssert = (Button) findViewById(R.id.insert);
        mRead = (Button) findViewById(R.id.read);

        mInssert.setOnClickListener(new InsertOnClicklistener());
        mRead.setOnClickListener(new ReadOnCLickListener());
    }

    private class InsertOnClicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            databaseHandler.add(new Other_QUestion("value1"));
//            databaseHandler.add(new Other_QUestion("value2"));
//            databaseHandler.add(new Other_QUestion("value3"));
//            databaseHandler.add(new Other_QUestion("value4"));
            Log.v("MainActivity","InsertOnClicklistener");

            Intent intent = new Intent(MainActivity.this, InsertData.class);
            startActivity(intent);

        }
    }

    private class ReadOnCLickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ReadData.class);
            startActivity(intent);
        }
    }
}
