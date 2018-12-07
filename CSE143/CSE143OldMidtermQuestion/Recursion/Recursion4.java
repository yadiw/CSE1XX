public class Recursion4 {
   public static void main(String[] args) {
      // 01
      writeNumbers(5);
      System.out.println();
      writeNumbers(8);
      System.out.println();
      // 02
      writeNums(10);
      System.out.println();
      // 03
      writeSquares(5);
      System.out.println();
      writeSquares(8);
      System.out.println();
   }

   public static void writeNumbers(int n) {
      if (n < 1) {
         throw new IllegalArgumentException();
      }
      if (n == 1) {
         System.out.print(n);
      } else if (n % 2 == 0) {
         writeNumbers(n - 1);
         System.out.print(", " + n);
      } else {
         System.out.print(n + ", ");
         writeNumbers(n - 1);
      }
   }
   
   public static void writeNums(int n) {
      if (n < 1) {
         throw new IllegalArgumentException();
      }
      if (n == 1) {
         System.out.print(n);
      } else {
         writeNums(n - 1);
         System.out.print(", " + n);
      }
   }
   
   public static void writeSquares(int n) {
      if (n < 1) {
         throw new IllegalArgumentException();
      }
      if (n == 1) {
         System.out.print(n);
      } else if (n % 2 == 1){
         System.out.print(n * n + ", ");
         writeSquares(n - 1);
      } else {
         writeSquares(n - 1);
         System.out.print(", " + n * n);
      }
   }
}