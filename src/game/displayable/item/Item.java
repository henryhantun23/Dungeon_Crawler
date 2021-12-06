package game.displayable.item;

import game.displayable.Displayable;
import game.displayable.creatures.Creature;

public class Item extends Displayable{
    private int item_value;

    public void setOwner(Creature owner){

    }
    public void setItemIntValue(int value){
        item_value = value;
    }

    public int getItem_value() {
        return item_value;
    }

    public Boolean canTraverse(){
        return true;
    }
    public String getName(){
        return this.getName();
    }

    public boolean canRead(){
        return false;
    }
}
