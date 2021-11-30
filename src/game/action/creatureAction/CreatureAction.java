package game.action.creatureAction;

import game.action.Action;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public abstract class CreatureAction extends Action{
    public String action_name;
    public Creature owner;


    public CreatureAction(String _action_name, Creature _owner){
        action_name = _action_name;
        owner = _owner;
    }

    // public CreatureAction(Creature owner){
    //     System.out.println("Creating endgame player game.action");
    //     setMessage("Player is killed!");
    public abstract void performAction();
    
}
