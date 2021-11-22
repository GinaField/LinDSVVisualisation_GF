package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListPointer extends GraphicalObject {
    private boolean pointer;


    public ListPointer(double x, double y,boolean pointer, ViewController viewController){
        this.x = x;
        this.y = y;
        this.pointer = pointer;
        viewController.draw(this);
    }

    public void draw(DrawTool drawTool){
        if (pointer == true){
            drawTool.setCurrentColor(100,200,100,255);
            drawTool.drawFilledRectangle(x+10,y+150, 30,30);
            drawTool.drawFilledPolygon(x+25,y+110,x+10,y+150,x+40,y+150);
        }
    }

    public boolean isPointer() {
        return pointer;
    }

    public void setPointer(boolean pointer) {
        this.pointer = pointer;
    }
}
