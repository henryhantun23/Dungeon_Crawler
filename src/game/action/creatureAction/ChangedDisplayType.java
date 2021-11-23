package game.action.creatureAction;

import game.displayable.creatures.*;

public class ChangedDisplayType extends CreatureAction{

    public ChangedDisplayType(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing ChangedDisplayType Action");
    }
    
    
}