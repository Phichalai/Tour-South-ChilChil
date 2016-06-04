package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class ReporttitelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporttitel);

       ImageView ImageView7 = (ImageView) findViewById(R.id.imageView7);


        TextView dis = (TextView) findViewById(R.id.dis);
        TextView reporttitel = (TextView) findViewById(R.id.reporttitel);
        TextView report = (TextView) findViewById(R.id.report);


        String reportname = jsonObject.getString(MyManage.column_reportname);
        String reporttitel = jsonObject.getString(MyManage.column_reporttitel);
        String Imagere = jsonObject.getString(MyManage.column_Imagere);
        String reportdesoription = jsonObject.getString(MyManage.column_reportdesoription);
        String reportform = jsonObject.getString(MyManage.column_reportform);








    }

}
