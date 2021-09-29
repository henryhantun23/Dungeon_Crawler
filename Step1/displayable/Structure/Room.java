package Step1.displayable.Structure;

import Step1.displayable.creatures.Creature;
import Step1.displayable.creatures.Monster;

public class Room extends Structure{
    private int id;
    //private int posX;
    //private int posY;
    private int width;
    private int height;
    private int monsterCount = 0;
    private Monster[] monsters;
    private Creature creature;
    public Room(int _id,int _posX, int _posY, int _width, int _height){
        System.out.println("Creating room\n");
        setId(_id);
        setPosX(_posX);
        setPosY(_posY);
        setWidth(_width);
        setHeight(_height);
    }
    public void addMonster (Monster monster){
        monsters[monsterCount++] = monster;
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
