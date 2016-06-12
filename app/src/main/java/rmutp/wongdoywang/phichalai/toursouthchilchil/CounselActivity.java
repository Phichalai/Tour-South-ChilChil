package rmutp.wongdoywang.phichalai.toursouthchilchil;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class CounselActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private EditText counselnameEditText, counselEmailEditText,
            counselcallEditText, counseldescriptionEditText;
    private String counselnameString, counselEmailString, counselcallString,
            counseldescriptionString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsel);

        //การผูกวิกเกต Bind Widget
        bindWidget();
    }//main method


    public void clickSubmit(View view) {

        counselnameString = counselnameEditText.getText().toString().trim();
        counselEmailString = counselEmailEditText.getText().toString().trim();
        counselcallString = counselcallEditText.getText().toString().trim();
        counseldescriptionString = counseldescriptionEditText.getText().toString().trim();
        //Check space การตรวจสอบช่องว่าง

        if (checkSpace()) {
            //Have space มีช่องว่าง
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(CounselActivity.this, "มีช่องว่าง",
                    "กรุณากรอก ทุกช่อง");

        } else {
            //No space ไม่มีช่องว่าง
            updateToserver();
        }

    }//clicksign ปุ่มตกลง

    private void updateToserver() {

        //conected http การคอนเน็ตปรค
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("countpoint", "counsel"));
            nameValuePairs.add(new BasicNameValuePair("Counselname", counselnameString));
            nameValuePairs.add(new BasicNameValuePair("CounselEmail", counselEmailString));
            nameValuePairs.add(new BasicNameValuePair("Counselcall", counselcallString));
            nameValuePairs.add(new BasicNameValuePair("Counseldescription", counseldescriptionString));

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            httpClient.execute(httpPost);

            Toast.makeText(CounselActivity.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                    Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(CounselActivity.this, "Error", "ไม่สามารถเชื่อมต่อ Server ได้");
            Log.d("test", "e =" + e.toString());
        }

    }//updateToDerver เอา ืทุกอย่างงขึ้น saver

    private boolean checkSpace() {
        boolean bolResult = true;

        bolResult = counselnameString.equals("") || counselEmailString.equals("") ||
                counselcallString.equals("") || counseldescriptionString.equals("");
        return bolResult;
    }

    private void bindWidget() {
        counselnameEditText = (EditText) findViewById(R.id.editText8);
        counselEmailEditText = (EditText) findViewById(R.id.editText9);
        counselcallEditText = (EditText) findViewById(R.id.editText10);
        counseldescriptionEditText = (EditText) findViewById(R.id.editText7);
    }
}//Main class