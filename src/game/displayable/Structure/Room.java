package game.displayable.Structure;

import game.displayable.creatures.Creature;
import game.displayable.creatures.Monster;
import game.displayable.creatures.Player;
import game.displayable.item.Armor;
import game.displayable.item.Sword;

import java.util.*;

public class Room extends Structure{
    private int id;
    public Room(int _id){
        System.out.println("Creating room");
        setId(_id);
    }
    private List<Monster> monsters = new ArrayList<Monster>(); // Arraylist of monsters + items
    private List<Armor> armors = new ArrayList<Armor>();
    private List<Sword> swords = new ArrayList<Sword>();

    private Player player;

    public void addMonster (Monster monster){
        System.out.println("add creature");
        monsters.add(monster);
    }

    public void addArmor(Armor armor){
        armors.add(armor);
    }
    public void addSword(Sword sword){
        swords.add(sword);
    }

    public void addPlayer (Player _player) {
        player = _player;
    }

    public void setId(int room){
        id = room;
        System.out.println("id set");
    }

    public void draw(){
        // TODO: draw the room's wall and floors
        for(int i=0; i < monsters.size(); i++){
            monsters.get(i).draw();
        }
        if(player != null){
            player.draw();
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
