package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //explicit
    private MyManage myManage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //request database
        myManage = new MyManage(this);

        //test add value
        //testaddValue();

        //Delete All data
        deleteAllData();





    }//Main Method

    private void deleteAllData() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);
        sqLiteDatabase.delete(MyManage.tour_table, null, null);
    }

    private void testaddValue() {
        myManage.addUser("user", "pass", "name", "email");
        myManage.addTour("province", "district", "name", "Cat", "descrip", "image",
                "lat", "lng", "range");
    }

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
    }


}//Main Class
