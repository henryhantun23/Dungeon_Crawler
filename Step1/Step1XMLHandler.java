package Step1;


import Step1.displayable.Structure.Passage;
import Step1.displayable.Structure.Room;
import Step1.displayable.Displayable;
import Step1.displayable.Dungeon;
import Step1.displayable.creatures.*;
import Step1.action.*;
import Step1.action.creatureAction.CreatureAction;
import java.util.ArrayList;
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
    private Dungeon dungeon;
    private int roomCount = 0;
    private Displayable[] displayable = new Displayable[10];//parse queue?
    private int disNum = 0;

    private Dungeon dungeonBeingParsed = null;
    private Room roomBeingParsed = null;
    private Monster monsterBeingParsed = null;
    private Player playerBeingParsed = null;
    private Action creatureActionBeingParsed = null;
    private Passage passageBeingParsed = null;

    /*
    private boolean bPosX = false;
    private boolean bPosY = false;
    private boolean bWidth = false;
    private boolean bHeight = false;
    private boolean bType = false;
    private boolean bHp = false;
    private boolean bMaxhit = false;
    private boolean bVisible = false;
    private boolean bHpMoves = false;
    private boolean bActionMessage = false;
    */

    public Dungeon getDungeons(){
        return dungeon;
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
            disNum++;

        } else if (qName.equalsIgnoreCase("Rooms")) {

        } else if (qName.equalsIgnoreCase("Room")) {
            int room = Integer.parseInt(attributes.getValue("room"));
            roomBeingParsed = new Room(room);
            dungeonBeingParsed.addRoom(roomBeingParsed); //arraylist implementation
            displayable[disNum] = roomBeingParsed;
            disNum++;


        } else if (qName.equalsIgnoreCase("Monster")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            monsterBeingParsed = new Monster(name, room, serial);
            roomBeingParsed.addMonster(monsterBeingParsed); // add the creature to the room
            displayable[disNum] = monsterBeingParsed;
            disNum++;


        } else if (qName.equalsIgnoreCase("Player")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            playerBeingParsed = new Player(name, room, serial);
            roomBeingParsed.addPlayer(playerBeingParsed);
            displayable[disNum] = playerBeingParsed;
            disNum++;

        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            String actionMessage = attributes.getValue("actionMessage");
            creatureActionBeingParsed = new CreatureAction(name, type);

        } /*else if (qName.equalsIgnoreCase("Passages"));

        } else if (qName.equalsIgnoreCase("Passage")) {
            int room1 = Integer.parseInt(attributes.getValue("room1"));
            int room2 = Integer.parseInt(attributes.getValue("room2"));
            passageBeingParsed = new Passage(room1, room2);

        }
            /*else if (qName.equalsIgnoreCase("posX")) {
            bPosX = true;
        } else if (qName.equalsIgnoreCase("posY")) {
            bPosY = true;
        } else if (qName.equalsIgnoreCase("width")) {
            bWidth = true;
        } else if (qName.equalsIgnoreCase("height")) {
            bHeight = true;
        } else if (qName.equalsIgnoreCase("type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("hp")) {
            bHp = true;
        } else if (qName.equalsIgnoreCase("maxhit")) {
            bMaxhit = true;
        } else if (qName.equalsIgnoreCase("visible")) {
            bVisible = true;
        } else if (qName.equalsIgnoreCase("hpMoves")) {
            bHpMoves = true;
        } else if (qName.equalsIgnoreCase("actionMessage")) {
            bActionMessage = true;
        } else {
            System.out.println("Unknown qname: " + qName);
        }*/
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Room room;
        Monster monster;
        Player player;
        CreatureAction action;
        if (qName.equalsIgnoreCase("posX")) {
            room = (Room) roomBeingParsed;
            //room.setPosX(data); //ask about parsing ints which setter to use
            displayable[disNum].setPosX(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("posY")) {
            room = (Room) roomBeingParsed;
            //room.setPosY();
            displayable[disNum].setPosY(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("width")) {
            room = (Room) roomBeingParsed;
            //room.setWidth();
            displayable[disNum].setWidth(Integer.parseInt(data.toString()));


        } else if (qName.equalsIgnoreCase("height")) {
            room = (Room) roomBeingParsed;
            //room.setHeight();
            displayable[disNum].setHeight(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("type")) {
            monster = (Monster) monsterBeingParsed;
            //monster.setType();
            displayable[disNum].setType(data.toString());

        } else if (qName.equalsIgnoreCase("hp")) {
            monster = (Monster) monsterBeingParsed;
            //monster.setHp();
            displayable[disNum].setHp(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("maxhit")) {
            monster = (Monster) monsterBeingParsed;
            //monster.setMaxHit();
            displayable[disNum].setMaxHit(Integer.parseInt(data.toString()));

        } else if (qName.equalsIgnoreCase("visible")) {
            player = (Player) playerBeingParsed;
            //player.setVisible();
            displayable[disNum].setVisible(Integer.parseInt(data.toString()));

        /*} else if (qName.equalsIgnoreCase("actionMessage")) {
            action = (CreatureAction) creatureActionBeingParsed;
            //CreatureAction.setActionMessage(data.toString());
            displayable[disNum].setActionMessage(data.toString());*/

        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            creatureActionBeingParsed = null;
            disNum--;
        } else if (qName.equalsIgnoreCase("Player")) {
            playerBeingParsed = null;
            disNum--;

        } else if (qName.equalsIgnoreCase("Monster")) {
            monsterBeingParsed = null;
            disNum--;

        } else if (qName.equalsIgnoreCase("Room")) {
            roomBeingParsed = null;
            disNum--;
            // decrement where you are in displayable stack

        } else if (qName.equalsIgnoreCase("Dungeon")) {
            dungeonBeingParsed = null;
            disNum--;
        }

    }

}


