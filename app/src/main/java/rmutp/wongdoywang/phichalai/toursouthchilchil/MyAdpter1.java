package rmutp.wongdoywang.phichalai.toursouthchilchil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Phichalai on 8/4/2559.
 */
public class MyAdpter1 extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings;
    private int[] resId;

    public MyAdpter1(Context context, String[] titleStrings, int[] resId) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.resId = resId;
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

        de.hdodenhof.circleimageview.CircleImageView tempthumbnail = (de.hdodenhof.circleimageview.CircleImageView) view1.findViewById(R.id.imageView2);
        tempthumbnail.setImageResource(resId[i]);

        TextView titleTextView = (TextView) view1.findViewById(R.id.txttest);
        titleTextView.setText(titleStrings[i]);

        return view1;
    }
}// Main Class
