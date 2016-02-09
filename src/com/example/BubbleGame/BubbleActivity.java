package com.example.BubbleGame;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;

public class BubbleActivity extends Activity {

    SpriteView view;
    GameModel model;
    // keep a reference to the running thread so
    // we can kill it from a lifecycle method
    GameThread runner;
    static String tag = "Bubble: ";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new GameModel();
        view = new SpriteView(this);
        setContentView(view);
        System.out.println(tag + model);
        System.out.println(tag + view);
    }

    public GameModel getModel() {
        return model;
    }

    public void onResume() {
        super.onResume();
        System.out.println("Bubble: onResume: ");
        rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        System.out.println("Bubble: onResume: " + rect);
        runner = new GameThread();
        runner.start();
    }

    public void onPause() {
        super.onPause();
        runner.running = false;
        try {
            runner.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Rect rect;


    class GameThread extends Thread {
        // have
        boolean running = true;

        public void run() {
            System.out.println(tag + "Running thread ...");
            while (running) {
                try {
                    rect = new Rect(0, 0, view.getWidth(), view.getHeight());
                    // System.out.println("Bubble Thread: " + rect);
                    getModel().update(rect, Constants.delay);
                    view.postInvalidate();
                    Thread.sleep(Constants.delay);
                } catch (Exception e) {
                    System.out.println("BubbleThread: " + e);
                    e.printStackTrace();
                }
            }
        }
    }
}
