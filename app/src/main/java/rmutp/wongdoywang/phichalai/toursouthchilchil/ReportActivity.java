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


public class ReportActivity extends AppCompatActivity {

    private ListView listView;
    private TextView tourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //Bind Widget
        listView = (ListView) findViewById(R.id.listView3);
        tourTextView = (TextView) findViewById(R.id.textView8);
        tourTextView.setText("ข่าวสาร");

        //Show List Tour
        showListTour();

    }

        private void showListTour() {

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM report", null);
                cursor.moveToFirst();

                final String[] column_reportname = new String[cursor.getCount()];
                final String[] column_reporttitel = new String[cursor.getCount()];
                final String[] column_Imagere = new String[cursor.getCount()];
                final String[] column_reportdesoription = new String[cursor.getCount()];
                final String[] column_reportform = new String[cursor.getCount()];

            for (int i = 0; i < cursor.getCount(); i++) {

                column_reportname[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_reportname));
                column_reporttitel[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_reporttitel));
                column_Imagere[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Imagere));
                column_reportdesoription[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_reportdesoription));
                column_reportform[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_reportform));

                cursor.moveToNext();
            }
            cursor.close();

            MyAdpter2 myAdapter = new MyAdpter2(this, column_reportname, column_Imagere);
            listView.setAdapter(myAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);

                    intent.putExtra("report1", column_reportname[i]);
                    intent.putExtra("report2", column_reporttitel[i]);
                    intent.putExtra("report3", column_Imagere[i]);
                    intent.putExtra("report4", column_reportdesoription[i]);
                    intent.putExtra("report5", column_reportform[i]);


                    startActivity(intent);
                }//onItem
            });

        }   // showListTour
}