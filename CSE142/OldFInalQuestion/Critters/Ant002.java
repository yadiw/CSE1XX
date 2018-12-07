import java.awt.*;
import java.util.*;

public class Ant002 extends Critter {
   private static final Direction[] MOVE1 = {Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
   private static final Direction[] MOVE2 = {Direction.SOUTH, Direction.NORTH, Direction.WEST, Direction.EAST};
   private int steps;
   private int count; 
   private int index;
   private boolean back;
   private Random rand;
    
   public Ant002(int steps) {
      this.steps = steps;
      rand = new Random();
      count = -1;
      back = true;
   }
    
   public Direction getMove() {
      count++;
      if (count % steps == 0) {
         back = !back;
         if (!back) {
            index = rand.nextInt(4);
         }
      }
      if (!back) {
         return MOVE1[index];
      } else {
         return MOVE2[index];
      }
   }
}