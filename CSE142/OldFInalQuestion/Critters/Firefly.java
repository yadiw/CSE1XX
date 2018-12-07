import java.awt.*;
import java.util.*;

public class Firefly extends Critter {
   private int glow;
   private boolean hunger;
   private Random rand;
   private int count;

   public Firefly(int glow) {
      count = glow + 1;
      this.glow = glow;
      hunger = true;
      rand = new Random();
   }
   
   public boolean eat() {
      if (count <= glow) {
         return false;
      } else {
         count = 0;
         hunger = false;
         return true;
      }

   }
   
   public Direction getMove() {
      count++;
      int num = rand.nextInt(2);
      if (num == 0) {
         return Direction.NORTH;
      } else {
         return Direction.SOUTH;
      }
   }
   
   public Color getColor() {
      if (count <= glow && !hunger) {
         return Color.YELLOW;
      
      } else {
         return Color.BLACK;
      }
   
   }








}