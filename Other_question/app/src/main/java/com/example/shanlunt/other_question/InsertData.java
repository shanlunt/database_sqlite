package com.example.shanlunt.other_question;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shanlunt.other_question.Database.DatabaseHandler;
import com.example.shanlunt.other_question.Model.Other_QUestion;

/**
 * Created by shanlunt on 3/21/17.
 */

public class InsertData extends AppCompatActivity {

    EditText mEditText;
    Button mSubmit;

    DatabaseHandler databaseHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertktp);

        Log.v("MainActivity","onCreate");

        databaseHandler = new DatabaseHandler(this);
        mEditText = (EditText) findViewById(R.id.edit_query);
        mSubmit = (Button) findViewById(R.id.submit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = mEditText.getText().toString();

                databaseHandler.add(new Other_QUestion(data));

                finish();
            }
        });

    }
}
