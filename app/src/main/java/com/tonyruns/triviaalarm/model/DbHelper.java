package com.tonyruns.triviaalarm.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Tony on 2016-01-14.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TriviaAlarm.db";
    public static final String ALARMS_TABLE_NAME = "alarms";
    public static final String ALARMS_COLUMN_ID = "id";
    public static final String ALARMS_COLUMN_TIME = "time";

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO add date instead of name (time datetime)
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    //add alarm
    public boolean insertAlarm  (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);

        db.insert("contacts", null, contentValues);
        return true;
    }


    //get all alarms
    public ArrayList<String> getAllAlarms()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return array_list;
    }
}
