package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.ListPointer;
import my_project.model.ListPolygon;
import my_project.model.QueueBall;
import my_project.model.StackBox;
import my_project.view.InputReceiver;
import my_project.model.ArrayClass;
import my_project.model.Circle;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute

    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Queue<QueueBall> ballQueue;
    private QueueBall lastBallinQueue;
    private Stack<StackBox> boxStack;
    private StackBox lastBoxInStack;
    private List<ListPolygon> polygonList;
    private ListPolygon lastPolygonInList;
    private ListPolygon first;
    private ListPolygon current;
    private ListPolygon last;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        // Für Benutzerinteraktion
        new InputReceiver(this,viewController); // darf anonym sein, weil kein Zugriff nötig ist
        // Für die Queue:
        ballQueue = new Queue<>();
        lastBallinQueue = null; // die letzte Kugel muss für die Animation gemerkt werden
        boxStack = new Stack<>();
        lastBoxInStack = null;
        polygonList = new List<>();
        lastPolygonInList = null;
        first = null;

        ArrayClass [][] circleArray = new ArrayClass[8][4]; //Array wird erzeugt
        for(int x = 0; x < circleArray[0].length; x++){ // solange x = 0 und x kleiner als die länge von cir.. wird c
            for(int y = 0; y < circleArray.length; y++){
                ArrayClass cArray = new ArrayClass(400,400,10 , 10, 10, false, viewController);
                if (x == 0 && y == 0) {
                    cArray.setCurrent(true);
                }
            }
        }

    }

    public void movePointer(){
        ListPointer newPointer = new ListPointer(lastPolygonInList.getX(),lastPolygonInList.getY(), true,viewController);
        polygonList.next();
    }
    public ListPolygon getPrevious(){
        ListPolygon temp = polygonList.getContent();
        polygonList.toFirst();
        while(polygonList.hasAccess()){
            polygonList.next();
            if(polygonList.getContent().equals(current.getNextListPolygon())){
                return temp;
            }
        }
        return null;
    }
    public void pointerToFirst(){
        if (!polygonList.isEmpty()) {
            current = first;

        }
    }
    public void addBallToQueue(){
        QueueBall newQueueBall = new QueueBall(650,50,lastBallinQueue,viewController);
        ballQueue.enqueue(newQueueBall);
        lastBallinQueue = newQueueBall;
    }
    public void addBoxOnStack(){
        StackBox newStackBox = new StackBox(400,400,((int)(Math.random()*255)),((int)(Math.random()*255)),((int)(Math.random()*255)),lastBoxInStack,viewController);
        boxStack.push(newStackBox);
        lastBoxInStack = newStackBox;
    }

    public void appendPolygonToList(){
        ListPolygon newListPolygon = new ListPolygon(800,700,((int)(Math.random()*255)),((int)(Math.random()*255)),((int)(Math.random()*255)), lastPolygonInList, viewController);
        lastPolygonInList = first;
        polygonList.append(newListPolygon);
        lastPolygonInList = newListPolygon;

    }
    public void deleteBallFromQueue(){
        if(!ballQueue.isEmpty()){
            if(ballQueue.front().tryToDelete()){
                ballQueue.dequeue();
            }
        }
    }
    public void deleteBoxFromStack(){
        if(!boxStack.isEmpty()){
            if(boxStack.top().tryToDelete()){
                boxStack.pop();
            }
        }
    }
    public void insertInList(){
        if(!polygonList.isEmpty()){

        }
    }
    public void deletePolygonFromList(){
        if(!polygonList.isEmpty()){
            current.tryDelete();
            polygonList.remove();
            current = getPrevious();
        }
    }

    /**
     * Aufruf bei Mausklick
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){

    }
    public void keyPressed(int key) {

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }
}
//ToDo schreibe eine funktionierende insert Methode
//ToDo schreibe eine funktionierende delete Methode
//ToDo schaffe es das der pointer auf das erste Objekt zeigt
//ToDo schaffe es das der pointer sich nach rechts bewegt