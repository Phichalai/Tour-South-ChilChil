package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class admin_add_interested extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_interested);

        EditText nameinterested = (EditText) findViewById(R.id.nameinterested);
        EditText imagea = (EditText) findViewById(R.id.imagea);
        EditText imageb = (EditText) findViewById(R.id.imageb);
        EditText imagec = (EditText) findViewById(R.id.imagec);
        EditText descriptionss = (EditText) findViewById(R.id.descriptionss);
        EditText latijuda = (EditText) findViewById(R.id.latijuda);
        EditText longtijuda = (EditText) findViewById(R.id.longtijuda);
        EditText open4 = (EditText) findViewById(R.id.open4);
        EditText call2 = (EditText) findViewById(R.id.call2);
        EditText email3 = (EditText) findViewById(R.id.email3);
        EditText price4 = (EditText) findViewById(R.id.price4);
        Button addinterested = (Button) findViewById(R.id.addinterested);

    }
}
