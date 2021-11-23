package game;


import game.action.Action;
import game.action.creatureAction.CreatureAction;
import game.displayable.Displayable;
import game.displayable.Dungeon;
import game.displayable.Structure.Passage;
import game.displayable.Structure.Room;
import game.displayable.creatures.Monster;
import game.displayable.creatures.Player;
import game.displayable.item.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Step1XMLHandler extends DefaultHandler {

    private static final int DEBUG = 1;
    private static final String CLASSID = "Step1XMLHandler";

    private StringBuilder data = null;

    private Room[] rooms;
    private Monster[] monsters;
    private Player player;
    private int roomCount = 0;
    private Displayable[] displayable = new Displayable[10];//parse queue?
    private int disNum = 0;

    private Dungeon dungeonBeingParsed = null;
    private Room roomBeingParsed = null;
    private Monster monsterBeingParsed = null;
    private Player playerBeingParsed = null;
    private Action creatureActionBeingParsed = null;
    private Passage passageBeingParsed = null;
    private Armor armorBeingParsed = null;
    private Sword swordBeingParsed = null;
    private Scroll scrollBeingParsed = null;

    public Dungeon getDungeons(){
        return dungeonBeingParsed;
    }

    public Player getPlayer(){
        return playerBeingParsed;
    }
    public Step1XMLHandler() {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (DEBUG > 1) {
            System.out.println(CLASSID + ".startElement qName: " + qName);
        }
        if (qName.equalsIgnoreCase("Dungeon")) {
            String name = attributes.getValue("name");
            int width = Integer.parseInt(attributes.getValue("width"));
            int topHeight = Integer.parseInt(attributes.getValue("topHeight"));
            int gameHeight = Integer.parseInt(attributes.getValue("gameHeight"));
            int bottomHeight = Integer.parseInt(attributes.getValue("bottomHeight"));
            dungeonBeingParsed = new Dungeon(name, width, topHeight, gameHeight, bottomHeight);
            displayable[disNum] = dungeonBeingParsed;
            //disNum++;

        } else if (qName.equalsIgnoreCase("Rooms")) {

        } else if (qName.equalsIgnoreCase("Room")) {
            disNum++;
            int room = Integer.parseInt(attributes.getValue("room"));
            roomBeingParsed = new Room(room);
            dungeonBeingParsed.addRoom(roomBeingParsed); //arraylist implementation
            displayable[disNum] = roomBeingParsed;
            //disNum++;


        } else if (qName.equalsIgnoreCase("Monster")) {
            disNum++;
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            monsterBeingParsed = new Monster(name, room, serial);
            roomBeingParsed.addMonster(monsterBeingParsed); // add the creature to the room
            displayable[disNum] = monsterBeingParsed;
            //disNum++;


        } else if (qName.equalsIgnoreCase("Player")) {
            disNum++;
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            playerBeingParsed = new Player(name, room, serial);
            dungeonBeingParsed.addPlayer(playerBeingParsed);
            displayable[disNum] = playerBeingParsed;
            

        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            String actionMessage = attributes.getValue("actionMessage");
            creatureActionBeingParsed = new CreatureAction(name, type);

        } else if (qName.equalsIgnoreCase("Passages")){

        }

        else if (qName.equalsIgnoreCase("Passage")) {
            disNum++;
            int room1 = Integer.parseInt(attributes.getValue("room1"));
            int room2 = Integer.parseInt(attributes.getValue("room2"));
            passageBeingParsed = new Passage(room1, room2);
            dungeonBeingParsed.addPassage(passageBeingParsed);
            displayable[disNum] = passageBeingParsed;

        }
        else if (qName.equalsIgnoreCase("Armor")) { // TODO check if it's in a room or in the player's pack
            disNum++;
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            armorBeingParsed = new Armor(name, room, serial);
            if(playerBeingParsed != null){
                playerBeingParsed.addItem(armorBeingParsed);
            }
            else{
                roomBeingParsed.addItem(armorBeingParsed);
            }
            displayable[disNum] = armorBeingParsed;
        }
        else if(qName.equalsIgnoreCase("Sword")) {
            disNum++;
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            swordBeingParsed = new Sword(name, room, serial);
            if(playerBeingParsed != null){
                playerBeingParsed.addItem(swordBeingParsed);
            }
            else{
                roomBeingParsed.addItem(swordBeingParsed);
            }
            displayable[disNum] = swordBeingParsed;

        }
        else if(qName.equalsIgnoreCase("Scroll")) {
            disNum++;
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            scrollBeingParsed = new Scroll(name, room, serial);
            if(playerBeingParsed != null){
                playerBeingParsed.addItem(scrollBeingParsed);
            }
            else{
                roomBeingParsed.addItem(scrollBeingParsed); 
            }
            displayable[disNum] = scrollBeingParsed;

        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if (qName.equalsIgnoreCase("posX")) {
            //room = (Room) roomBeingParsed;
            //room.setPosX(data); 
            displayable[disNum].setPosX(Integer.parseInt(data.toString()));
            
        } else if (qName.equalsIgnoreCase("posY")) {
            //room = (Room) roomBeingParsed;
            //room.setPosY();
            displayable[disNum].setPosY(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("width")) {
            //room = (Room) roomBeingParsed;
            //room.setWidth();
            displayable[disNum].setWidth(Integer.parseInt(data.toString()));


        } else if (qName.equalsIgnoreCase("height")) {
            //room = (Room) roomBeingParsed;
            //room.setHeight();
            displayable[disNum].setHeight(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("type")) {
            //monster = (Monster) monsterBeingParsed;
            //monster.setType();
            displayable[disNum].setType(data.toString());

        } else if (qName.equalsIgnoreCase("hp")) {
            //monster = (Monster) monsterBeingParsed;
            //monster.setHp();
            displayable[disNum].setHp(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("maxhit")) {
            //monster = (Monster) monsterBeingParsed;
            //monster.setMaxHit();
            displayable[disNum].setMaxHit(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("hpMoves")) {
            displayable[disNum].setHpMove(Integer.parseInt(data.toString()));
        }
        else if (qName.equalsIgnoreCase("visible")) {
            //player = (Player) playerBeingParsed;
            //player.setVisible();
            System.out.println("disNum = " + disNum);
            displayable[disNum].setVisible(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("actionMessage")) {
            //game.action = (CreatureAction) creatureActionBeingParsed;
            //CreatureAction.setActionMessage(data.toString());
            displayable[disNum].setActionMessage(data.toString());
            
        } /*else if (qName.equalsIgnoreCase("ItemIntValue")) {
            displayable[disNum].setItemIntValue(data.toString());
        }*/
        
        else if (qName.equalsIgnoreCase("CreatureAction")) {
            creatureActionBeingParsed = null;
            //disNum--;
        } else if (qName.equalsIgnoreCase("Player")) {
            playerBeingParsed.globalize(roomBeingParsed.getPosX(), roomBeingParsed.getPosY());
            playerBeingParsed = null;
            disNum--;

        } else if (qName.equalsIgnoreCase("Monster")) {
            monsterBeingParsed.globalize(roomBeingParsed.getPosX(), roomBeingParsed.getPosY());
            monsterBeingParsed = null;
            disNum--;

        } else if (qName.equalsIgnoreCase("Room")) {
            roomBeingParsed = null;
            disNum--;
            // decrement where you are in game.displayable stack

        } else if (qName.equalsIgnoreCase("Dungeon")) {
            //dungeonBeingParsed = null;
            disNum--;
        } else if(qName.equalsIgnoreCase("Passage")) {
            passageBeingParsed = null;
            disNum--;
        } else if(qName.equalsIgnoreCase("Armor")) {
            armorBeingParsed.globalize(roomBeingParsed.getPosX(), roomBeingParsed.getPosY());
            armorBeingParsed = null;
            disNum--;

        } else if(qName.equalsIgnoreCase("Sword")){
            swordBeingParsed.globalize(roomBeingParsed.getPosX(), roomBeingParsed.getPosY());
            swordBeingParsed = null;
            disNum--;
        } else if(qName.equalsIgnoreCase("Scroll")){
            scrollBeingParsed.globalize(roomBeingParsed.getPosX(), roomBeingParsed.getPosY());
            scrollBeingParsed = null;
            disNum--;
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
        if (DEBUG > 1) {
            System.out.println(CLASSID + ".characters: " + new String(ch, start, length));
            System.out.flush();
        }
    }

}


