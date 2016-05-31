package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
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

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

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
        Picasso.with(this).load(strImge).resize(480,200).into(imageView);
    }//showView

    private void bindWidget() {
        tourTextView = (TextView) findViewById(R.id.textView9);
        provinceTextView = (TextView) findViewById(R.id.textView10);
        descripTextView = (TextView) findViewById(R.id.textView12);
        imageView = (ImageView) findViewById(R.id.imageView3);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);



        final Dialog dialog = new Dialog(MapsActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // no titlebar
        dialog.setContentView(R.layout.activity_range);

        String temppoint = getIntent().getStringExtra("point");

        int point = Integer.parseInt(temppoint);
        int star = 0;

        if(point > 100){
            star = 5;
        }else if(point >= 80 && point <= 100){
            star = 4;
        }else if(point >= 60 && point <= 80){
            star = 3;
        }else if(point >= 40 && point <= 60){
            star = 2;
        }else if(point >= 1 && point <= 40){
            star = 1;
        }else{
            star = 0;
        }

        RatingBar ratingBar2 = (RatingBar) dialog.findViewById(R.id.ratingBar2);
        ratingBar2.setRating(star);

        Button button6 = (Button) dialog.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();

        //button
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = ratingBar.getRating();


                //conected http การคอนเน็ตปรค
                StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                        .Builder().permitAll().build();
                StrictMode.setThreadPolicy(threadPolicy);

                try {

                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("countpoint","true"));

                    Log.d("sfasfsdgdgdaf", String.valueOf(score));
                    Log.d("sfasfsdgdgdaf", strTour);

                    nameValuePairs.add(new BasicNameValuePair("point",String.valueOf(score)));
                    nameValuePairs.add(new BasicNameValuePair("name", strTour));

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/saa/php_add_user_phichalai.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                    httpClient.execute(httpPost);
                    Toast.makeText(MapsActivity.this, "ขอบคุณที่ให้คะแนนค่ะ",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(MapsActivity.this,"Error", "ไม่สามารถเชื่อมต่อ Server ได้");
                    Log.d("test", "e =" + e.toString());
                }
            }
        });


        final String strRes = getIntent().getStringExtra("res");
        final String strHotel = getIntent().getStringExtra("hotel");

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( strRes ) );
                startActivity( browse );

            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( strHotel ) );
                startActivity( browse );
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
