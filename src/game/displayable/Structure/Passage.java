package game.displayable.Structure;
import java.util.*;
import game.ObjectDisplayGrid;

public class Passage extends Structure{
    private int room1;
    private int room2;

    private List<Integer> posx = new ArrayList<Integer>();
    private List<Integer> posy = new ArrayList<Integer>();



    public Passage(int _room1, int _room2){
        setID(_room1, room2);
    }

    public void setID(int room1, int room2){

    }

    public char getChar(){
        return '+';
    }

    public void setPosX(int x){
        posx.add(x);
    }
    public void setPosY(int y){
        y = y + 2;
        posy.add(y);
    }

    public int returnStartJunctionX(){
        //System.out.println("Start Junction:" + posx.get(0));
        return posx.get(0);
    }
    public int returnStartJunctionY(){
        //System.out.println("Start Junction:" + posy.get(0));
        return posy.get(0);
    }

    public int returnEndJunctionX(){
        int i = posx.size();
        i -= 1;
        //System.out.println("End Junction:" + posx.get(i));
        return posx.get(i);
    }

    public int returnEndJunctionY(){
        int i = posy.size();
        i -= 1;
        //System.out.println("End Junction:" + posy.get(i));
        return posy.get(i);
    }

    public void draw(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
  
        for(int i = 0; i < posx.size() - 1; i++){ // cycle through each point
            if(posx.get(i) == posx.get(i + 1)){ // x positions stay the same
                if(posy.get(i) < posy.get(i + 1)){ // y increases
                    for(int y = posy.get(i); y < posy.get(i + 1); y++){ // make line
                        grid.addObjectToDisplay(new PassageFloor(), posx.get(i), y); // add line
                    }
                }
                else if(posy.get(i) > posy.get(i + 1)){ // y decreases
                    for(int y = posy.get(i + 1); y <= posy.get(i); y++){ // make line
                        grid.addObjectToDisplay(new PassageFloor(), posx.get(i), y); // add line
                    }
                }
                
            }
            else if(posy.get(i) == posy.get(i + 1)){ // y position stays the same
                if(posx.get(i) < posx.get(i + 1)){ // x increases
                    for(int x = posx.get(i); x < posx.get(i + 1); x++){ // make line
                        grid.addObjectToDisplay(new PassageFloor(), x, posy.get(i)); // add line
                   }
                }
                else if(posx.get(i) > posx.get(i + 1)){ // x decreases
                    for(int x = posx.get(i + 1); x <= posx.get(i); x++){ // make line
                        grid.addObjectToDisplay(new PassageFloor(), x, posy.get(i)); // add line
                    }
                }
            }
        }
        

        // Junctions
        grid.addObjectToDisplay(new PassageJunction(), this.returnStartJunctionX(), this.returnStartJunctionY());
        grid.addObjectToDisplay(new PassageJunction(), this.returnEndJunctionX(), this.returnEndJunctionY());

    }
    
          // for(int first = 0; first < posx.size(); first ++){
        //     if(posx.get(first + 1) == null){
        //         break;
        //     }
        //     else if(posx.get(first + 1) == posx.get(first)){
        //         for(int i = posy.get(first); i < posy.get(first + 1); i++)
        //         grid.addObjectToDisplay(new PassageFloor(), posx.get(first), i);
        //     }
        //     else{
        //         for(int i = posx.get(first); i < posx.get(first + 1); i++)
        //         grid.addObjectToDisplay(new PassageFloor(), i, posy.get(first));
        //     }
        // }

        // for(int i = 0; i < posx.size() - 2; i++){ // cycle through each point
        //     for(int j = 1; j < posx.size() - 1; i++){
        //          //grid.addObjectToDisplay(new PassageFloor(), posx.get(i), posy.get(i));
        //         if(posx.get(i) == posx.get(j)){
        //             for(int k = posy.get(i); k < posy.get(j); j++){
        //                 grid.addObjectToDisplay(new PassageFloor(), posx.get(i), posy.get(k));
        //             }
        //         }
        //         else{
        //             for(int k = posx.get(i); k < posx.get(j); j++){
        //                 grid.addObjectToDisplay(new PassageFloor(), posx.get(k), posy.get(i));
        //             }
        //         }
        //     }
        // }

        

}
