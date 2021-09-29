package Step1.displayable.creatures;

public class Monster extends Creature{

    private String name;
    //private int posX;
    //private int posY;
    //private char type;
    //private int hit_points;
    //private int maxhit;
    private int id;

    public Monster(int _posX, int _posY, char _type, int _hp, int _maxhit, String _name, int _room, int _serial){
        setName(_name);
        setId(_room, _serial);
        setPosX(_posX);
        setPosY(_posY);
        setType(_type);
        setHp(_hp);
        setMaxHit(_maxhit);
        System.out.println("monster created");
    }
    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setId(int _room, int _serial){
        id = (_room * 10) + _serial;
        System.out.println("id set");
    }

/*
    public String toString(){
        String str = "Monster: \n";
        str += "   posX: "+posX + "\n";
        str += "   posY: "+posY + "\n";
        str += "   type: "+type + "\n";
        str += "   hp: "+hit_points + "\n";
        str += "   maxhit: "+maxhit + "\n";
        return str;
    }*/

}