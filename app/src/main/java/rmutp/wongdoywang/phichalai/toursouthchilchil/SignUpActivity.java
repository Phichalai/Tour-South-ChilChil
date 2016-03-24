package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        }

    }//clicksign ปุ่มสมัครสมาขิก

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
