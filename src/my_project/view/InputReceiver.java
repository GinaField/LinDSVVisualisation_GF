package my_project.view;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputReceiver implements Interactable {

    private ProgramController programController;
    private ViewController viewController;

    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputReceiver(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this);
    }

    @Override
    public void keyPressed(int key) {
        if(viewController.isKeyDown(KeyEvent.VK_W)){
            programController.addBoxOnStack();
        }
        if(viewController.isKeyDown(KeyEvent.VK_S)){
            programController.deleteBoxFromStack();
        }
        if(viewController.isKeyDown(KeyEvent.VK_B)){
            programController.appendPolygonToList();
        }
        if(viewController.isKeyDown(KeyEvent.VK_DOWN)){
            //programController.deletePolygonFromList();
        }
        if(viewController.isKeyDown(KeyEvent.VK_RIGHT)){
            programController.movePointerToRight();
        }
        if(viewController.isKeyDown(KeyEvent.VK_UP)){
            programController.pointerToFirst();
        }

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){ // falls die linke Maustaste geklickt wurde...
            programController.addBallToQueue();
        } else { // falls eine andere Maustaste geklickt wurde
            programController.deleteBallFromQueue();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
