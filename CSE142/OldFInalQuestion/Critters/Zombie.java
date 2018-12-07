import java.awt.*;

public class Zombie extends Critter {
   
   private Direction rageMove;
   private boolean rage;
   private int step;
   private int count;
   
   public Zombie(Direction rageMove) {
      this.rageMove = rageMove;
   }
   
   public boolean eat() {
      return false;
   }

   public Attack fight(String opponent) {
      rage = true;
      return Attack.SCRATCH;
   }
   
   public Direction getMove() {
      step++;
      if (!rage) {
         if (step % 2 == 1) {
            return Direction.NORTH;
         } else {
            return Direction.CENTER;
         }
      } else {
         count++;
         if (count <= 10) {
            return rageMove;
         } else {
            rage = false;
            if (step % 2 == 1) {
               return Direction.NORTH;
            } else {
               return Direction.CENTER;
            }
         }
      }
   }
   
   public Color getColor() {
      if (step % 2 == 1) {
         return Color.BLUE;
      } else {
         return Color.GREEN;
      }
   
   }
   
   public String toString() {
      if (rage) {
         return "!";
      } else {
         return "Z";
      }
   }
}