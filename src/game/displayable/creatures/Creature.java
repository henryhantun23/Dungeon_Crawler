package game.displayable.creatures;

import game.action.creatureAction.CreatureAction;
import game.displayable.Displayable;
import java.util.Random;
import game.displayable.*;
import java.util.*;

public class Creature extends Displayable{
    private String message;
    public Dungeon dungeon;
    private List<CreatureAction> deathActions = new ArrayList<CreatureAction>();
    private List<CreatureAction> hitActions = new ArrayList<CreatureAction>();
    Random rand = new Random();
    
    public Creature(){
        System.out.println("creating Creature");
    }

    public void setDungeon(Dungeon _dungeon){
        dungeon = _dungeon;
    }

    public Dungeon getDungeon(){
        return dungeon;
    }

    public void addDeathAction(CreatureAction da){
        deathActions.add(da);
    }
    public void addHitAction(CreatureAction ha){
        hitActions.add(ha);
    }
    public Boolean canTraverse(){
        return this.getHp() <= 0;
    }
    public CreatureAction getDeathAction(int i){
        return deathActions.get(i);
    }
    public CreatureAction getHitActions(int i){
        return hitActions.get(i);
    }
    public int getDeathActionSize(){
        return deathActions.size();
    }

    public int getHitActionSize(){
        return hitActions.size();
    }
    /*public void setHitAction(ha){

    }*/


}
