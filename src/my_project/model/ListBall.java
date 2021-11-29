package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListBall extends GraphicalObject {

    private ListBall previous;
    private ListBall next=null;
    private int r,g,b;
    private boolean isOnPointer;
    private boolean arrived;
    private boolean deleted;
    private ViewController viewController;

    public ListBall(double x,ListBall previousBall, ViewController viewController){
        this.x=x;
        y=950;
        previous=previousBall;
        this.viewController=viewController;
        viewController.draw(this);
        r=b=g=255;
        isOnPointer=false;
        arrived = false;
        deleted = false;
        radius = 20;
    }

    public void draw(DrawTool drawTool){
        if(isOnPointer){
            drawTool.setCurrentColor(150,150,0,255);
            drawTool.drawFilledCircle(x,y,radius+5);
        }
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public void setPrevious(ListBall newPrevious){ previous=newPrevious; }
    public void setNext(ListBall theNext){ next=theNext; }
    public void setColorBlack(){ r=g=b=0; }
    public void setR(){
        setColorBlack();
        r=255;
    }
    public void setG(){
        setColorBlack();
        g=255;
    }
    public void setB(){
        setColorBlack();
        b=255;
    }
    public void changePointer(){ isOnPointer=!isOnPointer; }
    public ListBall getPrevious(){ return previous; }

    public boolean tryToDelete(){
        return deleted=true;
    }

    public void update(double dt){
        if(y>950) y-=50*dt;
        if(!arrived){
            if(previous == null || x > previous.getX()+50) x -= 100*dt;
            if(previous!=null&&previous.getX()>x-50) x += 100*dt;
            if (x < 50) arrived = true;
        }
        if(deleted){
            if(isOnPointer){
                if(next!=null) next.changePointer();
            }
            y += 200*dt;
            if(y > 1100) viewController.removeDrawable(this);
            if(next!=null) next.setPrevious(previous);
        }
    }
}
