package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class ArrayField extends GraphicalObject {

    public ArrayField(int x, int y, ViewController viewController){
        this.x = x;
        this.y = y;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 8; j++){
                drawTool.drawRectangle(x + i * 40, y + j * 40, 30, 30);
            }
        }
    }
}
