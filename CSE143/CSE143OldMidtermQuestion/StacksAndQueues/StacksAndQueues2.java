import java.util.*;

public class StacksAndQueues2 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l1 = {4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 0};
      Stack<Integer> s = c.initiateS(l1);
      expunge(s);
      System.out.println(s);
      
      // 02
      int[] ls = {7, 11, 9};
      int[] lq = {2, 777, 1};
      Stack<Integer> s = c.initiateS(ls);
      Queue<Integer> q = c.initiateQ(lq);
      Stack<Integer> ns = new Stack<Integer>();
      System.out.println(s);
      System.out.println(q);
      System.out.println(getMax(s, q));
      System.out.println(s);
      System.out.println(q);
      System.out.println(getMax(ns, q));
      
      // 03
      int[] l1 = {2, 5, 6, 3, 14, 13, 22};
      int[] l2 = {15, 7, 12, 5, 4};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(hasAlternatingParity(s1));
      System.out.println(s1);
      System.out.println(hasAlternatingParity(s2));
      System.out.println(s2);
      
      // 04
      int[] l = {2, 8, -5, 19, 7, 3, 24, 42};
      Queue<Integer> q = c.initiateQ(l);
      interleave(q);
      System.out.println(q);
      
      // 05  
      System.out.println(isBalanced("(this) is [balanced (properly)], isn¡¯t it?"));
      System.out.println(isBalanced("(this is [not) okay]"));
      System.out.println(isBalanced("(this (isn¡¯t okay)"));
      System.out.println(isBalanced("this is okay ([(())][[()]])"));   
      */
   } 
   
   public static void expunge(Stack<Integer> s) {
      if (s.size() > 1) {
         Stack<Integer> temp = new Stack<Integer>();
         int num1 = s.pop();
         temp.push(num1);
         while (!s.isEmpty()) {
            int num2 = s.pop();
            if (num2 >= num1) {
               temp.push(num2);
               num1 = num2;
            }
         }
         while (!temp.isEmpty()) {
            s.push(temp.pop());
         }
      }
   }
   
   public static int getMax(Stack<Integer> s, Queue<Integer> q) {
      Stack<Integer> temp = new Stack<Integer>();
      boolean nullS = true;
      boolean nullQ = true;
      int maxS = 0;
      int maxQ = 0;
      if (!s.isEmpty()) {
         nullS = false;
         maxS = s.pop();
         temp.push(maxS);
         while (!s.isEmpty()) {
            int num = s.pop();
            maxS = Math.max(maxS, num);
            temp.push(num);
         }
         while (!temp.isEmpty()) {
            s.push(temp.pop());
         }
      } 
      if (!q.isEmpty()) {
         nullQ = false;
         maxQ = q.remove();
         temp.push(maxQ);
         int size = q.size();
         for (int i = 0; i < size; i++) {
            int num = q.remove();
            maxQ = Math.max(maxQ, num);
            q.add(num);
         }
      } 
      if (!nullS && !nullQ) {
         return Math.max(maxS, maxQ);
      } else if (nullS && !nullQ){
         return maxQ;
      } else {
         return maxS;
      } 
   }
   
   
   public static boolean hasAlternatingParity(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      if (s.size() <= 1) {
         return true;
      }
      boolean result = true;
      int num1 = s.pop();
      q.add(num1);
      while (!s.isEmpty()) {
         int num2 = s.pop();
         q.add(num2);
         if (num1 % 2 == num2 % 2) {
            result = false;
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
      return result;
   }
   
   public static void interleave(Queue<Integer> q) {
      if (q.size() % 2 != 0) {
         throw new IllegalArgumentException();
      }
      Stack<Integer> s = new Stack<Integer>();
      int half = q.size() / 2;
      for (int i = 0; i < half; i++) {
         s.push(q.remove());
      }
      for (int i = 0; i < half; i++) {
         q.add(s.pop());
      }
      for (int i = 0; i < half; i++) {
         q.add(q.remove());
      }
      for (int i = 0; i < half; i++) {
         s.push(q.remove());
      }
      for (int i = 0; i < half; i++) {
         q.add(s.pop());
         q.add(q.remove());
      } 
   }
   
   public static boolean isBalanced(String s) {
      Stack<Character> stack = new Stack<Character>();
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if (c == '(' || c == '[') {
            stack.push(c);
         } else if (c == ')' || c == ']') {
            if (stack.isEmpty()) {
               return false;
            } else {
               char c2 = stack.pop();
               if ((c == ')' && c2 != '(') || (c == ']' && c2 != '[')) {
                  return false;
               }
            }
         }  
      }
      return stack.isEmpty();
   }
}