package my_project.model;

import KAGO_framework.model.GraphicalObject;

public class ArrayMarker extends GraphicalObject {

    private int i,j;

    public ArrayMarker(double x, double y, int i, int j){
        i = 0;
        j = 0;
        x = 130;
        y= 100;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
