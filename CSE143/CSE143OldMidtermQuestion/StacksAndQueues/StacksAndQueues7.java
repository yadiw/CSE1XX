import java.util.*;

public class StacksAndQueues7 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      Stack<Integer> s = c.initiateS(l);
      shift(s, 6);
      System.out.println(s);
      
      // 02
      // sort - same as reorder
      
      // 03
      int[] l1 = {1, 2, 3, 4};
      int[] l2 = {7, 6, 5};
      Queue<Integer> q = c.initiateQ(l1);
      Stack<Integer> s = c.initiateS(l2);
      swap(q, s);
      System.out.println(q);
      System.out.println(s);
      
      // 04
      int[] l = {3, 8, 17, 9, 99, 9, 17, 8, 3, 1, 2, 3, 4, 14, 42};
      Stack<Integer> s = c.initiateS(l);
      switchPairs(s);
      System.out.println(s);
      */
   }

   public static void shift(Stack<Integer> s, int n) {
      Queue<Integer> q = new LinkedList<Integer>();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      int size = q.size();
      for (int i = 0; i < size - n; i++) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < n; i++) {
         q.add(q.remove());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
   }
   
   public static void swap(Queue<Integer> q, Stack<Integer> s) {
      int size1 = q.size();
      int size2 = s.size();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < size1; i++) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < size2; i++) {
         q.add(q.remove());
      }
      for (int i = 0; i < size1; i++) {
         s.push(q.remove());
      }
   }
   
   public static void switchPairs(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      if (q.size() % 2 == 1) {
         q.add(q.remove());
      }
      int size = q.size();
      for (int i = 0; i < size / 2; i++) {
         s.push(q.remove());
         q.add(q.remove());
         q.add(s.pop());
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
}