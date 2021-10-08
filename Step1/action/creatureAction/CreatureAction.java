package Step1.action.creatureAction;

import Step1.action.Action;
import Step1.displayable.creatures.Creature;

public class CreatureAction extends Action{
    private String action_name;
    private String action_type;
    private String message;

    public CreatureAction(String _action_name, String _action_type, String _message){
        action_name = _action_name;
        action_type = _action_type;
        setMessage(_message);
    }

    // public CreatureAction(Creature owner){
    //     System.out.println("Creating endgame player action");
    //     setMessage("Player is killed!");

    // }
}
