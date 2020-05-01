package com.beepbeep.mammamia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Intent orderMoreIntent, placeOrderIntent, viewTablesIntent;
    Button orderMoreButton, viewTables;
    boolean isCheckedPoori;
    boolean isCheckedDosa;
    boolean isCheckedRiceBath;
    boolean isCheckedIdly;
    boolean isCheckedUppittu;
    ScrollingActivity scrollingActivity;
    String cID, tableNo;
    String [][] orders = new String [50][50];
    DatabaseHelper myDb;
    int i;
    AlertDialog.Builder builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        viewTables = findViewById(R.id.viewTables);
        viewTablesIntent = new Intent(Main5Activity.this, ScrollingActivity.class);
        placeOrderIntent = getIntent();
        scrollingActivity = new ScrollingActivity();
        myDb = new DatabaseHelper(this);
        isCheckedPoori = getIntent().getExtras().getBoolean("Poori");
        isCheckedDosa = getIntent().getExtras().getBoolean("Dosa");
        isCheckedRiceBath = getIntent().getExtras().getBoolean("Rice Bath");
        isCheckedIdly = getIntent().getExtras().getBoolean("Idly");
        isCheckedUppittu = getIntent().getExtras().getBoolean("Uppittu");
        cID = placeOrderIntent.getStringExtra("CID");
        tableNo = placeOrderIntent.getStringExtra("Table Number");
        viewTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrollingActivity.tableSpinner.setSelection(4);
                startActivity(viewTablesIntent);
            }
        });
        orderMoreButton = findViewById(R.id.ordermorefood);
        orderMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMoreIntent = new Intent(Main5Activity.this, Main4Activity.class);
                startActivity(orderMoreIntent);
            }
        });
        //int memberDiscount=myDb.ifMemberGetDiscount(cID);
        //int sum=0;
        //String[] result = new String[100];
        //orders = myDb.getBill(orders, cID);
        //for(i=0;i<orders.length-1;i++) {
          //      String x = orders[i][1];
            //    if(!TextUtils.isEmpty(x))
              //      sum += Integer.parseInt(x);
                //result[i] = orders[i][0];
        //}
        //sum=sum-memberDiscount;
        //orders[i][1]=Integer.toString(memberDiscount);
        //result[i]="Discount as Member";
        //builder2 = new AlertDialog.Builder(Main5Activity.this);
        //builder2.setCancelable(true);
        //builder2.setTitle("Total Bill = ₹"+sum);
        //builder2.setItems(result, new DialogInterface.OnClickListener() {
          //  @Override
            //public void onClick(DialogInterface dialogInterface, int i) {
              //  Toast.makeText(Main5Activity.this, "₹"+orders[i][1],Toast.LENGTH_LONG).show();
            ////}
        //});
        //AlertDialog dialog = builder2.create();
        //dialog.show();
        myDb.setTableUnoccupied(tableNo);
    }
}
