import java.util.*;

public class Final2 {
   public static void main(String[] args) {
      /*
      int[] values = {33, 16, 19, 0, 22};
      int[] ranges = {0, 4, 0, 1, 4, 5};
      System.out.println(Arrays.toString(copyRanges(values, ranges)));
      System.out.println(count("ee", "eeeee"));
      String token = "6 triple 10 5 20 double 7";
      Scanner line = new Scanner(token);
      System.out.println(darts(line));
      System.out.println(encode("four score and seven", 4));
      int[] list = {2, 4, 2, 4, 6};
      System.out.println(hasTwoPair(list));
      */
      
   
   }
   
   public static int[] copyRanges(int[] values, int[] ranges) {
      int length = 0;
      for (int i = 0; i < ranges.length - 1; i += 2) {
         length += (ranges[i + 1] - ranges[i]);
      }
      int[] result = new int[length];
      int index = 0;
      for (int i = 0; i < ranges.length - 1; i += 2) {
         for (int j = ranges[i]; j < ranges[i + 1]; j++) {
            result[index] = values[j];
            index++;
         }
      }
      return result;
   }
   
   public static int count(String target, String source) {
      source = source.toLowerCase();
      target = target.toLowerCase();
      int count1 = 0;
      for (int i = 0; i < (source.length() - target.length() + 1); i++) {
         int count2 = 0;
         for (int j = 0; j < target.length(); j++) {
            if (target.charAt(j) == source.charAt(i + j)) {
               count2++;
            }
         }
         if (count2 == target.length()){
            count1++;
         }
      }
      return count1;
   }
   
   public static int darts(Scanner input) {
      int result = 0;
      while (input.hasNext()) {
         if (input.hasNextInt()) {
            result += input.nextInt();
         } else {
            String str = input.next();
            if (str.equals("triple")) {
               result += 3 * input.nextInt();
            } else {
               result += 2 * input.nextInt();
            }
         }
      }
      return result;
   }
   
   public static String encode(String s, int n) {
      String result = "";
      for (int i = 0; i < n; i++) {
         for (int j = i; j < s.length(); j += n) {
            result += s.charAt(j);
         }
      }
      return result;
   }
   
   public static boolean hasTwoPair(int[] list) {
      int[] countList = new int[6];
      for (int i = 0; i < list.length; i++) {
         countList[list[i] - 1]++; 
      }
      int count = 0;
      for (int i = 0; i < 6; i++) {
         if (countList[i] == 2) {
            count++;
         }
      }
      return count == 2;
   }
}