package game.displayable;

import game.ObjectDisplayGrid;
import java.util.Random;
import game.displayable.creatures.*;
import game.displayable.item.Item;

public class Displayable {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int maxhit;
    private String type;
    private int hpm;
    private int hp;
    private int int_val;
    private int visible;
    private int invisible;
    private String message;
    Random rand = new Random();


    public Displayable(){ //what does this function do?

    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public char getChar(){
        return type.charAt(0);
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }
    public int getMaxHit(){
        return maxhit;
    }
    public String getType(){
        return type;
    }
    public int getHpMoves(){
        return hpm;
    }
    public int getHp(){
        return hp;
    }
    public boolean isVisible(){
        if(visible == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isMonster(){
        return false;
    }

    public void setInvisible(int invis){
        invisible = invis;
        System.out.println("invisible set");
    }

    public void setVisible(int vis){
        visible = vis;
        System.out.println("visible set");

    }
    public void setMaxHit(int max_Hit){
       maxhit = max_Hit;
       System.out.println("max hits set");
    }

    public void setHpMove(int hpMoves){
        hpm = hpMoves;
        System.out.println("set HP moves");
    }

    public void setHp(int Hp){
        hp = Hp;
        System.out.println("setHP");
    }

    public void setType(String t) {
        type = t;
        System.out.println("type set");
    }
    /*public void setIntValue(int v){
        
    }*/

    public void setPosX(int x){
        posX = x;
        System.out.println("x pos set");
        
    }
    public void setPosY(int y){
        posY = y;

        System.out.println("y pos set");
    }
    public void setWidth(int x){
        width = x;
        System.out.println("set width");
    }
    public void setHeight(int y){
        height = y;
        System.out.println("set height");
    }

    public void setActionMessage(String msg){
        message = msg;
        System.out.println(msg);
    }

    public void draw(){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        grid.addObjectToDisplay(this, posX, posY);
    }
    public String getName(){
        return this.getName();
    }

    public void globalize(int x, int y){
        posX += x;
        posY += (y);
    }

    public Boolean canTraverse(){
        return false;
    }

    public void attack(Creature attacker, Creature attackee, boolean writeSecond){
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        int hpHit = rand.nextInt(attacker.getMaxHit() + 1);
        int hp = attackee.getHp() - hpHit;
        attackee.setHp(hp);
        for(int i = 0; i < attackee.getHitActionSize(); i++){
            attackee.getHitActions(i).performAction();
        }
        String str = attacker.getName() + " dealt " + hpHit + " damage to " + attackee.getName();
        grid.writeInfo(str, writeSecond);
    }


    public boolean isPlayer(){
        return false;
    }
}
