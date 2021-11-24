package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Circle extends GraphicalObject {

    private ViewController viewController;
    private int r;
    private int g;
    private int b;

    public Circle(double x, double y,int r, int g, int b, ViewController viewController){

        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        viewController.draw(this);

    }

    public void draw(DrawTool drawTool){

        drawTool.drawFilledRectangle(x,y,100,100);

    }

}
