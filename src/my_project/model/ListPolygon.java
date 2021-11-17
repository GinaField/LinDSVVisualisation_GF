package my_project.model;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListPolygon extends GraphicalObject {
    private ViewController viewController;
    private ListPolygon previousListPolygon;
    private boolean arrived;
    private boolean deleted;
    private int r;
    private int g;
    private int b;

    public ListPolygon (double x, double y, int r, int g, int b, ListPolygon previousListPolygon, ViewController viewController){
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.previousListPolygon = previousListPolygon;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(r,g,b,255);
        drawTool.drawFilledPolygon(x,y,x+40,y+40,x+60,y+60);

    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousListPolygon== null || y < previousListPolygon.getY()){
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

