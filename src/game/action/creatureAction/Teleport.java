package game.action.creatureAction;

import game.displayable.creatures.*;

public class Teleport extends CreatureAction{
    String actionMessage;


    public Teleport(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing Teleport Action");
    }
}
