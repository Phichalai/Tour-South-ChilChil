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

public class admin_update_season extends AppCompatActivity {

    String name;
    EditText nameseason;
    EditText nametour ;
    EditText imagee ;
    EditText imagef ;
    EditText imageg ;
    EditText descriptionseason ;
    EditText latijudb ;
    EditText longtijudb ;
    EditText openseason ;
    EditText emailseason ;
    EditText priceseason ;

    EditText searchText ;

    boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_update_season);

        nameseason = (EditText) findViewById(R.id.nameseason);
        nametour = (EditText) findViewById(R.id.nametour);
        imagee = (EditText) findViewById(R.id.imagee);
        imagef = (EditText) findViewById(R.id.imagef);
        imageg = (EditText) findViewById(R.id.imageg);
        descriptionseason = (EditText) findViewById(R.id.descriptionseason);
        latijudb = (EditText) findViewById(R.id.latijudb);
        longtijudb = (EditText) findViewById(R.id.longtijudb);
        openseason = (EditText) findViewById(R.id.openseason);
        emailseason = (EditText) findViewById(R.id.emailseason);
        priceseason = (EditText) findViewById(R.id.priceseason);

        searchText = (EditText) findViewById(R.id.searchText);
        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM season WHERE seasontour = " + "'" + searchText.getText().toString() + "'", null);
                cursor.moveToFirst();

                Log.d("fsafsafas", "count " + String.valueOf(cursor.getCount()));

                if (cursor.getCount() > 0) {

                    check = true;

                    nameseason.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonname)));
                    nametour.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasontour)));
                    imagee.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImage)));
                    imagef.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonImageb)));
                    imageg.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasondescription)));
                    descriptionseason.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_Lat2)));
                    latijudb.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_Lng2)));
                    longtijudb.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                    openseason.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonopen)));
                    emailseason.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonemail)));
                    priceseason.setText(cursor.getString(cursor.getColumnIndex(MyManage.column_seasonprice)));
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(admin_update_season.this);
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
                        nameValuePairs.add(new BasicNameValuePair("countpoint", "delete_season"));
                        nameValuePairs.add(new BasicNameValuePair("name", searchText.getText().toString()));

                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                        httpClient.execute(httpPost);

                        check = false;
                        Toast.makeText(admin_update_season.this, "ลบข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        MyAlertDialog myAlertDialog = new MyAlertDialog();
                        myAlertDialog.myDialog(admin_update_season.this, "Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                        Log.d("test", "e =" + e.toString());
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(admin_update_season.this);
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



        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check == true) {
                    StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                            .Builder().permitAll().build();
                    StrictMode.setThreadPolicy(threadPolicy);

                    try {

                        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                        nameValuePairs.add(new BasicNameValuePair("countpoint", "update_season"));
                        nameValuePairs.add(new BasicNameValuePair("tempName", searchText.getText().toString()));

                        nameValuePairs.add(new BasicNameValuePair("seasonname", nameseason.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasontour", nametour.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonImage", imagee.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonImagea", imagef.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonImageb", imageg.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasondescription", descriptionseason.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("Lat", latijudb.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("Lng", longtijudb.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonopen", openseason.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonemail", emailseason.getText().toString()));
                        nameValuePairs.add(new BasicNameValuePair("seasonprice", priceseason.getText().toString()));

                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                        httpClient.execute(httpPost);

                        check = false;
                        Toast.makeText(admin_update_season.this, "แก้ไขข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (Exception e) {
                        MyAlertDialog myAlertDialog = new MyAlertDialog();
                        myAlertDialog.myDialog(admin_update_season.this, "Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                        Log.d("test", "e =" + e.toString());
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(admin_update_season.this);
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
