package game.displayable.Structure;

public class RoomWall extends Structure{
    public char getChar(){
        return 'X';
    }
    public Boolean canTraverse(){
        return false;
    }
}
