package game.displayable.item;

import game.action.ItemAction.ItemAction;
import java.util.*;

public class Scroll extends Item{
    private String name;
    private int id;
    public List<ItemAction> actions = new ArrayList<ItemAction>();

    public Scroll(String _name, int _room, int _serial){
        setName(_name);
        setID(_room, _serial);
    }
    public void setName(String _name){
        name = _name;
        System.out.println("Armor Name set");
    }
    public void setID(int _room, int _serial){
        id = (_room * 30) + _serial;
        System.out.println("Armor ID set");
    }

    public char getChar(){
        return '?';
    }
    public String getName(){
        return this.name;
    }

    public void addItemAction(ItemAction action){
        actions.add(action);
    }

    public boolean canRead(){
        return true;
    }
}
