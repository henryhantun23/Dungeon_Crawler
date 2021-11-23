package game.action.creatureAction;

import game.displayable.creatures.*;

public class ChangedDisplayType extends CreatureAction{
    String actionMessage;


    public ChangedDisplayType(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing ChangedDisplayType Action");
    }
    
    
}