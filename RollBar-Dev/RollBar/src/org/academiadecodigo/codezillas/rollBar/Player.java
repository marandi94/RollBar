package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player {

    private Keyboard keyboard;
    private String name;
    private GameBlock currentPiece;
    private Cube cube;

    public void moveLeft(){

    }

    public void moveRight(){

    }

    public void swap(){

    }

    public void initKeyboard(KeyboardHandler currentPiece) {

        Keyboard keyboard = new Keyboard(currentPiece);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveDown);
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public void setCurrentPiece(GameBlock currentPiece) {
        this.currentPiece = currentPiece;
    }

    public GameBlock getCurrentPiece() {
        return currentPiece;
    }

    public Cube getCube() {
        return cube;
    }
}
