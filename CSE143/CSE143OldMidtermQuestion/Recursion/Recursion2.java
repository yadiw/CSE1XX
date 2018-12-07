public class Recursion2 {
   public static void main(String[] args) {
      // 01
      System.out.println(isReverse("Go! Go", "OG !OG"));
      // 02
      System.out.println(isSorted(-223344551));
      // 03
      System.out.println(largestDigit(14263203));
      // 04
      mirrorString("bo");
      System.out.println();
      // 05
      System.out.println(moveToEnd("hello there", 'e'));
      // 06
      System.out.println(nthFromEnd(1234567890, 9));
      // 07
      parenthesize("Joe", 2);
      System.out.println();
      // 08
      parenthesize2(8);
      System.out.println();
      // 09
      printDashed(-834);
      System.out.println();
      // 10
      printPattern(7);
      System.out.println();
      
   }
   
   public static boolean isReverse(String str1, String str2) {
      if (str1.length() != str2.length()) {
         return false;
      } else if (str1.length() < 2) {
         return str1.equalsIgnoreCase(str2);
      } else {
         if (isReverse(str1.substring(0, 1), (str2.substring(str2.length() - 1, str2.length())))) {
            return isReverse(str1.substring(1), str2.substring(0, str2.length() - 1));
         } else {
            return false;
         }
      }
   }
   
   public static boolean isSorted(int num) {
      if (num < 0) {
         return isSorted(- num);
      } else if (num < 10) {
         return true;
      } else {
         int num1 = num % 10;
         int num2 = num / 10 % 10;
         if (num2 <= num1) {
            return isSorted(num / 10);
         } else {
            return false;
         }
      }
   }
   
   public static int largestDigit(int num) {
      if (num < 0) {
         return (largestDigit(- num));
      } else if (num < 10) {
         return num;
      } else {
         if (num % 10 > num / 10 % 10) {
            return Math.max(num % 10, largestDigit(num / 10));
         } else {
            return largestDigit(num / 10);
         }
      }
   }
   
   public static void mirrorString(String str) {
      if (str.length() > 0) {
         if (str.length() == 1) {
            System.out.print(str);
         } else {
            System.out.print(str.charAt(0));
            mirrorString(str.substring(1));
            System.out.print(str.charAt(0));
         }
      }
   }
   
   public static String moveToEnd(String str, char ch) {
      if (str.length() <= 1) {
         return str;
      } else {
         char start = str.charAt(0);
         if (start == ch) {
            return moveToEnd(str.substring(1), ch) + start;
         } else {
            return "" + start +moveToEnd(str.substring(1), ch);
         }
      }
   }
   
   public static int nthFromEnd(int num, int n) {
      if (num < 0 || n < 0) {
         throw new IllegalArgumentException();
      } else if (n == 0){
         return num % 10;   
      } else {
         return nthFromEnd(num / 10, n - 1);
      }
   }
   
   public static void parenthesize(String str, int n) {
      if (n < 0) {
         throw new IllegalArgumentException();
      }
      if (n == 0) {
         System.out.print(str);
      } else {
         System.out.print("(");
         parenthesize(str, n - 1);
         System.out.print(")");
      }
   }
   
   public static void parenthesize2(int n) {
      if (n <= 1) {
         System.out.print(n);
      } else if (n % 2 == 0){
         System.out.print("(" + n + " + ");
         parenthesize2(n - 1);
         System.out.print(")");
      } else {
         System.out.print("(");
         parenthesize2(n - 1);
         System.out.print(" + " + n + ")");
      }
   }
   
   public static void printDashed(int n) {
      if (n < 0) {
         System.out.print("-");
         printDashed(- n);
      } else if (n < 10) {
         System.out.print(n);
      } else {
         printDashed(n / 10);
         System.out.print("-" + (n % 10));
      }
   }
   
   public static void printPattern(int n) {
      if (n < 0) {
         throw new IllegalArgumentException();
      }
      if (n > 0) {
         if (n == 1) {
            System.out.print(".");
         } else if (n / 2 % 2 == 0) {
            System.out.print("[");
            printPattern(n - 2);
            System.out.print("]");
         } else {
            System.out.print("(");
            printPattern(n - 2);
            System.out.print(")");
         }
      }
   }
}