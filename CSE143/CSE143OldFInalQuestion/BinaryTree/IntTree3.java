import java.util.*;

public class IntTree3 {
   private static final int NULL = 0;
   private IntTreeNode overallRoot;
   
   public IntTree3() {
      overallRoot = null;
   }
   
   public IntTree3(int data[]) {   
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
   public int matches(IntTree3 other) {
      return matches(overallRoot, other.overallRoot);
   }
   
   private int matches(IntTreeNode root1, IntTreeNode root2) {
      if (root1 != null && root2 != null) {
         if (root1.data == root2.data) {
            return 1 + matches(root1.left, root2.left) + matches(root1.right, root2.right);
         } else {
            return matches(root1.left, root2.left) + matches(root1.right, root2.right);
         }
      }
      return 0;
   }
   
   // 02
   // mirror() - same as flip()
   
   // 03
   public void removeLeaves() {
      overallRoot = removeLeaves(overallRoot);
   }
   
   private IntTreeNode removeLeaves(IntTreeNode root) {
      if (root != null) {
         if (root.left == null && root.right == null) {
            root = null;
         } else {
            root.left = removeLeaves(root.left);
            root.right = removeLeaves(root.right);
         }
      }
      return root;
   }
   
   // 04
   public void removeLeftLeaves() {
      removeTreeLeaves(overallRoot);
   }
   
   private void removeTreeLeaves(IntTreeNode root) {
      if (root != null) {
         removeTreeLeaves(root.left);
         removeTreeLeaves(root.right);
         if (root.left != null && root.left.left == null && root.left.right == null) {
            root.left = null;
         }
      }
   }
   
   // 05
   public void removeMatchingLeaves(IntTree3 other) {
      overallRoot = removeMatchingLeaves(overallRoot, other.overallRoot);
   }
   
   private IntTreeNode removeMatchingLeaves(IntTreeNode root1, IntTreeNode root2) {
      if (root1 != null && root2 != null) {
         if (root1.left == null && root1.right == null) {
            if (root1.data == root2.data) {
               root1 = null;
            }
         } else {
            root1.left = removeMatchingLeaves(root1.left, root2.left);
            root1.right = removeMatchingLeaves(root1.right, root2.right);
         }
      }
      return root1;
   }
   
   // 06
   // removeRightLeaves() - same technique as removeLeftLeaves()
   
   // 07
   public void removeSmallLeaves(int n) {
      overallRoot = removeSmallLeaves(overallRoot, n);
   }
   
   private IntTreeNode removeSmallLeaves(IntTreeNode root, int n) {
      if (root != null) {
         root.left = removeSmallLeaves(root.left, n);
         root.right = removeSmallLeaves(root.right, n);
         if (root.left == null && root.right == null && root.data < n) {
            root = null;
         }  
      }
      return root;
   }
   
   // 08
   public void stretch() {
      overallRoot = stretch(overallRoot);
   }
   
   private IntTreeNode stretch(IntTreeNode root) {
      if (root != null) {
         if (root.left != null && root.right == null) {
            root = new IntTreeNode(1, root, null);
            root.left.left = stretch(root.left.left);
         } else if (root.right != null && root.left == null) {
            root = new IntTreeNode(1, null, root);
            root.right.right = stretch(root.right.right);
         } else {
            root.left = stretch(root.left);
            root.right = stretch(root.right);
         }
      }
      return root;
   }
   
   // 09
   public int sumLeaves() {
      return sumLeaves(overallRoot);
   }
   
   private int sumLeaves(IntTreeNode root) {
      int sum = 0;
      if (root != null) {
         if (root.left == null && root.right == null) {
            sum += root.data;
         } else {
            sum += sumLeaves(root.left);
            sum += sumLeaves(root.right);
         }
      }
      return sum;
   }
   
   // 10
   public void swapChildrenAtLevel(int level) { // wrong picture - subtree of child should follows it
      if (level < 1) {
         throw new IllegalArgumentException();
      }
      swapChildrenAtLevel(overallRoot, level, 1);
   }
   
   private void swapChildrenAtLevel(IntTreeNode root, int level, int current) {
      if (root != null && current <= level) {
         if (current < level) {
            swapChildrenAtLevel(root.left, level, current + 1);
            swapChildrenAtLevel(root.right, level, current + 1);
         } else { // current == level
            IntTreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
         }
      }
   }
   
   // 11
   public void tighten() {
      overallRoot = tighten(overallRoot);
   }
   
   private IntTreeNode tighten(IntTreeNode root) {
      if (root != null) {
         root.left = tighten(root.left);
         root.right = tighten(root.right);
         if (root.left == null && root.right != null) {
            root = root.right;
         } else if (root.left != null && root.right == null) {
            root = root.left;
         }
      }
      return root;
   }
   
   // 12
   public void trim(int min, int max) {
      overallRoot = trim(overallRoot, min, max);
   }
   
   private IntTreeNode trim(IntTreeNode root, int min, int max) {
      if (root != null) {
         root.left = trim(root.left, min, max);
         root.right = trim(root.right, min, max);
         if (root.data < min) {
            root = root.right;
         } else if (root.data > max) {
            root = root.left;
         }
      }
      return root;
   }
}