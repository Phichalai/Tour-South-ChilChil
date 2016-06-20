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


public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setText(getIntent().getStringExtra("hotel1"));

        ImageView hotela = (ImageView) findViewById(R.id.hotela);
        Picasso.with(this).load(getIntent().getStringExtra("hotel2")).resize(480, 200).into(hotela);

        ImageView hotelb = (ImageView) findViewById(R.id.hotelb);
        Picasso.with(this).load(getIntent().getStringExtra("hotel3")).resize(480, 200).into(hotelb);

        ImageView hotelc = (ImageView) findViewById(R.id.hotelc);
        Picasso.with(this).load(getIntent().getStringExtra("hotel4")).resize(480, 200).into(hotelc);

        TextView textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setText(getIntent().getStringExtra("hotel5"));

        TextView pricehotel = (TextView) findViewById(R.id.pricehotel);
        pricehotel.setText(getIntent().getStringExtra("hotel6"));

        TextView openhotel = (TextView) findViewById(R.id.openhotel);
        openhotel.setText(getIntent().getStringExtra("hotel7"));

        TextView addhotel = (TextView) findViewById(R.id.addhotel);
        addhotel.setText(getIntent().getStringExtra("hotel8"));

        TextView tavelhotel = (TextView) findViewById(R.id.tavelhotel);
        tavelhotel.setText(getIntent().getStringExtra("hotel9"));



    }
}
