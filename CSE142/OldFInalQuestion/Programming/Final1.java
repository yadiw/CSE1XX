import java.util.*;
import java.io.*;

public class Final1{
   public static void main(String[] args) throws FileNotFoundException {
      /*
      System.out.println(acronym("--quite-- confusing - punctuation-"));
      System.out.println(blackjack());
      int[] list = {1, 2, 3, 4, 5};
      System.out.println(Arrays.toString(collapse(list)));
      ArrayList<String> al = new ArrayList<String>();
      al.add("a");
      al.add("b");
      al.add("b");
      al.add("b");
      al.add("c");
      al.add("c");
      al.add("b");
      compress(al);
      System.out.println(al);
      Scanner file = new Scanner(new File("Final1.txt"));
      computeWishListCosts(file);
      */
      
   }
   
   public static String acronym(String str) {
      String result = "";
      if (str.charAt(0) != ' ' && str.charAt(0) != '-') {
         result += str.substring(0, 1).toUpperCase();
      }
      for (int i = 1; i < str.length(); i++) {
         if (str.charAt(i) != ' ' && str.charAt(i) != '-' &&
             (str.charAt(i - 1) == ' ' || str.charAt(i - 1) == '-')) {
            result += str.substring(i, i + 1).toUpperCase();    
         }
      }
      return result;
   }
   
   public static boolean blackjack() {
      Random rand = new Random();
      int sum = 0;
      while (sum < 17) {
         int num = rand.nextInt(10) + 1;
         System.out.print(num + " ");
         sum += num;
      }
      System.out.print("= " + sum + " ");
      if (sum > 21) {
         System.out.println("Busted!");
      } else if (sum == 21) {
         System.out.println("BLACKJACK!");
      } else {
         System.out.println();
      }
      return sum <= 21;
   }
   
   public static int[] collapse(int[] list) {
      int[] result = new int[(list.length + 1) / 2];
      int length;
      if (list.length % 2 == 0) {
         length = list.length;
      } else {
         result[result.length - 1] = list[list.length - 1];
         length = list.length - 1;
      }
      for (int i = 0; i < length; i += 2) {
         result[i / 2] = list[i] + list[i + 1];
      }
      return result;
   }
   
   public static void compress(ArrayList<String> list) {
      int count = 1;
      String left = list.get(0);
      int index = 1;
      while (index < list.size()) {
         String right = list.get(index);
         if (right.equals(left)) {
            list.remove(index - 1);
            count++;
         } else {
            if (count > 1) {
               list.set(index - 1, count + "*" + left);
            }
            count = 1;
            index++;
         }
         left = right;    
      }
      if (count > 1) {
         list.set(index - 1, count + "*" + left);
      }   
   }
   
   public static void computeWishListCosts(Scanner file) {
      while (file.hasNextLine()) {
         String line = file.nextLine();
         Scanner lineProcess = new Scanner(line);
         System.out.print(lineProcess.next() + ": $");
         double sum = 0;
         while (lineProcess.hasNext()) {
            int num = lineProcess.nextInt();
            String name = lineProcess.next();
            double price = lineProcess.nextDouble();
            sum += num * price;
         }
         System.out.println("" + sum);
      }
   }
}