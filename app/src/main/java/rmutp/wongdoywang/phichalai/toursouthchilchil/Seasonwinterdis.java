package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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


public class Seasonwinterdis extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonraindis);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        TextView season = (TextView) findViewById(R.id.season);
        season.setText(getIntent().getStringExtra("season1"));

        TextView nametour = (TextView) findViewById(R.id.nametour);
        nametour.setText(getIntent().getStringExtra("season2"));

        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        Picasso.with(this).load(getIntent().getStringExtra("season3")).resize(480, 200).into(imageView8);

        ImageView imageView55 = (ImageView) findViewById(R.id.imageView55);
        Picasso.with(this).load(getIntent().getStringExtra("season4")).resize(480, 200).into(imageView55);

        ImageView imageView56 = (ImageView) findViewById(R.id.imageView56);
        Picasso.with(this).load(getIntent().getStringExtra("season5")).resize(480, 200).into(imageView56);

        TextView newtext = (TextView) findViewById(R.id.newtext);
        newtext.setText(getIntent().getStringExtra("season6"));


        TextView open = (TextView) findViewById(R.id.open);
        open.setText(getIntent().getStringExtra("season7"));


        TextView emaill = (TextView) findViewById(R.id.emaill);
        emaill.setText(getIntent().getStringExtra("season8"));


        TextView price = (TextView) findViewById(R.id.price);
        price.setText(getIntent().getStringExtra("season9"));



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
}
