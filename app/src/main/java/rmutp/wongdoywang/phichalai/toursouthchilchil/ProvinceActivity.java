package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ProvinceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private EditText txtSearch;
    private String tempTxt;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);

       txtSearch = (EditText) findViewById(R.id.editText2);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempTxt = txtSearch.getText().toString();
                Log.d("textsearch",tempTxt);
            }
        });





        //create ListView
        final String[] provinceStrings = getResources().getStringArray(R.array.province);
        MyAdpter myAdpter = new MyAdpter(this, provinceStrings);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String[] districtStrings = getResources().getStringArray(findDistrict(i));
                Intent intent = new Intent(ProvinceActivity.this, DistrictActivity.class);
                intent.putExtra("District", districtStrings);
                intent.putExtra("Province", provinceStrings[i]);
                startActivity(intent);
            }//onItem
        });

    }//Main Method

    private int findDistrict(int i) {

        int intResult = R.array.district0;

        switch (i) {
            case 0:
                intResult = R.array.district0;
                break;
            case 1:
                intResult = R.array.district1;
                break;
            case 2:
                intResult = R.array.district2;
                break;
            case 3:
                intResult = R.array.district3;
                break;
            case 4:
                intResult = R.array.district4;
                break;
            case 5:
                intResult = R.array.district5;
                break;
            case 6:
                intResult = R.array.district6;
                break;
            case 7:
                intResult = R.array.district7;
                break;
            case 8:
                intResult = R.array.district8;
                break;
            case 9:
                intResult = R.array.district9;
                break;
            case 10:
                intResult = R.array.district10;
                break;
            case 11:
                intResult = R.array.district11;
                break;
            case 12:
                intResult = R.array.district12;
                break;
            case 13:
                intResult = R.array.district13;
                break;
        }

        return intResult;
    }


} // Main Class
