package game.action.creatureAction;

import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class DropPack extends CreatureAction{

    public DropPack(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing DropPack Action");
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Player p = (Player) owner;
        if(p.getPackSize() > 0){
            p.dropItem(0);
            grid.writeInfo(message, false);

        }
        else{
            grid.writeInfo("No items to drop from pack", false);
        }
        
    }
    
}
