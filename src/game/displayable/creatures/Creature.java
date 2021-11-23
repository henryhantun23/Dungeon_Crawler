package game.displayable.creatures;

import game.action.creatureAction.CreatureAction;
import game.displayable.Displayable;
import java.util.Random;
import java.util.*;

public class Creature extends Displayable{
    private String message;
    private List<CreatureAction> deathActions = new ArrayList<CreatureAction>();
    private List<CreatureAction> hitActions = new ArrayList<CreatureAction>();
    Random rand = new Random();
    
    public Creature(){
        System.out.println("creating Creature");
    }

    public void addDeathAction(CreatureAction da){
        deathActions.add(da);

    }

    public void addHitAction(CreatureAction ha){
        hitActions.add(ha);
    }
    public Boolean canTraverse(){
        return false;
    }
    /*public void setHitAction(ha){

    }*/


}
