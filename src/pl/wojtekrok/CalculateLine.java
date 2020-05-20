package pl.wojtekrok;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for calculating line based on points.
 *
 * WARNING: You DON'T have to modify this class - keep your solution in Pattern.java file
 */
public class CalculateLine {
    private CalculateLine() {
    }


    /**
     * Method return list of Points (pairs with x and y coordinates) that should contain sign in order to display user
     * a line starting from (x1,y1) up to (x2,y2).
     */
    public static List<Point> calculateLinePoints(int x1, int y1, int x2, int y2)
    {
        List<Point> line = new ArrayList<Point>();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while (true)
        {
            line.add(new Point(x1, y1));

            if (x1 == x2 && y1 == y2)
                break;

            e2 = 2 * err;
            if (e2 > -dy)
            {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (e2 < dx)
            {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
        return line;
    }
}
