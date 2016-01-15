package com.tonyruns.triviaalarm;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import com.tonyruns.triviaalarm.model.DbHelper;

/**
 * Created by Tony on 2016-01-14.
 */
public class TriviaAlarm extends Application {

    public static DbHelper dbHelper;
    public static SQLiteDatabase db;
    public static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();


        //TODO**FOR SETTINGS LATER????
        //PreferenceManager.setDefaultValues(this, R.xml.settings, false);
        //sp = PreferenceManager.getDefaultSharedPreferences(this);

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();
    }



    public static String getRingtone() {
       return "dog";
               //sp.getString(RemindMe.RINGTONE_PREF, DEFAULT_NOTIFICATION_URI.toString());
    }

}