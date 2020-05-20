package pl.wojtekrok;

import java.awt.*;
import java.util.List;

public class Pattern {


    public String prepareRectangleWithDiagonals(char sign, int width, int height) {
        String pattern = "";
        List<Point> diagonal1 = CalculateLine.calculateLinePoints(1, height - 2, width - 2, 1);
        List<Point> diagonal2 = CalculateLine.calculateLinePoints(1, 1, width - 2, height-2);

        Character[][] t = new Character[height][width];


        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                if (i == 0) {
                    t[i][j] = sign;
                } else if (j == 0) {
                    t[i][j] = sign;
                } else if (i == height - 1) {
                    t[i][j] = sign;
                } else if (j == width - 1) {
                    t[i][j] = sign;
                } else {
                    t[i][j] = ' ';
                }
            }
        }
        try {
            for (Point point : diagonal1) {
                t[(int) point.getY()][(int) point.getX()] = sign;
            }
            for (Point point : diagonal2) {
                t[(int) point.getY()][(int) point.getX()] = sign;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ractangle must be at least 2x2");
        }

        display(t);

        return pattern;
    }
    // method to display the rectangle
    static void display(Character[][] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println();
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j]);
            }
        }
    }


    public static void main(String[] args) {

        new Pattern().prepareRectangleWithDiagonals('*', 34, 22);


    }
}