package Step1.displayable;


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


    public Displayable(){ //what does this function do?

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
}
