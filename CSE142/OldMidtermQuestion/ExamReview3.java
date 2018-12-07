import java.util.*;

public class ExamReview3{
   public static void main(String[] args) {
      //Scanner console = new Scanner(System.in);
      //System.out.println(hasAlternatingParity(1));
      //System.out.println(hashTag(""));
      //System.out.println(highLow(0));
      //System.out.println(increasingDigits(0));
      //System.out.println(indexOf("iyf", "com"));
   
   }
   
   public static boolean hasAlternatingParity(int num) {
      while (num >= 10) {
         int left = num / 10 % 10;
         int right = num % 10;
         if (left % 2 == right % 2) {
            return false;
         }
         num /= 10;         
      }
      return true;   
   }
   
   public static String hashTag(String str) {
      String result = "#";
      if(str.length() != 0 && str.charAt(0) != ' ') {
         result += Character.toUpperCase(str.charAt(0));
      }
      for (int i = 1; i < str.length(); i++) {
         if (str.charAt(i - 1) == ' ' && str.charAt(i) != ' ') {
            result += Character.toUpperCase(str.charAt(i));
         } else if (str.charAt(i) != ' ') {
            result += Character.toLowerCase(str.charAt(i));
         }      
      }
      return result;
   }
   
   public static boolean highLow(int num) {
      while (num >= 10) {
         int left = num / 10 % 10;
         int right = num % 10;
         if (!((left <= 4 && right > 4) || (left > 4 && right <= 4))) {
            return false;
         }
         num /= 10;
      }
      return true;
   }
   
   public static boolean increasingDigits(int num) {
      while (num >= 10) {
         int left = num / 10 % 10;
         int right = num % 10;
         if (left >= right) {
            return false;
         }
         num /= 10;
      }
      return true;   
   }
   
   public static int indexOf(String str1, String str2) {
      if (! str1.contains(str2)){
          return -1;
      } else {
         int num = 0;
         for(int i = 0; i <= str1.length() - str2.length(); i++) {
            boolean flag = false;
            int index = 0;
            while ((!flag) && index < str2.length()) {
               if (str1.charAt(i + index) != str2.charAt(index)) {
                  flag = true;
               } else {
                  index++;
               }
            }
            if (index == str2.length()) {
               num = i;
            }
         }
         return num;
      }
   }
}                                
