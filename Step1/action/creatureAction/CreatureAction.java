package Step1.action.creatureAction;

import Step1.action.Action;
import Step1.displayable.creatures.Creature;

public class CreatureAction extends Action{
    private String action_name;
    private String action_type;
    public String message;

    public CreatureAction(String _action_name, String _action_type){
        action_name = _action_name;
        action_type = _action_type;
    }

    public static void setActionMessage(String msg){
        message = msg;
        System.out.println(msg + "\n");
    }
    // public CreatureAction(Creature owner){
    //     System.out.println("Creating endgame player action");
    //     setMessage("Player is killed!");

    
}
