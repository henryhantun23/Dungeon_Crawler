package game.action.creatureAction;

import game.displayable.creatures.*;

public class DropPack extends CreatureAction{
    String actionMessage;

    public DropPack(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing DropPack Action");
    }

    
}
