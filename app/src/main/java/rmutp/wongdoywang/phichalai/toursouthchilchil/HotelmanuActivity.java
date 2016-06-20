package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class HotelmanuActivity extends AppCompatActivity {

    private ListView listView;
    private String name;

    String[] hotelname;
    String[] hotelimage;
    String[] hotelimageB;
    String[] hotelimageC;
    String[] hoteldescription;
    String[] hotelprice;
    String[] hoteltime;
    String[] hoteladdress;
    String[] hoteltravel;
    String[] hotelurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelmanu);


        name = getIntent().getStringExtra("name");

        //create ListView
        listView = (ListView) findViewById(R.id.listView5);

        showListTour();

    }

    void showListTour() {
        String temp_sql = null;

        switch (name) {
            case "เกาะกระดาน":
                temp_sql = " _id >= 0 AND _id <= 3";
                break;
            case "เกาะตาชัย":
                temp_sql = " _id >= 4 AND _id <= 6";
                break;
            case "เกาะเหลาเหลียง":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
            case "เกาะไข่นอก ":
                temp_sql = " _id >= 10 AND _id <= 12";
                break;
            case "เกาะพยาม ":
                temp_sql = " _id >= 13 AND _id <= 15";
                break;
            case "เกาะลันตา ":
                temp_sql = " _id >= 16 AND _id <= 18";
                break;
        }

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM hotel WHERE" + temp_sql, null);
        cursor.moveToFirst();

        hotelname = new String[cursor.getCount()];
        hotelimage = new String[cursor.getCount()];
        hotelimageB = new String[cursor.getCount()];
        hotelimageC = new String[cursor.getCount()];
        hoteldescription = new String[cursor.getCount()];
        hotelprice = new String[cursor.getCount()];
        hoteltime = new String[cursor.getCount()];
        hoteladdress = new String[cursor.getCount()];
        hoteltravel = new String[cursor.getCount()];
        hotelurl = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            hotelname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelname));
            hotelimage[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimage));
            hotelimageB[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimageB));
            hotelimageC[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimageC));
            hoteldescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteldescription));
            hotelprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelprice));
            hoteltime[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltime));
            hoteladdress[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteladdress));
            hoteltravel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltravel));
            hotelurl[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelurl));

            cursor.moveToNext();
        }
            cursor.close();

            MyAdpter myAdapter = new MyAdpter(this, hotelname);
            listView.setAdapter(myAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(HotelmanuActivity.this, HotelActivity.class);

                    intent.putExtra("hotel1", hotelname[i]);
                    intent.putExtra("hotel2", hotelimage[i]);
                    intent.putExtra("hotel3", hotelimageB[i]);
                    intent.putExtra("hotel4", hotelimageC[i]);
                    intent.putExtra("hotel5", hoteldescription[i]);
                    intent.putExtra("hotel6", hotelprice[i]);
                    intent.putExtra("hotel7",  hoteltime[i]);
                    intent.putExtra("hotel8", hoteladdress[i]);
                    intent.putExtra("hotel9", hoteltravel[i]);
                    intent.putExtra("hotel10",  hotelurl[i]);

                    startActivity(intent);
                }//onItem
            });
    }
}
