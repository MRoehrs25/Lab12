import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        System.out.println("\nWelcome to the Adkins house! Entering the study room. To leave the house, please type exit to jump out of the nearest window.\n");
        /*
         * Guest Room: A room filled with numerous torture devices. Who said anything about welcome guests? :: Kitchen
         * Library: Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you! :: Holodeck, Trophy Room, Study
         * Kitchen: This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway. :: Study, Guest Room
         * Study: Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms. :: Kitchen, Library, Bedroom
         * Holodeck: A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library. :: Library
         * Trophy Room: Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to. :: Bedroom, Library
         * Bedroom: A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom. :: Study, Trophy Room
         */
         AdventureMap map = new AdventureMap();
         Room Guest = new Room("Guest Room", "A room filled with numerous torture devices. Who said anything about welcome guests?" );
         Room Library = new Room("Library", "Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you!");
         Room Kitchen = new Room("Kitchen", "This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway.");
         Room Study = new Room("Study", "Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms.");
         Room Holodeck = new Room("Holodeck", "A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library.");
         Room Trophy = new Room("Trophy Room", "Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to.");
         Room Bedroom = new Room("Bedroom", "A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom.");

         Study.addExit("Kitchen");
         Study.addExit("Library");
         Study.addExit("Bedroom");

         Guest.addExit("Kitchen");

         Kitchen.addExit("Study");
         Kitchen.addExit("Guest Room");

         Library.addExit("Holodeck");
         Library.addExit("Trophy Room");
         Library.addExit("Study");

         Holodeck.addExit("Library");

         Trophy.addExit("Bedroom");
         Trophy.addExit("Library");

         Bedroom.addExit("Study");
         Bedroom.addExit("Trophy Room");

         map.addRoom(Study);
         map.addRoom(Kitchen);
         map.addRoom(Trophy);
         map.addRoom(Holodeck);
         map.addRoom(Bedroom);
         map.addRoom(Library);
         map.addRoom(Guest);
        

        /*
         * Create a scanner, put the inital room (entrance) to study
         * While the user's input is not exit, continue to traverse the map. 
         * If there is an invalid selection, then print out "Invalid exit."
         * After you are done selecting, print out "Please choose an exit" and get next exit
         */
         Scanner scnr = new Scanner(System.in);
         String input = "Study";
         Room currentRoom = Study;
         while (!(input.equalsIgnoreCase("exit"))) {//prints room info
            System.out.println(currentRoom.toString());
            System.out.println("Exits:");
            System.out.println(currentRoom.listExits());
            System.out.println("Please choose an exit");
            try {
                input = scnr.nextLine();
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid exit");
                input = scnr.nextLine();
            }
            
            
            ArrayList<String> exits = currentRoom.getList();
            boolean bool = true;
            while (bool) {//validates input
                if (input.equalsIgnoreCase("exit")) {
                    bool = false;
                    break;
                }
                else if (!(exits.contains(input))) {
                    System.out.println("Invalid exit.");
                    System.out.println("Please choose an exit");
                    input = scnr.nextLine();
                }
                else {
                    currentRoom = map.getRoom(input);
                    bool = false;
                    break;
                }
            }
         }
        
    }

}

