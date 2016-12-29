package com.charles.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Just.T on 16/12/20.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        Paint paint2 = new Paint();
        paint2.setColor(Color.GREEN);

        paint.setStyle(Paint.Style.STROKE);
        paint1.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100,300);
        path.quadTo(200,200,300,300);
        path.quadTo(400,400,500,300);
        canvas.drawPath(path,paint);


        Path path1 = new Path();
        path1.moveTo(100,300);
        path1.lineTo(200,200);
        path1.lineTo(300,300);
        path1.lineTo(400,400);
        path1.lineTo(500,300);
        canvas.drawPath(path1,paint1);

        canvas.drawCircle(200,300,100,paint2);
    }
}
