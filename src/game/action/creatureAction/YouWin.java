package game.action.creatureAction;

import game.displayable.creatures.*;

public class YouWin extends CreatureAction{
    String actionMessage;


    public YouWin(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing YouWin Action");
    }

    
}
