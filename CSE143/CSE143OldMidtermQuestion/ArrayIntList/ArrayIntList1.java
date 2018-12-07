public class ArrayIntList1 {
   private int[] elementData; 
   private int size;

   public static final int DEFAULT_CAPACITY = 100;

   public ArrayIntList1(int[] list) {
      size = 0;
      elementData = new int[DEFAULT_CAPACITY];
      for (int i = 0; i < list.length; i++) {
         size++;
         elementData[i] = list[i];
      }
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
   public void collapse() {
      int index = 0;
      for (int i = 0; i < size; i += 2) {
         elementData[index] = elementData[i] + elementData[i + 1];
         index++;
      }
      if (size % 2 == 1) {
         elementData[index] = elementData[size - 1];
      }
      size = (size + 1) / 2;
   }
   
   // 02
   public void fromCounts() {
      int sum = 0;
      for (int i = 0; i < size; i += 2) {
         sum += elementData[i];
      }
      int index = size - 1;
      int count = 0;
      for (int i = sum - 1; i >= 0; i--) {
         if (!(count < elementData[index - 1])) {
            index -= 2;
            count = 0;
         }
         elementData[i] = elementData[index];
         count++;
      }
      size = sum;
   }
   
   // 03
   public void insertAt(int index, int n, int value) {
      if (index < 0 || index > size || n < 0) {
         throw new IllegalArgumentException();
      }
      for (int i = index; i < size; i++) {
         elementData[i + n] = elementData[i];
      }
      for (int i = index; i < index + n; i++) {
         elementData[i] = value;
      }
      size += n;
   }
   
   // 04
   public boolean isConsecutive() {
      if (size < 2) {
         return true;
      }
      int num1 = elementData[0];
      int difference = num1 - elementData[1];
      for (int i = 1; i < size; i++) {
         int num2 = elementData[i];
         if (Math.abs(num1 - num2) != 1 || num1 - num2 != difference) {
            return false;
         }
         num1 = num2;
      }
      return true;
   }
   
   // 05
   public boolean isPairWiseSorted() {
      if (size < 2) {
         return true;
      }
      for (int i = 0; i < size - 1; i += 2) {
         int num1 = elementData[i];
         int num2 = elementData[i + 1];
         if (num1 > num2) {
            return false;
         }
      }
      return true;
   }
   
   // 06
   public int longestSortedSequence() {
      if (size == 0) {
         return 0;
      }
      int max = 1;
      int count = 1;
      int num1 = elementData[0];
      for (int i = 1; i < size; i++) {
         int num2 = elementData[i];
         if (num1 <= num2) {
            count++;
            max = Math.max(count, max);
         } else {
            count = 1;
         }
         num1 = num2;
      }
      return max;
   }
   
   // 07
   public boolean makeConsecutiveByN(int n) {
      if (size < 2) {
         return true;
      }
      boolean changed = false;
      int num1 = elementData[0];
      for (int i = 1; i < size; i++) {
         int num2 = elementData[i];
         if (Math.abs(num1 - num2) != n) {
            for (int j = i; j < size - 1; j++) {
               elementData[j] = elementData[j + 1];
            }
            size--;
            changed = true;
            i--;
         } else {
            num1 = num2;
         }
      }
      return changed;
   }
   
   // 08
   public int maxCount() {
      if (size < 1) {
         return 0;
      }
      int count = 1;
      int max = 1;
      int num1 = elementData[0];
      for (int i = 1; i < size; i++) {
         int num2 = elementData[i];
         if (num1 == num2) {
            count++;
            max = Math.max(count, max);
         } else {
            count = 1;
         }
         num1 = num2;
      }
      return max;
   }
   
   // 09
   public void mirror() {
      for (int i = 0; i < size; i++) {
         elementData[size * 2 - 1 - i] = elementData[i];
      }
      size *= 2;
   }
   
   // 10
   public void printInversions() {
      for (int i = 0; i < size - 1; i++) {
         for (int j = i + 1; j < size; j++) {
            int num1 = elementData[i];
            int num2 = elementData[j];
            if (num1 > num2) {
               System.out.println("(" + num1 + ", " + num2 + ")");
            }
         }
      }
   
   }
}