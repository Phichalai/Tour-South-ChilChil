package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SeasonwinterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonwinter);

        Button Button42 = (Button) findViewById(R.id.button42);
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
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontours)));

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
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontours)));

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
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontours)));

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
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontours)));

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
                intent.putExtra("season4", cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                intent.putExtra("season5", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                intent.putExtra("season6", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                intent.putExtra("season7", cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                intent.putExtra("season8", cursor.getString(cursor.getColumnIndex(MyManage.column_seasontours)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);

            }
        });

    }
}














