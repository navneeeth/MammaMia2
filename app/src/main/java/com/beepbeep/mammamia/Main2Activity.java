package com.beepbeep.mammamia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText seats;
    AlertDialog.Builder builder;
    AlertDialog.Builder builder1;
    Button findSeats, viewTables;
    Intent findTableIntent, checkinIntent, sendDataToOrdersIntent, viewTablesIntent;
    Cursor res, res1;
    DatabaseHelper myDb;
    ScrollingActivity scrollingActivity;
    String userSeats, username, tableNumber, cID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checkinIntent = getIntent();
        viewTables = findViewById(R.id.viewTables);
        scrollingActivity = new ScrollingActivity();
        viewTablesIntent = new Intent(Main2Activity.this, ScrollingActivity.class);
        myDb = new DatabaseHelper(this);
        int i = checkinIntent.getIntExtra("Existing User", 0);
        //int i = Integer.parseInt(checkinIntent.getStringExtra("Existing User"));
        username = checkinIntent.getStringExtra("Username");
        cID = checkinIntent.getStringExtra("CID");
        if(i==1) {
            builder = new AlertDialog.Builder(Main2Activity.this);
            builder.setCancelable(true);
            builder.setTitle("Mamma Mia! An old customer!");
            builder.setMessage("Welcome, " + username + "!");
            builder.show();
        }
        seats = findViewById(R.id.seats);
        findSeats = findViewById(R.id.findTable);
        findTableIntent = new Intent(Main2Activity.this, Main3Activity.class);
        Toast.makeText(Main2Activity.this, "Customer Checked-in!", Toast.LENGTH_LONG).show();
        findSeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSeats = seats.getText().toString();
                res = myDb.findSeats(userSeats);
                if(res.getCount()==0)
                {
                    builder1 = new AlertDialog.Builder(Main2Activity.this);
                    builder1.setCancelable(true);
                    builder1.setTitle("No seats are available. Please wait.");
                    builder1.show();
                }
                else {
                    res.moveToFirst();
                    tableNumber = res.getString(0);
                    myDb.updateSeating(tableNumber, cID);
                    myDb.setTableOccupied(tableNumber);
                    sendDataToOrdersIntent = new Intent(Main2Activity.this, Main4Activity.class);
                    sendDataToOrdersIntent.putExtra("Table Number", tableNumber);
                   findTableIntent.putExtra("CID", cID);
                    findTableIntent.putExtra("Table Number", tableNumber);
                    startActivity(findTableIntent);
                }
                }
        });
        viewTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrollingActivity.tableSpinner.setSelection(3);
                startActivity(viewTablesIntent);
            }
        });
    }
}
