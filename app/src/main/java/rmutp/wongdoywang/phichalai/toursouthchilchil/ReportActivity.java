package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class ReportActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView TextView25 = (TextView) findViewById(R.id.textView25);

        Button Button25 = (Button) findViewById(R.id.button25);
        Button25.setText("ลอดท้องมังกร");
        Button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM report WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("report1", cursor.getString(cursor.getColumnIndex(MyManage.column_reportname)));
                intent.putExtra("report2", cursor.getString(cursor.getColumnIndex(MyManage.column_reporttitel)));
                intent.putExtra("report3", cursor.getString(cursor.getColumnIndex(MyManage.column_Imagere)));
                intent.putExtra("report4", cursor.getString(cursor.getColumnIndex(MyManage.column_reportdesoription)));
                intent.putExtra("report5", cursor.getString(cursor.getColumnIndex(MyManage.column_reportform)));

                cursor.moveToNext();
                cursor.close();

               startActivity(intent);
            }
        });
        Button Button26 = (Button) findViewById(R.id.button26);
        Button26.setText("ทะเลแหวก");
        Button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);
                startActivity(intent);
            }
        });

        Button Button32 = (Button) findViewById(R.id.button32);
        Button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);
                startActivity(intent);
            }
        });
        Button Button27 = (Button) findViewById(R.id.button27);
        Button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);
                startActivity(intent);
            }
        });
        Button Button28 = (Button) findViewById(R.id.button28);
        Button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);
                startActivity(intent);
            }
        });
        Button Button29 = (Button) findViewById(R.id.button29);
        Button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ReporttitelActivity.class);
                startActivity(intent);
            }
        });



    };


}
