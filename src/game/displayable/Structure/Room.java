package game.displayable.Structure;

import game.displayable.creatures.Creature;
import game.displayable.creatures.Monster;
import game.displayable.item.*;
import game.ObjectDisplayGrid;
import game.displayable.*;

import java.util.*;

public class Room extends Structure{
    private int id;
    private int posY;
    private Dungeon dungeon;
    public Room(int _id){
        System.out.println("Creating room");
        setId(_id);
    }
    private List<Monster> monsters = new ArrayList<Monster>(); // Arraylist of monsters + items
    private List<Item> items = new ArrayList<Item>();

    public Item getItem(int x, int y){
        for(int j=0; j < items.size(); j++){
            Item item = items.get(j);
            if(item.getPosX() == x && item.getPosY() == y){
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void removeMonster(Creature creature){
        monsters.remove(creature);
    }

    public void setDungeon(Dungeon _dungeon){
        dungeon = _dungeon;
    }

    public Dungeon getDungeon(){
        return dungeon;
    }

    public void addMonster (Monster monster){
        System.out.println("add creature");
        monster.setDungeon(dungeon);
        monsters.add(monster);
    }

    public void addItem(Item item){ 
        items.add(item);
    }

    public void setId(int room){
        id = room;
        System.out.println("id set");
    }

    public void draw(){
        // TODO: draw the room's wall and floors
        // walls:
        // posX to posX + wdith at posY
        // only posX to posX + width for height
        // posX to posX + wdith at posY + height
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        for(int i=0; i < this.getWidth(); i++){
            for(int j = 0; j < this.getHeight(); j++){
                grid.addObjectToDisplay(new RoomWall(), this.getPosX() + i, this.getPosY() + j);
            }
        }

        for(int i=1; i < (this.getWidth() -1); i++){
            for(int j=1; j < (this.getHeight() -1); j++){
                grid.addObjectToDisplay(new RoomFloor(), this.getPosX() + i, this.getPosY() + j);

            }
        }
        for(int i=0; i < monsters.size(); i++){
            monsters.get(i).draw();
        }
        for(int j=0; j < items.size(); j++){
            items.get(j).draw();
        }
        
    }

    /*
    public String toString(){
        String str = "Room: \n";
        str += "    posX: "+posX + "\n";
        str += "    posY: "+posY + "\n";
        str += "    width: "+width + "\n";
        str += "    height: "+height + "\n";
        for (Monster monster : monsters){
            str += monster.toString() + "\n";
        }
        return str;
    }*/
}
