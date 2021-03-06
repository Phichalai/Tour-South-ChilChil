package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    private MyManage myManage;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

        myManage = new MyManage(this); //Request Database

        //testAddValue();  //Test Add Value

        deleteAllData(); //Delete All data

        synJSONtoSQLite(); //Syn JSON to SQLIte*/
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        deleteAllData();
        synJSONtoSQLite();
    }

    //--------------------------- Login --------------------------------------

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void clickSignInMain(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();


        //Ceck Space
        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง ค่ะ ");
        } else if (userString.equals("adminzaza") &&
                passwordString.equals("55555zaza")) {
            startActivity(new Intent(MainActivity.this, admin_main.class));
            finish();
        } else {
            checkUser();    //No space
        }
    }

    private void checkUser() {
        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE User = " + "'" + userString + "'", null);
            cursor.moveToFirst();

            String[] resultStrings = new String[cursor.getColumnCount()];
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                resultStrings[i] = cursor.getString(i);
            }
            cursor.close();


            //Check Password
            if (passwordString.equals(resultStrings[2])) {
                Toast.makeText(this, "ยินดีต้อนรับ" + resultStrings[3], Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity.this, ProvinceActivity.class));
                startActivity(new Intent(MainActivity.this, ManuActivity.class));
                finish();
            } else {
                MyAlertDialog myAlertDialog = new MyAlertDialog();
                myAlertDialog.myDialog(this, "Password False",
                        "กรุณาพิมพ์ใหม่ คุณพิมพ์ Password ผิด");
            }

        } catch (Exception e) {
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, "ไม่มี User นี้",
                    "ไม่มี" + userString + "ในฐานข้อมูลของเรา");
        }
    }

