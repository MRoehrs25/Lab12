import java.util.ArrayList;

public class Room
{
    String name;
    String description;
    ArrayList<String> exits;
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        
    }
    /* Generate getters and setters for the naems and descriptions */
    
    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit) {
        exits.add(exit);
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits() {
        String exitList;
        for (String exit: exits) {
            exitList += exit + " \n";
        }
        return exitList;
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString() {
        String final = name + ": " + description; 
        return final;
    }
    public String getName() {
        return name;
    }
}
