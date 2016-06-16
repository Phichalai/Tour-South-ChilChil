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

public class admin_add_tourTABLE extends AppCompatActivity {

    String name;
    EditText nameprovince;
    EditText namedistrict ;
    EditText nametour;
    EditText descriptions ;
    EditText nametumbon ;
    EditText namemooban ;
    EditText imagea ;
    EditText imageb ;
    EditText imagec ;
    EditText latijud ;
    EditText longtijud ;
    EditText address ;
    EditText calltour;
    EditText opentour ;
    EditText emailtour ;
    EditText pricetour ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_tourtable);

        nameprovince = (EditText) findViewById(R.id.nameprovince);
        namedistrict = (EditText) findViewById(R.id.namedistrict);
        nametour = (EditText) findViewById(R.id.nametour);
        descriptions = (EditText) findViewById(R.id.descriptions);
        nametumbon = (EditText) findViewById(R.id.nametumbon);
        namemooban = (EditText) findViewById(R.id.namemooban);
        imagea = (EditText) findViewById(R.id.imagea);
        imageb = (EditText) findViewById(R.id.imageb);
        imagec = (EditText) findViewById(R.id.imagec);
        latijud = (EditText) findViewById(R.id.latijud);
        longtijud = (EditText) findViewById(R.id.longtijud);
        address = (EditText) findViewById(R.id.address);
        calltour = (EditText) findViewById(R.id.calltour);
        opentour = (EditText) findViewById(R.id.opentour);
        emailtour = (EditText) findViewById(R.id.emailtour);
        pricetour = (EditText) findViewById(R.id.pricetour);

        Button addtour = (Button) findViewById(R.id.addtour);
        addtour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conected http การคอนเน็ตปรค
                StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                        .Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);

                try {

                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("countpoint","add_tour"));

                    nameValuePairs.add(new BasicNameValuePair("Province",nameprovince.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("District",namedistrict.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Name", nametour.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Description", descriptions.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Tumboon",nametumbon.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Muban",namemooban.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Image", imagea.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Image1", imagea.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Image2",imageb.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lat",latijud.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("Lng", longtijud.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("add_tour", address.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("call",calltour.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("open", opentour.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("email", emailtour.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("price",pricetour.getText().toString()));

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    httpClient.execute(httpPost);

                    Toast.makeText(admin_add_tourTABLE.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(admin_add_tourTABLE.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                    Log.d("test", "e =" + e.toString());
                }
            }
        });

    }
}
