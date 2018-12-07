import java.util.*;
import java.awt.*;

public class Cheetah extends Critter {
   private int neededFood;
   private Random rand;
   private boolean eatFood;
   private int foodEaten;
   private Direction move;
   private static final Direction[] MOVE = {Direction.NORTH, Direction.SOUTH};
   
   public Cheetah(int neededFood) {
      this.neededFood = neededFood;
      rand = new Random();
      move = MOVE[rand.nextInt(2)];
   }
   
   public boolean eat() {
      foodEaten++;
      eatFood = true;
      return true;
   }
   
   public Direction getMove() {
      if (eatFood) {
         eatFood = false;
         move = MOVE[rand.nextInt(2)];
      } 
      return move;
   }
   
   public Attack fight(String opponent) {
      if (foodEaten < neededFood) {
         foodEaten = 0;
         return Attack.FORFEIT;
      } else {
         foodEaten = 0;
         return Attack.POUNCE;
      }
   }




}