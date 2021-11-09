package Step1.displayable;

import Step1.displayable.Structure.Passage;
import Step1.displayable.Structure.Room;
import Step1.displayable.creatures.Creature;
import Step1.displayable.item.Item;
import java.util.*;

public class Dungeon extends Displayable{
    private String name;
    private int width;
    private int topHeight;
    private int gameHeight;
    private int bottomHeight;
    private int roomCount = 0;
    //private Room[] rooms;

    private List<Room> rooms = new ArrayList<Room>();

    public Dungeon(String _name, int _width, int _topHeight, int _gameHeight, int _bottomHeight){
        name = _name;
        width = _width;
        topHeight = _topHeight;
        gameHeight = _gameHeight;
        bottomHeight = _bottomHeight;
        //System.out.println("Creating dungeon\n");
    }

    
    public void addRoom(Room room){ //use array lists
        //System.out.println("added room to dungeon.");
        //rooms[roomCount++] = room;
        rooms.add(room);
    }
    



    public void setDungeon(String name, int width, int topHeight, int gameHeight, int bottomHeight) {

    }
    public void addCreature(Creature creature){

    }
    public void addPassage(Passage passage){

    }
    public void addItem(Item item){

    }
    /*
    public String toString() {
        String str = "Dungeon : \n";
        str += "    name: "+ name + "\n";
        str += "    width: "+ width + "\n";
        str += "    topHeight: "+ topHeight + "\n";
        str += "    gameHeight: "+ gameHeight + "\n";
        str += "    bottomHeight: "+ bottomHeight + "\n";
        return str;
    }*/
}
