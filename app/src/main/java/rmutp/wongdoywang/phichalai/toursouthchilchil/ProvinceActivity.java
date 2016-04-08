package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ProvinceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
    //create ListView
        String[] provinceStrings = getResources().getStringArray(R.array.province);
        MyAdpter myAdpter = new MyAdpter(this, provinceStrings);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdpter);

    }//Main Method


} // Main Class
