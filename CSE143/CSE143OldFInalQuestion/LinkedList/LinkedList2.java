public class LinkedList2 {
   public ListNode front;
   
   public LinkedList2(int[] list) {
      for (int i = list.length - 1; i >= 0; i--) {
         front = new ListNode(list[i], front);
      }
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
   public void interleave(LinkedList2 other) {
      ListNode current1 = front;
      ListNode current2 = other.front;
      while (current1 != null && current2 != null && current1.next != null && current2.next != null) {
         ListNode temp1 = current1.next;
         ListNode temp2 = current2.next;
         current1.next = current2;
         current2.next = temp1;
         current1 = temp1;
         current2 = temp2;
      }
      if (current1.next == null) {
         current1.next = current2;
      } else { // current2.next == null
         ListNode temp = current1.next;
         current1.next = current2;
         current2.next = temp;
      }
      other.front = null;
   }
   
   // 02
   public boolean isConsecutive() {
      if (front == null || front.next == null) {
         return true;
      } else {
         ListNode left = front;
         ListNode right = front.next;
         while (right != null) {
            if (right.data - left.data != 1) {
               return false;
            }
            left = right;
            right = right.next;
         }
         return true;
      }
   }
   
   // 03
   public boolean isSortedByN(int n) {
      if (n <= 0) {
         throw new IllegalArgumentException();
      }
      ListNode current1 = front;
      ListNode current2 = front;
      int count = 0;
      while (current2 != null && count < n) {
         current2 = current2.next;
         count++;
      }
      while (current2 != null) {
         if (current1.data > current2.data) {
            return false;
         }
         current1 = current1.next;
         current2 = current2.next;
      }
      return true;
   }
   
   // 04
   public int lastIndexOf(int n) {
      int index = -1;
      if (front != null) {
         int currentIndex = 0;
         ListNode current = front;
         while (current != null) {
            if (current.data == n) {
               index = currentIndex;
            }
            currentIndex++;
            current = current.next;
         }
      }
      return index;
   }
   
   // 05
   public void markMultiples(int n) {
      if (n < 1) {
         throw new IllegalArgumentException();
      }
      if (front != null) {
         if (front.data % n == 0) {
            front = new ListNode(0, front);
         }
         ListNode current = front.next;;         
         while (current != null && current.next != null) {
            if (current.next.data % n == 0) {
               current.next = new ListNode(0, current.next);
               current = current.next;
            }
            current = current.next;
         }
      }
   }
   // 06
   public int maxAdjacentPairSum() {
      if (front == null || front.next == null) {
         return 0;
      } else {
         ListNode left = front;
         ListNode right = front.next;
         int sum = left.data + right.data;
         while (right != null) {
            sum = Math.max(sum, left.data + right.data);
            left = right;
            right = right.next;
         }
         return sum;
      }
   }
   
   // 07
   public void mergeFrom(LinkedList2 other) {
      if (other.front != null) {
         if (front == null) {
            front = other.front;
         } else {
            if (front.data > other.front.data) {
               ListNode temp = front;
               front = other.front;
               other.front = temp;
            }
            ListNode current1 = front;
            ListNode current2 = other.front;
            while (current1 != null && current2 != null && current1.next != null) {
               if (current1.next.data >= current2.data) {
                  ListNode temp = current1.next;
                  current1.next = current2;
                  current2 = current2.next;
                  current1.next.next = temp;
               }
               current1 = current1.next;
            }
            current1.next = current2;
         }
         other.front = null;
      }
   }
   
   // 08
   public int minGap() {
      if (front == null || front.next == null) {
         return 0;
      } else {
         int gap = front.next.data - front.data;
         ListNode left = front.next;
         ListNode right = front.next.next;
         while (right != null) {
            gap = Math.min(gap, right.data - left.data);
            left = right;
            right = right.next;
         }
         return gap;
      } 
   }
   
   // 09
   public void minToFront() {
      if (front != null && front.next != null) {
         int minData = front.data;
         ListNode current = front.next;
         while (current != null) {
            minData = Math.min(minData, current.data);
            current = current.next;
         }
         current = front;
         while (current.next != null && current.next.data != minData) {
            current = current.next;
         }
         ListNode minNode = current.next;
         current.next = current.next.next;
         minNode.next = front;
         front = minNode;
      }
   }
   
   // 10
   public int numUnique() {
      if (front == null) {
         return 0;
      } else {
         ListNode left = front;
         ListNode right = front.next;
         int count = 1;
         while (right != null) {
            if (left.data != right.data) {
               count++;
            }
            left = right;
            right = right.next;
         }
         return count;
      }  
   }
   
   // 11
   public void printEvenOddSum() {      
      int even = 0;
      int odd = 0;
      if (front != null) {
         ListNode evenCurrent = front;
         ListNode oddCurrent = front.next;
         while (evenCurrent != null && oddCurrent != null) {
            even += evenCurrent.data;
            odd += oddCurrent.data;
            evenCurrent = oddCurrent.next;
            oddCurrent = evenCurrent.next;
         }
         if (evenCurrent != null) {
            even += evenCurrent.data;
         }
      }
      System.out.println("even sum = " + even);
      System.out.println("odd sum = " + odd);
   }
   
   // 12
   public void printInversions() {
      if (front != null && front.next != null) {
         ListNode current = front;
         while (current.next != null) {
            ListNode pointer = current.next;
            while (pointer != null) {
               if (current.data > pointer.data) {
                  System.out.println("(" + current.data + ", " + pointer.data + ")");
               }
               pointer = pointer.next;
            }
            current = current.next;
         }
      }
   }
   
   // 13
   public void reOrder() {
      if (front != null && front.next != null) {
         ListNode current = front;
         while (current != null && current.next != null) {
            if (current.next.data < current.data) {
               ListNode temp = current.next;
               current.next = current.next.next;
               temp.next = front;
               front = temp;
            } else {
               current = current.next;
            }
         }     
      }   
   }
   
   // 14
   public void rearrange() {
      if (front != null && front.next != null && front.next.next != null) { // at least 3 elements
         ListNode current = front.next;
         while (current != null && current.next != null) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = front;
            front = temp;
            current = current.next;
         }
      }  
   }
   
   // 15
   public int removeAllNegatives() {
      int count = 0;
      if (front == null) {
         throw new IllegalArgumentException();
      }
      while (front != null && front.data < 0) {
         front = front.next;
         count++;
      }
      ListNode current = front;
      while (current != null && current.next != null) {
         if (current.next.data < 0) {
            count++;
            current.next = current.next.next;
         } else {
            current = current.next;
         }
      }
      return count;
   }
}