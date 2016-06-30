package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
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
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tourTextView, provinceTextView,
            descripTextView, MobanTextView, TumbonTextView,
            addtourTextView, calltourTextView, oprntourTextView,
            emailtourTextView, pricetourTextView;
    private ImageView imageView3, imageView6, imageView15;
    private RatingBar ratingBar;
    private String strTour;
    private float score;
    private int star = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        bindWidget();  //Bind Widget

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        showView();  //show View

    }

    private void showView() {

        strTour = getIntent().getStringExtra("Tour");
        tourTextView.setText(getIntent().getStringExtra("Tour"));

        provinceTextView.setText(getIntent().getStringExtra("District")
                + " : " + getIntent().getStringExtra("Province"));
        TumbonTextView.setText(getIntent().getStringExtra("Tumboon"));
        MobanTextView.setText(" : " + getIntent().getStringExtra("Muban"));

        String strDescrip = getIntent().getStringExtra("Description");
        descripTextView.setText(strDescrip);

        String strImge = getIntent().getStringExtra("Image");
        Picasso.with(this).load(strImge).resize(480,200).into(imageView3);

        String strImge6 = getIntent().getStringExtra("Image1");
        Picasso.with(this).load(strImge6).resize(280,100).into(imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("Image1"));
            }
        });

        String strImge5 = getIntent().getStringExtra("Image2");
        Picasso.with(this).load(strImge5).resize(280,100).into(imageView15);
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBigpic(getIntent().getStringExtra("Image2"));
            }
        });

        String straddtour = getIntent().getStringExtra("add");
        addtourTextView.setText(straddtour);

        String strcalltour = getIntent().getStringExtra("call");
        calltourTextView.setText(strcalltour);

        String stroprntour = getIntent().getStringExtra("open");
        oprntourTextView.setText(stroprntour);

        String stremailtour = getIntent().getStringExtra("email");
        emailtourTextView.setText(stremailtour);

        String strpricetour = getIntent().getStringExtra("price");
        pricetourTextView.setText(strpricetour);
    }//showView

    private void showBigpic(String tempImage) {

        final Dialog dialog = new Dialog(MapsActivity.this);
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

    private void bindWidget() {
        tourTextView = (TextView) findViewById(R.id.textView9);
        provinceTextView = (TextView) findViewById(R.id.textView10);
        descripTextView = (TextView) findViewById(R.id.textView12);
        TumbonTextView = (TextView) findViewById(R.id.Tumbon);
        MobanTextView = (TextView) findViewById(R.id.Moban);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        addtourTextView = (TextView) findViewById(R.id.addtour);
        calltourTextView = (TextView) findViewById(R.id.calltour);
        oprntourTextView = (TextView) findViewById(R.id.oprntour);
        emailtourTextView = (TextView) findViewById(R.id.emailtour);
        pricetourTextView = (TextView) findViewById(R.id.pricetour);


        final Dialog dialog = new Dialog(MapsActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // no titlebar
        dialog.setContentView(R.layout.activity_range);

        String temppoint = getIntent().getStringExtra("point");

        int point = Integer.parseInt(temppoint);

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

        final RatingBar ratingBar2 = (RatingBar) dialog.findViewById(R.id.ratingBar2);
        ratingBar2.setRating(star);

        ratingBar2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


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

        /*        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( strRes ) );
                startActivity( browse );*/

                Intent intent = new Intent(MapsActivity.this, RestaurantActivityManu.class);

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
                intent.putExtra("name", strTour);

                cursor.moveToNext();
                cursor.close();
                startActivity(intent);


            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( strHotel ) );
                startActivity( browse );*/

                Intent intent = new Intent(MapsActivity.this, HotelmanuActivity.class);

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
                intent.putExtra("name", strTour);


                cursor.moveToNext();
                cursor.close();

                startActivity(intent);
            }
        });

        //
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                score = rating;
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