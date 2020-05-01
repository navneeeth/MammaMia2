package com.beepbeep.mammamia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Main4Activity extends AppCompatActivity {
    CheckBox poori, dosa, riceBath, idly, uppittu;
    Button placeOrder, viewTables;
    Intent getDataForOrdersIntent, viewTablesIntent;
    Intent placeOrderIntent;
    ScrollingActivity scrollingActivity;
    DatabaseHelper myDb;
    boolean isCheckedPoori=false;
    boolean isCheckedDosa=false;
    boolean isCheckedRiceBath=false;
    boolean isCheckedIdly=false;
    boolean isCheckedUppittu=false;
    String tableNo, cID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        poori=findViewById(R.id.poori);
        dosa=findViewById(R.id.dosa);
        riceBath = findViewById(R.id.riceBath);
        idly = findViewById(R.id.idly);
        uppittu = findViewById(R.id.uppittu);
        placeOrder = findViewById(R.id.orderButton);
        viewTables = findViewById(R.id.viewTables);
        viewTablesIntent = new Intent(Main4Activity.this, ScrollingActivity.class);
        myDb = new DatabaseHelper(this);
        getDataForOrdersIntent = getIntent();
        scrollingActivity = new ScrollingActivity();
        tableNo = getDataForOrdersIntent.getStringExtra("Table Number");
        cID = getDataForOrdersIntent.getStringExtra("CID");
        placeOrderIntent = new Intent(Main4Activity.this, Main5Activity.class);
        viewTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrollingActivity.tableSpinner.setSelection(2);
                startActivity(viewTablesIntent);
            }
        });
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(poori.isChecked())
                {
                    isCheckedPoori = true;
                }
                if(dosa.isChecked())
                {
                    isCheckedDosa = true;
                }
                if(riceBath.isChecked())
                {
                    isCheckedRiceBath = true;
                }
                if(idly.isChecked())
                {
                    isCheckedIdly = true;
                }
                if(uppittu.isChecked())
                {
                    isCheckedUppittu = true;
                }
                myDb.setOrders(isCheckedPoori, isCheckedDosa, isCheckedRiceBath, isCheckedIdly, isCheckedUppittu, tableNo, cID);
                placeOrderIntent.putExtra("Poori", isCheckedPoori);
                placeOrderIntent.putExtra("Dosa", isCheckedDosa);
                placeOrderIntent.putExtra("Rice Bath", isCheckedRiceBath);
                placeOrderIntent.putExtra("Idly", isCheckedIdly);
                placeOrderIntent.putExtra("Uppittu", isCheckedUppittu);
                placeOrderIntent.putExtra("CID", cID);
                placeOrderIntent.putExtra("Table Number", tableNo);
                startActivity(placeOrderIntent);
            }
        });
    }
}
