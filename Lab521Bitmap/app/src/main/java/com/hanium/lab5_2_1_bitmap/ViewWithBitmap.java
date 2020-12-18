package com.hanium.lab5_2_1_bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

public class ViewWithBitmap extends View {

    public ViewWithBitmap(Context context) {
        super(context);
    }

    public ViewWithBitmap(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewWithBitmap(Context context, AttributeSet ats, int defaultStyle) {
        super(context, ats, defaultStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);

        Bitmap myPic = BitmapFactory.decodeResource(getResources(), R.drawable.me1);

        Bitmap myPicMedium = Bitmap.createScaledBitmap(myPic, 200, 300, false);
        canvas.drawBitmap(myPicMedium, 60, 75, null);

        Bitmap myPicSmall = Bitmap.createScaledBitmap(myPic, 50, 75, false);

        Matrix maxTopLeft = new Matrix();
        maxTopLeft.preRotate(30);

        Matrix maxBottomLeft = new Matrix();
        maxBottomLeft.preRotate(-30);

        Matrix maxTopRight = new Matrix();
        maxTopRight.preRotate(-30);
        maxTopRight.preScale(-1, 1);

        Matrix maxBottomRight = new Matrix();
        maxBottomRight.preRotate(30);
        maxBottomRight.preScale(-1, 1);

        Bitmap myPicTopLeft = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxTopLeft, false);
        Bitmap myPicBottomLeft = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxBottomLeft, false);

        Bitmap myPicTopRight = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxTopRight, false);
        Bitmap myPicBottomRight = Bitmap.createBitmap(myPicSmall, 0, 0, myPicSmall.getWidth(), myPicSmall.getHeight(), maxBottomRight, false);

        myPicSmall.recycle();
        myPic.recycle();

        canvas.drawBitmap(myPicTopLeft, 30, 30, null);
        canvas.drawBitmap(myPicBottomLeft, 30, 325, null);
        canvas.drawBitmap(myPicTopRight, 225, 30, null);
        canvas.drawBitmap(myPicBottomRight, 225, 325, null);
    }
}