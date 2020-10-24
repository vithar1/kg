package vsu.cg.tasks.engine.baseFigures.line.line_extends;

import vsu.cg.tasks.engine.baseFigures.line.Line;

public class LineDDA extends Line {

    public LineDDA(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void drawLine() {
        double xStart = Math.round(x1);
        double yStart = Math.round(y1);
        double xEnd = Math.round(x2);
        double yEnd = Math.round(y2);
        int L = (int) (Math.max(( Math.abs(xEnd - xStart)), Math.abs(yEnd - yStart))) + 1;
        if(y2<y1) {
            double x = x2;
            double y = y2;
            for (int i = 0; i < L; i+=1) {
                drawPixel(x, y);
                x -= (xEnd - xStart) / L;
                y -= (yEnd - yStart) / L;
            }
        }else{
            double x = x1;
            double y = y1;
            for (int i = 0; i < L; i+=1) {
                drawPixel(x, y);
                x += (xEnd - xStart) / L;
                y += (yEnd - yStart) / L;
            }
        }
    }
}