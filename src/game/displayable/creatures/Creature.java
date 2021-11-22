package game.displayable.creatures;

import game.action.creatureAction.CreatureAction;
import game.displayable.Displayable;
import java.util.Random;

public class Creature extends Displayable{
    private CreatureAction actions;
    private String message;
    Random rand = new Random();
    
    public Creature(){
        System.out.println("creating Creature");
    }

    public void setDeathAction(CreatureAction da){
        actions = da;

    }
    public Boolean canTraverse(){
        return false;
    }
    /*public void setHitAction(ha){

    }*/


}
