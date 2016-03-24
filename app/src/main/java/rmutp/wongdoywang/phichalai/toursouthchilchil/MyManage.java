package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.StringTokenizer;

/**
 * Created by Phichalai on 24/3/2559.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSQLiteDatabase;

    public static final String user_table = "userTABLE";
    private static final String column_id = "id";
    private static final String column_User = "User";
    private static final String column_Password = "Password";
    private static final String column_Name = "Name";
    private static final String column_Email = "Email";


    public static final String tour_table = "tourTABLE";
    private static final String column_Province = "Province";
    private static final String column_District = "District";
    private static final String column_Category = "Category";
    private static final String column_Description = "Description";
    private static final String column_Image = "Image";
    private static final String column_Lat = "Lat";
    private static final String column_Lng = "Lng";
    private static final String column_Range = "Range";


    public MyManage(Context context) {

        //Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqliteDatabase = myOpenHelper.getWritableDatabase();
        readSQLiteDatabase = myOpenHelper.getReadableDatabase();

    } //Constructor
} // M C
