import java.util.*;

public class StacksAndQueues4 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l = {3, 1, 2, 6, 5, 7, 9, 8, 12, 4, 3, 4, 12, 11, 14};
      Queue<Integer> q = c.initiateQ(l);
      makeSortedSequence(q);
      System.out.println(q);
      
      // 02
      int[] l1 = {7, 5, 1, 42, 6, -37, 8, 9, 21, 11, 12};
      int[] l2 = {7};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      maxToTop(s1);
      maxToTop(s2);
      System.out.println(s1);
      System.out.println(s2);
      
      // 03
      int[] l = {1, 3, 2, 7};
      Stack<Integer> s = c.initiateS(l);
      mirror(s);
      System.out.println(s);
      
      // 04
      int[] l = {10, 50, 19, 54, 30, 67};
      Queue<Integer> q = c.initiateQ(l);
      mirrorHalves(q);
      System.out.println(q);
      
      // 05
      int[] l = {5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41};
      Stack<Integer> s = c.initiateS(l);
      System.out.println(numUnique(s));
      System.out.println(s);
      */
   }
   
   public static void makeSortedSequence(Queue<Integer> q) {
      Stack<Integer> s = new Stack<Integer>();
      int num1 = q.remove();
      s.push(num1);
      int size = q.size();
      for (int i = 0; i < size; i++) {
         int num2 = q.remove();
         if (num2 >= num1) {
            s.push(num2);
            num1 = num2;
         } else {
            q.add(num2);
         }
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
   }

   public static void maxToTop(Stack<Integer> s) {
      if (!s.isEmpty()) {
         Queue<Integer> q = new LinkedList<Integer>();
         int num = s.pop();
         int max = num;
         q.add(num);
         while (!s.isEmpty()) {
            num = s.pop();
            if (num > max) {
               max = num;
            }
            q.add(num);
         }
         s.push(max);
         while (!q.isEmpty()) {
            int n = q.remove();
            if (n != max) {
               s.push(n);
            }
         }
         while (!s.isEmpty()) {
            q.add(s.pop());
         }  
         while (!q.isEmpty()) {
            s.push(q.remove());
         }
      }
   }
   
   public static void mirror(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      int size = q.size();
      for (int i = 0; i < size; i++) {
         int num = q.remove();
         q.add(num);
         s.push(num);
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
   }
   
   public static void mirrorHalves(Queue<Integer> q) {
      if (q == null || q.size() % 2 == 1) {
         throw new IllegalArgumentException();
      }
      int halfSize = q.size() / 2;
      Stack<Integer> s = new Stack<Integer>();
      for (int i = 0; i < 2; i++) {
         for (int j = 0; j < halfSize; j++) {
            int num = q.remove();
            q.add(num);
            s.push(num);
         }
         while (!s.isEmpty()) {
            q.add(s.pop());
         }
      }
   }
   
   public static int numUnique(Stack<Integer> s) {
      int count = 0;
      Queue<Integer> q = new LinkedList<Integer>();
      if (!s.isEmpty()) {
         int num1 = s.pop();
         q.add(num1);
         count++;
         while (!s.isEmpty()) {
            int num2 = s.pop();
            q.add(num2);
            if (num1 != num2) {
               count++;
            }
            num1 = num2;
         }
         while (!q.isEmpty()) {
            s.push(q.remove());
         }
         while (!s.isEmpty()) {
            q.add(s.pop());
         }
         while (!q.isEmpty()) {
            s.push(q.remove());
         }
      }
      return count;
   }
}