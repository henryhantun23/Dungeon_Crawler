package game;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;

import game.displayable.creatures.Player;
import game.displayable.*;

public class Rogue implements Runnable{

    public void run(){

    }

    public static void main(String[] args) {

	// check if a filename is passed in.  If not, print a usage message.
	// If it is, open the file
        String fileName = null;
        switch (args.length) {
        case 1:
           fileName = "xmlfiles/" + args[0];
           break;
        default:
            fileName = "src/xmlfiles/badScroll.xml";
           //System.out.println("java Test <xmlfilename>");
        }

	// Create a saxParserFactory, that will allow use to create a parser
	// Use this line unchanged
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

	// We haven't covered exceptions, so just copy the try { } catch {...}
	// exactly, // filling in what needs to be changed between the open and 
	// closed braces.
        try {
	    // just copy this
            SAXParser saxParser = saxParserFactory.newSAXParser();
	    // just copy this
            Step1XMLHandler handler = new Step1XMLHandler();
	    // just copy this.  This will parse the xml file given by fileName
            saxParser.parse(new File(fileName), handler);
	    // This will change depending on what kind of XML we are parsing
            Dungeon dungeon = handler.getDungeons();
            Player player = dungeon.getPlayer();
	    // print out all of the students.  This will change depending on 
	    // what kind of XML we are parsing
            //for (Student student : students) {
                //System.out.println(student);

            /*
             * the above is a different form of 
             for (int i = 0; i < students.length; i++) {
                System.out.println(students[i]);
            }
            */

        ObjectDisplayGrid.setGridSize(dungeon.getWidth(), dungeon.getTopHeight(), dungeon.getGameHeight(), dungeon.getBottomHeight());
        ObjectDisplayGrid grid = ObjectDisplayGrid.getInstance();
        dungeon.draw();
        dungeon.drawInitialInfo();

        // make thread
        // start
        // join

        Thread myThread = new Thread(new KeyStrokePrinter(grid, player));
        myThread.start();
        try {
            myThread.join();
            dungeon.draw();
        }
        catch (InterruptedException e){

        }

        // these lines should be copied exactly
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}