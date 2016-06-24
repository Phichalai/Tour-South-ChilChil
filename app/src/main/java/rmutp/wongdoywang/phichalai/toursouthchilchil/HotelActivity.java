package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.squareup.picasso.Picasso;


public class HotelActivity extends AppCompatActivity {
    private ImageView hotela, hotelb, hotelc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        TextView textView20 = (TextView) findViewById(R.id.textView20);
        textView20.setText(getIntent().getStringExtra("hotel1"));

        ImageView hotela = (ImageView) findViewById(R.id.hotela);
        Picasso.with(this).load(getIntent().getStringExtra("hotel2")).resize(480, 200).into(hotela);
        hotela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("hotel2"));
            }
        });

        ImageView hotelb = (ImageView) findViewById(R.id.hotelb);
        Picasso.with(this).load(getIntent().getStringExtra("hotel3")).resize(480, 200).into(hotelb);
        hotelb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("hotel3"));
            }
        });

        ImageView hotelc = (ImageView) findViewById(R.id.hotelc);
        Picasso.with(this).load(getIntent().getStringExtra("hotel4")).resize(480, 200).into(hotelc);
        hotelc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("hotel4"));
            }
        });

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
    private void showBigpic(String tempImage) {

        final Dialog dialog = new Dialog(HotelActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // no titlebar
        dialog.setContentView(R.layout.activity_pic_big);

        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        Picasso.with(this).load(tempImage).into(image);

        ImageView btnClose = (ImageView) dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();

    }
}
