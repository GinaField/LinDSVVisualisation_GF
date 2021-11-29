package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class ArrayCircle extends GraphicalObject {

    private ViewController viewController;
    private int r;
    private int g;
    private int b;

    public ArrayCircle(int x, int y, ViewController viewController, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.viewController = viewController;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,5);
    }

    public void setR(int r) {
        this.r = r;
    }

    public void delete(){
        viewController.removeDrawable(this);
    }

}
