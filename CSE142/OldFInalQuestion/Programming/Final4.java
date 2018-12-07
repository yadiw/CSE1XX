import java.util.*;

public class Final4 {
   public static void main(String[] args) {
      /*
      printReversed(" merry-go-round      is     one   word ");
      int[] list = {23, 12, 8, 0, 4, 80, 9, 7, 30, 99, 50, 42, 13, 47, 2, 16, 87, 75};
      rearrange(list);
      System.out.println(Arrays.toString(list));
      int[] list = {1, 1, 1, 3, 6, 7, 7, 10, 10, 10, 10, 18, 21, 24, 24};
      System.out.println(Arrays.toString(removeDuplicates(list)));
      int[] list = {7, 2, 3, 0, 4, 6, 0, 0, 13, 0, 78, 0, 0, 19, 14};
      removeZeros(list);
      System.out.println(Arrays.toString(list));
      System.out.println(samePattern("ascneencsa", "aeiouuoiea"));
      */
      
   }

   public static void printReversed(String str) {
      String result = "";
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) == ' ') {
            result += " ";
         } else {
            String word = "";
            while (str.charAt(i) != ' ') {
               word = str.charAt(i) + word;
               i++;
            }
            result += word;
            i--;
         } 
      }
      System.out.println(result);
   }
   
   public static void rearrange(int[] list) {
      for (int j = 0; j < list.length - 1; j++) {
         for (int i = 0; i < list.length - 1; i++) {
            int leftR = list[i] % 3;
            int rightR = list[i + 1] % 3;
            if (leftR > rightR) {
               int temp = list[i];
               list[i] = list[i + 1];
               list[i + 1] = temp;
            }
         }
      }
   }
   
   public static int[] removeDuplicates(int[] list) {
      int count = 1;
      for (int i = 1; i < list.length; i++) {
         if (list[i - 1] != list[i]) {
            count++;
         }
      }
      int[] result = new int[count];
      result[0] = list[0];
      int index = 1;
      for (int i = 1; i < list.length; i++) {
         if (list[i - 1] != list[i]) {
            result[index] = list[i];
            index++;
         }
      }
      return result;
   }
   
   public static void removeZeros(int[] list) {
      int index = 0;
      for (int i = 0; i < list.length; i++) {
         if (list[i] != 0){
            list[index] = list[i];
            index++;
         }
      }
      for (int i = index; index < list.length; index++) {
         list[index] = 0;
      }
   }
   
   public static boolean samePattern(String str1, String str2) {
      if (str1.length() != str2.length()) {
         return false;
      }
      for (int i = 0; i < str1.length(); i++) {
         for (int j = i + 1; j < str2.length(); j++) {
            boolean check1 = str1.charAt(i) == str1.charAt(j);
            boolean check2 = str2.charAt(i) == str2.charAt(j);
            if (check1 != check2) {
               return false;
            }
         }
      }
      return true;
   }

}