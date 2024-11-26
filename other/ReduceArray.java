import java.util.Scanner;

public class ReduceArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		Scanner scan = new Scanner(System.in);
		
		do{
			int[] newarr = new int[arr.length - 1];
			//遍历数组 复制元素
			for(int i = 0; i < arr.length - 1; i++) {
				newarr[i] = arr[i];
			}
			arr = newarr;

			//输出函数
			System.out.println("====AFTER====");
			for(int i = 0; i < newarr.length; i++) {
				System.out.print(newarr[i] + " ");
			}
			//检查数组剩余元素个数
			if(arr.length == 1) {
				System.out.println("\nthe last one");
				break;
			}
			//跳出循环选项
			System.out.println("\nContinue? y or any keys to quit");
			if(scan.next().charAt(0) != 'y') {
				break;
			}


		}
		while(true);

	}
}