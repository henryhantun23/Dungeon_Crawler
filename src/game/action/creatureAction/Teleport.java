package game.action.creatureAction;

import game.displayable.creatures.*;
import game.ObjectDisplayGrid;
import game.displayable.*;
import java.util.*;
import java.util.Random;


public class Teleport extends CreatureAction{

    public Teleport(String _name, Creature _owner){
        super(_name, _owner);
    }

    public void performAction(){
        System.out.println("Performing Teleport Action");
        Dungeon dungeon = owner.getDungeon();
        Random rand = new Random();
        List<Point> points = new ArrayList<Point>();
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        
        for(int x = 0; x < dungeon.getWidth(); x++){
            for(int y = 0; y < dungeon.getGameHeight(); y++){
                Displayable gridItem = grid.getObject(x, y);
                if(gridItem != null){
                    if(gridItem.canTraverse()){
                        points.add(new Point(x, y));
                    }
                }
            }
        }

        int r = rand.nextInt(points.size());
        Point going = points.get(r);
        owner.setPosX(going.getX());
        owner.setPosY(going.getY());
        dungeon.draw();

    
            
        
    }
}
