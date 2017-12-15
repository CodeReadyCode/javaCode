package algoritms.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGrapth {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("adc");
		list.add("abc");
		Collections.sort(list);
		System.out.println(list);
		
		String  f = "abb";
		String ff = "abf"; 
				if(f.compareTo(ff) < 0){
					System.out.println("yes");
				}
	}

}
