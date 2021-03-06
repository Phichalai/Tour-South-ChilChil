package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class WinterdisActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasondis);

        TextView namenametourtour = (TextView) findViewById(R.id.nametour);
        namenametourtour.setText(getIntent().getStringExtra("season1"));

        TextView newtext = (TextView) findViewById(R.id.newtext);
        newtext.setText(getIntent().getStringExtra("season2"));

        ImageView ImageView = (ImageView) findViewById(R.id.imageView8);
        Picasso.with(this).load(getIntent().getStringExtra("season3")).resize(480, 200).into(ImageView);

        TextView Description = (TextView) findViewById(R.id.Description);
        Description.setText(getIntent().getStringExtra("season4"));

        TextView open = (TextView) findViewById(R.id.open);
        open.setText(getIntent().getStringExtra("season5"));

        TextView emaill = (TextView) findViewById(R.id.emaill);
        emaill.setText(getIntent().getStringExtra("season6"));

        TextView price = (TextView) findViewById(R.id.price);
        price.setText(getIntent().getStringExtra("season7"));


    }
}
