package game.displayable.creatures;

public class Monster extends Creature{

    private String name;
    private int posX;
    private int posY;
    private char type;
    private int hp;
    private int maxhit;
    private int id;

    public Monster(String _name, int _room, int _serial){
        setName(_name);
        System.out.println("monster created");
        System.out.println("name set");
        setId(_room, _serial);
    }
    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setId(int _room, int _serial) {
        id = (_room * 10) + _serial;
        System.out.println("id set");
    }
    public boolean isMonster(){
        return true;
    }
    public String getName(){
        return name;
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