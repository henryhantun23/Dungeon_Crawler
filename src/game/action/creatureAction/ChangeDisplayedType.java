package game.action.creatureAction;

import game.displayable.creatures.*;
import game.displayable.*;

public class ChangeDisplayedType extends CreatureAction{

    public ChangeDisplayedType(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing ChangedDisplayType Action");
        owner.setType(actionCharValue);
        
    }
    
    
}