import java.util.*;

public class Final6 {
   public static void main(String[] args) {
      /*
      String[] fillings = {"banana", "nutella"};
      System.out.println(Arrays.toString(sandwich("white", fillings, 3)));
      int[] list = {7, 5, 8, 5, 9, 7, 2, 3};
      System.out.println(Arrays.toString(splice(list, 2, 4)));
      int[] list = {7, 5, 3, 2, 8, 4, 6};
      System.out.println(Arrays.toString(splitPairs(list)));
      int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8, 7};
      int[] list2 = {1, 2, 1};
      System.out.println(Arrays.toString(subtract(list1, list2)));
      String[] s = {"one", "two", "three"};
      swapHalves(s);
      System.out.println(Arrays.toString(s));
      */
   }
   
   public static String[] sandwich(String bread, String[] fillings, int fillFactor) {
      String[] result = new String[2 + fillings.length * fillFactor];
      result[0] = bread;
      result[result.length - 1] = bread;
      for (int i = 0; i < fillings.length; i++) {
         for (int j = 0; j < fillFactor; j++) {
            result[1 + i + j * fillings.length] = fillings[i];
         }
      }
      return result;
   }
   
   public static int[] splice(int[] list, int index1, int index2) {
      int[] result = new int[list.length];
      for (int i = 0; i < result.length; i++) {
         if (i < list.length - index2) {
            result[i] = list[index2 + i];
         } else if (i < list.length - index1) {
            result[i] = list[i - (list.length - index1 - index2)];
         } else {
            result[i] = list[i - list.length + index1];
         }
      
      }
      return result;
   }

   public static int[] splitPairs(int[] list) {
      int[] result = new int[list.length];
      for (int i = 0; i < list.length; i += 2) {
         result[i / 2] = list[i];
      }
      for (int i = 1; i < list.length; i +=2) {
         result[(list.length + 1) / 2 + i / 2] = list[i];
      }
      return result;
   }
   
   public static int[] subtract(int[] list1, int[] list2) {
      int[] result = new int[list1.length - list2.length];
      int index = 0;
      for (int i = 0; i <= list1.length - list2.length; i++) {
         int count = 0;
         for (int j = 0; j < list2.length; j++) {
            if (list1[i + j] == list2[j]) {
               count++;
            }
         }
         if (count == list2.length) {
            while (index < result.length) {
               result[index] = list1[index + list2.length];
               index++;
            }
            i = list1.length - list2.length;
         } else {
            result[index] = list1[i];
            index++;
         }
      }
      return result;
   }
   
   public static void swapHalves(String[] list) {
      int half = (list.length + 1) / 2;
      for (int i = 0; i < list.length / 2; i++) {
         String temp = list[i];
         list[i] = list[i + half];
         list[i + half] = temp;
      }
   }

}