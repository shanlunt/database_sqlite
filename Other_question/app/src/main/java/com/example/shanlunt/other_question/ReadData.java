package com.example.shanlunt.other_question;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.shanlunt.other_question.Database.DatabaseHandler;
import com.example.shanlunt.other_question.Model.Other_QUestion;

import java.util.List;

/**
 * Created by shanlunt on 3/21/17.
 */

public class ReadData extends AppCompatActivity {

    TextView mReadData;
    DatabaseHandler databaseHandler;
    String log;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_data);

        mReadData = (TextView) findViewById(R.id.read_db);


        databaseHandler = new DatabaseHandler(this);
        List<Other_QUestion> val = databaseHandler.getAllvalues();

        for (Other_QUestion cn : val) {
            log = "Id: " + cn.getId() + " ,values: "
                    + cn.getValue();
            Log.d("value: ", log);

            mReadData.setText(log);

        }

    }
}
