package game.displayable.creatures;

import game.displayable.item.*;
import game.displayable.*;
import java.util.*;
import game.ObjectDisplayGrid;

public class Player extends Creature {
    private String name;
    private int room;
    private int serial;
    private Dungeon dungeon;
    boolean isGameOver = false;

    public List<Item> pack = new ArrayList<Item>();

    public Player(String _name, int _room, int _serial) {
        setName(_name);
        setRoom(_room);
        setSerial(_serial);
        System.out.println("Player created");
    }

    public void drawHpString(int hp){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        super.setHp(hp);
        String str = "HP: " + hp + " score: 0";
        grid.writeToTop(str, 0);
    }

    public void pickUpItem(){
       Item item = dungeon.getItem(this.getPosX(), this.getPosY());
       if(item == null){
           System.out.println("No item to pick up");
       }
       else{
           pack.add(item);
           dungeon.removeItem(item);
       }
    }

    public void dropItem(int index){
        Item item = pack.get(index);
        pack.remove(item);
        item.setPosX(this.getPosX());
        item.setPosY(this.getPosY());
        dungeon.addItem(item);
        dungeon.draw();        
    }

    public void setName(String _name){
        name = _name;
        System.out.println("name set");
    }
    public void setRoom(int _room){
        room = _room;
        System.out.println("room set");
    }
    public void setSerial(int _serial){
        serial = _serial;
        System.out.println("serial set");
    }
    public char getChar(){
        return '@';
    }
    public String getName(){
        return name;
    }
    public boolean getIsGameOver(){
        return isGameOver;
    }

    // move(deltaX, deltaY)
    public void move(int deltaX, int deltaY, ObjectDisplayGrid grid){
        int x = this.getPosX();
        int y = this.getPosY();
        Displayable thing = grid.getObject(x + deltaX, y + deltaY);
        if(thing.canTraverse()){
            this.setPosX(x + deltaX);
            this.setPosY(y + deltaY);
            dungeon.draw();
        }
        else if(thing.isMonster()){
            this.attack(this, thing, false);
            thing.attack(thing, this, true);
            if(this.getHp() <= 0){ //TODO move to actions
                isGameOver = true;
            }
            this.drawHpString(this.getHp());
        }
    }

    public void setDungeon(Dungeon _dungeon){
        dungeon = _dungeon;
    }

    // add item
    public void addItem(Item item){
        pack.add(item);
    }
    // player.printPack
    public String printPack(){
        String str = "";
        for(int i = 0; i < pack.size(); i++){
            str += (i + 1) + ": " + pack.get(i).getName() + " ";
        }
        return str;
    }
    public Dungeon getDungeon(){
        return dungeon;
    }

    public int getRoom(){
        return room;
    }

    public boolean isPlayer(){
        return true;
    }
/*
    public void setWeapon(Item sword){

    }
    public void setArmor(Item armor){

    }
    */
}
