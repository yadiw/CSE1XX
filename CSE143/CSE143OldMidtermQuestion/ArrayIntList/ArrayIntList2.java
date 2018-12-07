import java.util.*;

public class ArrayIntList2 {
   private int[] elementData; 
   private int size;

   public static final int DEFAULT_CAPACITY = 100;

   public ArrayIntList2(int[] list) {
      size = 0;
      elementData = new int[DEFAULT_CAPACITY];
      for (int i = 0; i < list.length; i++) {
         size++;
         elementData[i] = list[i];
      }
   }
   
   public ArrayIntList2(int capacity) {
      if (capacity < 0) {
         throw new IllegalArgumentException();
      }
      size = 0;
      elementData = new int[capacity];
   }
   
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[" + elementData[0];
         for (int i = 1; i < size; i++) {
             result += ", " + elementData[i];
         }
         result += "]";
         return result;
      }
   }
   
   // 01
   public void removeAll(int n) {
      for (int i = 0; i < size; i++) {
         if (elementData[i] == n) {
            for (int j = i; j < size - 1; j++) {
               elementData[j] = elementData[j + 1];
            }
            size--;
            i--;
         }
      }
   }
   
   // 02
   public void removeFront(int n) {
      for (int i = 0; i < size - n; i++) {
         elementData[i] = elementData[i + n];
      }
      size -= n;
   }
   
   // 03
   public int removeLast(int n) {
      for (int i = size - 1; i >= 0; i--) {
         if (elementData[i] == n) {
            for (int j = i; j < size - 1; j++) {
               elementData[j] = elementData[j + 1];
            }
            size--;
            return i;
         }
      }
      return -1;
   }
   
   // 04
   public void removeOddPositions() {
      int index = 0;
      for (int i = 0; i < size / 2; i++) {
         elementData[i] = elementData[index];
         index += 2; 
      }
      if (size % 2 == 1) {
         elementData[size / 2] = elementData[index];
      }
      size = (size + 1) / 2;
   }
   
   // 05
   public void removeRange(int index1, int index2) {
      if (index1 < 0 || index1 >= size || index2 < index1 || index2 >= size) {
         throw new IllegalArgumentException();
      }
      for (int i = index1; i < index2; i++) {
         elementData[i] = elementData[i + index2 - index1];
      }
      size  -= index2 - index1;
   }
   
   // 06
   public void retainAll(Set<Integer> s) {
      for (int i = 0; i < size; i++) {
         if (!s.contains(elementData[i])){
            for (int j = i; j < size - 1; j++) {
               elementData[j] = elementData[j + 1];
            }
            size--;
            i--;
         }
      }
   }
   
   // 07
   public ArrayIntList2 reverseCopy() {
      ArrayIntList2 result = new ArrayIntList2(elementData.length);
      for (int i = 0; i < size; i++) {
         result.elementData[size - 1 - i] = elementData[i];
         result.size++;
      }
      return result;
   }
   
   // 08
   public ArrayIntList2 runningTotal() {
      ArrayIntList2 result = new ArrayIntList2(elementData.length);
      int sum = 0;
      for (int i = 0; i < size; i++) {
         sum += elementData[i];
         result.elementData[i] = sum;
         result.size++;
      }
      return result;
   }
   
   // 09
   public void takeMax(ArrayIntList2 other) {
      for (int i = 0; i < Math.min(size, other.size); i++) {
         elementData[i] = Math.max(elementData[i], other.elementData[i]);
      }
      if (other.size > size) {
         for (int i = size; i < other.size; i++) {
            elementData[i] = other.elementData[i];
         }
         size = other.size;
      }
   }
}