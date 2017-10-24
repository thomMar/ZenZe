package com.ucd.comp41690.team21.zenze.Activities;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import com.ucd.comp41690.team21.zenze.Game.Game;
import com.ucd.comp41690.team21.zenze.R;

/**
 * the main game screen
 */
public class GameActivity extends Activity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        game = new Game(this);
        setContentView(game.view);
    }

    @Override
    public void onPause(){
        Log.d("activity", "pause");
        super.onPause();
        game.onPause();
    }

    @Override
    public void onResume(){
        Log.d("activity", "resume");
        super.onResume();
        game.onResume();
    }
}
