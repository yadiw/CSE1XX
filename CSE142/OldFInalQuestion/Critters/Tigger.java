

public class Tigger extends Critter {

   private int count;
   private int height;
   private int max;
   
   public Tigger(int height) {
      //count = 0;
      this.height = height;
      max = height;
   }


   public boolean eat() {
      count = 0;
      max = height;
      return true;
   }
   
   public Direction getMove() {
      count++;
      if (count <= max) {
         return Direction.NORTH;
      } else if (count < 2 * max) {
         return Direction.SOUTH;
      } else {
         count = 0;
         max++;
         return Direction.SOUTH;
      }
   }
}