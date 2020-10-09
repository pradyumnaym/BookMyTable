package com.example.bookmytable;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        SQLiteDatabase db;
        int i = 0 ;

        db = openOrCreateDatabase("creditsDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Credits(Name VARCHAR , SRN VARCHAR)");

        //db.execSQL("DROP TABLE Credits");
        //db.execSQL("CREATE TABLE IF NOT EXISTS Credits(Name VARCHAR , SRN VARCHAR)");
        Cursor c = db.rawQuery("SELECT * from Credits", null);
        if (c.getCount() <= 0) {
            db.execSQL("INSERT INTO Credits  values ('Pruthvish','PES1201701629')");
            db.execSQL("INSERT INTO Credits  values ('Pradyumna','PES1201700986')");
            db.execSQL("INSERT INTO Credits  values ('Rajath','PES1201701134')");
            db.execSQL("INSERT INTO Credits  values ('Tanay Gangey','PES1201700144')");
        }
            TextView credit = (TextView) findViewById(R.id.credits);
            if(i==0){
            c = db.rawQuery("SELECT * from Credits", null);
            //c.moveToFirst();
            String display = "";
            while (c.moveToNext()) {
                display += c.getString(0) + "\t\t" + c.getString(1) + "\n\n\n";
            }
            i++;
            credit.setText("");
            credit.setText(display);
        }

}}
