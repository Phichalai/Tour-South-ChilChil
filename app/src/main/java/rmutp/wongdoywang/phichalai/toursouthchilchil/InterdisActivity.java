package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class InterdisActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ImageView imagez, imagezz, imageView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interdis);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

        TextView TextView44 = (TextView) findViewById(R.id.textView44);
        TextView44.setText(getIntent().getStringExtra("interested1"));

        ImageView ImageView10 = (ImageView) findViewById(R.id.imageView10);
        Picasso.with(this).load(getIntent().getStringExtra("interested2")).resize(480, 200).into(ImageView10);

        ImageView imagez = (ImageView) findViewById(R.id.imagez);
        Picasso.with(this).load(getIntent().getStringExtra("interested3")).resize(280, 100).into(imagez);
        imagez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("interested3"));
            }
        });

        ImageView imagezz = (ImageView) findViewById(R.id.imagezz);
        Picasso.with(this).load(getIntent().getStringExtra("interested4")).resize(280, 100).into(imagezz);
        imagezz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("interested4"));
            }
        });


        TextView TextView43 = (TextView) findViewById(R.id.textView43);
        TextView43.setText(getIntent().getStringExtra("interested5"));


        TextView open2 = (TextView) findViewById(R.id.open2);
        open2.setText(getIntent().getStringExtra("interested6"));


        TextView call = (TextView) findViewById(R.id.call);
        call.setText(getIntent().getStringExtra("interested7"));


        TextView Email = (TextView) findViewById(R.id.Email);
        Email.setText(getIntent().getStringExtra("interested8"));


        TextView price2 = (TextView) findViewById(R.id.price2);
        price2.setText(getIntent().getStringExtra("interested9"));


        Button button28 = (Button) findViewById(R.id.button28);
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterdisActivity.this, RestaurantActivityManu.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("restaurant1", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname)));
                intent.putExtra("restaurant2", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge)));
                intent.putExtra("restaurant3", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeB)));
                intent.putExtra("restaurant4", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimgeC)));
                intent.putExtra("restaurant5", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription)));
                intent.putExtra("restaurant6", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen)));
                intent.putExtra("restaurant7", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress)));
                intent.putExtra("restaurant8", cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel)));
                intent.putExtra("restaurant9", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice)));
                intent.putExtra("restaurant10", cursor.getString(cursor.getColumnIndex(MyManage.column_resurl)));
                intent.putExtra("name", getIntent().getStringExtra("interested1"));

                cursor.moveToNext();
                cursor.close();
                startActivity(intent);


            }
        });

        Button Button29 = (Button) findViewById(R.id.button29);
        Button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterdisActivity.this, HotelmanuActivity.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM hotel WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("hotel1", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelname)));
                intent.putExtra("hotel2", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimage)));
                intent.putExtra("hotel3", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimageB)));
                intent.putExtra("hotel4", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelimageC)));
                intent.putExtra("hotel5", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteldescription)));
                intent.putExtra("hotel6", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelprice)));
                intent.putExtra("hotel7", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltime)));
                intent.putExtra("hotel8", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteladdress)));
                intent.putExtra("hotel9", cursor.getString(cursor.getColumnIndex(MyManage.column_hoteltravel)));
                intent.putExtra("hotel10", cursor.getString(cursor.getColumnIndex(MyManage.column_hotelurl)));
                intent.putExtra("name", getIntent().getStringExtra("interested1"));


                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });
    }
    private void showBigpic(String tempImage) {

        final Dialog dialog = new Dialog(InterdisActivity.this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        String strLat = getIntent().getStringExtra("interested10");
        String strLng = getIntent().getStringExtra("interested11");
        double douLat = Double.parseDouble(strLat);
        double douLng = Double.parseDouble(strLng);

        LatLng latLng = new LatLng(douLat, douLng);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mMap.addMarker(new MarkerOptions().position(latLng));
    }
}












