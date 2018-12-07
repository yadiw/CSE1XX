
public class Raptor extends Critter {

   private boolean walkEast;
   private int count;

   public Raptor(boolean walkEast) {
      this.walkEast = walkEast;
      count = 21;
   }

   public boolean eat() {
      count = 0;
      return true;
   }
   
   public Direction getMove() {
      count++;
      if (count < 20) {
         if (count % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.SOUTH;
         }
      } else if (count == 20) {
         count = 21;
         walkEast = !walkEast;
         return Direction.SOUTH;
      } else if (walkEast) {
         return Direction.EAST;
      } else {
         return Direction.WEST;
      }
   }
}