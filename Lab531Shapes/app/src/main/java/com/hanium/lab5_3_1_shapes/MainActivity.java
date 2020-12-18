package com.hanium.lab5_3_1_shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button lineButton = (Button) findViewById(R.id.ButtonLine);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeDrawable d = new ShapeDrawable(new RectShape());
                d.setIntrinsicHeight(5);
                d.setIntrinsicWidth(250);
                d.getPaint().setColor(Color.BLUE);
                setShapeByDrawable(d);
            }
        });

        final Button rectButton = (Button) findViewById(R.id.ButtonRect);
        rectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShapeByResourceId(R.drawable.green_rect);
            }
        });

        final Button ovalButton = (Button) findViewById(R.id.ButtonOval);
        ovalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShapeByResourceId(R.drawable.red_oval);
            }
        });

        final Button roundRectButton = (Button) findViewById(R.id.ButtonRoundRect);
        roundRectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
                        new float[]{10, 10, 5, 5, 5, 5, 15, 15}, null, null));
                d.setIntrinsicHeight(50);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.CYAN);
                setShapeByDrawable(d);
            }
        });

        final Button pathButton = (Button) findViewById(R.id.ButtonPath);
        pathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        final Button path2Button = (Button) findViewById(R.id.ButtonPath2);
        path2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Path p = new Path();
                p.setFillType(Path.FillType.EVEN_ODD);
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.YELLOW);
                setShapeByDrawable(d);
            }
        });

        final Button path3Button = (Button) findViewById(R.id.ButtonPath3);
        path3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Path p = new Path();
                p.moveTo(50, 0);
                p.lineTo(25, 100);
                p.lineTo(100, 50);
                p.lineTo(0, 50);
                p.lineTo(75, 100);
                p.lineTo(50, 0);

                ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setStyle(Paint.Style.STROKE);
                setShapeByDrawable(d);
            }
        });

        final Button arcButton = (Button) findViewById(R.id.ButtonArc);
        arcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 345));
                d.setIntrinsicHeight(100);
                d.setIntrinsicWidth(100);
                d.getPaint().setColor(Color.MAGENTA);
                setShapeByDrawable(d);
            }
        });
    }

    private void setShapeByDrawable(Drawable drawable) {
        ImageView reusableImageView = (ImageView) findViewById(R.id.ImageViewForShape);
        reusableImageView.setImageDrawable(drawable);
    }

    private void setShapeByResourceId(int resourceId) {
        ImageView reusableImageView = (ImageView)findViewById(R.id.ImageViewForShape);
        reusableImageView.setImageResource(resourceId);
    }

}