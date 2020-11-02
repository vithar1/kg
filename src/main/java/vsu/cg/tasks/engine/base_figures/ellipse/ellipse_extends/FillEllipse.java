package vsu.cg.tasks.engine.base_figures.ellipse.ellipse_extends;

import javafx.scene.Group;
import vsu.cg.tasks.engine.base_figures.ellipse.Ellipse;

public class FillEllipse extends Ellipse {
    public FillEllipse(Group parentGroup, double x1, double y1, double a, double b) {
        super(parentGroup, x1, y1, a, b);
    }

    @Override
    public void draw() {
        for (double x = -a; x <= a; x++) {
            for (double y = -b; y <= b; y++) {
                if ((x / a) * (x / a) + (y / b) * (y / b) - 1 < 0.03) {
                    drawPixel(x1 + x, y1 + y);
                }
            }
        }
    }
}