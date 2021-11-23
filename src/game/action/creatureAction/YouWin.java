package game.action.creatureAction;

import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class YouWin extends CreatureAction{
    String actionMessage;


    public YouWin(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        
        System.out.println("Performing YouWin Action");
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeInfo(actionMessage, false);

    }

    
}
