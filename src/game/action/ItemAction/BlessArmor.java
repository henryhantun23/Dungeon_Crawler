package game.action.ItemAction;

import game.displayable.item.*;
import game.displayable.creatures.*;
import game.ObjectDisplayGrid;

public class BlessArmor extends ItemAction{
    public BlessArmor(Item owner){
        super(owner);
    }
    public void performAction(Player player){

        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        String str = "weapon";
        if(actionCharValue.equals("a")){
            str = "armor";
        }
        if(player.equipped_armor != null && actionCharValue.equals("a")){
            int hp = player.equipped_armor.getHp();
            hp += intVal;
            player.equipped_armor.setHp(hp); // add name setting as setHP override
            
            grid.writeInfo(str + " cursed! " + intVal + " taken from its effectiveness", false);
        }
        else if (player.equipped_sword != null && actionCharValue.equals("w")){
            int hp = player.equipped_sword.getHp();
            hp += intVal;
            player.equipped_sword.setHp(hp);
            grid.writeInfo(str + " cursed! " + intVal + " taken from its effectiveness", false);
        }
        else{
            grid.writeInfo("scroll of cursing does nothing because " + str + " not being used", false);
            System.out.println(str);
        }
    }


}
