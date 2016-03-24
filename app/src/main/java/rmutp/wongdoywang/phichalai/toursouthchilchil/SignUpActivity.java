package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private EditText nameEditText,emailEditText,
            userEditText, passwordEditText;
    private String nameString, emailString, userString,
            passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //การผูกวิกเกต Bind Widget
        bindWidget();
    }//main method


    public void clickSignUpSign(View view) {

        nameString = nameEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check space การตรวจสอบช่องว่าง
        if (checkSpace()) {
            //Have space มีช่องว่าง
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(SignUpActivity.this, "มีช่องว่าง",
                    "กรุณากรอก ทุกช่อง");

        } else {
        //No space ไม่มีช่องว่าง
            updateToserver();
        }

    }//clicksign ปุ่มสมัครสมาขิก

    private void updateToserver() {

        //conected http การคอนเน็ตปรค
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("isAdd","true"));
            nameValuePairs.add(new BasicNameValuePair("User",userString));
            nameValuePairs.add(new BasicNameValuePair("Password",passwordString));
            nameValuePairs.add(new BasicNameValuePair("Name", nameString));
            nameValuePairs.add(new BasicNameValuePair("Email", emailString));

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
            httpClient.execute(httpPost);

            Toast.makeText(SignUpActivity.this, "บันทึกข้อมูลเรียบร้อยแล้ว ขอบคุณค่ะ",
                    Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(SignUpActivity.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
            Log.d("test", "e =" + e.toString());
        }

    }//updateToDerver เอา user password name email ขึ้น saver

    private boolean checkSpace() {

        boolean bolResult = true;

        bolResult = nameString.equals("") || emailString.equals("") ||
                userString.equals("") || passwordString.equals("");
        return bolResult;
    }

    private void bindWidget() {
        nameEditText = (EditText) findViewById(R.id.editText3);
        emailEditText = (EditText) findViewById(R.id.editText4);
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);


    }
}//Main class
