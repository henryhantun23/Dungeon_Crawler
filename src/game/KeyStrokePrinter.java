package game;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;

public class KeyStrokePrinter implements InputObserver, Runnable {

    private static int DEBUG = 1;
    private static String CLASSID = "KeyStrokePrinter";
    private static Queue<Character> inputQueue = null;
    private ObjectDisplayGrid displayGrid;
    private Player player;

    public KeyStrokePrinter(ObjectDisplayGrid grid, Player _player) {
        inputQueue = new ConcurrentLinkedQueue<>();
        displayGrid = grid;
        player = _player;
    }

    @Override
    public void observerUpdate(char ch) {
        if (DEBUG > 0) {
            System.out.println(CLASSID + ".observerUpdate receiving character " + ch);
        }
        inputQueue.add(ch);
    }

    private void rest() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean processInput() {

        char ch;

        boolean processing = true;
        while (processing) {
            if (inputQueue.peek() == null) {
                processing = false;
            } else {
                ch = inputQueue.poll();
                if (DEBUG > 1) {
                    System.out.println(CLASSID + ".processInput peek is " + ch);
                }if (ch == 'h'){
                    System.out.println("moving player left");
                    player.move(-1, 0, displayGrid);
                }else if (ch == 'l'){
                    System.out.println("moving player right");
                    player.move(1, 0, displayGrid);
                }else if (ch == 'k'){
                    System.out.println("moving player up");
                    player.move(0, 1, displayGrid);
                }else if (ch == 'j'){
                    System.out.println("moving player down");
                    player.move(0, -1, displayGrid);
                }
            }
        }
        return true;
    }

    @Override
    public void run() {
        displayGrid.registerInputObserver(this);
        boolean working = true;
        while (working) {
            rest();
            working = (processInput( ));
        }
    }
}
