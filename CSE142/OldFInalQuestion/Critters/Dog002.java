import java.awt.*;

public class Dog002 extends Critter {
   private static final Direction[] MOVE = {Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST};
   private int step;
   private int max;
   
   public Dog002() {
      max = 1;
   }
   
   public Attack fight(String opponent) {
      step = 0;
      if (opponent.equals("%")) {
         return Attack. ROAR;
      } else {
         return Attack.SCRATCH;
      }
   }
   
   public Direction getMove() {
      if (step == max) {
         step = 0;
         max++;
      }
      step++;
      return MOVE[(max - 1) % 4];
   }
   
}