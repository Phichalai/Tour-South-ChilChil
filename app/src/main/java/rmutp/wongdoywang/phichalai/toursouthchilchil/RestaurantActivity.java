package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        TextView TextView16 = (TextView) findViewById(R.id.textView16);
        TextView16.setText(getIntent().getStringExtra("restaurant1"));

        ImageView ImageView5 = (ImageView) findViewById(R.id.imageView5);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant2")).resize(480, 200).into(ImageView5);

        ImageView imageView59 = (ImageView) findViewById(R.id.imageView59);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant3")).resize(480, 200).into(imageView59);

        ImageView imageView60 = (ImageView) findViewById(R.id.imageView60);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant4")).resize(480, 200).into(imageView60);

        TextView TextView15 = (TextView) findViewById(R.id.textView15);
        TextView15.setText(getIntent().getStringExtra("restaurant5"));

        TextView open3 = (TextView) findViewById(R.id.open3);
        open3.setText(getIntent().getStringExtra("restaurant6"));

        TextView addd = (TextView) findViewById(R.id.addd);
        addd.setText(getIntent().getStringExtra("restaurant7"));

        TextView traval2 = (TextView) findViewById(R.id.traval2);
        traval2.setText(getIntent().getStringExtra("restaurant8"));

        TextView price3 = (TextView) findViewById(R.id.price3);
        price3.setText(getIntent().getStringExtra("restaurant9"));

    }
}






