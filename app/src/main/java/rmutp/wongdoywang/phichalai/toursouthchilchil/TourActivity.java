package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TourActivity extends AppCompatActivity {

    //Explicit
    private String districtString;
    private TextView districtTextView;
    private ListView listView;
    private EditText txtSearch;
    private String tempTxt;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        //Bind Widget
        districtTextView = (TextView) findViewById(R.id.textView8);
        listView = (ListView) findViewById(R.id.listView3);

        //Receive Value
        districtString = getIntent().getStringExtra("District");
        districtTextView.setText(districtString);

        //Show List Tour
        showListTour();

        //show Province
        TextView tourTextView = (TextView) findViewById(R.id.textView8);
        tourTextView.setText("สถานที่ท่องเที่ยว");

    }   // Main Method

    private void showListTour() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tourTABLE WHERE District = " + "'" + districtString + "'", null);
        cursor.moveToFirst();


        Log.d("sgsagsag", "count " + String.valueOf(cursor.getCount()));
        final String[] id = new String[cursor.getCount()];


        final String[] provinceStrings = new String[cursor.getCount()];
        final String[] districtStrings = new String[cursor.getCount()];
        final String[] tourStrings = new String[cursor.getCount()];
        final String[] descriptionStrings = new String[cursor.getCount()];
        final String[] imageStrings = new String[cursor.getCount()];
        final String[] latStrings = new String[cursor.getCount()];
        final String[] lngStrings = new String[cursor.getCount()];
        final String[] pointStrings = new String[cursor.getCount()];
        final String[] resStrings = new String[cursor.getCount()];
        final String[] hotelStrings = new String[cursor.getCount()];


        for (int i = 0; i < cursor.getCount(); i++) {



            id[i] = cursor.getString(cursor.getColumnIndex("_id"));

            provinceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Province));
            districtStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_District));
            tourStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            descriptionStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Description));
            imageStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image));
            latStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lat));
            lngStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lng));
            pointStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_point));
            resStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_res));
            hotelStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotel));

            cursor.moveToNext();
        }
        cursor.close();

        Log.d("8April", "tourString Lang ==>> " + cursor.getCount());

        MyAdpter2 myAdapter = new MyAdpter2(this, tourStrings,imageStrings);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d("sgsagsag",id[i]);


                Intent intent = new Intent(TourActivity.this, MapsActivity.class);

                intent.putExtra("Tour", tourStrings[i]);
                intent.putExtra("District", districtStrings[i]);
                intent.putExtra("Province", provinceStrings[i]);
                intent.putExtra("Image", imageStrings[i]);
                intent.putExtra("Description", descriptionStrings[i]);
                intent.putExtra("Lat", latStrings[i]);
                intent.putExtra("Lng", lngStrings[i]);
                intent.putExtra("point", pointStrings[i]);
                intent.putExtra("res", resStrings[i]);
                intent.putExtra("hotel", hotelStrings[i]);




                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE _id = " + "'" + id[i] + "'", null);
                cursor.moveToFirst();

                intent.putExtra("res1", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname)));
                intent.putExtra("res2", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge)));
                intent.putExtra("res3", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription)));
                intent.putExtra("res4", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen)));
                intent.putExtra("res5", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress)));
                intent.putExtra("res6", cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel)));
                intent.putExtra("res7", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice)));
                cursor.moveToNext();
                cursor.close();

                cursor = sqLiteDatabase.rawQuery("SELECT * FROM hotel WHERE _id = " + "'" + id[i] + "'", null);
                cursor.moveToFirst();

                intent.putExtra("hotel1", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelname)));
                intent.putExtra("hotel2", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimage)));
                intent.putExtra("hotel3", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteldescription)));
                intent.putExtra("hotel4", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelprice)));
                intent.putExtra("hotel5", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltime)));
                intent.putExtra("hotel6", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteladdress)));
                intent.putExtra("hotel7", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltravel)));
                cursor.moveToNext();
                cursor.close();





                startActivity(intent);
            }//onItem
        });

        txtSearch = (EditText) findViewById(R.id.editText2);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempTxt = txtSearch.getText().toString();
                Log.d("textsearch", tempTxt);

                for (int i = 0; i < tourStrings.length; i++) {
                    if (tempTxt.equals(tourStrings[i])) {
                        Log.d("textsearch", "yesssss");
                        Intent intent = new Intent(TourActivity.this, MapsActivity.class);

                        intent.putExtra("Tour", tourStrings[i]);
                        intent.putExtra("District", districtStrings[i]);
                        intent.putExtra("Province", provinceStrings[i]);
                        intent.putExtra("Image", imageStrings[i]);
                        intent.putExtra("Description", descriptionStrings[i]);
                        intent.putExtra("Lat", latStrings[i]);
                        intent.putExtra("Lng", lngStrings[i]);
                        intent.putExtra("point", pointStrings[i]);


                        intent.putExtra("res", resStrings[i]);
                        intent.putExtra("hotel", hotelStrings[i]);


                        startActivity(intent);
                        break;
                    } else {
                        Log.d("textsearch", "noooo");
                    }
                }

            }
        });
    }   // showListTour

    public void clickBackTour(View view) {
        finish();
    }

}   // Main Class