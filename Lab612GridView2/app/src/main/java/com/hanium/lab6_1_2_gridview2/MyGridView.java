package com.hanium.lab6_1_2_gridview2;

import android.app.AlertDialog;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridView extends BaseAdapter {
    Context context;

    public MyGridView(Context c) {context = c;}
    public int getCount() {return posterID.length;}

    public Object getItem(int position) {return null;}
    public long getItemId(int position) {return 0;}

    Integer[] posterID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5};

    Integer[] posterTitle = {R.string.mov1, R.string.mov2, R.string.mov3, R.string.mov4, R.string.mov5};

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new GridView.LayoutParams(400, 650));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5, 5, 10, 10);

        imageview.setImageResource(posterID[position]);

        final int pos = position;
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialogView = (View) View.inflate(
                        context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ImageViewForPoster);
                ivPoster.setImageResource(posterID[pos]);
                //dlg.setTitle("큰 포스터");
                //dlg.setIcon(R.drawable.ic_launcher);
                dlg.setTitle(posterTitle[pos]);
                dlg.setIcon(posterID[pos]);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
        return imageview;
    }
}