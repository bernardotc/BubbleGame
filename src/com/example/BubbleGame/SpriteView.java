package com.example.BubbleGame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by bernardot on 2/9/16.
 */
public class SpriteView extends View {
    BubbleActivity controller;

    static String tag = "Bubble Sprite View: ";
    public void onDraw(Canvas g) {
        // get the model
        List<Sprite> sprites = controller.getModel().sprites;
        // System.out.println(tag + "onDraw: " + sprites.get(0).v + " : " + sprites.get(0).s);
        for (Sprite sprite : sprites) {

            sprite.draw(g);
        }
    }

    public SpriteView(Context context) {
        super(context);
        this.controller = (BubbleActivity) context;
    }

    public SpriteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.controller = (BubbleActivity) context;
    }

    public SpriteView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.controller = (BubbleActivity) context;
    }
}
