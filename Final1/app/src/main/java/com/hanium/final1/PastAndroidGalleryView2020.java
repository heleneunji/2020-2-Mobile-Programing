package com.hanium.final1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import static com.hanium.final1.PastAndroidClass2020Activity.ivPoster;

public class PastAndroidGalleryView2020 extends BaseAdapter {
    Context context;

    public PastAndroidGalleryView2020(Context c) {
        context = c;
    }

    public int getCount() {
        return posterID.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    Integer[] posterID = {R.drawable.android2020_1, R.drawable.android2020_2, R.drawable.android2020_3, R.drawable.android2020_4};

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
                return false;
            }
        });
        return imageview;
    }
}
