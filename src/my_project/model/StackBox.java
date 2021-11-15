package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class StackBox extends GraphicalObject{

    private ViewController viewController;
    private StackBox previousStackBox; // Vorgänger des QueueBalls
    private boolean arrived; // hat der QueueBall den Anfang der Schlange erreicht?
    private boolean deleted; // wurde der QueueBall aus der Schlange gelöscht?

    public StackBox (double x, double y, StackBox previousStackBox, ViewController viewController){
        this.x = x;
        this.y = y;
        this.previousStackBox = previousStackBox;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawRectangle(x,y,50,50);
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousStackBox== null || y < previousStackBox.getY()-30){
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

    public boolean tryToDelete(){ //wenn box auf ihrer position ist wird deleted auf true gesetzt und zurückgegeben
        if(arrived){
            deleted = true;
            return deleted;
        }
        return false;
    }


}