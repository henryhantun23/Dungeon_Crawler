package game.action.creatureAction;

import game.displayable.creatures.*;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class DropPack extends CreatureAction{
    String actionMessage;

    public DropPack(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing DropPack Action");
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Player p = (Player) owner;
        if(p.getPackSize() > 0){
            p.dropItem(0);
            grid.writeInfo(actionMessage, false);

        }
        else{
            grid.writeInfo("No items to drop from pack", false);
        }
        
    }
    
}
