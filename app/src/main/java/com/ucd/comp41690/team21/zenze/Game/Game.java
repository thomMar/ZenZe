package com.ucd.comp41690.team21.zenze.Game;

import android.content.Context;
import android.util.Log;

/**
 * Created by annalena on 16.10.17.
 */

public class Game implements Runnable{
    public GameView view;
    private Thread gameThread;
    private boolean running;

    public Game(Context context){
        gameThread = null;
        view = new GameView(context);
        running = true;
    }

    @Override
    public void run() {
        Log.d("run", "running");
        while(running){
            view.render();
            try {
                gameThread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onResume(){
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void onPause(){
        running = false;
        while(true){
            try {
                gameThread.join();
                break;
            } catch (InterruptedException e){}
        }
        gameThread = null;
    }
}
