import java.util.*;

public class IntTree1 {
   private static final int NULL = 0;
   private IntTreeNode overallRoot;
   
   public IntTree1() {
      overallRoot = null;
   }
   
   public IntTree1(int data[]) {   
      IntTreeNode[] nodes = new IntTreeNode[data.length];    
      for (int i = 0; i < data.length; i++){  
         if (data[i] == NULL) {  
            nodes[i] = null;  
         } else {  
            nodes[i] = new IntTreeNode(data[i]);  
         }  
      }  
      Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();  
      q.add(nodes[0]);  
      IntTreeNode node = null;  
      int index = 1;  
      while (index < data.length) { 
         while (q.peek() == null) {
            q.remove();
         } 
         node = q.remove();          
         node.left = nodes[index++];  
         q.add(node.left); 
         node.right = nodes[index++];  
         q.add(node.right);
      }  
      overallRoot = nodes[0];  
   } 
   
   public void print() {
      System.out.println("----------");
      print(overallRoot, 0);
      System.out.println("----------");
   }

   private void print(IntTreeNode root, int level) {
      if (root != null) {
         print(root.right, level + 1);
         for (int i = 0; i < level; i++) {
            System.out.print("    ");
         }
         System.out.println(root.data);
         print(root.left, level + 1);
      }
   }
   
   // 01
   public void add(IntTree1 other) {
      overallRoot = add(overallRoot, other.overallRoot);
   }
   
   private IntTreeNode add(IntTreeNode root1, IntTreeNode root2) {
      if (root2 != null) {
         if (root1 == null) {
            root1 = new IntTreeNode(0);
         }
         root1.data += root2.data;
         root1.left = add(root1.left, root2.left);
         root1.right = add(root1.right, root2.right);
      }
      return root1;
   }
   
   // 02
   public void cloneLonelyChildren() {
      overallRoot = cloneLonelyChildren(overallRoot);
   }
   
   private IntTreeNode cloneLonelyChildren(IntTreeNode root) {
      if (root != null) {
         if (root.left == null && root.right != null) {
            root.left = new IntTreeNode(root.right.data);
         } else if (root.right == null && root.left != null){
            root.right = new IntTreeNode(root.left.data);
         }
         root.left = cloneLonelyChildren(root.left);
         root.right = cloneLonelyChildren(root.right);
      }
      return root;
   }
   
   // 03
   public IntTree1 combineWith(IntTree1 other) {
      IntTree1 result = new IntTree1();
      result.overallRoot = combineWith(result.overallRoot, overallRoot, other.overallRoot);
      return result;
   }
   
   private IntTreeNode combineWith(IntTreeNode root1, IntTreeNode root2, IntTreeNode root3) {
      if (root2 != null || root3 != null) {
         IntTreeNode node21 = null;
         IntTreeNode node22 = null;
         IntTreeNode node31 = null;
         IntTreeNode node32 = null;
         root1 = new IntTreeNode(0); 
         if (root2 != null) {
            root1.data += 1;
            node21 = root2.left;
            node22 = root2.right;
         }
         if (root3 != null) {
            root1.data += 2;
            node31 = root3.left;
            node32 = root3.right;
         }         
         root1.left = combineWith(root1.left, node21, node31);
         root1.right = combineWith(root1.right, node22, node32);
      }
      return root1; 
   }
   
   // 04
   public void completeToLevel(int level) {
      overallRoot = completeToLevel(level, 1, overallRoot);
   }
   
   private IntTreeNode completeToLevel(int level, int current, IntTreeNode root) {
      if (current <= level) {
         if (root == null) {
            root = new IntTreeNode(-1);
         }
         root.left = completeToLevel(level, current + 1, root.left);
         root.right = completeToLevel(level, current + 1, root.right);
      }
      return root;
   }
   
   // 05
   public void construct(int[] data) {
      overallRoot = construct(data, 0, data.length - 1);
   }

   private IntTreeNode construct(int[] data, int index1, int index2) {
      if (index1 > index2) {
         return null;
      } else {
         int index = (index1 + index2 + 1) / 2;
         IntTreeNode root = new IntTreeNode(data[index]);
         root.left = construct(data, index1, index - 1);
         root.right = construct(data, index + 1, index2);
         return root;
      }
   }
   
   // 06
   public int countBelow(int level) {
      if (level < 1) {
         throw new IllegalArgumentException();
      }
      return countBelow(level, 1, overallRoot);
   }
   
   private int countBelow(int level, int current, IntTreeNode root) {
      int count = 0;
      if (root != null) {
         if (current >= level) {
            count++;
         }
         count += countBelow(level, current + 1, root.left);
         count += countBelow(level, current + 1, root.right);
      }
      return count;
   }
   
   // 07
   public int countNodes(int x, int y) {
      return countNodes(x, y, 0, 0, overallRoot);
   
   }
   
   private int countNodes(int x, int y, int currentX, int currentY, IntTreeNode root) {
      int count = 0;
      if (root != null && currentX <= x && currentY <= y) {
         if (currentX == x && currentY == y) {
            count++;
         }
         count += countNodes(x, y, currentX + 1, currentY, root.left);
         count += countNodes(x, y, currentX, currentY + 1, root.right);
      }
      return count;
   }
   
   // 08
   public int countPathsOfLength(int length) {
      return countPathsOfLength(length, 1, overallRoot);
   }
   
   private int countPathsOfLength(int length, int current, IntTreeNode root) {
      int count = 0;
      if (root != null && current <= length) {
         if (current == length) {
            if (root.left == null && root.right == null) {
               count++;
            }
         } else {
            count += countPathsOfLength(length, current + 1, root.left);
            count += countPathsOfLength(length, current + 1, root.right);
         }
      }
      return count;
   }
   
   // 09
   public void doubleIt() {
      doubleIt(overallRoot);
   }
   
   private void doubleIt(IntTreeNode root) {
      if (root != null) {
         IntTreeNode temp1 = root.left;
         IntTreeNode temp2 = root.right;
         root.left = new IntTreeNode(root.data * 2, temp1, null);
         root.right = new IntTreeNode(root.data * 2, null, temp2);
         doubleIt(temp1);
         doubleIt(temp2);
      }
   }
   
   // 10
   public void evenLevels() { // wrong diagram?
      overallRoot = evenLevels(1, overallRoot);
   }
   
   private IntTreeNode evenLevels(int level, IntTreeNode root) {
      if (root != null) {
         if (root.left == null && root.right == null) {
            if (level % 2 != 0) {
               root = null;
            }
         } else {
            root.left = evenLevels(level + 1, root.left);
            root.right = evenLevels(level + 1, root.right);
         }
      }
      return root;
   }
}