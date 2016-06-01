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
            "Tumboon text ," +
            "Muban text. " +
            "Image text, " +
            "Lat text, " +
            "Lng text, " +
            "point text, " +

            "res text, " +
            "hotel text);";
    private static  final  String create_Counsel = "create table counsel (" +
            "_id integer primary key, " +
            "Counselname text, " +
            "CounselEmail text, "+
            "Counseldescription, "+
            "Counseldat text):";
        private static  final  String create_hotel = "create table hotel (" +
            "_id integer primary key, " +
            "hotelname, " +
            "hotelimage, "+
            "hoteldescription, "+
            "hotelprice, "+
            "hoteltime, "+
            "hoteladdress, "+
            "hoteltravel):";
    private static  final  String create_interested = "create table interested (" +
            "_id integer primary key, " +
            "interestedname, " +
            "interestedimage, "+
            "interesteddescription, "+
            "interestedopen, "+
            "interestedcall, "+
            "interestedemail, "+
            "interestedprice, "+
            "interestedtravel):";
    private static  final  String create_report = "create table report (" +
            "_id integer primary key, " +
            "reportname, " +
            "reporttitel, " +
            "reportdesoription ," +
            "reportform):";
    private static  final  String create_restaurant = "create table restaurant (" +
            "_id integer primary key, " +
            "restaurantname, " +
            "restaurantimge, "+
            "restaurantdescription, "+
            "restaurantopen, "+
            "restaurantaddress, "+
            "restauranttravel, "+
            "restaurantprice):";
    private static  final  String create_season = "create table season (" +
            "_id integer primary key, " +
            "seasonname, " +
            "seasontour, "+
            "seasonimage, "+
            "seasondescription, "+
            "seasonopen, "+
            "seasonemail, "+
            "seasonprice, "+
            "seasontours):";
    private static  final  String create_travel = "create table travel (" +
            "_id integer primary key, " +
            "travelname, " +
            "travelvehicle, "+
            "travelcharges):";






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
