public class Recursion3 {
   public static void main(String[] args) {
      // 01
      printRange(8, 20);
      System.out.println();
      printRange(1, 10);
      System.out.println();
      // 02
      printTwos(32);
      System.out.println();
      // 03
      System.out.println(repeat("hi ho!", 5));
      // 04
      System.out.println(replace("to be or not to be", 'e', 'o'));
      // 05
      System.out.println(sameDashes("-12--123", "-xy--xyz"));
      System.out.println(sameDashes("---test-", "-test---"));
      // 06
      showSplit(8);
      System.out.println(); 
      showSplit(7);
      System.out.println();
      // 07
      System.out.println(substring("hamburger", 4, 8));
      // 08
      System.out.println(times(1, 5));
      System.out.println(times(0, 5));
      System.out.println(times(-7, -5));
      // 09
      System.out.println(vowelsToEnd("computer"));
      // 10
      System.out.println(weave(42, 7596));
      System.out.println(weave(42, 95));
   }
   
   public static void printRange(int x, int y) {
      if (x > y) {
         throw new IllegalArgumentException();
      }
      if (x == y) {
         System.out.print(x);
      } else if (y - x == 1) {
         System.out.print(x + " - " + y);
      } else {
         System.out.print(x + " > ");
         printRange(x + 1, y - 1);
         System.out.print(" < " + y);
      }
   }
   
   public static void printTwos(int n) {
      if (n < 1) {
         throw new IllegalArgumentException();
      }
      if (n % 2 == 1) {
         System.out.print(n);
      } else if (n % 4 == 0) {
         System.out.print("2 * ");
         printTwos(n / 4);
         System.out.print(" * 2");
      } else {
         System.out.print("2 * ");
         printTwos(n / 2);
      }
   }
   
   public static String repeat(String str, int n) {
      if (n < 0) {
         throw new IllegalArgumentException();
      }
      if (n > 0) {
         if (n == 1) {
            return str;
         } else if (n % 2 == 0) {
            String half = repeat(str, n / 2);
            return half + half;
         } else {
            return repeat(str, n - 1) + str;
         }
      } else {
         return "";
      }
   }
   
   public static String replace(String str, char before, char after) {
      if (str.length() == 1) {
         if (str.charAt(0) == before) {
            return "" + after;
         } else {
            return str;
         }
      } else if (str.length() > 1) {
         return replace(str.substring(0, 1), before, after) + replace(str.substring(1), before, after);
      } else {
         return "";
      }
   }
   
   public static boolean sameDashes(String str1, String str2) {
      if (str1.length() != str2.length()) {
         throw new IllegalArgumentException();
      }
      if (str1.length() == 0) {
         return true;
      } else if (str1.length() == 1) {
         return (str1.equals("-") == str2.equals("-"));
      } else {
         if (sameDashes(str1.substring(0, 1), str2.substring(0, 1))) {
            return sameDashes(str1.substring(1), str2.substring(1));
         } else {
            return false;
         }
      }
   }
   
   public static void showSplit(int n) {
      if (n < 0) {
         throw new IllegalArgumentException();
      }
      if (n <= 1) {
         System.out.print(n);
      } else if (n % 2 == 0) {
         System.out.print(n + " = (");
         showSplit(n / 2);
         System.out.print(", ");
         showSplit(n / 2);
         System.out.print(")");
      } else {
         System.out.print(n + " = (");
         showSplit((n + 1) / 2);
         System.out.print(", ");
         showSplit((n - 1) / 2);
         System.out.print(")");
      }
   }
   
   public static String substring(String str, int index1, int index2) {
      if (index1 < 0 || index2 > str.length() || index1 > index2) {
         throw new IllegalArgumentException();
      }
      if (index1 == index2) {
         return "";
      } else {
         return "" + str.charAt(index1) + substring(str, index1 + 1, index2);
      }
   }
   
   public static int times(int a, int b) {
      if (a < 0) {
         return - times(- a, b);
      } else if (b < 0) {
         return - times(a, - b);
      } else if (a == 0 || b == 0) {
         return 0;
      } else {
         return b + times(a - 1, b);
      }
   }
   
   public static String vowelsToEnd(String str) {
      if (str.length() < 2) {
         return str;
      } else {
         if ("aeiou".contains(str.substring(0, 1))) {
            return vowelsToEnd(str.substring(1)) + str.substring(0, 1);
         } else {
            return str.substring(0, 1) + vowelsToEnd(str.substring(1));
         }
      }
   }
   
   public static int weave(int x, int y) {
      if (x < 0 || y < 0) {
         throw new IllegalArgumentException();
      }
      if (x < 10 && y < 10) {
         return 10 * x + y;
      } else {
         return weave(x / 10, y / 10) * 100 + weave(x % 10, y % 10);
      }
   }
}