//--------------------------- my sql lite --------------------------------------

    private void synJSONtoSQLite() {

        // gig
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        int intTimes = 0;
        while (intTimes <= 8) {

            //1 Create InputStream
            InputStream inputStream = null;

            String[] urlStrings = {"http://swiftcodingthai.com/saa/php_get_user_phichalai.php",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=tour",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=counsel",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=interested",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=hotel",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=report",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=restaurant",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=season",
                    "http://swiftcodingthai.com/saa/php_get_tour_phichalai.php?main=travel"};
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(urlStrings[intTimes]);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();
            } catch (Exception e) {
                Log.d("test", "Input => " + e.toString());
            }

            //2 Create JSON String
            String strJSON = null;

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

                StringBuilder stringBuilder = new StringBuilder();
                String strLine = null;

                while ((strLine = bufferedReader.readLine()) != null) {

                    stringBuilder.append(strLine);
                }
                inputStream.close();
                strJSON = stringBuilder.toString();
            } catch (Exception e) {
                Log.d("test", "JSON => " + e.toString());
            }

            //3 Update SQLite
            try {
                JSONArray jsonArray = new JSONArray(strJSON);

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    switch (intTimes) {
                        case 0: //userTABLE
                            String strUser = jsonObject.getString(MyManage.column_User);
                            String strPassword = jsonObject.getString(MyManage.column_Password);
                            String strName = jsonObject.getString(MyManage.column_Name);
                            String strEmail = jsonObject.getString(MyManage.column_Email);

                            myManage.addUser(strUser, strPassword, strName, strEmail);
                            break;

                        case 1: //tourTABLE
                            String strPrivince = jsonObject.getString(MyManage.column_Province);
                            String strDistrict = jsonObject.getString(MyManage.column_District);
                            String strName1 = jsonObject.getString(MyManage.column_Name1);
                            String strCategory = jsonObject.getString(MyManage.column_Category);
                            String strDescription = jsonObject.getString(MyManage.column_Description);
                            String strTumboon = jsonObject.getString(MyManage.column_Tumboon);
                            String strMuban = jsonObject.getString(MyManage.column_Muban);
                            String strImage = jsonObject.getString(MyManage.column_Image);
                            String strImage1 = jsonObject.getString(MyManage.column_Image1);
                            String strImage2 = jsonObject.getString(MyManage.column_Image2);
                            String strLat = jsonObject.getString(MyManage.column_Lat);
                            String strLng = jsonObject.getString(MyManage.column_Lng);
                            String stradd = jsonObject.getString(MyManage.column_add);
                            String strcall = jsonObject.getString(MyManage.column_call);
                            String stropen = jsonObject.getString(MyManage.column_open);
                            String stremail = jsonObject.getString(MyManage.column_email);
                            String strprice = jsonObject.getString(MyManage.column_price);
                            String strpoint = jsonObject.getString(MyManage.column_point);
                            String res = jsonObject.getString(MyManage.column_res);
                            String hotel = jsonObject.getString(MyManage.column_hotel);

                            myManage.addTour(strPrivince, strDistrict, strName1, strCategory,
                                    strDescription, strTumboon, strMuban, strImage, strImage1, strImage2, strLat, strLng, stradd,
                                    strcall, stropen, stremail, strprice, strpoint, res, hotel);
                            break;

                        case 2: //CounseTable
                            String Counselname = jsonObject.getString(MyManage.column_Counselname);
                            String CounselEmail = jsonObject.getString(MyManage.column_CounselEmail);
                            String Counselcall = jsonObject.getString(MyManage.column_Counselcall);
                            String Counseldescription = jsonObject.getString(MyManage.column_Counseldescription);
                            String counseldat = jsonObject.getString(MyManage.column_counseldat);

                            myManage.addCounse(Counselname, CounselEmail, Counselcall, Counseldescription, counseldat);
                            break;

                        case 3: //interestedTable
                            String interestedname = jsonObject.getString(MyManage.column_interestedname);
                            String interestedimage = jsonObject.getString(MyManage.column_interestedimage);
                            String interestedimaged = jsonObject.getString(MyManage.column_interestedimaged);
                            String interestedimagee = jsonObject.getString(MyManage.column_interestedimagee);
                            String interesteddescription = jsonObject.getString(MyManage.column_interesteddescription);
                            String strLat1 = jsonObject.getString(MyManage.column_Lat1);
                            String strLag1 = jsonObject.getString(MyManage.column_Lag1);
                            String interestedopen = jsonObject.getString(MyManage.column_interestedopen);
                            String interestedcall = jsonObject.getString(MyManage.column_interestedcall);
                            String interestedemail = jsonObject.getString(MyManage.column_interestedemail);
                            String interestedprice = jsonObject.getString(MyManage.column_interestedprice);

                            myManage.addinterested(interestedname, interestedimage, interestedimaged,
                                    interestedimagee, interesteddescription, strLat1, strLag1,
                                    interestedopen, interestedcall, interestedemail, interestedprice);
                            break;

                        case 4: //hotelTable
                            String hotelname = jsonObject.getString(MyManage.column_hotelname);
                            String hotelimage = jsonObject.getString(MyManage.column_hotelimage);
                            String hotelimageB = jsonObject.getString(MyManage.column_hotelimageB);
                            String hotelimageC = jsonObject.getString(MyManage.column_hotelimageC);
                            String hoteldescription = jsonObject.getString(MyManage.column_hoteldescription);
                            String hotelprice = jsonObject.getString(MyManage.column_hotelprice);
                            String hoteltime = jsonObject.getString(MyManage.column_hoteltime);
                            String hoteladdress = jsonObject.getString(MyManage.column_hoteladdress);
                            String hoteltravel = jsonObject.getString(MyManage.column_hoteltravel);
                            String hotelurl = jsonObject.getString(MyManage.column_hotelurl);

                            myManage.addhotel(hotelname, hotelimage, hotelimageB, hotelimageC, hoteldescription, hotelprice, hoteltime,
                                    hoteladdress, hoteltravel, hotelurl);

                            break;

                        case 5: //reportTable
                            String reportname = jsonObject.getString(MyManage.column_reportname);
                            String reporttitel = jsonObject.getString(MyManage.column_reporttitel);
                            String Imagere = jsonObject.getString(MyManage.column_Imagere);
                            String reportdesoription = jsonObject.getString(MyManage.column_reportdesoription);
                            String reportform = jsonObject.getString(MyManage.column_reportform);

                            myManage.addreport(reportname, reporttitel, Imagere, reportdesoription, reportform);
                            break;

                        case 6: //restaurantTable
                            String restaurantname = jsonObject.getString(MyManage.column_restaurantname);
                            String restaurantimge = jsonObject.getString(MyManage.column_restaurantimge);
                            String restaurantimgeB = jsonObject.getString(MyManage.column_restaurantimgeB);
                            String restaurantimgeC = jsonObject.getString(MyManage.column_restaurantimgeC);
                            String restaurantdescription = jsonObject.getString(MyManage.column_restaurantdescription);
                            String restaurantopen = jsonObject.getString(MyManage.column_restaurantopen);
                            String restaurantaddress = jsonObject.getString(MyManage.column_restaurantaddress);
                            String restauranttravel = jsonObject.getString(MyManage.column_restauranttravel);
                            String restaurantprice = jsonObject.getString(MyManage.column_restaurantprice);
                            String resurl = jsonObject.getString(MyManage.column_resurl);

                            myManage.addrestaurant(restaurantname, restaurantimge, restaurantimgeB,
                                    restaurantimgeC, restaurantdescription,
                                    restaurantopen, restaurantaddress, restauranttravel, restaurantprice, resurl);
                            break;

                        case 7: //seasonTable
                            String seasonname = jsonObject.getString(MyManage.column_seasonname);
                            String seasontour = jsonObject.getString(MyManage.column_seasontour);
                            String seasonImage = jsonObject.getString(MyManage.column_seasonImage);
                            String seasonImagea = jsonObject.getString(MyManage.column_seasonImagea);
                            String seasonImageb = jsonObject.getString(MyManage.column_seasonImageb);
                            String seasondescription = jsonObject.getString(MyManage.column_seasondescription);
                            String strLat2 = jsonObject.getString(MyManage.column_Lat2);
                            String strLng2 = jsonObject.getString(MyManage.column_Lng2);
                            String seasonopen = jsonObject.getString(MyManage.column_seasonopen);
                            String seasonemail = jsonObject.getString(MyManage.column_seasonemail);
                            String seasonprice = jsonObject.getString(MyManage.column_seasonprice);


                            myManage.addseason(seasonname, seasontour, seasonImage, seasonImagea, seasonImageb, seasondescription, strLat2, strLng2,
                                    seasonopen, seasonemail, seasonprice);
                            break;

                        case 8: //travelTable
                            String travelname = jsonObject.getString(MyManage.column_travelname);
                            String travelvehicle = jsonObject.getString(MyManage.column_travelvehicle);
                            String travelcharges = jsonObject.getString(MyManage.column_travelcharges);

                            myManage.addtravel(travelname, travelvehicle, travelcharges);
                            break;
                    }
                }
            } catch (Exception e) {
                Log.d("test", "Update => " + e.toString());
            }
            intTimes++;
        }
    }

    private void deleteAllData() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,

                MODE_PRIVATE, null);

        sqLiteDatabase.delete(MyManage.user_table, null, null);
        sqLiteDatabase.delete(MyManage.tour_table, null, null);
        sqLiteDatabase.delete(MyManage.counsel_table, null, null);
        sqLiteDatabase.delete(MyManage.interested_table, null, null);
        sqLiteDatabase.delete(MyManage.hotel_table, null, null);
        sqLiteDatabase.delete(MyManage.report_table, null, null);
        sqLiteDatabase.delete(MyManage.restaurant_table, null, null);
        sqLiteDatabase.delete(MyManage.season_table, null, null);
        sqLiteDatabase.delete(MyManage.travel_table, null, null);
    }
}

