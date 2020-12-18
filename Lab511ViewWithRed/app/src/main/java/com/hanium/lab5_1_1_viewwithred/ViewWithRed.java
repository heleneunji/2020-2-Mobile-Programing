package com.hanium.lab5_1_1_viewwithred;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;

public class ViewWithRed extends View {
    public ViewWithRed(Context context) {super(context); }
    public ViewWithRed(Context context, AttributeSet attrs) {super(context, attrs);}
    public ViewWithRed(Context context, AttributeSet ats, int defaultStyle) {
        super(context, ats, defaultStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.RED);
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/3, circlePaint);

    }
}