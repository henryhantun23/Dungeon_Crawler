package Step1.displayable.creatures;

import Step1.displayable.Displayable;

public class Monster extends Creature{
    private int posX;
    private int posY;
    private String type;
    private int hp;
    private int maxhit;
    public Monster(int _posX, int _posY, String _type, int _hp, int _maxhit){
        System.out.println("monster created");
        
        posY = _posY;
        type = _type;
        hp = _hp;
        maxhit = _maxhit;
    }
    public void setName(string){

    }
    public void setId(int room, int serial){

    }

    public String toString(){
        String str = "Monster: \n";
        str += "   posX: "+posX + "\n";
        str += "   posY: "+posY + "\n";
        str += "   type: "+type + "\n";
        str += "   hp: "+hp + "\n";
        str += "   maxhit: "+maxhit + "\n";
        return str;
    }

}