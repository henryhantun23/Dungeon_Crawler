package game.displayable.Structure;

public class PassageFloor extends TraversableStructure {
    public char getChar(){
        return '#';
    }
    public Boolean canTraverse(){
        return true;
    }
}
