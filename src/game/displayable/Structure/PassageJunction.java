package game.displayable.Structure;

public class PassageJunction extends TraversableStructure{
    public char getChar(){
        return '+';
    }
    public Boolean canTraverse(){
        return true;
    }
}
