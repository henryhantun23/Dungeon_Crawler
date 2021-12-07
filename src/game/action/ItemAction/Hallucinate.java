package game.action.ItemAction;

import game.displayable.creatures.*;
import game.displayable.item.*;
import game.ObjectDisplayGrid;

public class Hallucinate extends ItemAction{
    public Hallucinate(Item _owner){
        super(_owner);
    }
    // set boolean in singleton to true
    // keep track of steps
    // set hallucinate back to false

    public void performAction(Player player){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.setHallucinating(true, this.intVal);
        grid.writeInfo(this.getMessage(), false);
    }
}
