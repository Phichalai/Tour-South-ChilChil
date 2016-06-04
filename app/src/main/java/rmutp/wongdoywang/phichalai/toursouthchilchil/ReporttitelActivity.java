package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class ReporttitelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporttitel);

        TextView reporttitel = (TextView) findViewById(R.id.reporttitel);
        reporttitel.setText(getIntent().getStringExtra("report1"));

        TextView report = (TextView) findViewById(R.id.report);
        report.setText(getIntent().getStringExtra("report2"));

        ImageView ImageView7 = (ImageView) findViewById(R.id.imageView7);
        Picasso.with(this).load(getIntent().getStringExtra("report3")).resize(480, 200).into(ImageView7);

        TextView dis = (TextView) findViewById(R.id.dis);
        dis.setText(getIntent().getStringExtra("report4"));

        TextView from = (TextView) findViewById(R.id.from);
        from.setText(getIntent().getStringExtra("report5"));
    }
}
