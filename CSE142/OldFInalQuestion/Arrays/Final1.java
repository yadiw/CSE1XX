import java.util.*;

public class Final1 {
   public static void main(String[] args) {
      /*
      String[] a1 = {};
      System.out.println(allPlural(a1));
      String[] a2 = {"shoes", "", "socks"};
      System.out.println(allPlural(a2));
      int[] list1 = {1, 2, 3};
      int[] list2 = {5, 6};
      System.out.println(Arrays.toString(append(list1, list2)));
      System.out.println(areMirrors(10, 1));
      int[] list1 = {12, 5, 71};
      int[] list2 = {17, 5, 21};
      System.out.println(areDeepMirrors(list1, list2));
      double[] a1 = {2.4, 3.8};
      double[] a2 = {0.2, 9.2, 4.3, 2.8, 1.4};
      System.out.println(Arrays.toString(arraySum(a1, a2)));
      */
      int[] a1 = {42, 3, 9, 42, 42, 0, 42, 9, 42, 42, 17, 8, 2222, 4, 9, 0, 1};
      int[] a2 = {42, 2222, 9};
      banish(a1, a2);
      System.out.println(Arrays.toString(a1));
      
   }
   
   public static boolean allPlural(String[] list) {
      for (int i = 0; i < list.length; i++) {
         String word = list[i].toUpperCase();
         if (word.equals("") || word.charAt(word.length() - 1) != 'S') {
            return false;
         }
      }
      return true;
   }
   
   public static int[] append(int[] list1, int[] list2) {
      int length1 = list1.length;
      int length2 = list2.length;
      int[] result = new int[length1 + length2];
      for (int i = 0; i < length1; i++) {
         result[i] = list1[i];
      }
      for (int i = length1; i < length1 + length2; i++) {
         result[i] = list2[i - length1];
      }
      return result;
   }
   
   public static boolean areDeepMirrors(int[] list1, int[] list2) {
      if (list1.length != list2.length) {
         return false;
      }
      for (int i = 0; i < list1.length; i++) {
         if (!areMirrors(list1[i], list2[list2.length - 1 - i])) {
            return false;
         }
      }
      return true;
   }
   
   public static boolean areMirrors(int num1, int num2) {
      int newNum1 = 0;
      int exp = 0;
      int num1Copy = num1;
      while (num1Copy >= 10){
         num1Copy /= 10;
         exp++;
      }
      while (num1 > 0) {
         newNum1 += num1 % 10 * Math.pow(10, exp);
         num1 /= 10;
         exp--;
      }
      return newNum1 == num2;
   }
   
   public static double[] arraySum(double[] a1, double[] a2) {
      double[] result = new double[Math.max(a1.length, a2.length)];
      for (int i = 0; i < result.length; i++) {
         if (i < a1.length) {
            result[i] += a1[i];
         }
         if (i < a2.length) {
            result[i] += a2[i];
         }
      }
      return result;
   }
   
   public static void banish(int[] a1, int[] a2) {
      int index = 0;
      for (int i = 0; i < a1.length; i++) {
         boolean flag = false;
         for (int j = 0; j < a2.length; j++) {
            if (a1[i] == a2[j]) {
               flag = true;
            }
         }
         if (!flag) {
            a1[index] = a1[i];
            index++;
         }
      }
      for (int i = index; i < a1.length; i++) {
         a1[i] = 0;
      }
   }
}