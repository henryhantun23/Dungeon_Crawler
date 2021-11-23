package game.action.creatureAction;

import game.displayable.creatures.*;

public class Teleport extends CreatureAction{


    public Teleport(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing Teleport Action");
    }
}
