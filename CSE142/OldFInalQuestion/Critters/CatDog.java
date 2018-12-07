import java.awt.*;
import java.util.*;

public class CatDog extends Critter {
   private static final Direction[] MOVE = {Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH};
   private int percent;
   private boolean dog;
   private Random rand;
   private int step;
   
   public CatDog(int n) {
      step = -1;
      percent = n;
      rand = new Random();
   }
   
   public boolean eat() {
      if (!dog) {
         int num = rand.nextInt(100);
         if (num < percent) {
            dog = true;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
   
   public Direction getMove() {
      if (!dog) {
         step = -1;
         return Direction.NORTH;
      } else {
         step++;
         if (step >= percent) {
            dog = false;
            return Direction.NORTH;
         } else {
            return MOVE[step % 8 / 2];
         }
      }
   }
   
}