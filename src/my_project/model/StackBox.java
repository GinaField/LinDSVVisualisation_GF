package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class StackBox extends GraphicalObject{

    private ViewController viewController;
    private StackBox previousStackBox;
    private boolean arrived;
    private boolean deleted;
    private int r;
    private int g;
    private int b;

    public StackBox (double x, double y, int r, int g, int b, StackBox previousStackBox, ViewController viewController){
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.previousStackBox = previousStackBox;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledRectangle(x,y,50,50);
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousStackBox== null || y < previousStackBox.getY()){
                y += 100*dt;
            }
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