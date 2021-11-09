package Step1.displayable.Structure;

import Step1.displayable.creatures.Creature;
import Step1.displayable.creatures.Monster;
import Step1.displayable.creatures.Player;
import java.util.*;

public class Room extends Structure{
    private int id;
    public Room(int _id){
        System.out.println("Creating room");
        setId(_id);
    }
    private List<Monster> monsters = new ArrayList<Monster>(); // Arraylist of monsters + items

    private Player player;

    private Creature creature;

    public void addMonster (Monster monster){
        System.out.println("add creature");
        monsters.add(monster);
    }
    public Player addPlayer (Player player) {
        return player;
    }

    public void setId(int room){
        id = room;
        System.out.println("id set");
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
