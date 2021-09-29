package Step1.displayable.creatures;

public class Player extends Creature {

    public Player(String _name, int _hp, int _hpm, int _max_hit, int _posX, int _posY, String _type, int maxhit, int _hpm) {
        setHp(_hp);
        setHpMoves(_hpm);
        setMaxHit(_max_hit);
        setPosX(_posX);
        setPosY(_posY);
        setType(_type);
        setHp(_hp);
        setMaxHit(maxhit);
        setHpMoves(_hpm);
    }

    public void setWeapon(Item sword){

    }
    public void setArmor(Item armor){

    }
    
}
