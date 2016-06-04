package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class SummerdisActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasondis);


        TextView namenametourtour = (TextView) findViewById(R.id.season);
        namenametourtour.setText(getIntent().getStringExtra("season1"));

        TextView nametour = (TextView) findViewById(R.id.nametour);
        nametour.setText(getIntent().getStringExtra("season2"));

        ImageView ImageView = (ImageView) findViewById(R.id.imageView8);
        Picasso.with(this).load(getIntent().getStringExtra("season3")).resize(480, 200).into(ImageView);

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
