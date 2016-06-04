package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Seasonwinterdis extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonraindis);

        TextView season = (TextView) findViewById(R.id.season);
        season.setText(getIntent().getStringExtra("season1"));

        TextView nametour = (TextView) findViewById(R.id.nametour);
        nametour.setText(getIntent().getStringExtra("season2"));

        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        Picasso.with(this).load(getIntent().getStringExtra("season3")).resize(480, 200).into(imageView8);

        TextView newtext = (TextView) findViewById(R.id.newtext);
        newtext.setText(getIntent().getStringExtra("season4"));


        TextView open = (TextView) findViewById(R.id.open);
        open.setText(getIntent().getStringExtra("season5"));


        TextView emaill = (TextView) findViewById(R.id.emaill);
        emaill.setText(getIntent().getStringExtra("season6"));


        TextView price = (TextView) findViewById(R.id.price);
        price.setText(getIntent().getStringExtra("season7"));


        TextView traval = (TextView) findViewById(R.id.traval);
        traval.setText(getIntent().getStringExtra("season8"));


    }
}