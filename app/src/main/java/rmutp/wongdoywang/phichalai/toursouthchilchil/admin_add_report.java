package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_add_report extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_report);

        EditText namereport = (EditText) findViewById(R.id.namereport);
        EditText titlereport = (EditText) findViewById(R.id.titlereport);
        EditText imagereport = (EditText) findViewById(R.id.imagereport);
        EditText desoriptionreport = (EditText) findViewById(R.id.desoriptionreport);
        EditText fromreport = (EditText) findViewById(R.id.fromreport);
        Button addreport = (Button) findViewById(R.id.addreport);

    }
}
