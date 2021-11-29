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
        /*switch (key){
            case KeyEvent.VK_Q -> programController.addBall("List");
            case KeyEvent.VK_S -> programController.deleteBall();
            case KeyEvent.VK_R -> programController.setColor("r");
            case KeyEvent.VK_G -> programController.setColor("g");
            case KeyEvent.VK_B -> programController.setColor("b");
            case KeyEvent.VK_A -> programController.changeListPointer("toFirst");
            case KeyEvent.VK_D -> programController.changeListPointer("next");
            case KeyEvent.VK_W -> programController.addBall("current");
        }*/
        switch (key){
            case KeyEvent.VK_E -> programController.deleteArrayObj();
            case KeyEvent.VK_Q -> programController.insertArrayObj();
            case KeyEvent.VK_BACK_SPACE -> programController.deleteAllArrayObjects();
            case KeyEvent.VK_W -> programController.arrayCurrentUp();
            case KeyEvent.VK_S -> programController.arrayCurrentDown();
            case KeyEvent.VK_A -> programController.arrayCurrentLeft();
            case KeyEvent.VK_D -> programController.arrayCurrentRight();
            case KeyEvent.VK_SPACE -> programController.fillArray();
        }


    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*if(e.getButton() == MouseEvent.BUTTON1){ // falls die linke Maustaste geklickt wurde...
            programController.addBallToQueue();
        } else { // falls eine andere Maustaste geklickt wurde
            programController.deleteBallFromQueue();
        }*/
        if(e.getButton() == MouseEvent.BUTTON1){ // falls die linke Maustaste geklickt wurde...

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
