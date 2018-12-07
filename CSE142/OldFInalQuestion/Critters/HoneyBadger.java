import java.util.*;

public class HoneyBadger extends Critter {
   private int step;
   private int count;
   private Random rand;
   
   public HoneyBadger(int step) {
      rand = new Random();
      this.step = step;
   }
   
   public boolean eat() {
      count = 0;
      return true;
   }
   
   public Direction getMove() {
      count++;
      if (count % step == 1 || step == 1) {
         return Direction.NORTH;
      } else {
         return Direction.WEST;
      }
   }
   
   public Attack fight() {
      int num = rand.nextInt(2);
      if (num == 0) {
         return Attack.POUNCE;
      } else {
         return Attack.SCRATCH;
      }
   }
}