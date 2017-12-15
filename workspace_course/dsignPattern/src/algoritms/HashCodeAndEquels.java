package algoritms;
import java.util.HashMap;
import java.util.Map;

public class HashCodeAndEquels {

	public static void main(String[] args) {
		Coutry n = new Coutry();
		n.setNum(33);
		n.hashCode();
		Coutry b = new Coutry();
		b.setNum(33);
		b.hashCode();
		
		b.equals(n);
		Map map  = new HashMap<>();
		
		map.put(n, "23"); 
		map.get(b);
		map.size();
		
		System.out.println(map);
		
		
		
		
		
	}
	
	
	static class Coutry{
		Integer num;
		
		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((num == null) ? 0 : num.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coutry other = (Coutry) obj;
			if (num == null) {
				if (other.num != null)
					return false;
			} else if (!num.equals(other.num))
				return false;
			return true;
		}
		
//		@Override
//		public int hashCode() {
//			return num.hashCode();
//		}
	}

}
