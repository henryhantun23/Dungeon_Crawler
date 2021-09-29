package Step1.displayable;

public class Displayable {
    private int pos_x;
    private int pos_y;
    private int width;
    private int height;
    private int Max_hits;
    private char type;
    private int hpm;
    private int hp;
    private int int_val;
    private int vis_val;

    public Displayable(){

    }

    public void setInvisible(){

    }

    public void setVisible(int vis){

    }

    public void setMaxHit(int maxHit){
        Max_hits = maxHit;
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

    public void setType(char t) {
        type = t;
        System.out.println("type set");
    }
    public void setIntValue(int v){
        
    }

    public void setPosX(int x){
        pos_x = x;
        System.out.println("pos x set");
    }
    public void setPosY(int y){
        pos_y = y;
        System.out.println("pos y set");
    }
    public void setWidth(int x){
        width = x;
        System.out.println("set width\n");
    }
    public void setHeight(int y){
        height = y
        System.out.println("set height\n");
    }
}
