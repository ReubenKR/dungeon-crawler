import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      int x = 0;
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      dungeonMap.populateMap();
      // TODO: Create a Player at a random location in the Map
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
      Player p = new Player(12000, "grate", (int) (Math.random()*5), (int) (Math.random()*6));      
      while (exitGame != true) {
            while (x < 1) {
               System.out.println("Starting position " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
               x++;
            }

            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
                        
            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            }
            else if (input.equals("LOOK") || input.equals("SEARCH")) {
               System.out.println(p.look(dungeonMap));
               System.out.println("You're looking at room " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
               
            }
            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               
               if (direction.equals("UP")) {
                  if (p.getCurrentY()+1 >= dungeonMap.getNumRows()) {
                     System.out.println("You cannot leave the map!");
                  } else {  
                  p.moveTo(p.getCurrentX(), p.getCurrentY()+1);
                  System.out.println("You moved up!");
                  System.out.println(p.look(dungeonMap));
                  System.out.println("New position on map " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
                  }
               } else if (direction.equals("DOWN")) {
                  if (p.getCurrentY()-1 < 0) {
                     System.out.println("You cannot leave the map!");
                  } else {  
                     p.moveTo(p.getCurrentX(), p.getCurrentY()-1);
                     System.out.println("You moved down!");
                     System.out.println(p.look(dungeonMap));
                     System.out.println("New position on map " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
                  }
               } else if (direction.equals("LEFT")) {  
                  if (p.getCurrentX()-1 < 0) {
                     System.out.println("You cannot leave the map!");
                  } else {
                     p.moveTo(p.getCurrentX()-1, p.getCurrentY());
                     System.out.println("You moved left!");
                     System.out.println(p.look(dungeonMap));
                     System.out.println("New position on map " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
                     }
               } else if (direction.equals("RIGHT")) {
                  if (p.getCurrentX()+1 >= dungeonMap.getNumCols()) {
                     System.out.println("You cannot leave the map!");
                  } else {
                     p.moveTo(p.getCurrentX()+1, p.getCurrentY());
                     System.out.println("You moved right!");
                     System.out.println(p.look(dungeonMap));
                     System.out.println("New position on map " + p.getCurrentX() + ", " + p.getCurrentY() + ".");
                  }
               } else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
               }
            }
            else if (input.startsWith("GRAB ") || input.startsWith("TAKE ")) {
               String itemToTake = input.substring(5);
               if (dungeonMap.getRoom(p.getCurrentX(), p.getCurrentY()).hasItem(itemToTake)){
                  p.addItemToInventory(dungeonMap.getRoom(p.getCurrentX(),p.getCurrentY()).getItem(itemToTake));
                  System.out.println("Inventory: " + p.inventoryContents());
               }
            } 
         // TODO: display a message to the user telling them their current coordinates every time they move
       }
   }
}