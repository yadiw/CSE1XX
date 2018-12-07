public class LinkedList1 {
   public ListNode front;
   
   public LinkedList1(int[] list) {
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
   public void addListAt(ListNode other, int index) {
      if (index < 0) {
         throw new IllegalArgumentException();
      }
      if (other != null) {
         ListNode before = null;
         ListNode after = front;
         for (int i = 0; i < index; i++) {
            if (after == null) {
               throw new IllegalArgumentException();
            }
            before = after;
            after = after.next;
         }
         ListNode otherCurrent = other;
         while (otherCurrent.next != null) {
            otherCurrent = otherCurrent.next;
         }
         if (before == null) {
            front = other;
         } else {
            before.next = other;
         }
         otherCurrent.next = after;
      }
   }
   
   // 02
   public boolean bubble() {
      boolean changed = false;
      if (front != null && front.next != null) {
         if (front.data > front.next.data) {
            changed = true;
            ListNode temp = front;
            front = front.next;
            temp.next = front.next;
            front.next = temp;
         }
         ListNode current = front;
         while (current.next != null && current.next.next != null) {
            if (current.next.data > current.next.next.data) {
               changed = true;
               ListNode temp = current.next.next;
               current.next.next = temp.next;
               temp.next = current.next;
               current.next = temp;
            }
            current = current.next;
         }
      }
      return changed;
   }
   
   // 03
   public void collapse() {
      if (front != null && front.next != null) {
         front.next.data = front.data + front.next.data;
         front = front.next;
         if (front.next != null){
            ListNode current = front.next;
            while (current != null && current.next != null) {
               current.data = current.data + current.next.data;
               current.next = current.next.next;
               current = current.next;
            }
         }
      }  
   }
   
   // 04
   public void compress(int factor) {
      ListNode current = front;    
      while (current != null) {
         int count = 1;
         ListNode last = current.next;
         while (last != null && count < factor) {
            current.data += last.data;
            current.next = current.next.next;
            count++;
            last = last.next;
         }
         current = current.next;
      }
   }
   
   // 05
   public void compressDuplicates() {
      if (front != null) {
         int num = front.data;
         int count = 1;
         while (front.next != null && front.next.data == num) {
            count++;
            front = front.next;
         }
         front = new ListNode(count, front);
         ListNode current = front.next;
         while (current.next != null) {
            count = 1;
            num = current.next.data;
            ListNode last = current.next.next;
            while (last != null && last.data == num) {
               current.next = current.next.next;
               count++;
               last = last.next;
               
            }
            current.next = new ListNode(count, current.next);
            current = current.next.next;
         }
      }
   }
   
   // 06
   public void doubleList() {
      if (front != null) {
         ListNode front2 = new ListNode(front.data); 
         ListNode end2 = front2;
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
            end2.next = new ListNode(current.data);
            end2 = end2.next;
         }
         current.next = front2;
      }
   }
   
   // 07
   public int evenSum() {
      int sum = 0;
      ListNode current = front;
      while (current != null) {
         sum += current.data;
         if (current.next != null) {
            current = current.next;
         }
         current = current.next;
      }
      return sum;
   }
   
   // 08
   public void expand() {
      if (front != null) {
         int count = front.data;
         int num = front.next.data;
         front = front.next;
         ListNode current = front;
         for (int i = 1; i < count; i++) {
            front = new ListNode(num, front);
         }
         while (current.next != null) { // has more pairs
            count = current.next.data;
            num = current.next.next.data;
            ListNode front2 = current.next.next;
            ListNode end2 = front2;
            for (int i = 1; i < count; i++) {
               front2 = new ListNode(num, front2);
            }
            current.next = front2;
            current = end2;
         }
      }
   }
   
   // 09
   public void frontToBack() {
      if (front != null && front.next != null) {
         ListNode temp = front;
         front = front.next;
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = temp;
         temp.next = null;
      }  
   }
   
   // 10
   public boolean hasAlternatingParity() {
      if (front == null || front.next == null) {
         return true;
      } else {
         ListNode current = front;
         while (current != null && current.next != null) {
            if (current.data % 2 == current.next.data) {
               return false;
            }
            current = current.next;
         }
         return true;
      }  
   }
   
   // 11
   public boolean hasDuplicates() {
      if (front == null || front.next == null) {
         return false;
      } else {
         ListNode current = front;
         while (current != null && current.next != null) {
            ListNode current2 = current.next;
            while (current2 != null) {
               if (current.data == current2.data) {
                  return true;
               } 
               current2 = current2.next; 
            }
            current = current.next;
         }
         return false;      
      }
   }
   
   // 12
   public boolean hasOddEven() {
      if (front == null || front.next == null) {
         return false;
      } else {
         ListNode current = front;
         int evenCount = 0;
         int oddCount = 0;
         while (current != null) {
            if (current.data % 2 == 0) {
               evenCount++;
            } else {
               oddCount++;
            }
            current = current.next;
         }
         return (evenCount >= 1 && oddCount >= 1);
      }
   }
   
   // 13
   public boolean hasTwoConsecutive() {
      if (front == null || front.next == null) {
         return false;
      } else {
         ListNode current = front;
         while (current != null && current.next != null) {
            if (current.data - current.next.data == -1) {
               return true;
            }
            current = current.next;
         }
         return false;
      }
   }
   
   // 14
   public boolean increasingTriples() {
      ListNode current = front;
      while (current != null && current.next != null && current.next.next != null) {
         if (current.data > current.next.data || current.next.data > current.next.next.data) {
            return false;
         }
         current = current.next.next.next;
      }
      if (current != null && current.next != null) {
         if (current.data > current.next.data) {
            return false;
         }
      }  
      return true;
   }
   
   // 15
   public void insertMultiplesOfN(int n) {
      if (n < 0) {
         throw new IllegalArgumentException();     
      } 
      if (front == null || front.data != 0) {
         front = new ListNode(0, front);
      }
      ListNode current = front;
      int count = 1;
      while (current != null && current.next != null) {
         if (current.data < count * n && current.next.data > count * n) {
            current.next = new ListNode(count * n, current.next);
            count++;
         } else if (current.data == count * n) {
            count++;
         }
         current = current.next;
      }
      if (current.data != count * n) {
         current.next = new ListNode(count * n);
      }
   }   
}