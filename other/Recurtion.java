public class Recurtion {
	public static void main(String[] args) {
		recurtion(4);
	}

	public static void recurtion(int n) {
	    if(n > 2) {
	        recurtion(n - 1);
	    }
	    System.out.println("n = " + n);
	} 
}

