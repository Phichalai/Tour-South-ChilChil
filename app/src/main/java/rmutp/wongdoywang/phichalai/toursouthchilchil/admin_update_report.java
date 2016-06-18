package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class admin_update_report extends AppCompatActivity {

    String name;
    EditText namereport ;
    EditText titlereport ;
    EditText imagereport ;
    EditText desoriptionreport ;
    EditText fromreport ;

    EditText searchText ;
    boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_update_report);

        namereport = (EditText) findViewById(R.id.namereport);
        titlereport = (EditText) findViewById(R.id.titlereport);
        imagereport = (EditText) findViewById(R.id.imagereport);
        desoriptionreport = (EditText) findViewById(R.id.desoriptionreport);
        fromreport = (EditText) findViewById(R.id.fromreport);

        searchText = (EditText) findViewById(R.id.searchText);
        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM report WHERE reportname = " + "'" + searchText.getText().toString() + "'", null);
                cursor.moveToFirst();

                Log.d("fsafsafas", "count " + String.valueOf(cursor.getCount()));

                if (cursor.getCount() > 0) {

                    check = true;

                    namereport.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_reportname)));
                    titlereport.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_reporttitel)));
                    imagereport.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_Imagere)));
                    desoriptionreport.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_reportdesoription)));
                    fromreport.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_reportform)));
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(admin_update_report.this);
                    builder.setMessage("ไม่พบข้อมูล");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                    Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                    pbutton.setTextColor(Color.parseColor("#147cce"));
                    pbutton.setTypeface(null, Typeface.BOLD);
                }

                cursor.close();
            }
        });

        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == true) {
                    StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                            .Builder().permitAll().build();
                    StrictMode.setThreadPolicy(threadPolicy);

                    try {
                        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                        nameValuePairs.add(new BasicNameValuePair("countpoint", "delete_report"));
                        nameValuePairs.add(new BasicNameValuePair("name", searchText.getText().toString()));

                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                        httpClient.execute(httpPost);

                        check = false;
                        Toast.makeText(admin_update_report.this, "ลบข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        MyAlertDialog myAlertDialog = new MyAlertDialog();
                        myAlertDialog.myDialog(admin_update_report.this, "Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                        Log.d("test", "e =" + e.toString());
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(admin_update_report.this);
                    builder.setMessage("กรุณากรอกข้อมูล");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                    Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                    pbutton.setTextColor(Color.parseColor("#147cce"));
                    pbutton.setTypeface(null, Typeface.BOLD);
                }

            }
        });
    }
}
