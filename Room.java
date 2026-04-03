import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      int numItems = (int) (Math.random()*2 + 1);
      int numMonsters = (int) (Math.random()*2 + 1);
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      itemsInRoom = new ArrayList<Item>(numItems);
      monstersInRoom = new ArrayList<Monster>(numMonsters);
      for (int i = 0; i < numItems; i++) {
         Item item = new Item();
         itemsInRoom.add(item);
      }
      for (int j = 0; j < numMonsters; j++) {
         Monster monster = new Monster();
         monstersInRoom.add(monster);
      }
   }
   
   public String toString() {
      String returnString = "Items in room: ";
      int a = 0;
      for (Item b : itemsInRoom) {
         returnString += itemsInRoom.get(a) + ", ";
         a++;
      }
      returnString += "Monsters in room: ";
      int c = 0;
      for (Monster d : monstersInRoom) {
         returnString += monstersInRoom.get(c) + ", ";
         c++;
      }

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      return returnString;
   }
      public boolean hasItem(String itemToFind) {
         for (int i = 0; i < itemsInRoom.size(); i++) {
            if (itemsInRoom.get(i).toString().equals(itemToFind)) {
               return true;
            } 
         }
         return false;
      }
      public Item getItem(String item) {
         for (int j = 0; j < itemsInRoom.size(); j++) {
            if (itemsInRoom.get(j).toString().equals(item)) {
               return itemsInRoom.get(j);
            }
         }
         return null;
      }
   }