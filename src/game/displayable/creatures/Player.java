package game.displayable.creatures;

import game.displayable.item.*;
import java.util.*;

public class Player extends Creature {
    private String name;
    private int room;
    private int serial;

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
/*
    public void setWeapon(Item sword){

    }
    public void setArmor(Item armor){

    }
    */
}
