package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.ListPolygon;
import my_project.model.QueueBall;
import my_project.model.StackBox;
import my_project.view.InputReceiver;
import my_project.model.ListPointer;

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
    private ListPointer listPointer;
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
        listPointer = new ListPointer(600,400);


    }
    public void movePointerToRight(){

    }
    /*public List getPrevious(List.ListNode pNode) {
        if (pNode != null && pNode != first && !this.polygonList.isEmpty()) {
            List.ListNode temp = first;
            while (temp != null && temp.getNextNode() != pNode) {
                temp = temp.getNextNode();
            }
            return temp;
        } else {
            return null;
        }
    }*/
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
    public void addPolygonToList(){
        ListPolygon newListPolygon = new ListPolygon(200,600,((int)(Math.random()*255)),((int)(Math.random()*255)),((int)(Math.random()*255)), lastPolygonInList,viewController);
        polygonList.insert(newListPolygon);
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
         //   if(polygonList.insert();){

           // }
        }
    }
    public void deletePolygonFromList(){
        if(!polygonList.isEmpty()){


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
