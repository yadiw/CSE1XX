import java.util.*;

public class Final3 {
   public static void main(String[] args) {
      /*
      int[] list = {1, 7, 3, 4, 5};
      distributeCount(list, 1);
      System.out.println(Arrays.toString(list));
      int[] list = {18, 7, 4, 24, 11};
      System.out.println(Arrays.toString(doubleSize(list)));
      int[] list = {3, 8, 4, 2, 0, 42, 5, 1};
      System.out.println(Arrays.toString(expand(list)));
      int[] bigList = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
      int[] shortList = {2, 4, 6, 8};
      insert001(shortList, bigList, 2);
      System.out.println(Arrays.toString(bigList));
      int[] list1 = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
      int[] list2 = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(insert002(list1, list2, 2)));
      */
   }
   
   public static void distributeCount(int[] list, int num) {
      int value = list[num];
      list[num] = 0;
      while (value > 0) {
         if (num == list.length - 1) {
            num = -1;
         }
         list[num + 1] += 1;
         value--;
         num++;
      }
   }
   
   public static int[] doubleSize(int[] list) {
      int[] result = new int[list.length * 2];
      for (int i = 0; i < list.length; i++) {
         result[2 * i] = (list[i] + 1) / 2;
         result[2 * i + 1] = list[i] - result[2 * i];
      }
      return result;
   }
   
   public static int[] expand(int[] list) {
      int length = 0;
      for (int i = 0; i < list.length; i += 2) {
         length += list[i];
      }
      int[] result = new int[length];
      int index = 1;
      int count = 0;
      for (int i = 0; i < result.length; i++) {
         if (list[index - 1] != 0) {
            result[i] = list[index];
            count++;
            if (count == list[index - 1]) {
               index += 2;
               count = 0;
            }
         } else {
            index += 2;
            count = 0;
            i--;
         }
      }  
      return result;
   }
   
   public static void insert001(int[] shortL, int[] longL, int index) {
      for (int i = index; i < index + shortL.length; i++) {
         if (i + shortL.length < longL.length) {
            longL[i + shortL.length] = longL[i];
         }
         longL[i] = shortL[i - index];
      }
   
   }
   
   public static int[] insert002(int[] list1, int[] list2, int n) {
      int[] result = new int[list1.length + list2.length];
      for (int i = 0; i < result.length; i++) {
         if (i < n) {
            result[i] = list1[i];
         } else if (i >= n && i < list2.length + n) {
            result[i] = list2[i - n];
         } else { //i >= list2.length + n 
            result[i] = list1[i - list2.length];
         }
      }
      return result;
   }
   


}