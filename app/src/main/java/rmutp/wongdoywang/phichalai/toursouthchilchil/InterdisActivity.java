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

public class InterdisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interdis);


        TextView TextView44 = (TextView) findViewById(R.id.textView44);
        TextView44.setText(getIntent().getStringExtra("interested1"));


        ImageView ImageView10 = (ImageView) findViewById(R.id.imageView10);
        Picasso.with(this).load(getIntent().getStringExtra("interested2")).resize(480, 200).into(ImageView10);


        TextView TextView43 = (TextView) findViewById(R.id.textView43);
        TextView43.setText(getIntent().getStringExtra("interested3"));


        TextView open2 = (TextView) findViewById(R.id.open2);
        open2.setText(getIntent().getStringExtra("interested4"));


        TextView call = (TextView) findViewById(R.id.call);
        call.setText(getIntent().getStringExtra("interested5"));


        TextView Email = (TextView) findViewById(R.id.Email);
        Email.setText(getIntent().getStringExtra("interested6"));


        TextView price2 = (TextView) findViewById(R.id.price2);
        price2.setText(getIntent().getStringExtra("interested7"));


        TextView travel = (TextView) findViewById(R.id.travel);
        travel.setText(getIntent().getStringExtra("interested8"));

    }
}
