import java.util.*;

public class Final3 {
   public static void main(String[] args) {
      /*
      int[] list1 = {1, 3, 5, 8, 12, 1, 3, 17, 1, 3, 6, 9, 1, 3, 6};
      int[] list2 = {1, 3, 6};
      System.out.println(indexOf(list2, list1));
      System.out.println(isMatch("h*l.o", "heello"));
      int[] list = {6, 6, 3, 6, 6};
      System.out.println(isPalindrome(list));
      int[] list = {4, 3, 9, 7, 3, 3, 1, 2, 7, 0, 9, 3, 2, 1, 4};
      moveToBack(list, 3);
      System.out.println(Arrays.toString(list));
      int[] list = {1, -4, -6, 8, 8, 99};
      System.out.println(Arrays.toString(positives(list)));
      */
   }
   
   public static int indexOf(int[] target, int[] source) {
      if (source.length == 0) {
         return 0;
      }
      for (int i = 0; i < (source.length - target.length + 1); i++) {
         int count = 0;
         for (int j = 0; j < target.length; j++) {
            if (source[i + j] == target[j]) {
               count++;
            }
         }
         if (count == target.length) {
            return i;
         }
      }
      return -1;
   }
   
   public static boolean isMatch(String pattern, String target) {
      int pIndex = 0;
      int tIndex = 0;
      for (pIndex = 0; pIndex < pattern.length(); pIndex++) {
         if (tIndex >= target.length()) {
            return false;
         }
         if (pattern.charAt(pIndex) == '*') {
            if (pIndex == pattern.length() - 1) {
               return true;
            } else {
               while (pattern.charAt(pIndex + 1) != target.charAt(tIndex) && tIndex < target.length())
                  tIndex++;
               }
               tIndex--;
         } else if (pattern.charAt(pIndex) != '.') {
            if (pattern.charAt(pIndex) != target.charAt(tIndex)) {
               return false;
            }
         }
         tIndex++;
      }
      return true;
   }
   
   public static boolean isPalindrome(int[] list) {
      for (int i = 0; i < list.length / 2; i++) {
         if (list[i] != list[list.length - i - 1]) {
            return false;
         }
      }
      return true;
   }

   public static void moveToBack(int[] list, int n) {
      int index = 0;
      for (int i = 0; i < list.length; i++) {
         if (list[i] != n){
            list[index] = list[i];
            index++;
         }
      }
      for (int i = index; index < list.length; index++) {
         list[index] = n;
      }
   }
   
   public static int[] positives(int[] list) {
      int length = 0;
      for (int i = 0; i < list.length; i++) {
         if (list[i] > 0) {
            length++;
         }
      }
      int[] result = new int[length];
      int index = 0;
      for (int i = 0; i < list.length; i++) {
         if (list[i] > 0) {
            result[index] = list[i];
            index++;
         }
      }
      return result;
   }
}