package game.displayable.creatures;

import game.displayable.item.*;
import game.displayable.*;
import java.util.*;
import game.ObjectDisplayGrid;

public class Player extends Creature {
    private String name;
    private int room;
    private int serial;
    private Dungeon dungeon;

    private List<Item> pack = new ArrayList<Item>();

    public Player(String _name, int _room, int _serial) {
        setName(_name);
        setRoom(_room);
        setSerial(_serial);
        System.out.println("Player created");
    }
    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setRoom(int _room){
        room = _room;
        System.out.println("room set");
    }
    public void setSerial(int _serial){
        serial = _serial;
        System.out.println("serial set");
    }
    public char getChar(){
        return '@';
    }

    // move(deltaX, deltaY)
    public void move(int deltaX, int deltaY, ObjectDisplayGrid grid){
        int x = this.getPosX();
        int y = this.getPosY();
        if(grid.getObject(x + deltaX, y + deltaY).canTraverse()){
            this.setPosX(x + deltaX);
            this.setPosY(y + deltaY);
            dungeon.draw();
        }
    }

    public void setDungeon(Dungeon _dungeon){
        dungeon = _dungeon;
    }

/*
    public void setWeapon(Item sword){

    }
    public void setArmor(Item armor){

    }
    */
}
