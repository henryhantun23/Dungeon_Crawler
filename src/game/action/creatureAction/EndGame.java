package game.action.creatureAction;

import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class EndGame extends CreatureAction{

    public EndGame(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing EndGame Action");
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.writeInfo(message, false);

    }

    

}
