/*斐波那契数列*/

/*记忆化搜索*/
import java.util.Scanner;
public class Feibonachi {
    // 缓存数组，用于记忆化存储
    public static int[] memo;	//定义全局可见数组memo[]

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();  // 要计算的斐波那契数列位置
        memo = new int[n + 1];  // 初始化缓存数组 注意这个n+1

      	fibonacci(n);

        for(int i = 0; i < memo.length - 1; i++) {
    	System.out.print(memo[i] + " ");
    	}
    }
    // 记忆化递归函数
    public static int fibonacci(int n) {
        if (n <= 1) {
        	memo[n] = n;
            return memo[n];
        }
        // 检查缓存中是否已有计算结果
        if (memo[n] != 0) {
            return memo[n];
        }
        // 递归计算并存储到缓存
        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }
}

/*import java.util.Scanner;
public class Feibonachi {
	public static void  main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		for(int i = 0; i < x; i++) {
			System.out.print(feibonachi(i) + " ");
		}
	}
	public static int feibonachi(int n) {
		int x;
		if(n <= 1) {
			return n;
		}
		else {
			x = feibonachi(n -1) + feibonachi(n -2);
			return x;
		}
	}
}*/

/*
从第3项起,每一项均为前两项之和,其中第1项和第2项为1
寻找递归函数的功能: 当前项 = 前一项(递归1) + 前二项(递归2)
探寻退出条件: 当n-1和n-2时 return 1
*/

/*import java.util.Scanner;
public class Feibonachi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("please print an number:\n");
		f(scan.nextInt());
	}

	public static int f(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		else {
			int num = f(n - 1) + f(n - 2);
			return num;
		}
	}

}*/

