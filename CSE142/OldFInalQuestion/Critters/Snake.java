

public class Snake extends Critter {
   
   private int count;
   private int max;
   private boolean walkEast;
   private boolean walkSouth;

   public Snake() {
      walkEast = true;
      //walkSouth = false;
      max = 1;
      count = 0;
   }

   public Direction getMove() {
      if (!walkSouth){
         count++;
         if (count < max) {
            if (walkEast) {
               return Direction.EAST;
            } else {
               return Direction.WEST;
            }
         } else {
            walkEast = !walkEast;
            max++;
            count = 0;
            walkSouth = true;
            if (!walkEast) {
               return Direction.EAST;
            } else {
               return Direction.WEST;
            }
         } 
      } else {
         walkSouth = false;
         return Direction.SOUTH;
      }
   }
}