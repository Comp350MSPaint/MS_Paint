package com.example.paintapplication;
//This is an example code for "having back and fore bitmaps and merge them at last"
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;
import android.view.View;

public class PaintView extends View{

    Bitmap mMergedLayersBitmap=null; //Note: this bitmap here contains the whole of the drawing (background+foreground) to be saved.
    Canvas mMergedLayersCanvas=null;

    Bitmap mBitmap = null; //bitmap onto which we draw our stuff
    Canvas mCanvas = null; //Main canvas. Will be linked to a .bmp file
    int mBackgroundColor = 0xFF000000; //default background color
    Paint mDefaultPaint = new Paint();

    Paint mDrawPaint = new Paint(); //used for painting example foreground stuff... We draw line segments.
    Point mDrawColor = new Point(); //used to store last location on our PaintView that was finger-touched

    //Constructor: we instantiate 2 Canvas-Bitmap pairs
    public PaintView(Context context, int width, int height) {
        super(context);
        mMergedLayersBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mMergedLayersCanvas = new Canvas(mMergedLayersBitmap);

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    //Change background color
    public void changeColor(int newColor){
        mBackgroundColor = newColor;
        invalidate(); //refresh view: this will indirectly invoke onDraw soon afterwards
    }

    //Called by user of PaintView in order to start a painting "stroke" (finger touching touch-screen): stores the
    //location of the finger when it first touched the screen
    public void startDraw(int x, int y, int radius, int color){
        mDrawPaint.setColor(color);
        mDrawPaint.setStyle(Style.STROKE);
        mDrawPaint.setStrokeWidth(radius);
        mDrawColor.x = x;
        mDrawColor.y = y;
    }

    //Called by user of PaintView when finger touching touch-screen is moving (must be called after a startDraw,
    //as the latter initializes a couple of necessary things)
    public void continueDraw(int x, int y){
        mCanvas.drawLine(mDrawColor.x, mDrawColor.y, x, y, mDrawPaint);
        mDrawColor.x = x;
        mDrawColor.y = y;
        invalidate(); //refresh view: this will indirectly invoke onDraw soon afterwards
    }

    //Merge the foreground Canvas-Bitmap with a solid background color, then stores this in the 2nd Canvas-Bitmap pair.
    private void mergeLayers(){
        mMergedLayersCanvas.drawColor(mBackgroundColor);
        mMergedLayersCanvas.drawBitmap(mBitmap, 0, 0, mDefaultPaint);
    }

    @Override
    public void onDraw(Canvas canvas){
        mergeLayers();
        canvas.drawBitmap(mMergedLayersBitmap, 0, 0, mDefaultPaint);
    }

}