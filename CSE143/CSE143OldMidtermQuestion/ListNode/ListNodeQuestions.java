//Before:
//list ->[ 1 | -]->[ 2 | -]->[ 3 | /]
//temp ->[ 4 | -]->[ 5 | -]->[ 6 | /]

//After:
//list ->[ 5 | -]->[ 3 | -]->[ 4 | -]->[ 2 | /]

public class ListNodeQuestions {

   public static void main(String[] args) {
      /*
      // 001
      int[] list1 = {1, 2, 3};
      int[] list2 = {4, 5, 6};
      ListNode list = initialize(list1);
      ListNode temp = initialize(list2);
      
      temp.next.next = list.next.next;
      list.next.next.next = temp;
      ListNode realTemp = temp.next;
      temp.next = list.next;
      list.next.next = null;
      list = realTemp;
      
      print(list);
      */
      
      /*
      // 004
      int[] list1 = {3, 1};
      int[] list2 = {2};
      ListNode A = initialize(list1);
      ListNode B = initialize(list2);
      
      A.next.next = B;
      ListNode temp = A;
      A = A.next;
      B = temp;
      B.next = null;
      
      print(A);
      print(B);
      */
      
      /*
      // 014
      int[] list1 = {1, 2};
      int[] list2 = {3, 4, 5};
      ListNode front = initialize(list1);
      ListNode temp = initialize(list2);
      
      ListNode realTemp = temp.next;
      temp.next = front.next;
      temp.next.next = realTemp;
      front.next = temp.next.next.next;
      temp.next.next.next = front;
      front = temp;
      
      print(front);
      */
   }
   
   public static ListNode initialize(int[] list) {
      ListNode front = null;
      for (int i = list.length - 1; i >= 0; i--) {
         front = new ListNode(list[i], front);
      }
      return front;
   }
   
   public static void print(ListNode front) {
      String result = "";
      if (front != null) {
         result += front.data;
         ListNode current = front.next;
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
         }
      }
      System.out.println( "[" + result + "]");
   }



}