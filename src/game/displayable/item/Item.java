package game.displayable.item;

import game.displayable.Displayable;
import game.displayable.creatures.Creature;

public class Item extends Displayable{
    
    public void setOwner(Creature owner){

    }
    public Boolean canTraverse(){
        return true;
    }
    public String getName(){
        return this.getName();
    }
}
