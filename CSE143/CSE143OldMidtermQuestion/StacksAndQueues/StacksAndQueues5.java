import java.util.*;

public class StacksAndQueues5 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l1 = {3, 4, 5};
      int[] l2 = {37, 14, 24};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(parityMachines(s1, s2));
      System.out.println(s1);
      System.out.println(s2);
      
      // 02
      int[] l = {6, 4, 5, 3};
      Queue<Integer> q = c.initiateQ(l);
      System.out.println(pushNumTimes(q));
      
      // 03
      int[] l = {3, 5, 4, 17, 6, 83, 1, 84, 16, 37};
      Queue<Integer> q = c.initiateQ(l);
      rearrange(q);
      System.out.println(q);
      
      // 04
      int[] l = {-10, -5, -5, -5, 3, 3, 3, 18, 19, 23, 23, 23, 23, 405};
      Queue<Integer> q = c.initiateQ(l);
      rearrangeDuplicates(q);
      System.out.println(q);
      
      // 05
      int[] l = {19, 8, 3, 19, 7, 3, 2, 19, 3, 2, 7, 12, -8, 4};
      Stack<Integer> s = c.initiateS(l);
      System.out.println(removeMax(s));
      System.out.println(s);
      */
   }
   
   public static int parityMachines(Stack<Integer> s1, Stack<Integer> s2) {
      if (s1.size() != s2.size()) {
         throw new IllegalArgumentException();
      }
      int count = 0;
      Queue<Integer> q = new LinkedList<Integer>();
      while (!s1.isEmpty()) {
         int num1 = s1.pop();
         q.add(num1);
         int num2 = s2.pop();
         q.add(num2);
         if (num1 % 2 == num2 % 2) {
            count++;
         }
      }
      while (!q.isEmpty()) {
         s1.push(q.remove());
         s2.push(q.remove());
      }
      while (!s1.isEmpty()) {
         q.add(s1.pop());
         q.add(s2.pop());
      }
      while (!q.isEmpty()) {
         s1.push(q.remove());
         s2.push(q.remove());
      }
      return count;
   }
   
   public static Stack<Integer> pushNumTimes(Queue<Integer> q) {
      Stack<Integer> s = new Stack<Integer>();
      int position = 1;
      while (!q.isEmpty()) {
         s.push(q.remove() * position);
         position++;
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      return s;
   }
   
   public static void rearrange(Queue<Integer> q) {
      Stack<Integer> s = new Stack<Integer>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
         int num = q.remove();
         if (num % 2 == 0) {
            s.push(num);
         } else {
            q.add(num);
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
   
   public static void rearrangeDuplicates(Queue<Integer> q) {
      if (!q.isEmpty()) {
         Stack<Integer> s = new Stack<Integer>();
         int num1 = q.remove();
         q.add(num1);
         int size = q.size();
         for (int i = 0; i < size; i++) {
            int num2 = q.remove();
            if (num1 != num2) {
               q.add(num1);
            } else {
               s.push(num1);
            }
            num1 = num2;
         }
         int newSize = q.size();
         while (!s.isEmpty()) {
            q.add(s.pop());
         }       
         for (int i = 0; i < newSize; i++) {
            q.add(q.remove());
         }
         for (int i = 0; i < size - newSize; i++) {
            s.push(q.remove());
         }
         while (!s.isEmpty()) {
            q.add(s.pop());
         }
      }
   }
   public static int removeMax(Stack<Integer> s) {
      if (s.isEmpty()) {
         throw new IllegalArgumentException();
      }
      Queue<Integer> q = new LinkedList<Integer>();
      int max = s.pop();
      q.add(max);
      while (!s.isEmpty()) {
         int num = s.pop();
         q.add(num);
         if (num > max) {
            max = num;
         }
      }
      while (!q.isEmpty()) {
         int num = q.remove();
         if (num < max) {
            s.push(num);
         }
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      return max;
   }
}