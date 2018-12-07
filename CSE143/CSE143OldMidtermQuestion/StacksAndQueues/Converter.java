import java.util.*;

public class Converter {
   
   public Stack<Integer> initiateS(int[] list) {
      Stack<Integer> result = new Stack<Integer>();
      for (int i = 0; i < list.length; i++) {
         result.push(list[i]);
      }
      return result;
   }
   
   public Stack<String> initiateS(String[] list) {
      Stack<String> result = new Stack<String>();
      for (int i = 0; i < list.length; i++) {
         result.push(list[i]);
      }
      return result;
   }
   
   public Queue<Integer> initiateQ(int[] list) {
      Queue<Integer> result = new LinkedList<Integer>();
      for (int i = 0; i < list.length; i++) {
         result.add(list[i]);
      }
      return result;
   }
   
   public Queue<String> initiateQ(String[] list) {
      Queue<String> result = new LinkedList<String>();
      for (int i = 0; i < list.length; i++) {
         result.add(list[i]);
      }
      return result;
   }
}