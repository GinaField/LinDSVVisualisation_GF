package my_project.control;

/**
 * In dieser Klasse werden globale, statische Einstellungen verwaltet.
 * Diese beziehen sich nur auf die Funktionsweise des Frameworks.
 * Für individuelle Einstellungen am eigenen Projekt sollte die Config-Datei im Paket "my_project"
 * verwendet werden.
 */
public class Config {

    // Frameworkversion
    public final static String WINDOW_TITLE = "LinDSVVisuakisation";
    public final static String VERSION = "KNB-AOS-GraphicalObject-Java-Framework - 4.2b - 15.12.2020";
    public final static String JAVA_SUPPORTED = "Java 11 + JavaFX";

    public final static boolean SHOW_DEFAULT_WINDOW = true;
    public final static int WINDOW_WIDTH = 1000;
    public final static int WINDOW_HEIGHT = 1000+29;
    public final static boolean useSound = true;


    // Schaltet die Infomeldungen des Frameworks an oder aus
    public final static boolean INFO_MESSAGES = true;
    public final static boolean DEBUG = false;

}