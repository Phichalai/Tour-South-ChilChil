package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class admin_main extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button travel = (Button) findViewById(R.id.travel);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent("tourTABLE");
            }
        });

        Button travelhit = (Button) findViewById(R.id.travelhit);
        travelhit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent("interested");
            }
        });

        Button travelseason = (Button) findViewById(R.id.travelseason);
        travelseason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent("season");
            }
        });

        Button travelnews = (Button) findViewById(R.id.travelnews);
        travelnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent("report");
            }
        });
    }

    void intent(String name){
        intent = new Intent(admin_main.this, admin_menu.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
