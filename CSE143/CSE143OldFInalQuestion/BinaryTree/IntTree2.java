import java.util.*;

public class IntTree2 {
   private static final int NULL = 0;
   private IntTreeNode overallRoot;
   
   public IntTree2() {
      overallRoot = null;
   }
   
   public IntTree2(int data[]) {   
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
   public void expand() {
      expand(overallRoot);
   }
   
   private void expand(IntTreeNode root) {
      if (root != null) {
         if (root.left == null && root.right != null) {
            root.left = new IntTreeNode(root.right.data, root.right.left, root.right.right);
         } else if (root.right == null && root.left != null) {
            root.right = new IntTreeNode(root.left.data, root.left.left, root.left.right);
         }
         expand(root.left);
         expand(root.right); 
      }
   }
   
   // 02
   public void fill() {
      int height = height(overallRoot);
      fill(overallRoot, height, 1);
   }
   
   private IntTreeNode fill(IntTreeNode root, int height, int current) {
      if (current > height) {
         root = null;
      } else if (root == null){
         root = new IntTreeNode(0);
      } else {
         root.left = fill(root.left, height, current + 1);
         root.right = fill(root.right, height, current + 1);
      }
      return root;
   }
   
   private int height(IntTreeNode root) {
      int height = 0;
      if (root != null) {
         height++;
         height += Math.max(height(root.left), height(root.right));
      }
      return height;
   }
   
   // 03
   public void flip() {
      flip(overallRoot);
   }
   
   private void flip(IntTreeNode root) {
      if (root != null) {
         IntTreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;
         flip(root.left);
         flip(root.right);
      }
   }
   
   // 04
   public void grow() { // 2 represents brown, 1 represents green
      grow(overallRoot);
   }
   
   private void grow(IntTreeNode root) {
      if (root != null) {
         if (root.left == null && root.right == null) {
            root.data = 2;
            root.left = new IntTreeNode(1);
            root.right = new IntTreeNode(1);
         } else {
            grow(root.left);
            grow(root.right);
         }      
      }   
   }
   
   // 05
   public void indicateMatching(IntTree2 other) {
      overallRoot = indicateMatching(overallRoot, other.overallRoot);
   }
   
   private IntTreeNode indicateMatching(IntTreeNode root1, IntTreeNode root2) {
      if (root1 == null && root2 != null) {
         root1 = new IntTreeNode(-2);
         root1.left = indicateMatching(null, root2.left);
         root1.right = indicateMatching(null, root2.right);
      } else if (root1 != null && root2 == null) {
         root1.data = -1;
         root1.left = indicateMatching(root1.left, null);
         root1.right = indicateMatching(root1.right, null);
      } else if (root1 != null && root2 != null){
         root1.left = indicateMatching(root1.left, root2.left);
         root1.right = indicateMatching(root1.right, root2.right);
      }
      return root1;
   }
   
   //06
   public boolean isBalanced() {
      return isBalanced(overallRoot);
   }
   
   private boolean isBalanced(IntTreeNode root) {
      if (root == null) {
         return true;
      } else {
         if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
         } else {
            return (isBalanced(root.left) && isBalanced(root.right));
         }
      }
   }
   
   // 07
   public void limitLeaves(int n) {
      overallRoot = limitLeaves(n, overallRoot);
   }
   
   private IntTreeNode limitLeaves(int n, IntTreeNode root) {
      if (root != null) {
         root.left = limitLeaves(n, root.left);
         root.right = limitLeaves(n, root.right);
         if (root.left == null && root.right == null && root.data <= n) {
            root = null;
         }
      }
      return root;
   }
   
   // 08
   public void limitPathSum(int n) {
      limitPathSum(n, 0, overallRoot);
   }
   
   private IntTreeNode limitPathSum(int n, int sum, IntTreeNode root) {
      if (root != null) {
         sum += root.data;
         if (sum > n) {
            root = null;
         } else {
            root.left = limitPathSum(n, sum, root.left);
            root.right = limitPathSum(n, sum, root.right);
         }
      }
      return root;
   }
   
   // 09
   public void makeFull() {
      overallRoot = makeFull(overallRoot, -1);
   }
   
   private IntTreeNode makeFull(IntTreeNode root, int level) {
      if (root != null) {
         if (root.left == null && root.right != null) {
            IntTreeNode temp = root.right;
            root.right = null;
            root = new IntTreeNode(level, root, temp);
         } else if (root.left != null && root.right == null) {
            IntTreeNode temp = root.left;
            root.left = null;
            root = new IntTreeNode(level, temp, root);
         }
         root.left = makeFull(root.left, level - 1);
         root.right = makeFull(root.right, level - 1);    
      }
      return root;
   }
   
   // 10
   public void makePerfect() {
      int height = height(overallRoot);
      makePerfect(overallRoot, 1, height);
   }
   
   private void makePerfect(IntTreeNode root, int depth, int height) {
      if (root != null && depth < height) {
         if (root.left == null) {
            root.left = new IntTreeNode(0);
         }
         if (root.right == null) {
            root.right = new IntTreeNode(0);
         }
         makePerfect(root.left, depth + 1, height); 
         makePerfect(root.right, depth + 1, height);
      }
   }
}