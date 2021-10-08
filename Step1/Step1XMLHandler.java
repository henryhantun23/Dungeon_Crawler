package Step1;

import Step1.displayable.Structure.Room;
import Step1.displayable.Dungeon;
import Step1.displayable.creatures.*;
import Step1.action.*;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Step1XMLHandler extends DefaultHandler {

    private static final int DEBUG = 1;
    private static final String CLASSID = "Step1XMLHandler";

    private StringBuilder data = null;

    private Room[] rooms;
    private int roomCount = 0;

    private Dungeon dungeonBeingParsed = null;
    private Room roomBeingParsed = null;
    private Monster monsterBeingParsed = null;
    private Player playerBeingParsed = null;
    private Action creatureActionBeingParsed = null;

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

    public Dungeon[] getDungeons(){
        return dungeons;
    }

    public Step1XMLHandler(){

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

        } else if (qName.equalsIgnoreCase("Rooms")) {

        } else if (qName.equalsIgnoreCase("Room")) {
            rooms = new Room[2];
            int room = Integer.parseInt(attributes.getValue("room"));
            int posX = Integer.parseInt(attributes.getValue("posX"));
            int posY = Integer.parseInt(attributes.getValue("posY"));
            int width = Integer.parseInt(attributes.getValue("width"));
            int height = Integer.parseInt(attributes.getValue("height"));

        } else if (qName.equalsIgnoreCase("Monster")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            int posX = Integer.parseInt(attributes.getValue("posX"));
            int posY = Integer.parseInt(attributes.getValue("posY"));
            String type = attributes.getValue("type");
            int hp = Integer.parseInt(attributes.getValue("hp"));
            int maxhit = Integer.parseInt(attributes.getValue("maxhit"));

        } else if (qName.equalsIgnoreCase("Player")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            int visible = Integer.parseInt(attributes.getValue("visible"));
            int posX = Integer.parseInt(attributes.getValue("posX"));
            int posY = Integer.parseInt(attributes.getValue("posY"));
            int hp = Integer.parseInt(attributes.getValue("hp"));
            int maxhit = Integer.parseInt(attributes.getValue("maxhit"));
            int hpMoves = Integer.parseInt(attributes.getValue("hpMoves"));

        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            String actionMessage = attributes.getValue("actionMessage");

        } else if (qName.equalsIgnoreCase("posX")) {
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
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Room room ;
        if (qName.equalsIgnoreCase("Room")) {
            room = (Room)roomBeingParsed;
            room.setId(Integer.parseInt(data.toString()));
        } else if(qName.equalsIgnoreCase("posX")) {
            room = (Room)roomBeingParsed;
            room.setPosX(Integer.parseInt(data.toString()));
        } else if(qName.equalsIgnoreCase("posY")){
            room = (Room)roomBeingParsed;
            room.setPosY(Integer.parseInt(data.toString()));
        } else if(qName.equalsIgnoreCase("width")) {
            room = (Room)roomBeingParsed;
            room.setWidth(Integer.parseInt(data.toString()));
        } else if(qName.equalsIgnoreCase("height")) {
            room = (Room)roomBeingParsed;
            room.setHeight(Integer.parseInt(data.toString()));
        } else if(qName.equalsIgnoreCase("Monster")){

        }


        if (qName.equalsIgnoreCase("Students")) {
            if (studentCount != maxStudents) {
                System.out.println("wrong number of students parsed, should be " + maxStudents + ", is " + studentCount);
            }
        } else if (qName.equalsIgnoreCase("Student")) {
            studentBeingParsed = null;
        } else if (qName.equalsIgnoreCase("Activity")) {
            activityBeingParsed = null;
        }
    }

