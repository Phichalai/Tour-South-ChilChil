package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;

public class DistrictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        //Receive from Intent
        final String[] districtStrings = getIntent().getStringArrayExtra("District");
        String stringProvince = getIntent().getStringExtra("Province");

        //show Province
        TextView provinceTextView = (TextView) findViewById(R.id.textView7);
        provinceTextView.setText("อำเภอในจังหวัด " + stringProvince);

        //show ListView
        MyAdpter myAdpter = new MyAdpter(this, districtStrings);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(myAdpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DistrictActivity.this, TourActivity.class);
                intent.putExtra("District", districtStrings[i]);
                startActivity(intent);
            }//onitem
        });


    }//Main Method


    public void clickBackDistrict(View view) {
        finish();
    }

}//Main Class
