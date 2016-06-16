package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
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

public class admin_add_season extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_season);

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
        Button addseason = (Button) findViewById(R.id.addseason);
        addseason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conected http การคอนเน็ตปรค
                StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                        .Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);

                try {

                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("countpoint","add_season"));

                    nameValuePairs.add(new BasicNameValuePair("seasonname",nameseason.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasontour",nametour.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonImage", imagee.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonImagea", imagef.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonImageb",imageg.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasondescription",descriptionseason.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lat", latijudb.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lng", longtijudb.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonopen",openseason.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonemail",emailseason.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("seasonprice", priceseason.getText().toString()));

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    httpClient.execute(httpPost);

                    Toast.makeText(admin_add_season.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(admin_add_season.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                    Log.d("test", "e =" + e.toString());
                }
            }
        });
    }
}
