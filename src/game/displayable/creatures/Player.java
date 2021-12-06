package game.displayable.creatures;

import game.displayable.item.*;
import game.displayable.*;
import game.displayable.item.Scroll;
import java.util.*;
import game.ObjectDisplayGrid;
import game.action.ItemAction.ItemAction;

public class Player extends Creature {
    private String name;
    private int room;
    private int serial;
    boolean isGameOver = false;
    private int hpMovesTracker;
    private int hMovesTracker;

    public List<Item> pack = new ArrayList<Item>();
    public Item equipped_armor = null;
    public Item equipped_sword = null;
    public Item read_scroll = null;
    public List<ItemAction> actions;

    public Player(String _name, int _room, int _serial) {
        setName(_name);
        setRoom(_room);
        setSerial(_serial);
        this.setType("@");
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

    public int getPackSize(){
        return pack.size();
    }

    public void dropItem(int index){
        Item item = pack.get(index);
        pack.remove(item);
        item.setPosX(this.getPosX());
        item.setPosY(this.getPosY());
        dungeon.addItem(item);
        dungeon.draw();        
    }
    public void wear_Armor(int index){

        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Item item = pack.get(index);
        if(item == null) {
            System.out.println("No items exist in the given inventory spot");
            grid.writeInfo("No items exist in the given inventory spot", false);
        }else if (item instanceof Armor) {
            equipped_armor = item;
            drawHpString(getHp() + equipped_armor.getHp());
            System.out.println(equipped_armor.getHp());
            System.out.println("Selected Armor is now equipped");
            grid.writeInfo("Selected Armor is now equipped", false);

            
        }else {
            System.out.println("Item name " + item.getName());
            System.out.println("Selected item is not Armor");
            grid.writeInfo("Selected item is not Armor", false);

        }

    }
    public void Take_Sword(int index) {

        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Item item = pack.get(index);
        if(item == null) {
            System.out.println("No items exist in the given inventory spot");
            grid.writeInfo("No items exist in the given inventory spot", false);
        } else if (item instanceof Sword){
            equipped_sword = item;
            System.out.println("Player is wielding the selected sword");
            grid.writeInfo("Player is wielding the selected sword", false);
        } else {
            System.out.println("Item name " + item.getName());
            System.out.println("Selected Item is not a Sword.");
            grid.writeInfo("Selected Item is not a Sword.", false);
        }
    }

    public void Take_scroll(int index) {

        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Item item = pack.get(index);
        if (item == null) {
            System.out.println("No items exist in that inventory spot");
            grid.writeInfo("No items exist in the given inventory spot", false);
        }else if (item instanceof Scroll) {
            read_scroll = item;
            System.out.println("Player has selected the scroll");
            grid.writeInfo("Player has selected the scroll", false);

        }else {
            System.out.println("Item name " + item.getName());
            System.out.println("Selected Item is not a scroll");
            grid.writeInfo("Selected Item is not a scroll", false);
        }
    }
    public int getHp(){
        if (equipped_armor == null){
            return super.getHp();
        }
        return super.getHp() + equipped_armor.getItem_value();
    }

    public void setHp(int Hp){
        if (equipped_armor == null){
            super.setHp(Hp); //override
        }
        else {
            super.setHp(Hp - equipped_armor.getItem_value());
        }
        System.out.println("setHP");
    }

    public void readItem(int index){

        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        Item item = pack.get(index);
        if(item.canRead()){
            Scroll scroll = (Scroll) item;
            actions = scroll.getActions();
            for(ItemAction action : actions){
                System.out.print("Calling perform action");
                action.performAction();
            }
        }
        else {
            grid.writeInfo("The item you selected is not readable", false);
        }
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
    public String getName(){
        return name;
    }
    public boolean getIsGameOver(){
        return isGameOver;
    }
    public void setIsGameOver(boolean b){
        isGameOver = b;
    }
    public void setHpMove(int _hpMoves){
        super.setHpMove(_hpMoves);
        hpMovesTracker = _hpMoves;
        
    }

    // move(deltaX, deltaY)
    public void move(int deltaX, int deltaY, ObjectDisplayGrid grid){
        //int num = this.getHpMoves();
        int x = this.getPosX();
        int y = this.getPosY();
        Displayable thing = grid.getObject(x + deltaX, y + deltaY);
        hMovesTracker = grid.getHallucinateMoves(); // Hall
        if(thing != null){
            if(thing.canTraverse()){
                this.setPosX(x + deltaX);
                this.setPosY(y + deltaY);
                hpMovesTracker--;
                hMovesTracker--; // Hall
                if(hpMovesTracker == 0){
                    hpMovesTracker = this.getHpMoves();
                    this.setHp(this.getHp() + 1);
                    grid.writeInfo("Hp increased by 1", false);
                }
                if(hMovesTracker == 0){ // Hall
                    grid.setHallucinating(false, hMovesTracker); // Hall
                }else if (hMovesTracker > 0){
                    grid.setHallucinating(true, hMovesTracker);
                }
                dungeon.draw();
            }
            else if(thing.isMonster()){
                this.attack(this, (Creature) thing, false); // player attacks creature
                if(this.getHp() <= 0){ 
                    for(int i = 0; i < this.getDeathActionSize(); i++){
                        this.getDeathAction(i).performAction();
                    }
                }
                thing.attack((Creature) thing, this, true); // creature attacks player
                if(thing.getHp() <= 0){
                    Creature c = (Creature) thing;
                    for(int i = 0; i < c.getDeathActionSize(); i++){
                        c.getDeathAction(i).performAction();
                    }
                }
                this.drawHpString(this.getHp());
            }
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
        for(int i = 0; i < pack.size(); i++) {
            str += (i + 1) + ": " + pack.get(i).getName() + " ";
            if (pack.get(i) == equipped_armor) {
                str += "(a) ";
            }else if (pack.get(i) == equipped_sword) {
                str += "(w) ";
            }
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
