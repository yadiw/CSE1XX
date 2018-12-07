import java.util.*;

public class ExamReview4{
   public static void main(String[] args) {
      Random rand = new Random();
      //System.out.println(isConsecutive(123));
      //System.out.println(numWords(" !&$%--$$!!*()   foo_bar_baz   "));
      //printSquare(5,5);
      //printStripped("this > has <comment>greater-than outside a comment >>");
      //randomRects(rand);
      
   }

   public static boolean isConsecutive(int num) {
      while (num >= 10) {
         int left = num / 10 % 10;
         int right = num % 10;
            if (right - left != 1) {
               return false;
            }
         num /= 10;
      }
      return true;
   }
   
   public static int numWords(String str) {
      int num = 0;
      if (str.length() != 0 && str.charAt(0) != ' '){
         num++;
      }
      for(int i = 0; i < str.length() - 1; i++) {
         if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
            num++;
         }     
      }
      return num;
   }
   
   public static void printSquare(int num1, int num2) {
      int row = num2 - num1 + 1;
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < row; j++){
            int num = num1 + i + j;
            if (num <= num2) {
               System.out.print(num);
            } else {
               System.out.print(num - row);
            }        
         }
         System.out.println();
      }
   }
   
   public static void printStripped(String str) {
      int index = 0;
      while (index < str.length()){
         if (str.charAt(index) != '<') {
            System.out.print(str.charAt(index));
            index++;
         } else {
            String subStr = str.substring(index);
            index = subStr.indexOf(">") + 1 + index;
         }  
      } 
   }
   
   public static void randomRects(Random rand) {
      int count = 0;
      int a1 = 100;
      int a2 = 100;
      while (count < 4) {
         int w = rand.nextInt(10) + 1;
         int h = rand.nextInt(10) + 1;
         a2 = a1;
         a1 = w * h;
         System.out.println("w: " + w + ", h: " + h + ", area: " + a1);
         if (a1 > a2) {
            count++;
         }
      }
      System.out.println("Four rectangles of increasing area.");   
   }

}