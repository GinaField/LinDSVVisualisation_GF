package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ArrayClass extends GraphicalObject {

    private ViewController viewController;
    private int r;
    private int g;
    private int b;
    private boolean current;


    public ArrayClass(double x, double y,int r, int g, int b, boolean current, ViewController viewController){

        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.current = current;
        current = false;
        viewController.draw(this);

    }

    public void draw(DrawTool drawTool){

        drawTool.drawRectangle(x,y,100,100);

    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
