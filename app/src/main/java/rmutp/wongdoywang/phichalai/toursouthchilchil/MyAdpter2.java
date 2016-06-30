package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Phichalai on 8/4/2559.
 */
public class MyAdpter2 extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings;
    private String[] Img;

    public MyAdpter2(Context context, String[] titleStrings,String[] Img) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.Img = Img;
    }//constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView titleTextView = (TextView) view1.findViewById(R.id.txttest);
        titleTextView.setText(titleStrings[i]);

        URL url = null;
        try {
            url = new URL(Img[i]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        de.hdodenhof.circleimageview.CircleImageView imageView2 = (de.hdodenhof.circleimageview.CircleImageView) view1.findViewById(R.id.imageView2);
        imageView2.setImageBitmap(bmp);
        
        return view1;
    }
}// Main Class
