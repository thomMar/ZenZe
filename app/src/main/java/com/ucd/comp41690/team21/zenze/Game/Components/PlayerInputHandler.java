package com.ucd.comp41690.team21.zenze.Game.Components;

import android.view.InputEvent;
import android.view.MotionEvent;

import com.ucd.comp41690.team21.zenze.Game.Commands.Command;
import com.ucd.comp41690.team21.zenze.Game.Commands.Jump;
import com.ucd.comp41690.team21.zenze.Game.Commands.MoveHorizontal;
import com.ucd.comp41690.team21.zenze.Game.Game;
import com.ucd.comp41690.team21.zenze.Game.GameObject;
import com.ucd.comp41690.team21.zenze.Game.InputObserver;

/**
 * receives input from the user
 * defines characters reaction
 */
public class PlayerInputHandler extends InputObserver implements InputComponent{

    private MotionEvent inputEvent;

    private MoveHorizontal moveLeft;
    private MoveHorizontal moveRight;
    private Jump jumpUp;

    private Command returnCommand;

    public PlayerInputHandler(float playerSpeed) {
        Game.getInstance().addInputObserver(this);
        moveLeft = new MoveHorizontal(-playerSpeed);
        moveRight = new MoveHorizontal(playerSpeed);
        jumpUp = new Jump();
        returnCommand = null;
    }

    @Override
    public Command handleInput(GameObject object) {
        if(inputEvent!=null) {
            switch (inputEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    if (inputEvent.getX() < Game.getInstance().getWidth() / 4) {
                        returnCommand = moveLeft;
                    } else if  (inputEvent.getX() > Game.getInstance().getWidth()*3/4){
                        returnCommand = moveRight;
                    } else {
                        returnCommand = jumpUp;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    returnCommand = null;
                    break;
            }
        }
        return returnCommand;
    }

    @Override
    public void onNotify(InputEvent event) {
        try {
            this.inputEvent = (MotionEvent) event;
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }
}
