package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class ArrayMarker extends GraphicalObject {

    private int i,j;

    public ArrayMarker(ViewController viewController){
        i = 0;
        j = 0;
        x = 130;
        y = 100;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawRectangle(x, y, 30, 30);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        x=130+40*i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
        y= 100 + 40*j;
    }
}

