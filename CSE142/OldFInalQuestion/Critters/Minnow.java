

public class Minnow extends Critter {

   private boolean reset;
   private int foodCount;
   private Direction hori;
   private int count;
   
   public Minnow() {
      foodCount = 1;
      hori = Direction.EAST;
   }

   public boolean eat() {
      foodCount++;
      reset = true;
      return false;
   }
   
   public Direction getMove() {
      count++;
      if (reset) {
         count = 1;
         reset = false;
         if (hori == Direction.EAST) {
            hori = Direction.WEST;
         } else {
            hori = Direction.EAST;
         }
         return Direction.SOUTH;
      } else {
         if (count % (foodCount + 1) == 1) {
            return Direction.SOUTH;
         } else {
            return hori;
         }
      }
   }
}