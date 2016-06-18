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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;


public class SummerdisActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasondis);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);


        TextView namenametourtour = (TextView) findViewById(R.id.season);
        namenametourtour.setText(getIntent().getStringExtra("season1"));

        TextView nametour = (TextView) findViewById(R.id.nametour);
        nametour.setText(getIntent().getStringExtra("season2"));

        ImageView ImageView = (ImageView) findViewById(R.id.imageView8);
        Picasso.with(this).load(getIntent().getStringExtra("season3")).resize(480, 200).into(ImageView);

        ImageView imageView57 = (ImageView) findViewById(R.id.imageView57);
        Picasso.with(this).load(getIntent().getStringExtra("season4")).resize(280, 100).into(imageView57);
        imageView57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("season4"));
            }
        });

        ImageView imageView58 = (ImageView) findViewById(R.id.imageView58);
        Picasso.with(this).load(getIntent().getStringExtra("season5")).resize(280, 100).into(imageView58);
        imageView58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("season5"));
            }
        });

        TextView newtext = (TextView) findViewById(R.id.newtext);
        newtext.setText(getIntent().getStringExtra("season6"));

        TextView open = (TextView) findViewById(R.id.open);
        open.setText(getIntent().getStringExtra("season7"));

        TextView emaill = (TextView) findViewById(R.id.emaill);
        emaill.setText(getIntent().getStringExtra("season8"));

        TextView price = (TextView) findViewById(R.id.price);
        price.setText(getIntent().getStringExtra("season9"));

        Button button50 = (Button) findViewById(R.id.button50);
        button50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SummerdisActivity.this, RestaurantActivityManu.class);

                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                        MODE_PRIVATE, null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM restaurant WHERE _id = 1", null);
                cursor.moveToFirst();

                intent.putExtra("restaurant1", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantname)));
                intent.putExtra("restaurant2", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantimge)));
                intent.putExtra("restaurant3", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantdescription)));
                intent.putExtra("restaurant4", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantopen)));
                intent.putExtra("restaurant5", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantaddress)));
                intent.putExtra("restaurant6", cursor.getString(cursor.getColumnIndex(MyManage.column_restauranttravel)));
                intent.putExtra("restaurant7", cursor.getString(cursor.getColumnIndex(MyManage.column_restaurantprice)));
                intent.putExtra("name", getIntent().getStringExtra("season1"));


                cursor.moveToNext();
                cursor.close();


                startActivity(intent);


            }
        });

        Button Button54 = (Button) findViewById(R.id.button54);
        Button54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SummerdisActivity.this, HotelmanuActivity.class);

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
                intent.putExtra("name", getIntent().getStringExtra("season1"));


                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

    Button Button33 = (Button) findViewById(R.id.button33);
    Button33.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(SummerdisActivity.this, CounselActivity.class);
            startActivity(intent);
        }
    });
}

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        String strLat = getIntent().getStringExtra("season10");
        String strLng = getIntent().getStringExtra("season11");
        double douLat = Double.parseDouble(strLat);
        double douLng = Double.parseDouble(strLng);


        LatLng latLng = new LatLng(douLat, douLng);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mMap.addMarker(new MarkerOptions().position(latLng));
    }

    private void showBigpic(String tempImage) {

        final Dialog dialog = new Dialog(SummerdisActivity.this);
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
