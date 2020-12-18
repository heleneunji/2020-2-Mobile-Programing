package com.hanium.lab5_1_4_hw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class hw1 extends View {
    public hw1(Context context) {super(context);}
    public hw1(Context context, AttributeSet attrs) {super(context, attrs);}
    public hw1(Context context, AttributeSet ats, int defaultStyle) {
        super (context, ats, defaultStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        RadialGradient radred = new RadialGradient(600, 300, 150, Color.RED, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radred);
        canvas.drawCircle(600, 300, 150, circlePaint);

        RadialGradient radyellow = new RadialGradient(600, 550, 150, Color.YELLOW, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radyellow);
        canvas.drawCircle(600, 550, 150, circlePaint);

        RadialGradient radgreen = new RadialGradient(600, 800, 150, Color.GREEN, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radgreen);
        canvas.drawCircle(600, 800, 150, circlePaint);

        RadialGradient radblue = new RadialGradient(600, 1050, 150, Color.BLUE, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radblue);
        canvas.drawCircle(600, 1050, 150, circlePaint);

        RadialGradient radmag = new RadialGradient(600, 1300, 150, Color.MAGENTA, Color.BLACK, Shader.TileMode.MIRROR);
        circlePaint.setShader(radmag);
        canvas.drawCircle(600, 1300, 150, circlePaint);

        Paint Circle2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Circle2.setColor(Color.WHITE);
        canvas.drawCircle(550, 250, 30, Circle2);

        Paint Circle3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Circle3.setColor(Color.WHITE);
        canvas.drawCircle(650, 250, 30, Circle3);

        Paint Circle4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Circle4.setColor(Color.BLACK);
        canvas.drawCircle(650, 230, 10, Circle4);

        Paint Circle5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        Circle5.setColor(Color.BLACK);
        canvas.drawCircle(550, 230, 10, Circle5);

        Paint change = new Paint(Paint.ANTI_ALIAS_FLAG);
        SweepGradient sweepGrad = new SweepGradient(600, 1500,
                new int[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA}, null);
        change.setShader(sweepGrad);
        canvas.drawCircle(600, 1500, 75, change);

    }
}