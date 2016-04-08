package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DistrictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        //Receive from Intent
        String[] districtStrings = getIntent().getStringArrayExtra("District");
        String stringProvince = getIntent().getStringExtra("Province");

        //show Province
        TextView provinceTextView = (TextView) findViewById(R.id.textView7);
        provinceTextView.setText("อำเภอในจังหวัด " + stringProvince);


    }//Main Method
}//Main Class
