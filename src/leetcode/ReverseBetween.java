package leetcode;

public class ReverseBetween {
	public static void main(String []argv){
		int [] a = {1,2,3,4,5,6,7,8,9,10};
		int m=1;
		int n=8;
		
		ListNode head = new ListNode(a[0]);
		ListNode c = head;
		for(int i=1;i<a.length;i++){
			c.next = new ListNode(a[i]);
			c = c.next;
		}
		c = head;
		while(c != null){
			System.out.print(c.val+",");
			c = c.next;
		}
		System.out.println("\n---");
		
		head = reverseBetween(head,m,n);
		
		c = head;
		while(c != null){
			System.out.print(c.val+",");
			c = c.next;
		}
		System.out.println("\n---");
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(m == n){
			return head;
			}
		
		ListNode pre = null;
		ListNode ppre = null;
		ListNode cursor = null;
		ListNode next = null;
		ListNode mnode = null;
		ListNode nnode = null;
		
		cursor = head;
		pre = null;
		int i=1;
		while(i<=n && cursor != null){
			if(pre != null & cursor !=null){
				System.out.println("i:"+i+"; cursor:"+cursor.val+"; "+"; pre:"+pre.val);
			}
			if(i < m){
				pre = cursor;
				cursor = cursor.next;
				
			}
			else if(i == m){
				mnode = cursor;
				ppre = pre;
				
				pre = cursor;
				cursor = cursor.next;
			}
			else if(i>m && i<n){
				next = cursor.next;
				cursor.next = pre;
				pre = cursor;
				cursor = next;
				
			}
			else if(i == n){
				nnode = cursor;
				next = cursor.next;
				cursor.next = pre;
				pre = cursor;
				cursor = next;
			}
			
			
			
			i++;
		}
		
		System.out.println("nnode:"+nnode.val);
		System.out.println("mnode:"+mnode.val);
		
		if(ppre != null){
			ppre.next = nnode;
			System.out.println("ppre:"+ppre.val);
		}else{
			head = nnode;
		}
		
		mnode.next = next;
		
        return head;
    }
}
