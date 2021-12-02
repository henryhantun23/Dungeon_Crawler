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

    public Item getItem(int x, int y){
        for(Room room : rooms){
            Item roomItem = room.getItem(x, y);
            if(roomItem != null){
                return roomItem;
            }
        }
        return null;
    }

    public void removeItem(Item item){
        for(Room room : rooms){
            room.removeItem(item);
        }
    }

    public void removeMonster(Creature creature){
        for(Room room : rooms){
            room.removeMonster(creature);
        }
    }

    public void addItem(Item item){
        rooms.get(0).addItem(item);
    }

    public void addPlayer (Player _player) {
        player = _player;
        player.setDungeon(this);
    }

    public Player getPlayer(){
        return player;
    }

    public void addRoom(Room room){ //use array lists
        //System.out.println("added room to dungeon.");
        //rooms[roomCount++] = room;
        room.setDungeon(this);
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
        for(int i = 0; i < rooms.size(); i++){
            rooms.get(i).drawInside(); // drawing stuff inside rooms
        }

        if(player != null){
            player.draw();
            int hp = player.getHp();
            player.drawHpString(hp);
        } else{
            grid.repaintGrid(); // repaint is called from drawHpString

        }


        // String str = "Get out of me swamp";
        // grid.writeToTop(str, 0);
        // String str2 = "Hello";
        // grid.writeToTop(str2, 0);
        // String str3 = "Bottom";
        // grid.writeToBottom(str3, 0);
    
    }
    public void drawPack(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        String pack = player.printPack();
        grid.writeToBottom("Pack: " + pack, 0);
        grid.repaintGrid();
    }

    public void emptyInfo(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeToBottom("Info:", 2);
    }

    public void hidePack(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeToBottom("Pack:", 0);
        grid.repaintGrid();
    }

    public void drawInitialInfo(){
        hidePack();
        emptyInfo();
    }

    public void drawInfo(String str){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeToBottom("Info: " + str, 2);
        grid.repaintGrid();
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
