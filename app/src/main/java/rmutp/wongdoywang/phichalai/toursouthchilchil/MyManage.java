package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyManage {

    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Name = "Name";
    public static final String column_Email = "Email";

    public static final String tour_table = "tourTABLE";
    public static final String column_Province = "Province";
    public static final String column_District = "District";
    public static final String column_Name1 = "Name";
    public static final String column_Category = "Category";
    public static final String column_Description = "Description";
    public static final String column_Image = "Image";
    public static final String column_Lat = "Lat";
    public static final String column_Lng = "Lng";
    public static final String column_point = "point";
    public static final String column_res = "res";
    public static final String column_hotel = "hotel";

    public static final String counsel_table = "counsel";
    public static final String column_Counselname = "Counselname";
    public static final String column_CounselEmail = "CounselEmail";
    public static final String column_Counselcall = "Counselcall";
    public static final String column_Counseldescription = "Counseldescription";
    public static final String column_counseldat = "counseldat";

    public static final String interested_table = "interested";
    public static final String column_interestedname = "interestedname";
    public static final String column_interestedimage = "interestedimage";
    public static final String column_interesteddescription = "interesteddescription";
    public static final String column_Lat1 = "Lat";
    public static final String column_Lag1 = "Lag";
    public static final String column_interestedopen = "interestedopen";
    public static final String column_interestedcall = "interestedcall";
    public static final String column_interestedemail = "interestedemail";
    public static final String column_interestedprice = "interestedprice";
    public static final String column_interestedtravel = "interestedtravel";

    public static final String hotel_table = "hotel";
    public static final String column_hotelname = "hotelname";
    public static final String column_hotelimage = "hotelimage";
    public static final String column_hoteldescription = "hoteldescription";
    public static final String column_hotelprice = "hotelprice";
    public static final String column_hoteltime = "hoteltime";
    public static final String column_hoteladdress = "hoteladdress";
    public static final String column_hoteltravel = "hoteltravel";

    public static final String report_table = "report";
    public static final String column_reportname = "reportname";
    public static final String column_reporttitel = "reporttitel";
    public static final String column_Imagere = "Imagere";
    public static final String column_reportdesoription = "reportdesoription";
    public static final String column_reportform = "reportform";

    public static final String restaurant_table = "restaurant";
    public static final String column_restaurantname = "restaurantname";
    public static final String column_restaurantimge = "restaurantimge";
    public static final String column_restaurantdescription = "restaurantdescription";
    public static final String column_restaurantopen = "restaurantopen";
    public static final String column_restaurantaddress = "restaurantaddress";
    public static final String column_restauranttravel = "restauranttravel";
    public static final String column_restaurantprice = "restaurantprice";

    public static final String season_table = "season";
    public static final String column_seasonname = "seasonname";
    public static final String column_seasontour = "seasontour";
    public static final String column_seasonImage = "seasonImage";
    public static final String column_seasondescription = "seasondescription";
    public static final String column_Lat2 = "Lat";
    public static final String column_Lng2 = "Lng";
    public static final String column_seasonopen = "seasonopen";
    public static final String column_seasonemail = "seasonemail";
    public static final String column_seasonprice = "seasonprice";
    public static final String column_seasontours = "seasontours";

    public static final String travel_table = "travel";
    public static final String column_travelname = "travelname";
    public static final String column_travelvehicle = "travelvehicle";
    public static final String column_travelcharges = "travelcharges";

    public MyManage(Context context) {  //Create & Connected
        myOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = myOpenHelper.getWritableDatabase();
        readSqLiteDatabase = myOpenHelper.getReadableDatabase();
    }

    // Constructor
    public long addUser(String strUser,
                        String strPassword,
                        String strName,
                        String strEmail) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_User, strUser);
        contentValues.put(column_Password, strPassword);
        contentValues.put(column_Name, strName);
        contentValues.put(column_Email, strEmail);

        return writeSqLiteDatabase.insert(user_table, null, contentValues);
    }

    public long addTour(String strProvince,
                        String strDistrict,
                        String strName,
                        String strCategory,
                        String strDescription,
                        String strImage,
                        String strLat,
                        String strLng,
                        String strpoint,
                        String strres,
                        String strhotel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Province, strProvince);
        contentValues.put(column_District, strDistrict);
        contentValues.put(column_Name1, strName);
        contentValues.put(column_Category, strCategory);
        contentValues.put(column_Description, strDescription);
        contentValues.put(column_Image, strImage);
        contentValues.put(column_Lat, strLat);
        contentValues.put(column_Lng, strLng);
        contentValues.put(column_point, strpoint);
        contentValues.put(column_res, strres);
        contentValues.put(column_hotel, strhotel);

        return writeSqLiteDatabase.insert(tour_table, null, contentValues);
    }


    //----------------------------------------------------
    public long addCounse(String Counselname,
                          String CounselEmail,
                          String Counselcall,
                          String Counseldescription,
                          String counseldat) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Counselname, Counselname);
        contentValues.put(column_CounselEmail, CounselEmail);
        contentValues.put(column_Counselcall, Counselcall);
        contentValues.put(column_Counseldescription, Counseldescription);
        contentValues.put(column_counseldat, counseldat);

        return writeSqLiteDatabase.insert(counsel_table, null, contentValues);
    }

    public long addinterested(String interestedname,
                              String interestedimage,
                              String interesteddescription,
                              String Lat,
                              String Lag,
                              String interestedopen,
                              String interestedcall,
                              String interestedemail,
                              String interestedprice,
                              String interestedtravel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_interestedname, interestedname);
        contentValues.put(column_interestedimage, interestedimage);
        contentValues.put(column_interesteddescription, interesteddescription);
        contentValues.put(column_Lat1, Lat);
        contentValues.put(column_Lag1, Lag);
        contentValues.put(column_interestedopen, interestedopen);
        contentValues.put(column_interestedcall, interestedcall);
        contentValues.put(column_interestedemail, interestedemail);
        contentValues.put(column_interestedprice, interestedprice);
        contentValues.put(column_interestedtravel, interestedtravel);

        return writeSqLiteDatabase.insert(interested_table, null, contentValues);
    }

    public long addhotel(String hotelname,
                         String hotelimage,
                         String hoteldescription,
                         String hotelprice,
                         String hoteltime,
                         String hoteladdress,
                         String hoteltravel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_hotelname, hotelname);
        contentValues.put(column_hotelimage, hotelimage);
        contentValues.put(column_hoteldescription, hoteldescription);
        contentValues.put(column_hotelprice, hotelprice);
        contentValues.put(column_hoteltime, hoteltime);
        contentValues.put(column_hoteladdress, hoteladdress);
        contentValues.put(column_hoteltravel, hoteltravel);

        return writeSqLiteDatabase.insert(hotel_table, null, contentValues);
    }

    public long addreport(String reportname,
                          String reporttitel,
                          String Imagere,
                          String reportdesoription,
                          String reportform) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_reportname, reportname);
        contentValues.put(column_reporttitel, reporttitel);
        contentValues.put(column_Imagere, Imagere);
        contentValues.put(column_reportdesoription, reportdesoription);
        contentValues.put(column_reportform, reportform);

        return writeSqLiteDatabase.insert(report_table, null, contentValues);
    }

    public long addrestaurant(String restaurantname,
                              String restaurantimge,
                              String restaurantdescription,
                              String restaurantopen,
                              String restaurantaddress,
                              String restauranttravel,
                              String restaurantprice) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_restaurantname, restaurantname);
        contentValues.put(column_restaurantimge, restaurantimge);
        contentValues.put(column_restaurantdescription, restaurantdescription);
        contentValues.put(column_restaurantopen, restaurantopen);
        contentValues.put(column_restaurantaddress, restaurantaddress);
        contentValues.put(column_restauranttravel, restauranttravel);
        contentValues.put(column_restaurantprice, restaurantprice);

        return writeSqLiteDatabase.insert(restaurant_table, null, contentValues);
    }

    public long addseason(String seasonname,
                          String seasontour,
                          String seasonImage,
                          String seasondescription,
                          String Lat2,
                          String Lng2,
                          String seasonopen,
                          String seasonemail,
                          String seasonprice,
                          String seasontours) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_seasonname, seasonname);
        contentValues.put(column_seasontour, seasontour);
        contentValues.put(column_seasonImage, seasonImage);
        contentValues.put(column_seasondescription, seasondescription);
        contentValues.put(column_Lat2, Lat2);
        contentValues.put(column_Lng2, Lng2);
        contentValues.put(column_seasonopen, seasonopen);
        contentValues.put(column_seasonemail, seasonemail);
        contentValues.put(column_seasonprice, seasonprice);
        contentValues.put(column_seasontours, seasontours);

        return writeSqLiteDatabase.insert(season_table, null, contentValues);
    }

    public long addtravel(String travelname,
                          String travelvehicle,
                          String travelcharges) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_travelname, travelname);
        contentValues.put(column_travelvehicle, travelvehicle);
        contentValues.put(column_travelcharges, travelcharges);

        return writeSqLiteDatabase.insert(travel_table, null, contentValues);
    }
}
