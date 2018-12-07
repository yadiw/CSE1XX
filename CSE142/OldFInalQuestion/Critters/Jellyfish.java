
public class Jellyfish extends Critter {
   private int move;
   private int count;
   private Direction movement;
   private static final Direction[] MOVE = {Direction.NORTH, Direction.CENTER, Direction.CENTER};
   private int index;
   
   public Jellyfish(int move) {
      this.move = move;
      count = move + 1;
      index = -1;
   }

   public boolean eat() {
      count = 0;
      return true;
   }

   public Direction getMove() {
      count++;
      if (count <= move) {
         movement = Direction.WEST;
      } else {
         index++;
         if (index >=3 ) {
            index = 0;
         }
         movement = MOVE[index];
      }
      return movement;
   }
   
   public String toString() {
      if (movement == Direction.WEST || movement == Direction.NORTH) {
         return "D";
      } else {
         return "o";
      }
   }









}