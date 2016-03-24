package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Phichalai on 24/3/2559.
 */
public class MyOpenHelper  extends SQLiteOpenHelper{

    //Exception
    public static final String database_name = "tour.db";
    private static final int datebase_version = 1;

    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "User text, " +
            "Password test, " +
            "Name text, " +
            "Email text);";
    private static  final  String create_tour_table = "create table tourTABLE (" +
            "_id integer primary key, " +
            "Province text, " +
            "District text, " +
            "Name text, " +
            "Category text, " +
            "Description text, " +
            "Image text, " +
            "Lat text, " +
            "Lng text, " +
            "Range text);";


    public MyOpenHelper(Context context) {
        super(context, database_name, null, datebase_version);
    } //constructor


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_user_table);
        sqLiteDatabase.execSQL(create_tour_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} //M C
