package game.displayable;

import game.displayable.Structure.Passage;
import game.displayable.Structure.Room;
import game.displayable.creatures.Creature;
import game.displayable.creatures.*;
import game.displayable.item.Item;
import java.util.*;
import game.ObjectDisplayGrid;

public class Dungeon extends Displayable{
    private String name;
    private int width;
    private int topHeight;
    private int gameHeight;
    private int bottomHeight;
    private int roomCount = 0;
    //private Room[] rooms;
    

    private List<Room> rooms = new ArrayList<Room>();
    private List<Passage> passages = new ArrayList<Passage>();
    private Player player;

    public Dungeon(String _name, int _width, int _topHeight, int _gameHeight, int _bottomHeight){
        name = _name;
        width = _width;
        topHeight = _topHeight;
        gameHeight = _gameHeight;
        bottomHeight = _bottomHeight;
        //System.out.println("Creating dungeon\n");
    }

    public void addPlayer (Player _player) {
        player = _player;
    }

    public void addRoom(Room room){ //use array lists
        //System.out.println("added room to dungeon.");
        //rooms[roomCount++] = room;
        rooms.add(room);
    }

    public void addPassage(Passage passage){
        passages.add(passage);
    }

    public int getGameHeight(){
        return gameHeight;
    }

    public int getTopHeight(){
        return topHeight;
    }

    public int getBottomHeight(){
        return bottomHeight;
    }

    public int getWidth(){
        return width;
    }

    public void draw(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        
        for(int i = 0; i < rooms.size(); i++){
            rooms.get(i).draw(); // drawing all the rooms
        }
        for(int i=0; i < passages.size(); i++){
            passages.get(i).draw();
        }

        if(player != null){
            player.draw();
            int hp = player.getHp();
            String str = "HP: " + hp + " score: 0";
            grid.writeToTop(str, 0);
            grid.writeToBottom("Pack: ", 0);
            grid.writeToBottom("Info: ", 2);

        }


        // String str = "Get out of me swamp";
        // grid.writeToTop(str, 0);
        // String str2 = "Hello";
        // grid.writeToTop(str2, 0);
        // String str3 = "Bottom";
        // grid.writeToBottom(str3, 0);
    
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
