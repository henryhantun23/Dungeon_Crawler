package game.action.creatureAction;

import game.displayable.creatures.*;

public class Remove extends CreatureAction{
    String actionMessage;


    public Remove(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;

    }
    public void performAction(){
        System.out.println("Performing Remove Action");
    }

    
}
