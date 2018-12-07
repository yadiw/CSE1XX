import java.util.*;

public class StacksAndQueues3 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l1 = {3, 4, 5, 6, 7, 8, 9, 10};
      int[] l2 = {3, 4, 5, 6, 7, 8, 9, 10, 12};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(isConsecutive(s1));
      System.out.println(isConsecutive(s2));
      System.out.println(s1);
      System.out.println(s2);
      
      // 02
      int[] l1 = {3, 4, -1, -2, 10, 9, 7, 8, 10};
      int[] l2 = {3, 5, -1, -2, 10, 9, 7, 8};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(isPairwiseConsecutive(s1));
      System.out.println(isPairwiseConsecutive(s2));
      System.out.println(s1);
      System.out.println(s2);
      
      // 03
      int[] l1 = {3, 8, 17, 9, 17, 8, 3};
      int[] l2 = {3, 8, 17, 9, 4, 17, 8, 3};
      Queue<Integer> q1 = c.initiateQ(l1);
      Queue<Integer> q2 = c.initiateQ(l2);
      System.out.println(isPalindrome(q1));
      System.out.println(isPalindrome(q2));
      System.out.println(q1);
      System.out.println(q2);
      
      // 04 
      int[] l1 = {-5, 0, 3, 18, 23, 42, 208};
      int[] l2 = {-5, 0, 3, 18, 23, 42, 208, 17, 20, 94};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(isSorted(s1));
      System.out.println(isSorted(s2));
      System.out.println(s1);
      System.out.println(s2);
      
      // 05
      int[] l1 = {10, 7, 5, 3, 2, 20, 8, 8};
      int[] l2 = {18, 12, 6, 15, 1};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(isSortedTriples(s1));
      System.out.println(isSortedTriples(s2));
      System.out.println(s1);
      System.out.println(s2);
      */
   }
   
   public static boolean isConsecutive(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      if (s.size() < 2) {
         return true;
      }
      boolean answer = true;
      int num1 = s.pop();
      q.add(num1);
      while (!s.isEmpty()) {
         int num2 = s.pop();
         if (num2 - num1 != -1) {
            answer = false;
         }
         q.add(num2);
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
      return answer;
   }
   
   public static boolean isPairwiseConsecutive(Stack<Integer> s) {
      if (s.size() < 2) {
         return true;
      }
      Queue<Integer> q = new LinkedList<Integer>();
      boolean answer = true;
      if (s.size() % 2 == 1) {
         q.add(s.pop());
      }
      while (!s.isEmpty()) {
         int num1 = s.pop();
         q.add(num1);
         int num2 = s.pop();
         q.add(num2);
         if (Math.abs(num1 - num2) != 1) {
            answer = false;
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
      return answer;
   }

   public static boolean isPalindrome(Queue<Integer> q) {
      if (q.size() < 2) {
         return true;
      }
      Stack<Integer> s = new Stack<Integer>();
      boolean answer = true;
      int size = q.size();
      for (int i = 0; i < size; i++) {
         int num = q.remove();
         s.push(num);
         q.add(num);
      }
      for (int i = 0; i < size; i++) {
         int num1 = q.remove();
         int num2 = s.pop();
         if (num1 != num2) {
            answer = false;
         }
         q.add(num1);
      }
      return answer;
   }
   
   public static boolean isSorted(Stack<Integer> s) {
      if (s.size() < 2) {
         return true;
      }
      boolean answer = true;
      Queue<Integer> q = new LinkedList<Integer>();
      int num1 = s.pop();
      q.add(num1);
      while (!s.isEmpty()) {
         int num2 = s.pop();
         q.add(num2);
         if (num2 > num1) {
            answer = false;
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
      return answer;
   }

   public static boolean isSortedTriples(Stack<Integer> s) {
      if (s.size() < 3) {
         return true;
      }
      boolean answer = true;
      Queue<Integer> q = new LinkedList<Integer>();
      int size = s.size();
      for (int i = 0; i < size / 3; i++) {
         int num1 = s.pop();
         q.add(num1);
         int num2 = s.pop();
         q.add(num2);
         int num3 = s.pop();
         q.add(num3);
         if (!(num1 <= num2 && num2 <= num3)) {
            answer = false;
         }
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
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      return answer;
   }
}