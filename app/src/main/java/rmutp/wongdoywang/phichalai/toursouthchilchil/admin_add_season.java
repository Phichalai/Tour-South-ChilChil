package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_add_season extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_season);

        EditText nameseason = (EditText) findViewById(R.id.nameseason);
        EditText nametour = (EditText) findViewById(R.id.nametour);
        EditText imagee = (EditText) findViewById(R.id.imagee);
        EditText imagef = (EditText) findViewById(R.id.imagef);
        EditText imageg = (EditText) findViewById(R.id.imageg);
        EditText descriptionseason = (EditText) findViewById(R.id.descriptionseason);
        EditText latijudb = (EditText) findViewById(R.id.latijudb);
        EditText longtijudb = (EditText) findViewById(R.id.longtijudb);
        EditText openseason = (EditText) findViewById(R.id.openseason);
        EditText emailseason = (EditText) findViewById(R.id.emailseason);
        EditText priceseason = (EditText) findViewById(R.id.priceseason);
        Button addseason = (Button) findViewById(R.id.addseason);
    }
}
