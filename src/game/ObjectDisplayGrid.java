package game;

import game.asciiPanel.AsciiPanel;
import game.displayable.Displayable;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {

    private static final int DEBUG = 0;
    private static final String CLASSID = ".ObjectDisplayGrid"; 

    private static AsciiPanel terminal;
    private Displayable[][] objectGrid = null; // 2d array of char objects

    private List<InputObserver> inputObservers = null;

    private static int topHeight;
    private static int gameHeight;
    private static int bottomHeight;

    private static int width;
    private static ObjectDisplayGrid instance = null;

    // csn add more parameters, call before getInstance
    public static void setGridSize(int _width, int __topHeight, int _gameHeight, int _bottomHeight){
        if(instance != null){
            System.out.println("Setting grid size after object display grid was already created");
        }
        width = _width;
        topHeight = __topHeight;
        gameHeight = _gameHeight;
        bottomHeight = _bottomHeight;
    }

    public static ObjectDisplayGrid getInstance(){
        if(instance == null){
            instance = new ObjectDisplayGrid();
        }
        return instance;
    }

    private ObjectDisplayGrid() {
        //width = _width;
        //height = _height;

        terminal = new AsciiPanel(width, topHeight + gameHeight + bottomHeight);

        objectGrid = new Displayable[width][gameHeight];

        //initializeDisplay(); // drawing dots across screen

        super.add(terminal);
        super.setSize(width * 10, (topHeight + gameHeight + bottomHeight) * 17);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // super.repaint();
        // terminal.repaint( );
        super.setVisible(true);
        terminal.setVisible(true);
        terminal.addKeyListener(this);
        super.addKeyListener(this);
        inputObservers = new ArrayList<>();
        super.repaint();
    }

    @Override
    public void registerInputObserver(InputObserver observer) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".registerInputObserver " + observer.toString());
        }
        inputObservers.add(observer);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".keyTyped entered" + e.toString());
        }
        KeyEvent keypress = (KeyEvent) e;
        notifyInputObservers(keypress.getKeyChar());
    }

    private void notifyInputObservers(char ch) {
        for (InputObserver observer : inputObservers) {
            observer.observerUpdate(ch);
            if (DEBUG > 0) {
                System.out.println(CLASSID + ".notifyInputObserver " + ch);
            }
        }
    }

    // we have to override, but we don't use this
    @Override
    public void keyPressed(KeyEvent even) {
    }

    // we have to override, but we don't use this
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void fireUp() {
        if (this.requestFocusInWindow()) {
            System.out.println(CLASSID + ".ObjectDisplayGrid(...) requestFocusInWindow Succeeded");
        } else {
            System.out.println(CLASSID + ".ObjectDisplayGrid(...) requestFocusInWindow FAILED");
        }
    }

    public void addObjectToDisplay(Displayable ch, int x, int y) {
        if ((0 <= x) && (x < objectGrid.length)) {
            if ((0 <= y) && (y < objectGrid[0].length)) {
                objectGrid[x][y] = ch;
                writeToTerminal(x, y);
            }
        }
    }

    public Displayable getObject(int x, int y){
        Displayable obj = objectGrid[x][y];
        return obj;
    }

    private void writeToTerminal(int x, int y) {
        char ch = objectGrid[x][y].getChar();
        terminal.write(ch, x, y + topHeight); // can offset
        terminal.repaint();
    }

    public void writeToTop(String str, int y){
        terminal.write(str, 0, y);
        for(int i = str.length(); i < width; i++){
            terminal.write(' ', i, y);
        }
        terminal.repaint();
    }

    public void writeToBottom(String str, int y){
        terminal.write(str, 0, y + topHeight + gameHeight);
        for(int i = str.length(); i < width; i++){
            terminal.write(' ', i, y + topHeight + gameHeight);
        }
        terminal.repaint();
    }
}