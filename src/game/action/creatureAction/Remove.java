package game.action.creatureAction;

import game.displayable.creatures.*;
import game.displayable.*;

public class Remove extends CreatureAction{


    public Remove(String _name, Creature _owner){
        super(_name, _owner);

    }
    public void performAction(){
        System.out.println("Performing Remove Action");
        Dungeon dungeon = owner.getDungeon();
        dungeon.removeMonster(owner);
        dungeon.draw();
    }

    
}
