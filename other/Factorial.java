public class Factorial {
	public static void main(String[] args) {
		factorial(10);
	}

	public static int factorial(int n) {
		int sum = n;
		if(n > 1) {	//如果n>0, 最顶层栈空间返回值就是0,则会导致每一步相乘都为0
			sum *= factorial(n - 1);
			System.out.println(sum);
		}
		return sum;
	}
}
