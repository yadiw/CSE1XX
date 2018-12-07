import java.util.*;
import java.io.*;

public class Final5 {
   public static void main(String[] args) throws FileNotFoundException {
      /*
      Scanner file = new Scanner(new File("Final5.txt"));
      stockMarket(file);
      int[] data = {0, 1, 0, 6, 9, 2, 3, 7, 3, 7, 7, 5, 10, 1};
      int[] sum = new int[4];
      int[] count = new int[4];
      sumCount(data, sum, count);
      System.out.println(Arrays.toString(sum));
      System.out.println(Arrays.toString(count));
      int[] list = { 4 };
      System.out.println(summarize(list));
      int[] a1 = {1, 2, 3, 4, 5, 6};
      int[] a2 = {7, 8, 9, 10};
      System.out.println(Arrays.toString(weave(a1, a2)));
      */
   }
   
   public static void stockMarket(Scanner file) {
      double maxPrice = 0;
      int maxStock = 1;
      int maxDay = 2;
      int stock = 0;
      while (file.hasNextLine()) {
         stock++;
         String singleLine = file.nextLine();
         Scanner line = new Scanner(singleLine);
         double pre = line.nextDouble();
         double post = line.nextDouble();
         maxPrice = Math.max(post - pre, maxPrice);
         int day = 2;
         while (line.hasNextDouble()) {
            day++;
            pre = post;
            post = line.nextDouble();
            if ((post - pre) > maxPrice) {
               maxPrice = post - pre;
               maxDay = day;
               maxStock = stock;
            }
         }
      }
      System.out.println("Stock " + maxStock + " had the greatest price increase of $" 
                         + maxPrice + " on day " + maxDay);
   }
   
   public static void sumCount(int[] data, int[] sum, int[] count) {
      for (int i = 0; i < data.length; i++) {
         int index = (i % 7 + 1) / 2;
         sum[index] += data[i];
         if (data[i] != 0) {
            count[index]++;
         }
      }
   }

   public static int summarize(int[] list) {
      int count = 1;
      int returnN = 1;
      if (list.length == 1) {
         System.out.println("1 " + list[0] + "'s  ");
         return 1;
      }

      for (int i = 1; i < list.length; i++) {
         int left = list[i - 1];
         int right = list[i];
         if (left == right) {
            count++;
         } else {
            returnN++;
            System.out.print(count + " " + list[i - 1] + "'s  ");
            count = 1;
         }
      }
      System.out.println();
      return returnN;
   }
   
   public static int[] weave(int[] list1, int[] list2) {
      int[] result = new int[list1.length + list2.length];
      int index = 0;
      for (int i = 0; i < result.length; index++) {
         if (index < list1.length) {
            result[i] = list1[index];
            i++;
         }
         if (index < list2.length) {
            result[i] = list2[index];
            i++;
         }
      }
      return result;
   }

}