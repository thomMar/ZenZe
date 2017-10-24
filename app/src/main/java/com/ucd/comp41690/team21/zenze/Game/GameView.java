package com.ucd.comp41690.team21.zenze.Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by annalena on 24.10.17.
 */

public class GameView extends SurfaceView {
    Canvas canvas;
    SurfaceHolder holder;
    public GameView(Context context) {
        super(context);
        canvas = null;
        holder = getHolder();
    }

    public void render(){
        Log.d("view", "rendering");
        if(holder.getSurface().isValid()) {
            canvas = holder.getSurface().lockHardwareCanvas();
            if (canvas != null) {
                Log.d("view", "got canvas");
                Paint myPaint = new Paint();
                myPaint.setColor(Color.BLUE);
                canvas.drawColor(Color.RED);
                canvas.drawCircle(0, 0, 100, myPaint);
            }
            holder.getSurface().unlockCanvasAndPost(canvas);
        }
    }
}

