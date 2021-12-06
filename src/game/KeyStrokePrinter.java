package game;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;
import game.displayable.*;

public class KeyStrokePrinter implements InputObserver, Runnable {

    private static int DEBUG = 1;
    private static String CLASSID = "KeyStrokePrinter";
    private static Queue<Character> inputQueue = null;
    private ObjectDisplayGrid displayGrid;
    private Player player;
    private boolean dropItem = false;
    private boolean equipArmor = false;
    private boolean equipSword = false;
    private boolean readScroll = false;

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
            
            if(player.getIsGameOver() == true){
                return false;
            }
            if (inputQueue.peek() == null) {
                processing = false;
            } else {
                ch = inputQueue.poll();
                if (DEBUG > 1) {
                    System.out.println(CLASSID + ".processInput peek is " + ch);
                } if(dropItem){
                    if(Character.isDigit(ch) && ch != '0' && (ch - '0') <= player.pack.size()){
                        int index = ch - '0' - 1;
                        player.dropItem(index);
                    }else{
                        player.getDungeon().drawInfo("Need to give a digit 1-9 that is an index of the pack");
                    }
                    dropItem = false;
                } else if(equipArmor) {
                    if (Character.isDigit(ch) && ch != '0' && (ch - '1') < player.pack.size()) {
                        int index = ch - '0' - 1;
                        player.wear_Armor(index);
                    }else{
                        player.getDungeon().drawInfo("Need to give a digit 1-9 that is an index of the pack");
                    }
                    equipArmor = false;
                } else if (equipSword) {
                    if (Character.isDigit(ch) && ch != '0' && (ch - '1') < player.pack.size()) {
                        int index = ch - '0' - 1;
                        player.Take_Sword(index);
                    }else{
                        player.getDungeon().drawInfo("Need to give a digit 1-9 that is an index of the pack");
                    }
                    equipSword = false;
                } if(readScroll){
                    if(Character.isDigit(ch) && ch != '0' && (ch - '0') <= player.pack.size()){
                        int index = ch - '0' - 1;
                        player.readItem(index);
                        System.out.println("Reading item");
                    }else{
                        player.getDungeon().drawInfo("Need to give a digit 1-9 that is an index of the pack");
                    }
                    readScroll = false;

                }
                else if (ch == 'h'){
                    System.out.println("moving player left");
                    player.move(-1, 0, displayGrid);
                }else if (ch == 'l'){
                    System.out.println("moving player right");
                    player.move(1, 0, displayGrid);
                }else if (ch == 'k'){
                    System.out.println("moving player down");
                    player.move(0, 1, displayGrid);
                }else if (ch == 'j'){
                    System.out.println("moving player up");
                    player.move(0, -1, displayGrid);
                }else if (ch == 'p'){
                    System.out.println("picking up item");
                    player.pickUpItem();
                }else if (ch == 'i'){
                    System.out.println("displaying pack and info");
                    player.getDungeon().drawPack();
                }else if (ch == 'd'){
                    System.out.println("dropping item");
                    dropItem = true;
                }else if(ch == 'w'){
                    equipArmor = true;
                }
                else if (ch == 't'){
                    equipSword = true;
                    System.out.println("Equipped Sword");
                }
                else if (ch == 'r'){
                    readScroll = true;
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
