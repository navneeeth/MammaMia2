package com.beepbeep.mammamia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView tableNumber;
    Button orderFood, viewTables;
    Intent orderFoodIntent, findTableIntent, viewTablesIntent;
    ScrollingActivity scrollingActivity;
    String tableNo, cID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewTables = findViewById(R.id.viewTables);
        tableNumber = findViewById(R.id.tableNumber);
        orderFood = findViewById(R.id.orderFood);
        scrollingActivity = new ScrollingActivity();
        viewTablesIntent = new Intent(Main3Activity.this, ScrollingActivity.class);
        findTableIntent = getIntent();
        tableNo = findTableIntent.getStringExtra("Table Number");
        cID = findTableIntent.getStringExtra("CID");
        tableNumber.setText(" "+tableNo);
        orderFoodIntent = new Intent(Main3Activity.this, Main4Activity.class);
        orderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderFoodIntent.putExtra("Table Number", tableNo);
                orderFoodIntent.putExtra("CID", cID);
                startActivity((orderFoodIntent));
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
