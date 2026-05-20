package com.example.sae402airhockey;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private Paint redPaint, bluePaint, blackPaint, whitePaint;
    private int viewWidth, viewHeight, viewCenterX, viewCenterY;
    private int goalWidth, goalHeight, leftGoalPosX, rightGoalPosX, goalPosY;

    public GameView(Context context) {
        super(context);
        // init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        viewWidth = this.getMeasuredWidth();
        viewHeight = this.getMeasuredHeight();
        viewCenterX = (int)(viewWidth / 2);
        viewCenterY = (int)(viewHeight / 2);

        // Définition des coordonées des buts (utile pour leur détection plus tard)
        goalWidth = 20;
        goalHeight = (int)(viewHeight / 3);
        goalPosY = goalHeight;
        leftGoalPosX = 0;
        rightGoalPosX = viewWidth - goalWidth;

        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setColor(Color.rgb(255, 0, 0));
        bluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setColor(Color.rgb(0, 0, 255));
        blackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        blackPaint.setColor(Color.rgb(0, 0, 0));
        whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        whitePaint.setColor(Color.rgb(255, 255, 255));
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);

        // Traits bleus
        c.drawRect((float)(viewCenterX / 2.25), 0, 10, viewHeight, bluePaint); // Gauche
        c.drawRect(viewWidth - (float)(viewCenterX / 2.25), 0, 10, viewHeight, bluePaint); // Droite

        // Buts
        c.drawRect(leftGoalPosX, goalPosY, goalWidth, goalHeight, blackPaint); // But à gauche
        c.drawRect(rightGoalPosX, goalPosY, goalWidth, goalHeight, blackPaint); // But à droite

        // Bordure rouge de la vue
        c.drawRect(0, 0, 10, viewHeight, redPaint); // Bordure rouge à gauche
        c.drawRect(0, 0, viewWidth, 10, redPaint); // Bordure rouge en haut
        c.drawRect(viewWidth - 10, 0, 10, viewHeight, redPaint); // Bordure rouge à droite
        c.drawRect(0, viewHeight - 10, viewWidth, 10, redPaint); // Bordure rouge en bas

        // Trait rouge au milieu
        c.drawRect(viewCenterX - 5, 0, viewCenterX + 5, viewHeight, redPaint);

        // Cercle au centre de la vue
        c.drawOval(viewCenterX - 110, viewCenterY - 110, viewCenterX + 110, viewCenterY + 110, redPaint); // Contour rouge
        c.drawOval(viewCenterX - 100, viewCenterY - 100, viewCenterX + 100, viewCenterY + 100, whitePaint);
    }
}