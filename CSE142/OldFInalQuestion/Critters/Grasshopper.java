

public class Grasshopper extends Critter {

   private int height;
   private boolean hop;
   private int hopCount;
   
   public Attack fight(String opponent) {
      height++;
      if (hop) {
         return Attack.FORFEIT;
      } else {
         hop = true;
         return Attack.ROAR;
      }
   }
   
   public Direction getMove() {
      if (hop) {
         hopCount++;
         if (hopCount <= height) {
            return Direction.NORTH;
         } else if (hopCount <= 2 * height) {
            return Direction.SOUTH;
         } else {
            hop = false;
            hopCount = 0;
            return Direction.WEST;
         }
      } else {
         return Direction.CENTER;
      }
   
   
   }









}