package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class SeasonwinterActivity extends AppCompatActivity {

    private ListView listView;
    private TextView tourTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonwinter);

        //Bind Widget
        listView = (ListView) findViewById(R.id.listView3);
        tourTextView = (TextView) findViewById(R.id.textView8);
        tourTextView.setText("SUMMER");

        //Show List Tour
        showListTour();

   /*     Button Button42 = (Button) findViewById(R.id.button42);
        Button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 7", null);
                cursor.moveToFirst();

                intent.putExtra("season1", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                intent.putExtra("season2", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                intent.putExtra("season3", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season9", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                intent.putExtra("season11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });


        Button Button43 = (Button) findViewById(R.id.button43);
        Button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 8", null);
                cursor.moveToFirst();

                intent.putExtra("season1", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                intent.putExtra("season2", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                intent.putExtra("season3", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season9", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                intent.putExtra("season11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);

            }
        });
        Button Button23 = (Button) findViewById(R.id.button23);
        Button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 9", null);
                cursor.moveToFirst();

                intent.putExtra("season1", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                intent.putExtra("season2", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                intent.putExtra("season3", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season9", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                intent.putExtra("season11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);

            }
        });
        Button Button30 = (Button) findViewById(R.id.button30);
        Button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 10", null);
                cursor.moveToFirst();

                intent.putExtra("season1", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                intent.putExtra("season2", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                intent.putExtra("season3", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season9", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                intent.putExtra("season11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);

            }
        });

        Button Button21 = (Button) findViewById(R.id.button21);
        Button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 11", null);
                cursor.moveToFirst();

                intent.putExtra("season1", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                intent.putExtra("season2", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                intent.putExtra("season3", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season9", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                intent.putExtra("season11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);

            }
        });*/

    }



    private void showListTour() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE seasonname = " + "'" + "ฤดูฝน" + "'", null);
        cursor.moveToFirst();

        final String[] column_seasonname = new String[cursor.getCount()];
        final String[] column_seasontour = new String[cursor.getCount()];
        final String[] column_seasonImage = new String[cursor.getCount()];
        final String[] column_seasonImagea = new String[cursor.getCount()];
        final String[] column_seasonImageb = new String[cursor.getCount()];
        final String[] column_seasondescription = new String[cursor.getCount()];
        final String[] column_seasonopen = new String[cursor.getCount()];
        final String[] column_seasonemail = new String[cursor.getCount()];
        final String[] column_seasonprice = new String[cursor.getCount()];
        final String[] column_Lat2 = new String[cursor.getCount()];
        final String[] column_Lng2 = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            column_seasonname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname));
            column_seasontour[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour));
            column_seasonImage[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage));
            column_seasonImagea[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImagea));
            column_seasonImageb[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb));
            column_seasondescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription));
            column_seasonopen[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen));
            column_seasonemail[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail));
            column_seasonprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice));
            column_Lat2[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2));
            column_Lng2[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2));

            cursor.moveToNext();
        }
        cursor.close();

        MyAdpter2 myAdapter = new MyAdpter2(this, column_seasontour, column_seasonImage);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(SeasonwinterActivity.this, SummerdisActivity.class);

                intent.putExtra("season1", column_seasonname[i]);
                intent.putExtra("season2", column_seasontour[i]);
                intent.putExtra("season3", column_seasonImage[i]);
                intent.putExtra("season4", column_seasonImagea[i]);
                intent.putExtra("season5", column_seasonImageb[i]);
                intent.putExtra("season6", column_seasondescription[i]);
                intent.putExtra("season7", column_seasonopen[i]);
                intent.putExtra("season8", column_seasonemail[i]);
                intent.putExtra("season9", column_seasonprice[i]);
                intent.putExtra("season10", column_Lat2[i]);
                intent.putExtra("season11", column_Lng2[i]);

                startActivity(intent);
            }//onItem
        });

    }   // showListTour
}














