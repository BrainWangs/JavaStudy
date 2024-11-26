import java.util.Scanner;
 class OverloadExercise {
	 public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Method.overf(2);
		Method.overf(3, 4);
		Method.overf("ajsda");
		Method.max(2.3, 4.0, 5);
	}// main end

	public class Method {
		/*方法重载*/
		public static int overf(int n1) {
			return n1 * n1;
		}
		public static int overf(int n1, int n2) {
			return n1 * n2;
		}
		public static void overf(String str) {
			System.out.println(str);
			
		}
		public static int max(int n1, int n2) {
			int max = n1 > n2 ? n1 : n2;
			System.out.println(" int max = " + max);
			return max;
		}
		public static double max(double n1, double n2, double n3) {
			double max = n1;
			if(n2 > max) 
				max = n2;
			if(n3 > max)
				max = n3;
			System.out.println("double max = " + max);
			return max;
		}

	}// method class end


}

