package com.example.BubbleGame;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by bernardot on 2/9/16.
 */
public class GameModel {
    ArrayList<Sprite> sprites;
    int nSprites = 20;
    int score;
    int timeRemaining = 1000000;

    static Paint paintBlue, paintGreen;

    static {
        paintBlue = new Paint();
        paintBlue.setColor(Color.BLUE);
        paintBlue.setStyle(Paint.Style.FILL);
        paintBlue.setAntiAlias(true);

        paintGreen = new Paint();
        paintGreen.setColor(Color.GREEN);
        paintGreen.setStyle(Paint.Style.FILL);
        paintGreen.setAntiAlias(true);
    }

    public void update(Rect rect, int delay) {
        // check that the drawing rectangle is valid
        if (rect.width() <= 0 || rect.height() <= 0) return;

        if (!gameOver()) {
            for (Sprite sprite : sprites) sprite.update(rect);
            timeRemaining -= delay;
        }
    }

    public boolean gameOver() {
        return timeRemaining <= 0;
    }

    public GameModel() {
        System.out.println("Bubble GameModel: GameModel()");
        initSprites();
        score = 0;
        System.out.println("Bubble GameModel:  finished in ()");
    }

    public void click(float x, float y) {
        for (Sprite s : sprites) {
            if (s.contains(x, y)) {
                score += s.getScore();
                s.reSpawn();
                return;
            }
        }
    }

    void initSprites() {
        sprites = new ArrayList<Sprite>();
        for (int i = 0; i < nSprites; i++) {
            Paint p = i % 2 == 0 ? paintBlue : paintGreen;
            sprites.add(new Sprite(p));
        }
    }
}
