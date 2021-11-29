package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import my_project.model.*;
import my_project.view.InputReceiver;

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
    private List<ListBall> ballList;
    private ListBall lastBallInList;
    private ArrayCircle[][] circleArray;
    private ArrayCircle arrayCircleObj;
    private ArrayMarker arrayMarker;
    private ArrayField arrayField;


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
        new InputReceiver(this,viewController);
        ballList = new List<>();
        ballList.toFirst();
        lastBallInList = null;
        circleArray = new ArrayCircle[4][8];
        arrayField = new ArrayField(130,100,viewController);
        arrayMarker = new ArrayMarker(viewController);

        /*ArrayClass [][] circleArray = new ArrayClass[8][4]; //Array wird erzeugt
        for(int x = 0; x < circleArray[0].length; x++){ // solange x = 0 und x kleiner als die länge von cir.. wird c
            for(int y = 0; y < circleArray.length; y++){
                ArrayClass cArray = new ArrayClass(400,400,10 , 10, 10, false, viewController);
                if (x == 0 && y == 0) {
                    cArray.setCurrent(true);
                }
            }
        }*/

    }
    public void fillArray(){
        if(circleArray[0][0] == null){
            for (int x = 0; x < circleArray.length; x++){
                for (int y = 0; y < circleArray[0].length; y++){
                    circleArray[x][y] = new ArrayCircle(130 + (x * 40) + 15, 100 + (y * 40) + 15, viewController, 0,0,255);
                }
            }
        }
    }

    public void deleteAllArrayObjects(){
        for (int x = 0; x < circleArray.length; x++){
            for (int y = 0; y < circleArray[0].length; y++){
                viewController.removeDrawable(circleArray[x][y]);
                circleArray[x][y] = null;
            }
        }
    }

    public void deleteArrayObj(){
        if(circleArray[arrayMarker.getI()][arrayMarker.getJ()] != null){
            circleArray[arrayMarker.getI()][arrayMarker.getJ()].delete();
            circleArray[arrayMarker.getI()][arrayMarker.getJ()] = null;
        }
    }

    public void insertArrayObj(){
        if(circleArray[arrayMarker.getI()][arrayMarker.getJ()] == null){
            circleArray[arrayMarker.getI()][arrayMarker.getJ()] = new ArrayCircle( ( (int) arrayMarker.getX()) + 15, ( (int) arrayMarker.getY()) + 15, viewController,0,0,255);
        }
    }

    public void changeArrayObj(){
        if(circleArray[arrayMarker.getI()][arrayMarker.getJ()] != null){
            circleArray[arrayMarker.getI()][arrayMarker.getJ()].setR(255);
        }
    }

    public void arrayCurrentRight(){
        if(arrayMarker.getI() < circleArray.length-1){
            arrayMarker.setI(arrayMarker.getI()+1);
        }
    }

    public void arrayCurrentLeft(){
        if(arrayMarker.getI() > 0){
            arrayMarker.setI(arrayMarker.getI()-1);
        }
    }

    public void arrayCurrentUp(){
        if(arrayMarker.getJ() > 0){
            arrayMarker.setJ(arrayMarker.getJ()-1);
        }
    }

    public void arrayCurrentDown(){
        if(arrayMarker.getJ() < circleArray[0].length-1){
            arrayMarker.setJ(arrayMarker.getJ()+1);
        }
    }
    public void addBall(String to){
        switch(to){
            case "List" -> {
                if(ballList.isEmpty()){
                    addListBall();
                    ballList.toFirst();
                    ballList.getContent().changePointer();
                }else {
                    ListBall previous = lastBallInList;
                    addListBall();
                    previous.setNext(lastBallInList);
                }
            }
            case "current" -> {
                if(ballList.hasAccess()) {
                    ListBall newListBall = new ListBall(ballList.getContent().getX(), ballList.getContent().getPrevious(), viewController);
                    newListBall.setY(1000);
                    newListBall.setNext(ballList.getContent());
                    ballList.getContent().setPrevious(newListBall);
                    if (newListBall.getPrevious() != null) {
                        newListBall.getPrevious().setNext(newListBall);
                    }
                    ballList.insert(newListBall);
                }
            }
        }
    }

    private void addListBall() {
        ListBall newListBall = new ListBall(850,lastBallInList,viewController);
        ballList.append(newListBall);
        lastBallInList = newListBall;
    }

    public void deleteBall(){
        if(!ballList.isEmpty()&& ballList.hasAccess()){
            if(ballList.getContent().tryToDelete()) ballList.remove();
        }
    }
    public void changeListPointer(String to){
        if(ballList.getContent()!=null)ballList.getContent().changePointer();
        switch (to){
            case "toFirst" -> ballList.toFirst();
            case "next" -> {
                if(ballList.hasAccess()) {
                    ballList.next();
                }else{
                    ballList.toFirst();
                }
            }
        }
        if(ballList.getContent()!=null) ballList.getContent().changePointer();
    }
    public void setColor(String color){
        if(!ballList.isEmpty()&&ballList.hasAccess()) {
            switch (color) {
                case "r" -> ballList.getContent().setR();
                case "g" -> ballList.getContent().setG();
                case "b" -> ballList.getContent().setB();
            }
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