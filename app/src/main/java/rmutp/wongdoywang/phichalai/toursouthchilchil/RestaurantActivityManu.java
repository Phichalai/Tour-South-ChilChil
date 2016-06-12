package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantmanu);

        name = getIntent().getStringExtra("name");
        Log.d("safsafsa", name);

        //create ListView
        listView = (ListView) findViewById(R.id.listView4);

        showListTour();


        Button Button52 = (Button) findViewById(R.id.button52);
        Button52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RestaurantActivityManu.this, RestaurantActivityManu.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("restaurant1", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname)));
                intent.putExtra("restaurant2", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge)));
                intent.putExtra("restaurant3", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription)));
                intent.putExtra("restaurant4", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen)));
                intent.putExtra("restaurant5", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress)));
                intent.putExtra("restaurant6", cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel)));
                intent.putExtra("restaurant7", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice)));
                cursor.moveToNext();
                cursor.close();


                startActivity(intent);
            }
        });
    }

    private void showListTour() {

        String temp_sql = null;

        switch (name){
            case "เกาะกระดาน":
                temp_sql = " _id >= 0 AND _id <= 3";
                break;
            case "เกาะตาชัย":
                temp_sql = " _id >= 4 AND _id <= 6";
                break;
            case "เกาะเหลาเหลียง":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
            case "44":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
            case "55555":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
            case "66666":
                temp_sql = " _id >= 7 AND _id <= 9";
                break;
        }

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE" + temp_sql, null);
        cursor.moveToFirst();

        final String[] id = new String[cursor.getCount()];
        final String[] restaurantname = new String[cursor.getCount()];
        final String[] restaurantimge = new String[cursor.getCount()];
        final String[] restaurantdescription = new String[cursor.getCount()];
        final String[] restaurantopen = new String[cursor.getCount()];
        final String[] restaurantaddress = new String[cursor.getCount()];
        final String[] restauranttravel = new String[cursor.getCount()];
        final String[] restaurantprice = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            restaurantname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname));
            restaurantimge[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge));
            restaurantdescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription));
            restaurantopen[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen));
            restaurantaddress[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress));
            restauranttravel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel));
            restaurantprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice));

            cursor.moveToNext();
        }
        cursor.close();

        MyAdpter myAdapter = new MyAdpter(this, restaurantname);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }//onItem
        });
    }
}
