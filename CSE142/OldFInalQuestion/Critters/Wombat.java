import java.util.*;

public class Wombat extends Critter {
   private static final Direction[] MOVE = {Direction.SOUTH, Direction.SOUTH, Direction.NORTH};
   private String shape;
   private int count;
   private Random rand;
   
   public Wombat() {
      shape = "?";
      count = -1;
      rand = new Random();
   }
   
   public boolean eat() {
      int num = rand.nextInt(3);
      return num == 2;
   }


   public Attack fight(String opponent) {
      shape = opponent;
      if (opponent.equals("%")){
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   
   }
   
   public Direction getMove() {
      count++;
      return MOVE[count % 3];
   }

   public String toString() {
      return shape;
   }





}