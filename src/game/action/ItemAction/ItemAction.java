package game.action.ItemAction;

import game.action.Action;
import game.displayable.item.*;

public class ItemAction extends Action{
    Item owner;

    public ItemAction(Item _owner){
        owner = _owner;
    }
    public void performAction(){
        System.out.println("Called super perform action");
    }
}
