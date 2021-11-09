package game.displayable.creatures;

import game.action.creatureAction.CreatureAction;
import game.displayable.Displayable;

public class Creature extends Displayable{
    private CreatureAction actions;
    private String message;
    
    public Creature(){
        System.out.println("creating Creature");
    }

    public void setDeathAction(CreatureAction da){
        actions = da;

    }
    /*public void setHitAction(ha){

    }*/

}
