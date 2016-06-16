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

public class admin_add_report extends AppCompatActivity {

    String name;
    EditText namereport ;
    EditText titlereport ;
    EditText imagereport ;
    EditText desoriptionreport ;
    EditText fromreport ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_report);

        namereport = (EditText) findViewById(R.id.namereport);
        titlereport = (EditText) findViewById(R.id.titlereport);
        imagereport = (EditText) findViewById(R.id.imagereport);
        desoriptionreport = (EditText) findViewById(R.id.desoriptionreport);
        fromreport = (EditText) findViewById(R.id.fromreport);

        Button addreport = (Button) findViewById(R.id.addreport);
        addreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conected http การคอนเน็ตปรค
                StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                        .Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);

                try {
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("countpoint","add_report"));

                    nameValuePairs.add(new BasicNameValuePair("reportname",namereport.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("reporttitel",titlereport.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Imagere", imagereport.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("reportdesoription", desoriptionreport.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("reportform",fromreport.getText().toString()));

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    httpClient.execute(httpPost);

                    Toast.makeText(admin_add_report.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(admin_add_report.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                    Log.d("test", "e =" + e.toString());
                }
            }
        });

    }
}
