public class ListNode {
    public int data;       // data stored in this node
    public ListNode next;  // a link to the next node in the list
    
    public ListNode() { 
      data = 0;
      next = null;
    }
    public ListNode(int data) {
      this.data = data;
    }
    public ListNode(int data, ListNode next) { 
      this.data = data;
      this.next = next;
    }
}