package org.academiadecodigo.codezillas.rollBar;


import org.academiadecodigo.codezillas.rollBar.blocks.BlockColor;
import org.academiadecodigo.simplegraphics.graphics.Color;


public class ColorMapper {

    private static final Color colors[] = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW
    };

    public static Color getColor(BlockColor color){
        Color clr = null;
        switch (color) {
            case RED:
                clr = colors[0];
                break;
            case GREEN:
                clr = colors[1];
                break;
            case BLUE:
                clr = colors[2];
                break;
            case YELLOW:
                clr = colors[3];
                break;
            default:
                System.out.println("Color mapper not good!!!");


        }
        return clr;
    }


}
