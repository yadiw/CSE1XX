import java.util.*;

public class ExamReview1 {
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      //System.out.println(baseball(console));
      //System.out.println(collapseDigits(122100));
      //System.out.println(countParitySwitches(75930));
      //System.out.println(countWords(""));
      //System.out.println(diffChar("abcd", "ABCD"));

   }
   
   public static int baseball(Scanner console) {
      int inning = 0;
      int score1 = 0;
      int score2 = 0;
      while (inning < 9 && Math.abs(score1 - score2) < 10) {
         inning++;
         System.out.print("Inning #" + inning + ": ");
         score1 += console.nextInt();
         score2 += console.nextInt();
      }
      while (score1 == score2) {
         inning++;
         System.out.print("Inning #" + inning + ": ");
         score1 += console.nextInt();
         score2 += console.nextInt();
      }
      System.out.println("Final score: " + score1 + " - " + score2);
      if (score1 > score2) {
         return 1;
      } else {
         return 2;
      } 
   }
   
   public static int collapseDigits(int num) {
      int newNum = 0;
      int exp = 0;
      while (num > 0) {
         newNum += num % 10 * (int)Math.pow(10, exp);
         exp ++;
         if (num % 10 == num / 10 % 10) {
            num /= 100;
         } else {
            num /= 10;
         }
      }
      return newNum;
   }
   
   public static int countParitySwitches(int num) {
      int parity = 0;
      while (num >= 10) {
         if (num % 10 % 2 != num / 10 % 10 % 2){
            parity++;
         }
         num /= 10;
      }
      return parity;
   }
   
   public static int countWords(String str) {
      int count = 0;
      if (str.length() != 0 && str.charAt(0) != ' ') {
         count++;
      }
      for(int i = 0; i < str.length() - 1; i++){
         if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' '){
            count++;
         }
      }
      return count;
   }
   
   public static int diffChar(String word1, String word2) {
      int num = 0;
      word1 = word1.toLowerCase();
      word2 = word2.toLowerCase();
      String longW;
      String shortW;
      if (word1.length() >= word2.length()){
         longW = word1;
         shortW = word2;
      } else {
         longW = word2;
         shortW = word1;
      }
      for (int i = 0; i < shortW.length(); i++) {
         if (longW.charAt(i) != shortW.charAt(i) && longW.charAt(i) != '_' && shortW.charAt(i) != '_') {
            num++;
         }
      }
      for (int i = shortW.length(); i < longW.length(); i++) {
         if (longW.charAt(i) != '_') {
            num++;
         }
      }
      return num;
   }
   
   

}