package Step1.action.creatureAction;

import Step1.action.Action;
import Step1.displayable.creatures.Creature;

public class CreatureAction extends Action{
    private String action_name;
    private String action_type;

    public CreatureAction(Creature owner){
        System.out.println("Creating Action");
        setMessage("Player is killed!");

    }
}
