package Step1.displayable.creatures;

import Step1.action.creatureAction.CreatureAction;
import Step1.displayable.Displayable;

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
