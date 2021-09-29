package Step1.displayable.creatures;

import Step1.displayable.Displayable;

public class Monster extends Creature{
    private int posX;
    private int posY;
    private String type;
    private int hp;
    private int maxhit;
    private String name;
    private int id;
    public Monster(int _posX, int _posY, char _type, int _hp, int _maxhit, String _name, int _room, int _serial){
        System.out.println("monster created");
        setName(_name);
        setPosX(_posX);
        setPosY(_posY);
        setType(_type);
        setHp(_hp);
        setMaxHit(maxhit);
    }
    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setId(int _room, int _serial){
        id = (_room * 10) + _serial;
        System.out.println("id set");
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