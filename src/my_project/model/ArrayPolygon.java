package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ArrayPolygon extends GraphicalObject {
    private ViewController viewController;
    private double x;
    private double y;
    private boolean arrived;
    private boolean deleted;
    private ArrayPolygon posArray;

    private int r;
    private int g;
    private int b;

    public ArrayPolygon (ViewController viewController, double x, double y, ArrayPolygon posArray, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.posArray = posArray;
        this.r = r;
        this.g = g;
        this.b = b;
        this.viewController = viewController;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledRectangle(x,y,200,200);


    }
    public void update(double dt){
        if(!arrived){
            /*if(previousMeArray== null || y < previousMeArray.getY()){
                y += 100*dt;
            }*/
            if (y <= 500){
                arrived = true;
            }
        }
        if(deleted){
            y += 200*dt;
            if(y > 600) viewController.removeDrawable(this);
        }
    }

    public boolean tryToDelete(){
        if(arrived){
            deleted = true;
            return deleted;
        }
        return false;
    }

}
