public class LinkedList4 {
   public ListNode front;
   
   public LinkedList4(int[] list) {
      for (int i = list.length - 1; i >= 0; i--) {
         front = new ListNode(list[i], front);
      }
   }
   
   public LinkedList4() { 
      front = new ListNode();
   }
   
   public String toString() {
      String result = "";
      if (front != null) {
         result += front.data;
         ListNode current = front.next;
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
         }
      }
      return "[" + result + "]";
   }
   
   // 01
   public void shift() {
      if (front != null && front.next != null) {
         ListNode temp = front;
         front = front.next;
         ListNode end = front;
         ListNode mark = temp;
         while (end != null && end.next != null) {
            end = end.next;
         }
         end.next = temp;
         end = end.next;
         ListNode current = front;
         while (current != null && current.next != null && current.next != mark) {
            temp = current.next;
            current.next = current.next.next;
            end.next = temp; 
            end = end.next;
            current = current.next;
         }
         end.next = null;
      }  
   }
   
   // 02
   public void sortPairs() {
      if (front != null && front.next != null) {
         ListNode temp1 = null;
         ListNode temp2 = null;
         if (front.data > front.next.data) {
            temp1 = front;
            temp2 = front.next.next;
            front = front.next;
            front.next = temp1;
            temp1.next = temp2;
         }
         ListNode current = front.next;
         while (current != null && current.next != null && current.next.next != null) {
            if (current.next.data > current.next.next.data) {
               temp1 = current.next;
               temp2 = current.next.next.next;
               current.next = current.next.next;
               current.next.next = temp1;
               temp1.next = temp2;   
            } 
            current = current.next.next;
         }
      }
   }
   
   // 03
   public LinkedList4 splitBySign() {
      LinkedList4 result = new LinkedList4();
      ListNode temp = null;
      ListNode current2 = null;
      while (front != null && front.data < 0) {
         temp = front;
         front = front.next;
         if (current2 == null) {
            result.front = temp;
            current2 = result.front;
         } else {
            current2.next = temp;
            current2 = current2.next;
         }
      }
      ListNode current1 = front; 
      while (current1 != null && current1.next != null) {
         if (current1.next.data < 0) {
            temp = current1.next;
            current1.next = current1.next.next;
            if (current2 == null) {
               result.front = temp;
               current2 = result.front;
            } else {
               current2.next = temp;
               current2 = current2.next;
            }
         } else {
            current1 = current1.next;
         }
      }
      if (current2 != null) {
         current2.next = null;
      }
      return result;
   }
   
   // 04
   public void stutterTwo() {
      ListNode current = front;
      while (current != null && current.next != null) {
         current.next.next = new ListNode(current.data, new ListNode(current.next.data, current.next.next));
         current = current.next.next.next.next;
      }
   }
   
   // 05
   public void surroundWith(int x, int y) {
      ListNode current = front;
      if (front != null && front.data == x) {
         front = new ListNode(y, front);
         front.next.next = new ListNode(y, front.next.next);
         current = front.next.next;
      }
      while (current != null && current.next != null) {
         if (current.next.data == x) {
            current.next = new ListNode(y, current.next);
            current.next.next.next = new ListNode(y, current.next.next.next);
            current = current.next.next.next.next;
         } else {
            current = current.next;
         }
      }
   }
   
   // 06
   public void switchEvens(LinkedList4 other) {
      if (front != null && other.front != null) {
         ListNode temp1 = front.next;
         ListNode temp2 = other.front.next;
         front.next = temp2;
         other.front.next = temp1;
         ListNode temp = front;
         front = other.front;
         other.front = temp;
         ListNode current1 = front.next;
         ListNode current2 = other.front.next;
         while (current1 != null && current2 != null && current1.next != null && current2.next != null) {
            temp1 = current1.next;
            temp2 = current2.next;
            current1.next = temp2;
            current2.next = temp1;
            temp = temp1.next;
            current2.next.next = temp2.next;
            current1.next.next = temp;
            current1 = current1.next.next;
            current2 = current2.next.next;      
         }
      }  
   }
   
   // 07
   public void switchPairs() {
      if (front != null && front.next != null) {
         ListNode temp1 = front;
         ListNode temp2 = front.next.next;
         front = front.next;
         front.next = temp1;
         front.next.next = temp2;
         ListNode current = front.next;
         while (current != null && current.next != null && current.next.next != null) {
            temp1 = current.next;
            temp2 = current.next.next.next;
            current.next = current.next.next;
            current.next.next = temp1;
            temp1.next = temp2;
            current = current.next.next;
         }
      }   
   }
   
   // 08
   public void takeSmallerFrom(LinkedList4 other) {
      if (front != null && other.front != null) {
         ListNode temp1 = null;
         ListNode temp2 = null;
         if (front.data > other.front.data) {
            temp1 = front;
            temp2 = front.next;
            front = other.front;
            other.front = temp1;
            other.front.next = front.next;
            front.next = temp2;
         }
         ListNode current1 = front;
         ListNode current2 = other.front;
         while (current1 != null && current2 != null && current1.next != null && current2.next != null) {
            if (current1.next.data > current2.next.data) {
               temp1 = current1.next;
               temp2 = current1.next.next;
               current1.next = current2.next;
               current2.next = temp1;
               current2.next.next = current1.next.next;
               current1.next.next = temp2;                  
            } 
            current1 = current1.next;
            current2 = current2.next;
         }
      }
   }
   
   // 09
   public void trimEnds(int k) {
      if (k > 0) {
         ListNode current = front;
         int size = 0;
         while (current != null) {
            size++;
            current = current.next;
         }
         if (2 * k > size) {
            throw new IllegalArgumentException();
         } else if (2 * k == size) {
            front = null;
         } else {
            current = front;
            for (int i = 0; i < k; i++) {
               front = front.next;
               current = current.next;
               size--;
            }
            for (int i = 0; i < size - k - 1; i++) {
               current = current.next;
            }
            current.next = null;
         }
      }
   }
   
   // 10
   public void weave(LinkedList4 other) {
      if (front == null) {
         front = other.front;
         other.front = null;
      } else if (other.front != null) {
         ListNode current1 = front;
         ListNode current2 = other.front;
         while (current1.next != null && current2.next != null) {
            ListNode temp = current1.next;
            current1.next = current2;
            current2 = current2.next;
            current1.next.next = temp;
            current1 = temp;
         }
         if (current1.next == null) {
            current1.next = current2;
         } else {
            current2.next = current1.next;
            current1.next = current2;
         }
         other.front = null;
      }
   }
}