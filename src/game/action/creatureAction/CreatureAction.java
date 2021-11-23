package game.action.creatureAction;

import game.action.Action;
import game.displayable.creatures.*;

public abstract class CreatureAction extends Action{
    private String message;
    private String action_name;
    private Creature owner;


    public CreatureAction(String _action_name, Creature _owner){
        action_name = _action_name;
        owner = _owner;
    }

    public void setActionMessage(String msg){
        message = msg;
        System.out.println(msg);
    }
    // public CreatureAction(Creature owner){
    //     System.out.println("Creating endgame player game.action");
    //     setMessage("Player is killed!");
    public abstract void performAction();
    
}
