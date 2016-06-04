package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeasonsummerActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonsummer);

        Button Button37 = (Button) findViewById(R.id.button37);
        Button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SeasonsummerActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 1", null);
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




        Button Button38 = (Button) findViewById(R.id.button38);
        Button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeasonsummerActivity.this, SummerdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE _id = 2", null);
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