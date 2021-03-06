package solutions;

import java.util.Queue;
import java.util.Stack;

public class GNE {

	public static void main(String[] args) {
		
		int[] arr = {40,50,11,32,55,68,75};
		getNGE(arr);

	}
	
	
	public static void getNGE(int[] a) {
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(a[0]);

	    for (int i = 1; i < a.length; i++) {
	        if (s.peek() != null) {
	            while (true) {
	                if (s.peek() == null || s.peek() > a[i]) {
	                    break;
	                }
	                System.out.println(s.pop() + ":" + a[i]);
	            }
	            s.push(a[i]);
	        }
	        
	    }
	    
	    
	    while (s.peek() != null) {
	        System.out.println(s.pop() + ":" + -1);
	    }
	}

}
