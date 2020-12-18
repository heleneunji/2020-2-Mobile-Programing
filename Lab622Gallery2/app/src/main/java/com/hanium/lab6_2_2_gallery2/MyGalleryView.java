package com.hanium.lab6_2_2_gallery2;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.hanium.lab6_2_2_gallery2.MainActivity.ivPoster;

public class MyGalleryView extends BaseAdapter {
    Context context;

    public MyGalleryView(Context c) {context = c;}
    public int getCount() {return posterID.length;}

    public Object getItem(int position) {return null;}
    public long getItemId(int position) {return 0;}

    Integer[] posterID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5};

    Integer[] posterTitle = {R.string.mov1, R.string.mov2, R.string.mov3, R.string.mov4, R.string.mov5};

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new Gallery.LayoutParams(300, 400));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5, 5, 5, 5);

        imageview.setImageResource(posterID[position]);

        final int pos = position;

        imageview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //ivPoster = (ImageView)findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[pos]);

                Toast toast = new Toast(context.getApplicationContext());
                View toastView = (View) View.inflate(
                        context.getApplicationContext(), R.layout.toast_view, null);
                TextView toastText = (TextView) toastView.findViewById(R.id.textView1);
                toastText.setText(posterTitle[pos]);
                toast.setView(toastView);
                toast.show();
                
                return false;
            }
        });
        return imageview;
    }
}
