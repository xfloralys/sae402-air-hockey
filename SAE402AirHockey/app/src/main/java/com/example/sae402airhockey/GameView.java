package com.example.sae402airhockey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * TODO: document your custom view class.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 100, circleY = 100;

    public GameView(Context c) {
        super(c);
        setFocusable(true);
        if (surfaceHolder == null) {
            surfaceHolder = getHolder();
            surfaceHolder.addCallback(this);
        }
        if (paint == null) {
            paint = new Paint();
            paint.setColor(Color.RED);
        }
        this.setZOrderOnTop(true);
        this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawPlayer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void drawPlayer() {
        Canvas c = surfaceHolder.lockCanvas();
        c.drawCircle(circleX, circleY, 100, paint);
        surfaceHolder.unlockCanvasAndPost(c);
    }

    public float getCircleX() {
        return circleX;
    }
    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }
    public float getCircleY() {
        return circleY;
    }
    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }
    public Paint getPaint() {
        return paint;
    }
    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}