import java.util.*;

public class Final5 {
   public static void main(String[] args) {
      /*
      int[] list = {1, 2, 2, 2, 5, 7, 9, 9, 9};
      System.out.println(mode(list));
      int[] a1 = {234, 528, 235, 253, 400};
      int[] a5 = {500, 300, 241, 99, 501};
      System.out.println(priceIsRight(a1, 300));
      System.out.println(priceIsRight(a5, 50));
      int[] list = {0, 1, 2, 3, 4, 5, 6, 7};
      System.out.println(Arrays.toString(reverseSublist(list, 2, 5)));
      int[] list = {2, 4, 6, 8, 10};
      System.out.println(sameGap(list));
      */
      
   }

   public static int mode(int[] list) {
      int count = 1;
      int maxCount = 1;
      int max = list[0];
      for (int i = 1; i < list.length; i++) {
         if (list[i] == list[i - 1]) {
            count++;
         } else {
            if (count > maxCount) {
               maxCount = count;
               max = list[i - 1];
            }
            count = 1;
         }
      }
      return max;
   }
   
   public static int priceIsRight(int[] bids, int price) {
      int result = -1;
      for (int i = 0; i < bids.length; i++) {
         if (bids[i] <= price && bids[i] > result) {
            result = bids[i];
         }
      }
      return result;
   }
   
   // reMoveZeros
   
   public static int[] reverseSublist(int[] list, int index1, int index2) {
      int[] result = new int[index2 - index1];
      for (int i = 0; i < result.length; i++) {
         result[i] = list[index2 - 1 - i];
      }
      return result;
   }
   
   public static boolean sameGap(int[] list) {
      if (list.length <= 2) {
         return true;
      }
      int left = Math.abs(list[1] - list[0]);
      for (int i = 2; i < list.length; i++) {
         int right = Math.abs(list[i] - list[i - 1]);
         if (left != right) {
            return false;
         }
      }
      return true;
   }
}