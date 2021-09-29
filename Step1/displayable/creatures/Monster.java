package Step1.displayable.creatures;

public class Monster extends Creature{
    private int hit_points;
    private int hp_Moves;
    private String name;
    private int posX;
    private int posY;
    private String type;
    private int maxhit;
    private int id;

    public Monster(int _posX, int _posY, String _type, int _hp, int _maxhit, String _name, int _room, int _serial){
        System.out.println("monster created");
        setName(_name);
        setPosX(_posX);
        setPosY(_posY);
        setType(_type);
        setHp(_hp);
        setMaxHit(_maxhit);
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
        str += "   hp: "+hit_points + "\n";
        str += "   maxhit: "+maxhit + "\n";
        return str;
    }

}