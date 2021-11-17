package my_project.model;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ListPointer extends GraphicalObject {

    public ListPointer(double x, double y ){
        this.x = x;
        this.y = y;

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawRectangle(x,y+50,40,60);

    }


}
