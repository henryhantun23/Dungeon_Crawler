package Step1.displayable.Structure;

import Step1.displayable.creatures.Creature;
import Step1.displayable.creatures.Monster;
import Step1.displayable.creatures.Player;
import java.util.*;

public class Room extends Structure{
    private int id;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int monsterCount = 0;
    private List<Monster> monsters = new ArrayList<Monster>(); // Arraylist of monsters + items

    private Player player;

    private Creature creature;
    public Room(int _id){
        System.out.println("Creating room\n");
        setId(_id);
    }
    public void addMonster (Monster monster){
        monsters.add(monster);
    }
    public void addPlayer (Player player) {
        
    }
    public void setId(int room){
        id = room;
        System.out.println("id set\n");
    }

    public void setCreature(Creature Monster){
        creature = Monster;
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
