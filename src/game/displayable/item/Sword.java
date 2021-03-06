package game.displayable.item;

public class Sword extends Item{
    private String name;
    private int id;
    public Sword(String _name, int _room, int _serial){
        setName(_name);
        setID(_room, _serial);
    }
    public void setName(String _name){
        name = _name;
        System.out.println("Armor Name set");
    }
    public void setID(int _room, int _serial){
        id = (_room * 30) + _serial;
        System.out.println("Armor ID set");
    }
    public char getChar(){
        return '|';
    }
    public String getName(){
        return this.name;
    }

}
