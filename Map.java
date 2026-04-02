public class Map {

   private Room[][] roomGrid;
   
   public int getNumRows() {
      // TODO: return the number of rows in roomGrid
      return roomGrid[0].length;
   }
   public int getNumCols() {
      // TODO: return the number of columns in roomGrid
      return roomGrid.length;
   }

   public Map(int rows, int columns) {
      // TODO: initalize the Map by creating the 2D array
      // and then calling populateMap which will build all of the Rooms
      roomGrid = new Room[rows][columns];
      populateMap();
   }
   public void populateMap() {
      // TODO: populate the map with a bunch of Rooms with random numbers of monsters and items
      // Hint: Use nested for loops to fill every row and column
      // Another Hint: use the Room constructor to populate the Monsters and Items
      for (int i = 0; i < roomGrid.length; i++) {
         for (int j = 0; j < roomGrid[0].length; j++) {
            roomGrid[i][j] = new Room();
         }
      }
   }
   public Room getRoom(int row, int column) {
      // TODO: return the Room that is at the row and column that are passed
      return roomGrid[row][column];
   }
   
   public Room getRandomRoom() {
      // TODO: This method will simply return a random room in the Map so that you can 
      // give the player a random starting point.
      return roomGrid[(int) Math.random()*roomGrid.length][(int) Math.random()*roomGrid[0].length];
   }
}
  