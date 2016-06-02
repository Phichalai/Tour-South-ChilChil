package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Phichalai on 2/6/2559.
 */
public class ManuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);

        Button Button8 = (Button) findViewById(R.id.button8);
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(ManuActivity.this, ProvinceActivity.class));
            }
        });

        Button Button9 = (Button) findViewById(R.id.button9);
        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManuActivity.this, InteresActivity.class));
            }
        });

        Button Button10 = (Button) findViewById(R.id.button10);
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManuActivity.this, SeasonActivity.class));
            }
        });

        Button Button11 = (Button) findViewById(R.id.button11);
        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManuActivity.this, ReportActivity.class));
            }
        });

    }
}
