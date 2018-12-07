import java.util.*;

public class Final7 {
   public static void main(String[] args) {
      /*
      String[] a = {"to", "be", "or", "not", "to", "be", "hamlet"};
      swapPairs(a);
      System.out.println(Arrays.toString(a));
      int[] a1 = {1, 2, 3, 4, 5, 6};
      int[] a2 = {7, 8, 9};
      System.out.println(Arrays.toString(weave(a1, a2)));
      */
   
   }
   
   public static void swapPairs(String[] list) {
      for (int i = 0; i < list.length - 1; i += 2) {
         String temp = list[i];
         list[i] = list[i + 1];
         list[i + 1] = temp;
      }
   }
   
   public static int[] weave(int[] list1, int[] list2) {
      int[] result = new int[list1.length + list2.length];
      int index = 0;
      for (int i = 0; i < Math.max(list1.length, list2.length); i++) {
         if (i < Math.min(list1.length, list2.length)) {
            result[index] = list1[i];
            index++;
            result[index] = list2[i];
            index++;
         } else {
            if (i < list1.length) {
               result[index] = list1[i];
               index++;
            } else {
               result[index] = list2[i];
               index++;
            }
         }
      }
      return result;  
   }

}