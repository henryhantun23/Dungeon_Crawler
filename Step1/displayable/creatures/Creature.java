package Step1.displayable.creatures;

import Step1.action.CreatureAction.CreatureAction;
import Step1.displayable.Displayable;

public class Creature extends Displayable{
    private int hit_points;
    private int hp_Moves;
    private String name;
    public Creature(int _hp, int _hpm, String _name){
        System.out.println("Creating Creature");
        setHp(_hp);
        setHpMoves(_hpm);
        setName(_name);
    }
//hp and hpm here accounts for the damage the creatures will be doing on the player...potentially might need
    //additional parameters to update hp values.

    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setHp(int h){
        hit_points = h;
        System.out.println("setHP");
    }
    public void setHpMoves(int hpm){
        hp_Moves = hpm;
        System.out.println("set HP Moves");
    }
    public void setDeathAction(CreatureAction da){ //creature actions haven't

    }
    public void setHitAction(ha){

    }
}
