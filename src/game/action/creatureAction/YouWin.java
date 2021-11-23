package game.action.creatureAction;

import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class YouWin extends CreatureAction{

    public YouWin(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        
        System.out.println("Performing YouWin Action " + message);
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeInfo(message, false);

    }

    
}
