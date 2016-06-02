package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        ScrollView scrollView3 = (ScrollView) findViewById(R.id.scrollView3);
        ImageView ImageView6 = (ImageView) findViewById(R.id.imageView6);
        TextView TextView18 = (TextView) findViewById(R.id.textView18);
        TextView TextView19 = (TextView) findViewById(R.id.textView19);
        EditText price1 = (EditText) findViewById(R.id.price1);
        EditText open = (EditText) findViewById(R.id.open);
        EditText add = (EditText) findViewById(R.id.add);
        EditText trivel1 = (EditText) findViewById(R.id.trivel1);
        RatingBar RatingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        Button Button19 = (Button) findViewById(R.id.button19);
        TextView TextView20 = (TextView) findViewById(R.id.textView20);

    }
}
