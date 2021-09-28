package Step1;

public class Room extends Structure{
    private int id;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int monsterCount = 0;
    private Monster[] monsters;
    public Room(int _id,int _posX, int _posY, int _width, int _height){
        id = _id;
        posX = _posX;
        posY = _posY;
        width = _width;
        height = _height;
    }
    public void addMonster (Monster monster){
        monsters[monsterCount++] = monster;
    }
    public void Room(string){

    }
    public void setId(int room){

    }
    public void setCreature(Creature Monster){
        
    }
    public String toString(){
        String str = "Room: \n";
        str += "    posX: "+posX + "\n";
        str += "    posY: "+posY + "\n";
        str += "    width: "+width + "\n";
        str += "    height: "+height + "\n";
        for (Monster monster : monsters){
            str += monster.toString() + "\n";
        }
        return str;
    }
}
