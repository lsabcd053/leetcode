package leetcode;

public class AddTwoNumbers {
	public static void main(String []argv){
		int [] int1={9,8};
		int [] int2={1};
		
		ListNode l1=new ListNode(int1[0]);
		ListNode l2=new ListNode(int2[0]);
		ListNode tmp = l1;
		for(int i=1;i<int1.length;i++){
			tmp.next=new ListNode(int1[i]);
			tmp = tmp.next;
		}
		
		ListNode tmp2 = l2;
		for(int i=1;i<int2.length;i++){
			tmp2.next=new ListNode(int2[i]);
			tmp2 = tmp2.next;
		}
		
		System.out.println();
		ListNode res = addTwoNumbers(l1,l2);
		
		while(res!=null){
			System.out.print(res.val+"->");
			res = res.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		int c = 0;
		int t = c + l1.val+l2.val;
		ListNode res = new ListNode(t % 10);
		ListNode resi = res;
		c = t / 10;
		while(l1.next != null && l2.next != null){
			l1 = l1.next;
			l2 = l2.next;
			
			t = c + l1.val+l2.val;
			resi.next = new ListNode(t % 10);
			resi = resi.next;
			c = t / 10;
			
		}
		if(c==0 && l1.next != null){
			resi.next = l1.next;
		}
		if(c==0 && l2.next != null){
			resi.next = l2.next;
		}
		if(c >0 && l1.next == null && l2.next == null){
			resi.next = new ListNode(1);
		}
		
		if(c >0 && l1.next != null){
			resi.next = l1.next;
			while(c > 0 &&resi.next!=null){
				t = c+resi.next.val;
				resi.next.val = t % 10;
				c = t / 10;
				resi = resi.next;
			}
			if(c > 0 && resi.next==null){
				resi.next = new ListNode(1);
			}
		}
		
		if(c >0 && l2.next != null){
			resi.next = l2.next;
			while(c > 0 &&resi.next!=null){
				t = c+resi.next.val;
				resi.next.val = t % 10;
				c = t / 10;
				resi = resi.next;
			}
			if(c > 0 && resi.next==null){
				resi.next = new ListNode(1);
			}
		}
		return res;
    }
}
