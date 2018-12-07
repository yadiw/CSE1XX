import java.util.*;

public class ExamReview2{
   public static void main(String[] args) {
      //Scanner console = new Scanner(System.in);
      //System.out.println(digitSum(20897));
      //System.out.println(digitsInARow(233333888));
      //favoriteLetter(console, "l");
      //findAllPerfectUpto(100000);
      //System.out.println(findMatching("snatch", ""));
   }

   public static int digitSum(int num) {
      int sum = 0;
      while (num > 0) {
         sum += num % 10;
         num /= 10;
      }
      return sum;
   }
   
   public static int digitsInARow(int num) {
      int count1 = 1;
      int count = 0;
      while (num > 0) {
         int left = num / 10 % 10;
         int right = num % 10;
         if (left == right) {
            count1++;
         } else {
            count = Math.max(count, count1);
            count1 = 1;
         }
         num /= 10;
      }
      return count;
   }
   
   public static void favoriteLetter(Scanner console, String str) {
      System.out.println("Looking for two \"" + str + "\" words in a row. ");
      String str1 = "ass";
      String str2 = "gfdg";
      while (!(str1.startsWith(str) && str2.startsWith(str))) {
         System.out.print("Type a word: ");
         str2 = str1;
         str1 = console.next();      
      }
      System.out.println("\"" + str + "\" is for \"" + str + "\"");   
   } 
   
   public static void findAllPerfectUpto(int num) {
      System.out.print("Perfect numbers up to " + num + ":");
      for (int i = 1; i <= num; i++) {
         int sum = 0;
         for (int j = 1; j < i; j++) {
            if (i % j == 0) {
               sum += j;
            }
         
         }
         if (sum == i) {
            System.out.print(" "+ i);
         }      
      }     
   }
   
   public static String findMatching(String str1, String str2) {
      String longS;
      String shortS;
      String result = "";
      if (str1.length() > str2.length()) {
         longS = str1;
         shortS = str2;
      } else {
         longS = str2;
         shortS = str1;
      }
      for (int i = 0; i < shortS.length(); i++) {
         if (shortS.charAt(i) == longS.charAt(i)) {
            result += shortS.charAt(i);
         } else {
            result += ".";
         }
      }
      for (int i = 1; i <= longS.length() - shortS.length(); i++) {
         result += ".";
      }   
      return result;
   }
}