import java.util.*;

public class Final2 {
   public static void main(String[] args) {
      /*
      String[] line = {"Iva", "Ben", "Brett", "Ally", "Kim", "Jesse"};
      caughtSkipping(line, "Jesse", "Kim");
      System.out.println(Arrays.toString(line));
      caughtSkipping(line, "Ben", "Ally");
      System.out.println(Arrays.toString(line));
      int[] list = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(collapse(list)));
      int[] list1 = {7, 15, 4, 3, 8, 2};
      int[] list2 = {42, -3, 5, 12, 17, 6, 0};
      System.out.println(Arrays.toString(combineSublists(list1, list2, 1, 5)));
      String[] a4 = {"hi", "Ed", "how", "ARE", "you", "Doing", "I'm", "fine"};
      String[] a5 = {"hi", "Bob", "how", "are", "YOU", "Doing"};
      String[] a6 = {"hi", "you", "how", "is", "you", "Doing", "this", "fine", "day?"};
      System.out.println(countCommon(a4, a5, a6));
      int[] numbers2 = {3, 8, 2, 5, 1, 9};
      System.out.println(Arrays.toString(delta(numbers2)));
      */
   }
   
   public static void caughtSkipping(String[] line, String skipper, String skipped) {
      int index1 = line.length - 1;
      int index2 = 0;
      for (int i = 0; i < line.length; i++) {
         if (line[i].equals(skipper)) {
            index1 = i;
         }
         if (line[i].equals(skipped)) {
            index2 = i;
         }
      }
      if (index1 < index2) {
         line[index1] = "";
         for (int i = index1; i < line.length - 1; i++) {
            line[i] = line[i + 1];
         }
         line[line.length - 1] = skipper;
      }
   }
   
   public static int[] collapse(int[] list) {
      int[] result = new int[(list.length + 1) / 2];
      if (list.length % 2 == 1) {
         result[result.length - 1] = list[list.length - 1];
      } 
      for (int i = 0; i < list.length / 2; i++) {
         result[i] = list[2 * i] + list[2 * i + 1];
      }
      return result;
   }
   
   public static int[] combineSublists(int[] list1, int[] list2, int index1, int index2) {
      int[] result = new int[(index2 - index1) * 2];
      for (int i = index1; i < index2; i++) {
         result[i - index1] = list1[i];
         result[i - index1 * 2 + index2] = list2[i];
      }
      return result;
   }
   
   public static int countCommon(String[] str1, String[] str2, String[] str3) {
      int count = 0;
      int length = Math.min(str3.length, Math.min(str2.length, str1.length));
      for (int i = 0; i < length; i++) {
         if (str1[i].equals(str2[i]) && str1[i].equals(str3[i])) {
            count++;
         }
      }
      return count;
   }
   
   public static int[] delta(int[] list) {
      if (list.length == 0) {
         return new int[0];
      }
      int[] result = new int[2 * list.length - 1];
      for (int i = 0; i < list.length - 1; i++) {
         result[2 * i] = list[i];
         result[2 * i + 1] = list[i + 1] - list[i];
      }
      result[result.length - 1] = list[list.length - 1];
      return result;
   }

}