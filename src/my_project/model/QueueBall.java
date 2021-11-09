package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

/**
 * Repräsentiert eine Kugel (einen Kreis), der in eine Schlange eingefügt werden soll. Dabei muss jeder QueueBall immer
 * seinen Vorgänger kennen, damit er zu ihm Abstand halten kann.
 */
public class QueueBall extends GraphicalObject {

    private ViewController viewController;
    private QueueBall previousQueueBall; // Vorgänger des QueueBalls
    private boolean arrived; // hat der QueueBall den Anfang der Schlange erreicht?
    private boolean deleted; // wurde der QueueBall aus der Schlange gelöscht?

    /**
     * Erzeugt einen neuen QueueBall
     * @param x Startposition x
     * @param y Startposition y
     * @param previousQueueBall der vorhergehende QueueBall (kann auch null sein)
     * @param viewController das ViewController-Objekt des Frameworks
     */
    public QueueBall(double x, double y, QueueBall previousQueueBall, ViewController viewController){
        this.x = x;
        this.y = y;
        this.previousQueueBall = previousQueueBall;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }


    /**
     * Selbsterklärend: zeichnet den QueueBall. Wird vom Framework aufgerufen.
     */
    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawCircle(x,y,20);
    }

    /**
     * Wird mit jeder Frame vom Framework aufgerufen und dient zur Manipulation des Objekts im Verlauf
     * der Zeit.
     * @param dt die Sekunden, die seit dem letzten Aufruf von update vergangen sind
     */
    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueBall == null || x > previousQueueBall.getX()+50) x -= 100*dt;
            if (x < 100) arrived = true;
        }
        if(deleted){
            x -= 200*dt;
            if(x < -25) viewController.removeDrawable(this);
        }
    }

    /**
     * Versucht das Objekt auf deleted zu setzen. Dies bewirkt, dass es sich aus dem Fenster heraus bewegt.
     * @return true, falls das Löschen geklappt hat, sonst false
     */
    public boolean tryToDelete(){
        if(arrived){
            deleted = true;
            return deleted;
        }
        return false;
    }
}
