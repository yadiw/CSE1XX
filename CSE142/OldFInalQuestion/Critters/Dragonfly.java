import java.awt.*;

public class Dragonfly extends Critter {

   private int goEast;
   private int count;
   private Direction lastDirection;
   
   public Dragonfly() {
      lastDirection = Direction.SOUTH;
      goEast = 1;
      count = 1;
   }
   
   public boolean eat() {
      goEast++;
      return true;
   }
   
   public Direction getMove() {
      if (goEast == count) {
         count = 0;
         if (lastDirection == Direction.SOUTH) {
            lastDirection = Direction.NORTH;
            return Direction.NORTH;
         } else {
            lastDirection = Direction.SOUTH;
            return Direction.SOUTH;
         }
      } else {
         count++;
         return Direction.EAST;
      }   
   }










}