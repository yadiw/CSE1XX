


public class Goldfish extends Critter {
   
   private boolean walkNorth;
   private int count;
   
   public Goldfish(boolean walkNorth) {
      this.walkNorth = walkNorth;
      count = 11;
   }
   
   public Attack fight() {
      count = 0;
      return Attack.SCRATCH;
   }
   
   public Direction getMove() {
      count++;
      if (count > 10) {
         if (walkNorth) {
            return Direction.NORTH;
         } else {
            return Direction.SOUTH;
         }
      } else {
         if (walkNorth) {
            return Direction.SOUTH;
         } else {
            return Direction.NORTH;
         }
      }
   }
}