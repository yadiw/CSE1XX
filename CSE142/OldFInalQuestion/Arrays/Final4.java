import java.util.*;

public class Final4 {
   public static void main(String[] args) {
      /*
      int[] list1 = {18, 10, 19, 20, 42};
      int[] list2 = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(insertMirror(list1, list2, 2)));
      int[] list1 = {1, 8, 3, 9};
      int[] list2 = {82, 7, 4, 2, 1, 6, 5, 0, 18};
      System.out.println(Arrays.toString(interleave(list1, list2)));
      int[] list1 = {10, 15, 24, 32, 19};
      int[] list2 = {19, 32, 24, 15, 10};
      System.out.println(isReverse(list1, list2));
      int[] list1 = {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97, 10, 4};
      int[] list2 = {4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74};
      System.out.println(isUnique(list1));
      System.out.println(isUnique(list2));
      String[] a1 = {"Splinter", "Leo", "April", "Don", "Raph"};
      String[] a2 = {"Krang", "Shredder", "Bebop"};
      System.out.println(Arrays.toString(longer(a1, a2)));
      */
   }
   
   public static int[] insertMirror(int[] list1, int[] list2, int index) {
      int[] result = new int[list1.length + 2 * list2.length];
      for (int i = 0; i < index; i++) {
         result[i] = list1[i];
      }
      for (int i = 0; i < list2.length; i++) {
         result[index + list2.length + i] = list2[i];
         result[index + list2.length - 1 - i] = list2[i];
      }
      for (int i = index; i < list1.length; i++) {
         result[i + 2 * list2.length] = list1[i];
      }
      return result;
   }
   
   public static int[] interleave(int[] list1, int[] list2) {
      int[] result = new int[list1.length + list2.length];
      for (int i = 0; i < list1.length && i < list2.length; i++) {
         result[2 * i] = list1[i];
         result[2 * i + 1] = list2[i];
      }
      for (int i = Math.min(list1.length, list2.length); i < result.length; i++) {
         if (i < list1.length) {
            result[i] = list1[i - list2.length];
         } else {
            result[i] = list2[i - list1.length];
         }
      }
      return result;
   }
   
   public static boolean isReverse(int[] list1, int[] list2) {
      if (list1.length != list2.length) {
         return false;
      }
      for (int i = 0; i < list1.length; i++) {
         if (list1[i] != list2[list2.length - 1 - i]) {
            return false;
         }
      }
      return true;
   }
   
   public static boolean isUnique(int[] list) {
      for (int i = 0; i < list.length; i++) {
         for (int j = i + 1; j < list.length; j++) {
            if (list[i] == list[j]) {
            return false;
            }
         }
      }
      return true;
   }
   
   public static String[] longer(String[] list1, String[] list2) {
      String[] result = new String[Math.max(list1.length, list2.length)];
      for (int i = 0; i < result.length; i++) {
         if (i < list1.length && i < list2.length) {
            if (list1[i].length() >= list2[i].length()) {
               result[i] = list1[i];
            } else {
               result[i] = list2[i];
            }
         } else {
            result[i] = "oops";
         }
      }
      return result;
   }
}