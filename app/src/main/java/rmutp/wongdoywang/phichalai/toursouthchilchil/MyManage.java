package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Phichalai on 24/3/2559.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSQLiteDatabase;


    public MyManage(Context context) {

        //Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqliteDatabase = myOpenHelper.getWritableDatabase();
        readSQLiteDatabase = myOpenHelper.getReadableDatabase();

    } //Constructor
} // M C
