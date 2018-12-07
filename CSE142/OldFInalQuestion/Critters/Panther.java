import java.awt.*;
import java.util.*;

public class Panther extends Critter {
   
   private boolean foraging;
   private Random rand;
   private static final Direction[] MOVE = {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
   
   public Panther() {
      foraging = true;
      rand = new Random();
   }
   
   public boolean eat() {
      foraging = false;
      return true;
   }
   
   public Attack fight(String opponent) {
      if (foraging) {
         return Attack.ROAR;
      } else {
         foraging = true;
         return Attack.SCRATCH;
      }      
   }
   
   public Direction getMove() {
      int num = rand.nextInt(4);
      return MOVE[num];
   }
   
   public Color getColor() {
      if (foraging) {
         return Color.BLACK;
      } else {
         return Color.RED;
      }
   }










}