package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.graphics.Cube;

public class Main {
    public static void main(String[] args) {

        Graphics graphics = new Graphics();

        graphics.init();

        Cube test = new Cube(graphics);

        Player one = new Player();

        one.initKeyboard(test);


    }
}