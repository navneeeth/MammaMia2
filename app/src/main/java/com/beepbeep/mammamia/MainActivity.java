package com.beepbeep.mammamia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cid, cname, phno;
    Button checkin, viewTables;
    Intent checkinIntent, viewTablesIntent;
    DatabaseHelper myDb;
    String existingUser, existingUserPhNo;
    Cursor res;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        i=0;
        cid = findViewById(R.id.cid);
        cname = findViewById(R.id.cname);
        phno = findViewById(R.id.phno);
        viewTables = findViewById(R.id.viewTables);
        viewTablesIntent = new Intent(MainActivity.this, ScrollingActivity.class);
        checkin = findViewById(R.id.checkin);
        viewTables.setVisibility(View.INVISIBLE);
        boolean result = myDb.insertDefaultValues();
        if(result==true)
        {
            Toast.makeText(MainActivity.this, "Default values inserted.", Toast.LENGTH_LONG).show();
        }
        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkinIntent = new Intent(MainActivity.this, Main2Activity.class);
                existingUser = cid.getText().toString();
                existingUserPhNo = cid.getText().toString();
                res = myDb.ifExistingUser(existingUser, existingUserPhNo);
                if (res.getCount() == 0) {
                    boolean isInserted = myDb.insertData(cid.getText().toString(), cname.getText().toString(), phno.getText().toString());
                    if (!isInserted) {
                        Toast.makeText(MainActivity.this, "Please enter valid data.", Toast.LENGTH_LONG).show();
                    } else {
                        checkinIntent.putExtra("CID", cid.getText().toString());
                        startActivity(checkinIntent);
                    }
                }
                else
                {
                    i=1;
                    checkinIntent.putExtra("Existing User", i);
                    checkinIntent.putExtra("Username", res.getString(1));
                    startActivity(checkinIntent);
                }
            }
        });
        viewTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(viewTablesIntent);
            }
        });
    }
}
