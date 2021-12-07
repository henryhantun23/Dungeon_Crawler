package game.action.ItemAction;

import game.action.Action;
import game.displayable.item.*;
import game.displayable.creatures.*;

public class ItemAction extends Action{
    Item owner;

    public ItemAction(Item _owner){
        owner = _owner;
    }
    public void performAction(Player p){
        System.out.println("Called super perform action");
    }
}
