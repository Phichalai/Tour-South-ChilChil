package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tourTextView, provinceTextView, descripTextView;
    private ImageView imageView;
    private RatingBar ratingBar;
    private String strTour, strProcivce;
    private float score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        //Bind Widget
        bindWidget();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //show View
        showView();

    }//Main Method

    private void showView() {

        strTour = getIntent().getStringExtra("Tour");
        tourTextView.setText(strTour);

        String strDistrict = getIntent().getStringExtra("District");
        strProcivce = getIntent().getStringExtra("Province");
        provinceTextView.setText(strDistrict + " : " + strProcivce);

        String strDescrip = getIntent().getStringExtra("Description");
        descripTextView.setText(strDescrip);

        String strImge = getIntent().getStringExtra("Image");
        Picasso.with(this).load(strImge).resize(200,200).into(imageView);
    }//showView

    private void bindWidget() {
        tourTextView = (TextView) findViewById(R.id.textView9);
        provinceTextView = (TextView) findViewById(R.id.textView10);
        descripTextView = (TextView) findViewById(R.id.textView12);
        imageView = (ImageView) findViewById(R.id.imageView3);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        //button
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = ratingBar.getRating();
                Log.d("sfasfsaf", String.valueOf(score));
                Toast.makeText(MapsActivity.this, "ขอบคุณที่ให้คะแนนค่ะ",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

    public void onRatingChanged(RatingBar ratingBar, float rating,
                                boolean fromUser) {
        score = rating;
        Log.d("sfasfsaf", String.valueOf(score));
            }
        });
    }//bindWidget

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String strLat = getIntent().getStringExtra("Lat");
        String strLng = getIntent().getStringExtra("Lng");

        double douLat = Double.parseDouble(strLat);
        double douLng = Double.parseDouble(strLng);
        LatLng latLng = new LatLng(douLat, douLng);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        mMap.addMarker(new MarkerOptions().position(latLng));
    }//onMap

}//Main class
