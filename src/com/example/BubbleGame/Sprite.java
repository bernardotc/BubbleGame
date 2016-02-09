package com.example.BubbleGame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

import static com.example.BubbleGame.Constants.*;

/**
 * Created by bernardot on 2/9/16.
 */
public class Sprite {
    Vector2d s, v;
    float rad;
    Paint fg;

    public Sprite(Paint fg, double width, double height) {
        this(width, height);
        this.fg = fg;
    }

    static Random random = new Random();

    public Sprite(double width, double height) {
        s = new Vector2d();
        v = new Vector2d();
        reSpawn(width, height);
    }

    public void reSpawn(double width, double height) {
        rad = (float) (width / minRadiusFactor + random.nextInt((int) (width / randSizeFactor)));
        s.set(0,0);
        v.set(velocityScale * (float) random.nextGaussian(),
                velocityScale * (float) random.nextGaussian());
    }

    public int getScore() {
        return fg == GameModel.paintGreen ? greenScore : blueScore;
    }

    public void update(Rect rect) {
        s.add(v);
        s.wrap(rect.width(), rect.height());
    }

    public boolean contains(float x, float y) {
        return s.dist(x,y) < rad;
    }

    public void draw(Canvas c) {
        c.drawCircle(s.x, s.y, rad, fg);
    }
}
