package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InteresActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes);

        Button Button47 = (Button) findViewById(R.id.button47);
        Button47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

        Button Button48 = (Button) findViewById(R.id.button48);
        Button48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 2", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

        Button Button49 = (Button) findViewById(R.id.button49);
        Button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 3", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });
        Button Button15 = (Button) findViewById(R.id.button15);
        Button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 4", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });
        Button Button16 = (Button) findViewById(R.id.button16);
        Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 5", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

        Button Button12 = (Button) findViewById(R.id.button12);
        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested WHERE _id = 6", null);
                cursor.moveToFirst();

                intent.putExtra("interested1", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname)));
                intent.putExtra("interested2", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage)));
                intent.putExtra("interested3", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged)));
                intent.putExtra("interested4", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee)));
                intent.putExtra("interested5", cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription)));
                intent.putExtra("interested6", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen)));
                intent.putExtra("interested7", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall)));
                intent.putExtra("interested8", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail)));
                intent.putExtra("interested9", cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice)));
                intent.putExtra("interested10", cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1)));
                intent.putExtra("interested11", cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1)));

                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

    }
}



