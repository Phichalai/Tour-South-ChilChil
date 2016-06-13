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


public class HotelmanuActivity extends AppCompatActivity {

    private ListView listView;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelmanu);


        name = getIntent().getStringExtra("name");

        //create ListView
        listView = (ListView) findViewById(R.id.listView5);

        showListTour();

        Button Button53 = (Button) findViewById(R.id.button53);
        Button53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(HotelmanuActivity.this, HotelmanuActivity.class);

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 1", null);
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
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM hotel WHERE" + temp_sql, null);
        cursor.moveToFirst();

        final String[] hotelname = new String[cursor.getCount()];
        final String[] hotelimage = new String[cursor.getCount()];
        final String[] hoteldescription = new String[cursor.getCount()];
        final String[] hotelprice = new String[cursor.getCount()];
        final String[] hoteltime = new String[cursor.getCount()];
        final String[] hoteladdress = new String[cursor.getCount()];
        final String[] hoteltravel = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            hotelname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelname));
            hotelimage[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimage));
            hoteldescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteldescription));
            hotelprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hotelprice));
            hoteltime[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltime));
            hoteladdress[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteladdress));
            hoteltravel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltravel));

            cursor.moveToNext();
        }
            cursor.close();

            MyAdpter myAdapter = new MyAdpter(this, hotelname);
            listView.setAdapter(myAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                }//onItem
            });
    }
}
