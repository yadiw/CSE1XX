public class LinkedList3 {
   public ListNode front;
   
   public LinkedList3(int[] list) {
      for (int i = list.length - 1; i >= 0; i--) {
         front = new ListNode(list[i], front);
      }
   }
   
   public LinkedList3() { // constructor for Q2, Q6
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
   public void removeDuplicates() {
      if (front != null && front.next != null) {
         ListNode current1 = front;
         ListNode current2 = front.next;
         while (current1 != null && current1.next != null) {
            while (current2 != null && current2.next != null) {
               if (current1.data == current2.next.data) {
                  current2.next = current2.next.next;
               } else {
                  current2 = current2.next;
               }
            }
            current1 = current1.next;
            current2 = current1.next;         
         }
      }
   }
   
   // 02
   public LinkedList3 removeEvens() {
      LinkedList3 result = new LinkedList3();
      if (front != null) {
         result.front = front;
         front = front.next;
         result.front.next = null;
         ListNode current1 = front;
         ListNode current2 = result.front;
         while (current1 != null && current1.next != null) {
            ListNode temp = current1.next;
            current1.next = current1.next.next;
            current2.next = temp;
            temp.next = null;
            current1 = current1.next;
            current2 = current2.next;
         }        
      }
      return result;
   }

   // 03
   public void removeEveryIthElement(int i) {
      if (i < 1) {
         throw new IllegalArgumentException();
      }
      if (i == 1) {
         front = null;
      } else {
         ListNode current = front;
         int count = 1;
         while (current != null && current.next != null) {
            count++;
            if (count == i) {
               count = 1;
               current.next = current.next.next;
            }
            current = current.next;                   
         }
      }
   }
   
   // 04
   public void removeEveryOther() { // remove elements at odd position??
      ListNode current = front;
      while (current != null && current.next != null) {
         current.next = current.next.next;
         current = current.next;
      }
   }
   
   // 05
   public boolean removeFirstNegative() {
      boolean removed = false;
      if (front != null && front.data < 0) {
         front = front.next;
         removed = true;
      }
      ListNode current = front;
      while (current != null && current.next != null && !removed) {
         if (current.next.data < 0) {
            current.next = current.next.next;
            removed = true;
         } else {
            current = current.next;
         }      
      }
      return removed;
   }
   
   // 06
   public LinkedList3 removeFirstOf3() {
      LinkedList3 result = new LinkedList3();
      if (front != null) {
         ListNode temp = front;
         front = front.next;
         result.front = temp;
         temp.next = null;
         ListNode current1 = front;
         ListNode current2 = result.front;
         int count = 1;
         while (current1 != null && current1.next != null) {
            count++;
            if (count == 3) {
               temp = current1.next;
               current1.next = current1.next.next;
               current2.next = temp;
               temp.next = null;
               count = 1;
               current2 = current2.next;
            }
            current1 = current1.next;
         }
      }   
      return result;
   }
   
   // 07
   public void removeFrom(LinkedList3 list) {
      if (front != null && list.front != null) {
         ListNode current2 = list.front;
         while (front != null && current2 != null && front.data >= current2.data) {
            if (front.data > current2.data) {
               current2 = current2.next;
            } else {
               front = front.next;
            }
         }
         if (front != null) {
            ListNode current1 = front;
		      while (current1.next != null && current2 != null) {
			      if (current1.next.data < current2.data) {
			        current1 = current1.next;
			      } else if (current1.next.data == current2.data) {
			        current1.next = current1.next.next;
			      } else {
			        current2 = current2.next;
              }
            }
         }
      }   
   }
   
   // 08
   public void removeLast(int n) {
      if (front != null) {
         ListNode left = null;
         ListNode right = front;
         while (right.next != null) {
            if (right.next.data == n) {
               left = right;
            }
            right = right.next;
         }
         if (left != null){
            left.next = left.next.next;
         } else if (front.data == n) {
            front = front.next;
         }
      }
   }
   
   // 09
   public void removeMin() {
      if (front == null) { // cannot find NoSuchElementException :(
         throw new IllegalStateException();
      }
      ListNode current = front.next;
      int min = front.data;
      while (current != null) {
         min = Math.min(min, current.data);
         current = current.next;
      }
      if (min == front.data) {
         front = front.next;
      } else {
         current = front;
         boolean removed = false;
         while (!removed && current != null && current.next != null) {
            if (current.next.data == min) {
               current.next = current.next.next;
               removed = true;
            } else {
               current = current.next;
            }
         }
      }
   }
   
   // 10
   public int removeRange(int min, int max) {
      int count = 0;
      while (front != null && front.data >= min && front.data <= max) {
         front = front.next;
         count++;
      }
      ListNode current = front;
      while (current != null && current.next != null) {
         if (current.next.data >= min && current.next.data <= max) {
            count++;
            current.next = current.next.next;
         } else {
            current = current.next;
         }
      }
      return count;
   }
   
   // 11
   // reorder() - same as reOrder().
   
   // 12
   public void reorder3() {
      if (front != null && front.next != null) {
         ListNode temp1 = front.next.next;
         ListNode temp2 = front;
         front = front.next;
         front.next = temp2;
         front.next.next = temp1;
         ListNode current = temp1;
         while (current != null && current.next != null && current.next.next != null) {
            temp1 = current.next;
            temp2 = current.next.next.next;
            current.next = current.next.next;
            current.next.next = temp1;
            temp1.next = temp2;
            current = temp2;
         }
      }
   }
   
   // 13
   public void reverse3() {
      if (front != null && front.next != null && front.next.next != null) { // at least 3 elements
         ListNode temp1 = front;
         front = front.next.next;
         ListNode temp2 = front.next;
         front.next = temp1.next;
         front.next.next = temp1;
         temp1.next = temp2;
         ListNode current = temp1;
         while (current != null && current.next != null && current.next.next != null && current.next.next.next != null) {
            temp1 = current.next;
            current.next = current.next.next.next;
            temp2 = current.next.next;
            current.next.next = temp1.next;
            current.next.next.next = temp1;
            temp1.next = temp2;
            current = temp1;
         
         }
      }
   }
   
   // 14
   public void rotate() {
      if (front != null && front.next != null) {
         ListNode temp = front;
         front = front.next;
         temp.next = null;
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = temp;
      }     
   }
   
   // 15
   public void rotate3() {
      if (front != null && front.next != null && front.next.next != null) { // at least 3 elements
         ListNode temp1 = front;
         front = front.next;
         ListNode temp2 = front.next.next;
         front.next.next = temp1;
         temp1.next = temp2;
         ListNode current = temp1;
         while (current != null && current.next != null && current.next.next != null && current.next.next.next != null) {
            temp1 = current.next;
            current.next = current.next.next;
            temp2 = current.next.next.next;
            current.next.next.next = temp1;
            temp1.next = temp2;
            current = temp1;         
         }
      }
   }
}