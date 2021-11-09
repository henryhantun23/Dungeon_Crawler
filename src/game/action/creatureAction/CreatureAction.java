package game.action.creatureAction;

import game.action.Action;

public class CreatureAction extends Action{
    private static String message;
    private String action_name;
    private String action_type;


    public CreatureAction(String _action_name, String _action_type){
        action_name = _action_name;
        action_type = _action_type;
    }

    public static void setActionMessage(String msg){
        message = msg;
        System.out.println(msg);
    }
    // public CreatureAction(Creature owner){
    //     System.out.println("Creating endgame player game.action");
    //     setMessage("Player is killed!");

    
}
