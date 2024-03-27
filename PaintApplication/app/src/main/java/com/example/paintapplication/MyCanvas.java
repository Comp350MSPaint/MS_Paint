package com.example.paintapplication;

import static androidx.core.view.MotionEventCompat.getPointerId;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCanvas extends View {
    Paint paint, block;
    Path path;
    Bitmap mMergedLayersBitmap=null; //Note: this bitmap here contains the whole of the drawing (background+foreground) to be saved.
    Canvas mMergedLayersCanvas=null;

    Bitmap mBitmap = null; //bitmap onto which we draw our stuff
    Canvas mCanvas = null; //Main canvas. Will be linked to a .bmp file

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        block = new Paint();//test block
        path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);//set to background color as this paint is eraser
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15f);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);

        block.setColor(Color.BLACK);
        block.setStyle(Paint.Style.FILL);
        canvas.drawRect(100,100,680,950,block);
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();
        //return super.onTouchEvent(event);

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;

            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        invalidate();
        return true;
    }
}
