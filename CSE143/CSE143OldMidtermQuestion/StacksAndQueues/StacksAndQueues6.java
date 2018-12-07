import java.util.*;

public class StacksAndQueues6 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l = {2, 8, 3, 19, 7, 3, 2, 42, 9, 3, 2, 7, 12, 4};
      Stack<Integer> s = c.initiateS(l);
      System.out.println(removeMin(s));
      System.out.println(s);
      
      // 02
      int[] l = {0, 1, 2, -2, 4, -5, 8, -8, 12, -15, 23};
      Queue<Integer> q = c.initiateQ(l);
      reorder(q);
      System.out.println(q);
      
      // 03
      int[] l = {8, 9, 15, 27, -3, 14, 42, 8, 73, 19};
      Queue<Integer> q = c.initiateQ(l);
      reverseByN(q, 4);
      System.out.println(q);
      
      // 04
      int[] l = {10, 20, 30, 40, 50, 60, 70, 80, 90};
      Queue<Integer> q = c.initiateQ(l);
      reverseFirstK(4, q);
      System.out.println(q);
      
      // 05
      int[] l = {1, 2, 3, 4, 5, 6, 7, 8};
      Stack<Integer> s = c.initiateS(l);
      rotateBy(s, 3);
      System.out.println(s);
      */
   }

   public static int removeMin(Stack<Integer> s) {
      if (s.isEmpty()) {
         throw new IllegalArgumentException();
      }
      Queue<Integer> q = new LinkedList<Integer>();
      int min = s.pop();
      q.add(min);
      while (!s.isEmpty()) {
         int num = s.pop();
         q.add(num);
         if (num < min) {
            min = num;
         }
      }
      while (!q.isEmpty()) {
         int num = q.remove();
         if (num > min) {
            s.push(num);
         }
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      return min;
   }
   
   public static void reorder(Queue<Integer> q) {
      Stack<Integer> s = new Stack<Integer>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
         int num = q.remove();
         if (num < 0) {
            s.push(num);
         } else {
            q.add(num);
         }
      }
      int newSize = q.size();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < newSize; i++) {
         q.add(q.remove());
      }
   }
   
   public static void reverseByN(Queue<Integer> q, int n) {
      Stack<Integer> s = new Stack<Integer>();
      for (int i = 0; i < q.size() / n; i++) {
         for (int j = 0; j < n; j++) {
            s.push(q.remove());
         }
         while (!s.isEmpty()) {
            q.add(s.pop());
         }
      }
      int remain = q.size() % 4;
      for (int i = 0; i < remain; i ++) {
         s.push(q.remove());
      }
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
   }
   
   public static void reverseFirstK(int k, Queue<Integer> q) {
      if (q == null || q.size() < k) {
         throw new IllegalArgumentException();
      }
      Stack<Integer> s = new Stack<Integer>();
      for (int i = 0; i < k; i++) {
         s.push(q.remove());
      }
      int size = q.size();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < size; i++) {
         q.add(q.remove());
      }
   }
   
   public static void rotateBy(Stack<Integer> s, int n) {
      Queue<Integer> q = new LinkedList<Integer>();
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      for (int i = 0; i < q.size() - n; i++) {
         q.add(q.remove());
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