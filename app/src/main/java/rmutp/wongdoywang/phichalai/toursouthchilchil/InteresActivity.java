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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class InteresActivity extends AppCompatActivity {

    private ListView listView;
    private TextView tourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes);


        //Bind Widget
        listView = (ListView) findViewById(R.id.listView3);
        tourTextView = (TextView) findViewById(R.id.textView8);
        tourTextView.setText("สถานที่น่าสนใจ");

        //Show List Tour
        showListTour();

    }

    private void showListTour() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM interested", null);
        cursor.moveToFirst();

        final String[] column_interestedname = new String[cursor.getCount()];
        final String[] column_interestedimage = new String[cursor.getCount()];
        final String[] column_interestedimaged = new String[cursor.getCount()];
        final String[] column_interestedimagee = new String[cursor.getCount()];
        final String[] column_interesteddescription = new String[cursor.getCount()];
        final String[] column_interestedopen = new String[cursor.getCount()];
        final String[] column_interestedcall = new String[cursor.getCount()];
        final String[] column_interestedemail = new String[cursor.getCount()];
        final String[] column_interestedprice = new String[cursor.getCount()];
        final String[] column_Lat1 = new String[cursor.getCount()];
        final String[] column_Lag1 = new String[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            column_interestedname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedname));
            column_interestedimage[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimage));
            column_interestedimaged[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimaged));
            column_interestedimagee[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedimagee));
            column_interesteddescription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interesteddescription));
            column_interestedopen[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedopen));
            column_interestedcall[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedcall));
            column_interestedemail[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedemail));
            column_interestedprice[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_interestedprice));
            column_Lat1[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lat1));
            column_Lag1[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Lag1));

            cursor.moveToNext();
        }
        cursor.close();

        MyAdpter2 myAdapter = new MyAdpter2(this, column_interestedname, column_interestedimage);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(InteresActivity.this, InterdisActivity.class);

                intent.putExtra("interested1", column_interestedname[i]);
                intent.putExtra("interested2", column_interestedimage[i]);
                intent.putExtra("interested3", column_interestedimaged[i]);
                intent.putExtra("interested4", column_interestedimagee[i]);
                intent.putExtra("interested5", column_interesteddescription[i]);
                intent.putExtra("interested6", column_interestedopen[i]);
                intent.putExtra("interested7", column_interestedcall[i]);
                intent.putExtra("interested8", column_interestedemail[i]);
                intent.putExtra("interested9", column_interestedprice[i]);
                intent.putExtra("interested10", column_Lat1[i]);
                intent.putExtra("interested11", column_Lag1[i]);

                startActivity(intent);
            }//onItem
        });

    }   // showListTour
}



