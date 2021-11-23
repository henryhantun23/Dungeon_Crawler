package game.action.ItemAction;

import game.action.Action;
import game.displayable.creatures.*;

public class ItemAction extends Action{
    Creature owner;

    public ItemAction(Creature _owner){
        owner = _owner;
    }
}
