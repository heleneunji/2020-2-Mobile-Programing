package com.hanium.lab5_2_3_imagehandling;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static com.hanium.lab5_2_3_imagehandling.MainActivity.angle;
import static com.hanium.lab5_2_3_imagehandling.MainActivity.satur;
import static com.hanium.lab5_2_3_imagehandling.MainActivity.scaleX;
import static com.hanium.lab5_2_3_imagehandling.MainActivity.scaleY;

public class MyGraphicView extends View {
    public MyGraphicView(Context context) {
        super(context);
    }

    public MyGraphicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGraphicView(Context context, AttributeSet ats, int defaultStyle) {
        super(context, ats, defaultStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cenX = this.getWidth() / 2;
        int cenY = this.getHeight() / 2;
        canvas.scale(scaleX, scaleY, cenX, cenY);
        canvas.rotate(angle, cenX, cenY);

        Paint paint = new Paint();
        float[] array = {MainActivity.color, 0, 0, 0, 0, 0, MainActivity.color, 0, 0, 0, 0, 0, MainActivity.color, 0, 0, 0, 0, 0, 1, 0};
        ColorMatrix cm = new ColorMatrix(array);

        if (satur == 0)
            cm.setSaturation(satur);

        paint.setColorFilter(new ColorMatrixColorFilter(cm));

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.me1);
        int picX = (this.getWidth() - picture.getWidth()) / 2;
        int picY = (this.getHeight() - picture.getHeight()) / 2;
        canvas.drawBitmap(picture, picX, picY, paint);

        picture.recycle();
    }
}
