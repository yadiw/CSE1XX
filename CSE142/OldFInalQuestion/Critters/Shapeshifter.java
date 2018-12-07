import java.util.*;

public class Shapeshifter extends Critter {
   private String shape;
   private Random rand;
   private static final Direction[] MOVE = {Direction.NORTH, Direction.NORTH, Direction.CENTER, Direction.SOUTH};
   private int count;
   
   public Shapeshifter(String shape) {
      this.shape = shape;
      rand = new Random();
      count = -1;
   }
   
   public Attack fight(String opponent) {
      shape = opponent;
      int num = rand.nextInt(3);
      if (num == 0) {
         return Attack.POUNCE;
      } else if (num == 1) {
         return Attack.ROAR;
      } else {
         return Attack.SCRATCH;
      }
   }
   
   public Direction getMove() {
      count++;
      return MOVE[count % 4];
   }
   
   public String toString() {
      return shape;
   }
}