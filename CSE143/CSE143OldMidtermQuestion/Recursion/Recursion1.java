public class Recursion1 {
   public static void main(String[] args) {
      // 01
      System.out.println(collapseSequences("-this----has maaany--dashes---", '-'));
      // 02
      System.out.println(commonChars("hello world", "heyya world"));
      // 03
      countToBy(40, 5);
      System.out.println();
      // 04
      System.out.println(dedup("mississippi"));
      // 05
      System.out.println(digitMatch(1234567, 67));
      // 06
      System.out.println(digitProduct(-30551));
      // 07
      System.out.println(evens(-163505));
      // 08
      System.out.println(indexOf("Barack Obama", "ck"));
      // 09
      System.out.println(isPalindrome("radar"));
      // 10
      System.out.println(isReversal("foo","oof"));
      
   }

   public static String collapseSequences(String str, char ch) {
      if (str.length() < 2) {
         return str;
      } else {
         char letter = str.charAt(0);
         if (letter == ch && letter == str.charAt(1)) {
            return collapseSequences(str.substring(1), ch);
         } else {
            return "" + letter + collapseSequences(str.substring(1), ch);
         }
      }
   }
   
   public static String commonChars(String str1, String str2) {
      if (str1.length() <= 1 && str2.length() <= 1) {
         if (str1.equals(str2)){
            return str1;
         } else {
            return ".";
         }
      } else {
         return commonChars("" + str1.charAt(0), "" + str2.charAt(0)) + 
                            commonChars(str1.substring(1), str2.substring(1));
      }
   }
   
   public static void countToBy(int n, int m) {
      if (m < 1 || n < 1) {
         throw new IllegalArgumentException();
      } 
      if (n <= m) {
         System.out.print(n);
      } else {
         countToBy(n - m, m);
         System.out.print(", " + n);
      }
   }
   
   public static String dedup(String str) {
      if (str.equals("")){
         throw new IllegalArgumentException();
      }
      if (str.length() < 2) {
         return str;
      } else {
         if (str.charAt(0) == str.charAt(1)) {
            return dedup(str.substring(1));
         } else {
            return "" + str.charAt(0) + dedup(str.substring(1));
         }
      }
   }
   
   public static int digitMatch(int num1, int num2) {
      if (num1 < 0 || num2 < 0) {
         throw new IllegalArgumentException();
      }
      if (num1 < 10 && num2 < 10) {
         if (num1 == num2) {
            return 1;
         } else {
            return 0;
         }
      } else {
         return digitMatch(num1 / 10, num2 / 10) + digitMatch(num1 % 10, num2 % 10);
      }
   }
   
   public static int digitProduct(int num) {
      if (num == 0) {
         throw new IllegalArgumentException();
      }
      if (num < 0) {
         return -(digitProduct(-num));
      }
      if (num < 10) {
         return(num);
      } else {
         if (num % 10 != 0) {
            return digitProduct(num % 10) * digitProduct(num / 10);
         } else {
            return digitProduct(num / 10);
         }
      }
   }
   
   public static int evens(int num) {
      if (num < 0) {
         return -(evens(-num));
      } else if (num < 10) {
         if (num % 2 == 0) {
            return num;
         } else {
            return 0;
         }
      } else {
         if (num % 10 % 2 == 0) {
            return evens(num / 10) * 10 + evens(num % 10);
         } else {
            return evens(num / 10);
         }
      }
   }
   
   public static int indexOf(String str1, String str2) {
      if (str2.length() > str1.length()){
         return -1;
      } else if (str1.substring(0, str2.length()).equals(str2)) {
         return 0;
      } else {
         int index = indexOf(str1.substring(1), str2);
         if (index != -1) {
            return index + 1;
         } else {
            return -1;
         }
      }
   }
   
   public static boolean isPalindrome(String str) {
      if (str.length() < 2) {
         return true;
      } else {
         if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
         } else {
            return false;
         }
      } 
   }
   
   public static boolean isReversal(String str1, String str2) {
      if (str1.length() != str2.length()) {
         throw new IllegalArgumentException();
      }
      if (str1.length() < 2) {
         return str1.equals(str2);
      } else {
         if (str1.charAt(0) == str2.charAt(str2.length() - 1)) {
            return isReversal(str1.substring(1), str2.substring(0, str2.length() - 1));
         } else {
            return false;
         }
      }
   }
}