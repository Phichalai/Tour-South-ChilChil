package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_add_tourTABLE extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_tourtable);

        EditText nameprovince = (EditText) findViewById(R.id.nameprovince);
        EditText namedistrict = (EditText) findViewById(R.id.namedistrict);
        EditText nametour = (EditText) findViewById(R.id.nametour);
        EditText descriptions = (EditText) findViewById(R.id.descriptions);
        EditText nametumbon = (EditText) findViewById(R.id.nametumbon);
        EditText namemooban = (EditText) findViewById(R.id.namemooban);
        EditText imagea = (EditText) findViewById(R.id.imagea);
        EditText imageb = (EditText) findViewById(R.id.imageb);
        EditText imagec = (EditText) findViewById(R.id.imagec);
        EditText latijud = (EditText) findViewById(R.id.latijud);
        EditText longtijud = (EditText) findViewById(R.id.longtijud);
        EditText address = (EditText) findViewById(R.id.address);
        EditText calltour = (EditText) findViewById(R.id.calltour);
        EditText opentour = (EditText) findViewById(R.id.opentour);
        EditText emailtour = (EditText) findViewById(R.id.emailtour);
        EditText pricetour = (EditText) findViewById(R.id.pricetour);
        Button addtour = (Button) findViewById(R.id.addtour);

    }
}
