package com.example.temp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * TODO: document your custom view class.
 */
public class GameView extends SurfaceView {
    /*
     * ----- FICHIER NON UTILISE -----
     * Mais pour l'instant il reste quand
     * même dans le repo parce que ça reste
     * une bonne base pour plus tard
     */

    private Paint redPaint, bluePaint, blackPaint, whitePaint;
    private int viewWidth, viewHeight, viewCenterX, viewCenterY;
    private int goalWidth, goalHeight, leftGoalPosX, rightGoalPosX, goalPosY;

    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        viewWidth = 1920;
        viewHeight = 1080;
        Log.v("", String.valueOf(viewWidth));
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

        Log.v("", "a");
        draw();
    }


    private void draw() {
        Canvas c = new Canvas();
        Log.v("", "b");
        c.drawColor(Color.WHITE);

        // Traits bleus
        c.drawRect((float) (viewCenterX / 2.25), 0, 10, viewHeight, bluePaint); // Gauche
        c.drawRect(viewWidth - (float) (viewCenterX / 2.25), 0, 10, viewHeight, bluePaint); // Droite

        Log.v("", "c");

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