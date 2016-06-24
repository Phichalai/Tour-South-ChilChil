package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class RestaurantActivity extends AppCompatActivity {
    private ImageView imageView5, imageView59, imageView60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        TextView TextView16 = (TextView) findViewById(R.id.textView16);
        TextView16.setText(getIntent().getStringExtra("restaurant1"));

        ImageView ImageView5 = (ImageView) findViewById(R.id.imageView5);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant2")).resize(480, 200).into(ImageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("restaurant2"));
            }
        });

        ImageView imageView59 = (ImageView) findViewById(R.id.imageView59);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant3")).resize(480, 200).into(imageView59);
        imageView59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("restaurant3"));
            }
        });

        ImageView imageView60 = (ImageView) findViewById(R.id.imageView60);
        Picasso.with(this).load(getIntent().getStringExtra("restaurant4")).resize(480, 200).into(imageView60);
        imageView60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("restaurant4"));
            }
        });

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
    private void showBigpic(String tempImage) {

        final Dialog dialog = new Dialog(RestaurantActivity.this);
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






