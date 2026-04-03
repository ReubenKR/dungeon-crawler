import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private String playerName;
   private int health;
   private int currentX;
   private int currentY;


   public Player(int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      inventory = new ArrayList<Item>();
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
   }

   public void addItemToInventory(Item item) {
      // TODO: add an item to inventory
         inventory.add(item);
   }
   
   public Item removeItemFromInventory(Item item) {
      // TODO: remove an item to inventory. Return the Item so it can returned to the Room that it is in
      inventory.remove(item);
      return item;
   }
   
   
   public boolean hasItem(String itemName) {
      if (inventory.contains(itemName)) {
      return true;
      } else {
      return false;
      }
   }
   

   
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
      return map.getRoom(currentX, currentY).toString();
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
      currentX = x;
      currentY = y;
   }
   
   public Room getRoom(Map map) {
      // TODO: return the room object that the player is currently in, given the Map that was passed
      return map.getRoom(currentX, currentY);
   }
   public int getCurrentX() {
      return currentX;
   }
   public int getCurrentY() {
      return currentY;
   }
   public String inventoryContents() {
      String s = "";
      int a = 0;
      for (Item value : inventory) {
      s += inventory.get(a) + ", ";
      a++;
      }
      return s;
   }
}
