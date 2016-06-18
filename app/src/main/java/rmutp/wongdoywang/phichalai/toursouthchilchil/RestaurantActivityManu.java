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
import android.widget.TextView;


public class RestaurantActivityManu extends AppCompatActivity {

    private ListView listView;
    private String name;

    String[] restaurantname;
    String[] restaurantimge;
    String[] restaurantimgeB;
    String[] restaurantimgeC;
    String[] restaurantdescription;
    String[] restaurantopen;
    String[] restaurantaddress;
    String[] restauranttravel;
    String[] restaurantprice;
    String[] resurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantmanu);

        name = getIntent().getStringExtra("name");


        //create ListView
        listView = (ListView) findViewById(R.id.listView4);

        showListTour();


        Button Button52 = (Button) findViewById(R.id.button52);
        Button52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(RestaurantActivityManu.this, RestaurantActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("restaurant1", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname)));
                intent.putExtra("restaurant2", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge)));
                intent.putExtra("restaurant3", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeB)));
                intent.putExtra("restaurant4", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeC)));
                intent.putExtra("restaurant5", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription)));
                intent.putExtra("restaurant6", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen)));
                intent.putExtra("restaurant7", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress)));
                intent.putExtra("restaurant8", cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel)));
                intent.putExtra("restaurant9", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice)));
                intent.putExtra("restaurant10", cursor.getString(cursor.getColumnIndex(MyManage.column_resurl)));
                cursor.moveToNext();
                cursor.close();


                startActivity(intent);*/

                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse("resurl") );
                startActivity( browse );
            }
        });
    }

    private void showListTour() {

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
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE" + temp_sql, null);
        cursor.moveToFirst();

        restaurantname = new String[cursor.getCount()];
        restaurantimge = new String[cursor.getCount()];
        restaurantimgeB = new String[cursor.getCount()];
        restaurantimgeC = new String[cursor.getCount()];
        restaurantdescription = new String[cursor.getCount()];
        restaurantopen = new String[cursor.getCount()];
        restaurantaddress = new String[cursor.getCount()];
        restauranttravel = new String[cursor.getCount()];
        restaurantprice = new String[cursor.getCount()];
        resurl = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            restaurantname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname));
            restaurantimge[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge));
            restaurantimgeB[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeB));
            restaurantimgeC[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeC));
            restaurantdescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription));
            restaurantopen[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen));
            restaurantaddress[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress));
            restauranttravel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel));
            restaurantprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice));
            resurl[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_resurl));
            cursor.moveToNext();
        }
        cursor.close();

        MyAdpter myAdapter = new MyAdpter(this, restaurantname);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RestaurantActivityManu.this, RestaurantActivity.class);

                intent.putExtra("restaurant1", restaurantname[i]);
                intent.putExtra("restaurant2", restaurantimge[i]);
                intent.putExtra("restaurant3", restaurantimgeB[i]);
                intent.putExtra("restaurant4", restaurantimgeC[i]);
                intent.putExtra("restaurant5", restaurantdescription[i]);
                intent.putExtra("restaurant6", restaurantopen[i]);
                intent.putExtra("restaurant7", restaurantaddress[i]);
                intent.putExtra("restaurant8", restauranttravel[i]);
                intent.putExtra("restaurant9", restaurantprice[i]);
                intent.putExtra("restaurant10", resurl[i]);
                startActivity(intent);
            }//onItem
        });
    }
}
