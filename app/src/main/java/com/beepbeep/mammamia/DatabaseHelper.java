package com.beepbeep.mammamia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Reservation1.db";
    public static final String TABLES = "Tables";
    public static final String TABLESTNo = "TNo";
    public static final String TABLESOccupied = "Occupied";
    public static final String TABLESSeats = "Seats";
    public static final String SEATING = "Seating";
    public static final String SEATINGTNo = "TNo";
    public static final String SEATINGCid = "Cid";
    public static final String MEMBERS = "Members";
    public static final String MEMBERSDiscount = "Discount";
    public static final String MEMBERSCid = "Cid";
    public static final String CUSTOMERS = "Customers";
    public static final String CUSTOMERSCid = "Cid";
    public static final String CUSTOMERSCname = "CName";
    public static final String CUSTOMERSPhNo = "PhNo";
    public static final String ORDERS = "Orders";
    public static final String ORDERSTNo = "TNo";
    public static final String ORDERSCid = "Cid";
    public static final String ORDERSFid = "Fid";
    public static final String MENU = "Menu";
    public static final String MENUFid = "Fid";
    public static final String MENUFname = "Fname";
    public static final String MENUPrice = "Price";
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        onDowngrade(sqLiteDatabase);
        sqLiteDatabase.execSQL("create table " + TABLES + "(" + TABLESTNo + " integer primary key, " + TABLESOccupied + " text, " + TABLESSeats + " integer)");
        sqLiteDatabase.execSQL("create table " + CUSTOMERS + "(" + CUSTOMERSCid + " integer primary key, " + CUSTOMERSCname + " text, " + CUSTOMERSPhNo + " number(10))");
        sqLiteDatabase.execSQL("create table " + MENU + "(" + MENUFid + " integer primary key, " + MENUFname + " text, " + MENUPrice + " integer)");
        sqLiteDatabase.execSQL("create table " + SEATING + "(" + SEATINGTNo + " integer, " + SEATINGCid + " integer, foreign key(TNo) references tables(tno), foreign key(Cid) references customers(cid))");
        sqLiteDatabase.execSQL("create table " + ORDERS + "(" + ORDERSTNo + " integer, " + ORDERSCid + " integer, " + ORDERSFid + " integer, foreign key(Tno) references tables(tno), foreign key(Cid) references customers(cid), foreign key(fid) references menu(fid))");
        sqLiteDatabase.execSQL("create table " + MEMBERS + "(" + MEMBERSCid + " integer, " + MEMBERSDiscount + " integer, foreign key(Cid) references customers(cid))");
    }
    public boolean insertDefaultValues() {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = this.getWritableDatabase();
        //onCreate(sqLiteDatabase);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLESTNo, 21);
        contentValues.put(TABLESOccupied, "Yes");
        contentValues.put(TABLESSeats, 3);
        long result = sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 22);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 4);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 23);
        contentValues.put(TABLESOccupied, "Yes");
        contentValues.put(TABLESSeats, 5);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 24);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 4);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 25);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 6);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 26);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 7);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 27);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 8);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 28);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 9);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 29);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 10);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 310);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 11);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 311);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 12);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 312);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 13);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 313);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 14);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 314);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 15);
        sqLiteDatabase.insert(TABLES, null, contentValues);
        contentValues.put(TABLESTNo, 315);
        contentValues.put(TABLESOccupied, "No");
        contentValues.put(TABLESSeats, 16);
        sqLiteDatabase.insert(TABLES, null, contentValues);

        if(result==1) {
            contentValues = new ContentValues();
            contentValues.put(SEATINGTNo, 21);
            contentValues.put(SEATINGCid, 1);
            sqLiteDatabase.insert(SEATING, null, contentValues);
            contentValues.put(SEATINGTNo, 23);
            contentValues.put(SEATINGCid, 9);
            sqLiteDatabase.insert(SEATING, null, contentValues);
        }
        contentValues = new ContentValues();
        contentValues.put(MENUFid, 31);
        contentValues.put(MENUFname, "Poori");
        contentValues.put(MENUPrice, 40);
        sqLiteDatabase.insert(MENU, null, contentValues);
        contentValues.put(MENUFid, 32);
        contentValues.put(MENUFname, "Dosa");
        contentValues.put(MENUPrice, 50);
        sqLiteDatabase.insert(MENU, null, contentValues);
        contentValues.put(MENUFid, 33);
        contentValues.put(MENUFname, "Rice Bath");
        contentValues.put(MENUPrice, 30);
        sqLiteDatabase.insert(MENU, null, contentValues);
        contentValues.put(MENUFid, 34);
        contentValues.put(MENUFname, "Idly");
        contentValues.put(MENUPrice, 25);
        sqLiteDatabase.insert(MENU, null, contentValues);
        contentValues.put(MENUFid, 35);
        contentValues.put(MENUFname, "Uppittu");
        contentValues.put(MENUPrice, 30);
        sqLiteDatabase.insert(MENU, null, contentValues);
        if(result==1) {
            contentValues = new ContentValues();
            contentValues.put(MEMBERSCid, 1);
            contentValues.put(MEMBERSDiscount, 10);
            sqLiteDatabase.insert(MEMBERS, null, contentValues);
            contentValues.put(MEMBERSCid, 9);
            contentValues.put(MEMBERSDiscount, 15);
            sqLiteDatabase.insert(MEMBERS, null, contentValues);
        }
        if(result==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLES);
        sqLiteDatabase.execSQL("drop table if exists "+MEMBERS);
        sqLiteDatabase.execSQL("drop table if exists "+ORDERS);
        sqLiteDatabase.execSQL("drop table if exists "+SEATING);
        sqLiteDatabase.execSQL("drop table if exists "+MENU);
        sqLiteDatabase.execSQL("drop table if exists "+CUSTOMERS);
        onCreate(sqLiteDatabase);
    }
    public void onDowngrade(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("drop table if exists "+TABLES);
        sqLiteDatabase.execSQL("drop table if exists "+MEMBERS);
        sqLiteDatabase.execSQL("drop table if exists "+ORDERS);
        sqLiteDatabase.execSQL("drop table if exists "+SEATING);
        sqLiteDatabase.execSQL("drop table if exists "+MENU);
        sqLiteDatabase.execSQL("drop table if exists "+CUSTOMERS);
    }

    public boolean insertData(String cid, String cname, String phno) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSTOMERSCid, cid);
        contentValues.put(CUSTOMERSCname, cname);
        contentValues.put(CUSTOMERSPhNo, phno);
        long result = sqLiteDatabase.insert(CUSTOMERS, null, contentValues);
        if(result ==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData(String tableName)
    {
        SQLiteDatabase sqliteDatabase = this.getWritableDatabase();
        Cursor res = sqliteDatabase.rawQuery("select * from "+tableName, null);
        return res;
    }

    public String price(String fID)
    {
        if(fID.equals("31"))
        {
            return "40";
        }
        else if(fID.equals("32"))
        {
            return "50";
        }
        else if(fID.equals("33"))
        {
            return "30";
        }
        else if(fID.equals("34"))
        {
            return "25";
        }
        else if(fID.equals("35"))
        {
            return "30";
        }
        else
            return "50";

    }

    public String[][] getBill(String[][] orders, String cID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res1 = sqLiteDatabase.rawQuery("select fid from "+ORDERS+" where cid="+cID, null);
        //Cursor res = sqLiteDatabase.rawQuery("select price from "+MENU+" where fid = "+res1.get, null);
        int length = res1.getCount();
        res1.moveToFirst();
        for(int i=0; i<length;i++) {
            orders[i][0] = res1.getString(0);
            orders[i][1] = price(orders[i][0]);
            res1.moveToNext();
        }
        return orders;
    }
    public Cursor ifExistingUser(String existingUser, String existingUserPhNo)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from customers where cid =" + existingUser + " and PhNo =" + existingUserPhNo, null);
        return res;
    }
    public Cursor findSeats(String userSeats)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select tno from tables where occupied='No' and seats="+userSeats, null);
        return res;
    }
    public void updateSeating(String tableNumber, String cID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SEATINGTNo, tableNumber);
        contentValues.put(SEATINGCid, cID);
        sqLiteDatabase.insert(SEATING, null, contentValues);
    }
    public void setTableOccupied(String tableNumber)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLESOccupied, "Yes");
        sqLiteDatabase.update(TABLES, contentValues, "tno = ?", new String[] { tableNumber});
    }
    public void setOrders(boolean isCheckedPoori, boolean isCheckedDosa, boolean isCheckedRiceBath, boolean isCheckedIdly, boolean isCheckedUppittu, String tableNumber, String cID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String poori="31";
        String dosa = "32";
        String riceBath="33";
        String idly="34";
        String uppittu="35";
        if(isCheckedPoori)
        {
            contentValues = new ContentValues();
            contentValues.put(ORDERSTNo, tableNumber);
            contentValues.put(ORDERSCid, cID);
            contentValues.put(ORDERSFid, poori);
            sqLiteDatabase.insert(ORDERS, null, contentValues);
        }
        if(isCheckedDosa)
        {
            contentValues = new ContentValues();
            contentValues.put(ORDERSTNo, tableNumber);
            contentValues.put(ORDERSCid, cID);
            contentValues.put(ORDERSFid, dosa);
            sqLiteDatabase.insert(ORDERS, null, contentValues);
        }
        if(isCheckedRiceBath)
        {
            contentValues = new ContentValues();
            contentValues.put(ORDERSTNo, tableNumber);
            contentValues.put(ORDERSCid, cID);
            contentValues.put(ORDERSFid, riceBath);
            sqLiteDatabase.insert(ORDERS, null, contentValues);
        }
        if(isCheckedIdly)
        {
            contentValues = new ContentValues();
            contentValues.put(ORDERSTNo, tableNumber);
            contentValues.put(ORDERSCid, cID);
            contentValues.put(ORDERSFid, idly);
            sqLiteDatabase.insert(ORDERS, null, contentValues);
        }
        if(isCheckedUppittu)
        {
            contentValues = new ContentValues();
            contentValues.put(ORDERSTNo, tableNumber);
            contentValues.put(ORDERSCid, cID);
            contentValues.put(ORDERSFid, uppittu);
            sqLiteDatabase.insert(ORDERS, null, contentValues);
        }
    }
    public int ifMemberGetDiscount(String cID)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select distinct discount from members where cid="+cID, null);
        res.moveToFirst();
        if(res.getCount()==0)
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(res.getString(0));
        }
    }
    public void setTableUnoccupied(String tableNumber)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLESOccupied, "No");
        sqLiteDatabase.update(TABLES, contentValues, "tno = ?", new String[] {tableNumber});
    }

}
