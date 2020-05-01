package com.beepbeep.mammamia;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScrollingActivity extends Activity implements AdapterView.OnItemSelectedListener{
    Spinner tableSpinner;
    DatabaseHelper myDb;
    Cursor res;
    StringBuffer buffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        tableSpinner = findViewById(R.id.tablesSpinner);
        myDb = new DatabaseHelper(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tables, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableSpinner.setAdapter(adapter);
        tableSpinner.setOnItemSelectedListener(this);
        tableSpinner.setSelection(1);
    }
    public void insertTableHeaders(String tableName) {
        switch (tableName) {
            case "Customers":
                buffer.append(myDb.CUSTOMERSCid+"\t");
                buffer.append(myDb.CUSTOMERSCname+"\t");
                buffer.append(myDb.CUSTOMERSPhNo+"\t");
                break;
            case "Tables":
                buffer.append(myDb.TABLESTNo+"\t");
                buffer.append(myDb.TABLESOccupied+"\t");
                buffer.append(myDb.TABLESSeats+"\t");
                break;
            case "Menu":
                buffer.append(myDb.MENUFid+"\t");
                buffer.append(myDb.MENUFname+"\t");
                buffer.append(myDb.MENUPrice+"\t");
                break;
            case "Seating":
                buffer.append(myDb.SEATINGTNo+"\t");
                buffer.append(myDb.SEATINGCid+"\t");
                break;
            case "Orders":
                buffer.append(myDb.ORDERSTNo+"\t");
                buffer.append(myDb.ORDERSCid+"\t");
                buffer.append(myDb.ORDERSFid+"\t");
                break;
            case "Members":
                buffer.append(myDb.MEMBERSCid+"\t");
                buffer.append(myDb.MEMBERSDiscount+"\t");
                break;
            default:
                return;
        }
    }
    public void viewAll(String tableName) {
        res = myDb.getAllData(tableName);
        int columnCount;
        res.moveToFirst();
        if(res.getCount() ==0)
        {
            showMessage("Table empty.", "No data found.");
            return;
        }
        buffer = new StringBuffer();
        columnCount = res.getColumnCount();
        insertTableHeaders(tableName);
        buffer.append("\n");
        res.moveToFirst();
        while(res.moveToNext()) {
            for(int i=0;i<columnCount;i++)
            {
                buffer.append(res.getString(i)+"    ");
            }
            buffer.append("\n");
        }
        showMessage(tableName, buffer.toString());
    }
    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text != null) {
            viewAll(text);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
