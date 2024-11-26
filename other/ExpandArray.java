import java.util.Scanner;

public class ExpandArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Scanner scan = new Scanner(System.in);
		
		do{
			int[] newarr = new int[arr.length+1];
			//遍历数组 复制元素
			for(int i = 0; i < arr.length; i++) {
				newarr[i] = arr[i];
			}
			//扩容最后一个元素
			System.out.println("\nplease print an integer");
			newarr[arr.length] = scan.nextInt();
			arr = newarr;//重点,原本的arr所占内存空间被销毁,现在arr和newarr指代相同(同时实现了arr+1)
			//输出函数
			System.out.println("====AFTER====");
			for(int i = 0; i < newarr.length; i++) {
				System.out.print(newarr[i] + " ");
			}


			//跳出循环选项
			char key ;
			while(true) {
				System.out.println("\nContinue added? y / r to reduce last element / any other keys to quit");
				key = scan.next().charAt(0);

				if( key == 'y' ) {
					break;
				}
				else if( key == 'r') {
					reduce(arr);	//调用reduce函数,传入数组的指针作为参数
				}
				
			}
			if(key != 'y' && key != 'r') {
				break;
			}

		}
		while(true);
}


		public static void reduce(int[] arr) {
			
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
				}
		}
			

		
	
}