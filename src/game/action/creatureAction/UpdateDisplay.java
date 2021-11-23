package game.action.creatureAction;

import game.displayable.creatures.*;

public class UpdateDisplay extends CreatureAction{

    public UpdateDisplay(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing UpdateDisplay Action");
    }
    
}
