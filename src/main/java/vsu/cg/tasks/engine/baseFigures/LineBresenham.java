package vsu.cg.tasks.engine.baseFigures;

import javafx.scene.paint.Color;

public class LineBresenham extends Line {

    public LineBresenham(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        gContext.setFill(Color.RED);
        Color color = new Color(34,432,432,43);
        /*
        TODO выше смотри  для алгоритма ву показанно тут как яркость поменять
         */
        int deltax, deltay, error, deltaerr, y, x, diry, dirx;
        deltax = (int) Math.abs(x2 - x1);
        deltay = (int) Math.abs(y2 - y1);
        error = 0;
        if(x2 <x1){
            double mem = x2;
            x2 = x1;
            x1 = mem;
            mem = y2;
            y2 = y1;
            y1 = mem;
        }
        if (deltax > deltay) {
            deltaerr = deltay + 1;
            y = (int) y1;
            diry = (int) (y2 - y1);
            if (diry > 0) {
                diry = 1;
            }
            if (diry < 0) {
                diry = -1;
            }
            for (double x0 = x1; x0 < x2; x0++) {
                drawPixel(x0, y);
                error = error + deltaerr;
                if (error >= (deltax + 1)) {
                    y += diry;
                    error -= (deltax + 1);
                }
            }
        } else {
            deltaerr = deltax + 1;
            x = (int) x1;
            dirx = (int) (x2 - x1);
            if (dirx > 0) {
                dirx = 1;
            }
            if (dirx < 0) {
                dirx = -1;
            }
            if(y2<y1){
                for (double y0 = y1; y0 > y2; y0--) {
                    drawPixel(x, y0);
                    error = error + deltaerr;
                    if (error >= (deltay + 1)) {
                        x += dirx;
                        error -= (deltay + 1);
                    }
                }
            }else {
                for (double y0 = y1; y0 < y2; y0++) {
                    drawPixel(x, y0);
                    error = error + deltaerr;
                    if (error >= (deltay + 1)) {
                        x += dirx;
                        error -= (deltay + 1);
                    }
                }
            }
        }
    }
}
