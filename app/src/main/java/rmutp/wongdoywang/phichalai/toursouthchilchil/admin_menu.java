package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_menu extends AppCompatActivity {

    String name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        name = getIntent().getStringExtra("name");

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (name){
                    case "tourTABLE":
                       intent = new Intent(admin_menu.this, admin_add_tourTABLE.class);
                        break;
                    case "interested":
                        intent = new Intent(admin_menu.this, admin_add_interested.class);
                        break;
                    case "season":
                        intent = new Intent(admin_menu.this, admin_add_season.class);
                        break;
                    case "report":
                        intent = new Intent(admin_menu.this, admin_add_report.class);
                        break;
                }

                startActivity(intent);
            }
        });

        Button edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (name){
                    case "tourTABLE":
                        intent = new Intent(admin_menu.this, admin_update_tourTABLE.class);
                        break;
                    case "interested":
                        intent = new Intent(admin_menu.this, admin_update_interested.class);
                        break;
                    case "season":
                        intent = new Intent(admin_menu.this, admin_update_season.class);
                        break;
                    case "report":
                        intent = new Intent(admin_menu.this, admin_update_report.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
