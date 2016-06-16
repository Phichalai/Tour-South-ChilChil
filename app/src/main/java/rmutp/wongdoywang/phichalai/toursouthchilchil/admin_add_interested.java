package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class admin_add_interested extends AppCompatActivity {

    String name;
    EditText nameinterested;
    EditText imagea ;
    EditText imageb ;
    EditText imagec ;
    EditText descriptionss ;
    EditText latijuda ;
    EditText longtijuda ;
    EditText open4 ;
    EditText call2 ;
    EditText email3 ;
    EditText price4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_interested);

        nameinterested = (EditText) findViewById(R.id.nameinterested);
        imagea = (EditText) findViewById(R.id.imagea);
        imageb = (EditText) findViewById(R.id.imageb);
        imagec = (EditText) findViewById(R.id.imagec);
        descriptionss = (EditText) findViewById(R.id.descriptionss);
        latijuda = (EditText) findViewById(R.id.latijuda);
        longtijuda = (EditText) findViewById(R.id.longtijuda);
        open4 = (EditText) findViewById(R.id.open4);
        call2 = (EditText) findViewById(R.id.call2);
        email3 = (EditText) findViewById(R.id.email3);
        price4 = (EditText) findViewById(R.id.price4);
        Button addinterested = (Button) findViewById(R.id.addinterested);
        addinterested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conected http การคอนเน็ตปรค
                StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                        .Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);

                try {

                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("countpoint","add_interested"));

                    nameValuePairs.add(new BasicNameValuePair("interestedname",nameinterested.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedimage",imagea.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedimaged", imageb.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedimagee", imagec.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interesteddescription",descriptionss.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lat", latijuda.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lag",longtijuda.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedopen",open4.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedcall", call2.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedemail",email3.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("interestedprice",price4.getText().toString()));


                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    httpClient.execute(httpPost);

                    Toast.makeText(admin_add_interested.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(admin_add_interested.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                    Log.d("test", "e =" + e.toString());
                }
            }
        });

    }
}
