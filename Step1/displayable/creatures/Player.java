package Step1.displayable.creatures;

public class Player extends Creature {
    private String name;
    private int posX;
    private int posY;
    private char type;
    private int hp;
    private int maxhit;
    private int visible;
    public Player(String _name, int _hp, int _hpm, int _max_hit, int _posX, int _posY, char _type, int maxhit, int _visible) {
        setHp(_hp);
        setHpMove(_hpm);
        setMaxHit(_max_hit);
        setPosX(_posX);
        setPosY(_posY);
        setType(_type);
        setHp(_hp);
        setName(_name);
        setVisible(_visible);
        System.out.println("Player created");
    }
    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
/*
    public void setWeapon(Item sword){

    }
    public void setArmor(Item armor){

    }
    */
}
