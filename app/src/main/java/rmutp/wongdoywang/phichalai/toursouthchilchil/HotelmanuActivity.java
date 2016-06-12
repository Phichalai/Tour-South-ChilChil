package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Phichalai on 11/6/2559.
 */
public class HotelmanuActivity extends AppCompatActivity{ private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelmanu);


        ListView listView5 = (ListView) findViewById(R.id.listView5);
        Button Button53 = (Button) findViewById(R.id.button53);
    }
}