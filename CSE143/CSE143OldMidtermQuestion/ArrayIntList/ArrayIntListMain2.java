import java.util.*;

public class ArrayIntListMain2 {
   public static void main(String[] args) {
      /*
      // 01
      int[] list = {12, 7, 8, 3, 9, 3, 2, 3, 3, 14};
      ArrayIntList2 al = new ArrayIntList2(list);
      al.removeAll(3);
      System.out.println(al);
      
      // 02
      int[] list = {8, 17, 9, 24, 42, 3, 8};
      ArrayIntList2 al = new ArrayIntList2(list);
      al.removeFront(4);
      System.out.println(al);
      
      // 03
      int[] list = {23, 34, -6, 98, -12, 7, 44, 23, 67, 23, 12};
      ArrayIntList2 al = new ArrayIntList2(list);
      System.out.println(al.removeLast(23));
      System.out.println(al);
      
      // 04
      int[] list = {8, 13, 17, 4, 9, 12, 98};
      ArrayIntList2 al = new ArrayIntList2(list);
      al.removeOddPositions();
      System.out.println(al);
      
      // 05
      int[] list = {8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92};
      ArrayIntList2 al = new ArrayIntList2(list);
      al.removeRange(3, 8);
      System.out.println(al);
      
      // 06
      int[] list = {23, 34, -6, 98, -12, 7, 44, 23, 67, 23, 12};
      Set<Integer> s = new TreeSet<Integer>();
      s.add(6);
      s.add(8);
      s.add(12);
      s.add(15);
      s.add(17);
      s.add(23);
      s.add(44);
      ArrayIntList2 al = new ArrayIntList2(list);
      al.retainAll(s);
      System.out.println(al);
      
      // 07
      int[] list = {17, 42, 3, 8, 9, 12};
      ArrayIntList2 al = new ArrayIntList2(list);
      ArrayIntList2 copy = al.reverseCopy();
      System.out.println(copy);
      
      // 08
      int[] list = {2, 3, 5, 4, 7, 15, 20, 7};
      ArrayIntList2 al = new ArrayIntList2(list);
      ArrayIntList2 total = al.runningTotal();
      System.out.println(total);
      */
      // 09
      int[] list1 = {41, 2, 4, 17, -3, -1, 20};
      ArrayIntList2 al1 = new ArrayIntList2(list1);
      int[] list2 = {6, 13, 4, 29, -4};
      ArrayIntList2 al2 = new ArrayIntList2(list2);
      al2.takeMax(al1);
      System.out.println(al2);
   }
}