import java.util.*;

public class StacksAndQueues1 {
   public static void main(String[] args) {
      Converter c = new Converter();
      /*
      // 01
      int[] l1 = {4, 3, -3, 3, 2, -1, 1};
      Stack<Integer> s1 = c.initiateS(l1);
      System.out.println(s1);
      cancel(s1);
      System.out.println(s1);
      
      // 02
      int[] l2 = {1, 2, 3, 4, 5};
      Stack<Integer> s2 = c.initiateS(l2);
      System.out.println(s2);
      collapse(s2);
      System.out.println(s2);
      
      // 03
      int[] l3 = {2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 1, 0, 17, 17};
      Stack<Integer> s3 = c.initiateS(l3);
      System.out.println(s3);
      compressDuplicates(s3);
      System.out.println(s3);
      
      // 04
      int[] l1 = {3, 18, 9, 42};
      int[] l2 = {3, 18, 9, 42};
      int[] l3 = {42, 9, 18, 3};
      Stack<Integer> s1 = c.initiateS(l1);
      Stack<Integer> s2 = c.initiateS(l2);
      Stack<Integer> s3 = c.initiateS(l3);
      System.out.println(equals(s1, s2));
      System.out.println(equals(s1, s3));
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
      
      // 05
      // Before: ( [ () (( ]   )       
      // After : ( ( () (( ))) )
      String[] l = {"(", "[", "(", ")", "(", "(", "]", ")"};
      Queue<String> q = c.initiateQ(l);
      System.out.println(q);
      expand(q);
      System.out.println(q);
      */
   }

   public static void cancel(Stack<Integer> s) {
      Stack<Integer> ns = new Stack<Integer>();
      if (s.size() > 1) {
         int num0 = 0;
         int num1 = s.pop();
         int num2 = 0;
         while (!s.isEmpty()) {
            num2 = s.pop();
            if (num1 + num2 != 0 && num0 + num1 != 0) {
               ns.push(num1);
            }
            num0 = num1;
            num1 = num2;
         }
         if (num2 + num1 != 0 && num0 + num1 != 0) {
            ns.push(num2);
         }
         while (!ns.isEmpty()) {
            s.push(ns.pop());
         }
      }
   }
   
   public static void collapse(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      if (s.size() % 2 == 1) {
         q.add(s.pop());
      } 
      while (!s.isEmpty()) {
         q.add(s.pop() + s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
      while (!s.empty()) {
         q.add(s.pop());
      }
      while (!q.isEmpty()) {
         s.push(q.remove());
      }
   }
   
   public static void compressDuplicates(Stack<Integer> s) {
      Queue<Integer> q = new LinkedList<Integer>();
      if (!s.isEmpty()) {
         int count = 0;
         int num = s.pop(); 
         while (!s.isEmpty()) {
            int n = s.pop();
            count++;
            if (n != num) {
               q.add(num);
               q.add(count);
               count = 0;
            }
            num = n;
         }
         q.add(num);
         q.add(count + 1);
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
   
   public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
      if (s1.size() != s2.size()) {
         return false;
      }
      Stack<Integer> s = new Stack<Integer>();
      for (int i = 0; i < s2.size(); i++) {
         int num1 = s1.pop();
         int num2 = s2.pop();
         if (num1 != num2) {
            s1.push(num1);
            s2.push(num2);
            while (!s.isEmpty()) {
               s2.push(s.pop());
               s1.push(s.pop());
            }
            return false;
         } else {
            s.push(num1);
            s.push(num2);
         }
      }
      while (!s.isEmpty()) {
         s2.push(s.pop());
         s1.push(s.pop());
      }
      return true;
   }
   
   public static void expand(Queue<String> q) {
      Stack<String> s = new Stack<String>();
      boolean encounter = false;
      int count = 0;
      while (!q.isEmpty()) {
         String str = q.remove();
         if (!encounter) {
            if (str.equals("(") || str.equals(")")) {
               s.push(str);
            } else { // "["
               encounter = true;
               s.push("(");
            }
         } else {
            if (str.equals("(")) {
               count++;
               s.push(str);
            } else if (str.equals(")")) {
               count--;
               s.push(str);
            } else { // "]"
               encounter = false;
               s.push(")");
               for (int i = 0; i < count; i++) {
                  s.push(")");
               }
               count = 0;
            }
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
   }
}