package game.action.creatureAction;

import game.displayable.creatures.*;
import game.displayable.item.Item;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;


public class EmptyPack extends CreatureAction{
    String actionMessage;

    public EmptyPack(String _name, Creature _owner, String am){
        super(_name, _owner);
        actionMessage = am;
    }

    public void performAction(){
        System.out.println("Performing DropPack Action");
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Player p = (Player) owner;
        if(p.getPackSize() > 0){
            for(int i = 0; i < p.getPackSize(); i++){
                p.dropItem(i);
            }
            grid.writeInfo(actionMessage, false);

        }
        else{
            grid.writeInfo("No items to drop from pack", false);
        }
        
    }
}
