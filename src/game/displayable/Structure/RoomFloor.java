package game.displayable.Structure;

public class RoomFloor extends TraversableStructure{
    public char getChar(){
        return '.';
    }
    public Boolean canTraverse(){
        return true;
    }
}
