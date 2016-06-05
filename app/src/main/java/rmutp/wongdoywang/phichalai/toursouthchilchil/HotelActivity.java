package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.squareup.picasso.Picasso;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setText(getIntent().getStringExtra("hotel1"));

        ImageView ImageView6 = (ImageView) findViewById(R.id.imageView6);
        Picasso.with(this).load(getIntent().getStringExtra("hotel2")).resize(480, 200).into(ImageView6);

        TextView textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setText(getIntent().getStringExtra("hotel3"));

        TextView open1 = (TextView) findViewById(R.id.open1);
        open1.setText(getIntent().getStringExtra("hotel4"));

        TextView email1 = (TextView) findViewById(R.id.email1);
        email1.setText(getIntent().getStringExtra("hotel5"));

        TextView price1 = (TextView) findViewById(R.id.price1);
        price1.setText(getIntent().getStringExtra("hotel6"));

        TextView tavel1 = (TextView) findViewById(R.id.tavel1);
        tavel1.setText(getIntent().getStringExtra("hotel7"));


    }
}
